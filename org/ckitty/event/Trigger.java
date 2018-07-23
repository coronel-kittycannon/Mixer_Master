package org.ckitty.event;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.ckitty.compiler.Instruction;
import org.ckitty.compiler.MixerCompiler;
import org.ckitty.compiler.Wait;
import org.ckitty.mixer.Config;
import org.ckitty.mixer.Config.ConfigPlanet;
import org.ckitty.mixer.Mixer;
import org.ckitty.mixer.MixerData;
import org.ckitty.mixer.MixerSound;
import org.ckitty.player.AbstractPlayer;
import org.ckitty.player.AreaPlayer;
import org.ckitty.player.LocationPlayer;
import org.ckitty.player.PersonalLocationPlayer;
import org.ckitty.player.PersonalPlayer;
import org.ckitty.player.PlayerManager;
import org.ckitty.player.PublicPlayer;
import org.ckitty.radio.RadioPublicPlayer;
import org.ckitty.radio.RadioStation;

public class Trigger implements Listener, CommandExecutor {

	public static ConfigPlanet events;

	/*
	 * mx 
	 * 
	 * help
	 * list
	 * 
	 * play <sound> [player]
	 * forceplay <sound> [player]
	 * playloc <sound> <x> <y> <z> <world>
	 * playloca <sound> <x> <y> <z> <xr> <yr> <zy> <world>
	 * playhere <sound> [r]
	 * lp.
	 * regloop <name> <sound>
	 * unregloop <name>
	 * 
	 * regradio <name> <station>
	 * unregradio <name>
	 * 
	 * radio <channel|on|off>
	 * 
	 * reload stop
	 * 
	 * edit <sound> <#line> <newline>
	 * tell <sound> <#line>
	 * compile <data>
	 * 
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length > 0) {
			try {
				switch (args[0].toLowerCase()) {
				case "list":
					this.validatePermision(sender, "mixer.user.list", MixerData.NO_PERM_CMD);
					this.validateArgumentSize(args, 1, 1, MixerData.CMD_USAGE_LIST);

					sender.sendMessage(MixerData.MIXER_HEADER + MixerData.MIXER_LIST_PREFIX);
					for (String s : PlayerManager.LOADED_SOUNDS.keySet()) {
						sender.sendMessage(MixerData.MX_LIST_ENTRY + s);
					}

					break;
				case "compile": //     /mx compile <args...>
					Player p = this.validatePlayer(sender, MixerData.NO_PLAYER);
					this.validatePermision(sender, "mixer.admin.compile", MixerData.NO_PERM_CMD);
					new BukkitRunnable() {
						public void run() {
							try {
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.COMPILING);
								for (Instruction i : new MixerCompiler(null) {
									@Override
									public Instruction handleWait(String s) {
										long l = 1;
										s = s.replaceFirst("wait", "");
										if (!s.isEmpty()) {
											l = Long.parseLong(s);
										}
										return new Wait(Math.round(l * (MixerData.SECOND / 10d)));
									}
								}.generalCompiler(Arrays.asList(args).subList(1, args.length))) {
									i.instruct(p);
								}
							} catch (Exception e) {
								e.printStackTrace();
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.COMPILING_ERROR + "§r (" + e.getClass().getSimpleName() + ": "
										+ e.getMessage() + ")");
							}
							p.sendMessage(MixerData.MIXER_HEADER + MixerData.COMPILING_END);
						}
					}.runTaskAsynchronously(Mixer.plugin);

					break;
				case "play": //		/mx play <sound> [player]
					this.validatePermision(sender, "mixer.user.play", MixerData.NO_PERM_CMD);
					this.validateArgumentSize(args, 2, 3, MixerData.CMD_USAGE_PLAY);
					MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(args[1].toLowerCase());
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);
					this.validatePermision(sender, mxs.getPermPlay(), MixerData.NO_PERM_SOUND);
					if (args.length == 3) {
						this.validatePermision(sender, "mixer.admin.play.force", MixerData.NO_PERM_CMD);
						p = Bukkit.getPlayer(args[2]);
						this.validateNotNull(p, MixerData.PLAYER_DOESNT_EXIST);
						new PersonalPlayer(p).playInstruction(mxs.getInstructions());
					} else {
						p = this.validatePlayer(sender, MixerData.NO_PLAYER);
						new PersonalPlayer(p).playInstruction(mxs.getInstructions());
					}
					break;
				case "playloc": //  	/mx playloc <sound> <x> <y> <z> <world>
					this.validatePermision(sender, "mixer.admin.play.loc", MixerData.NO_PERM_CMD);
					this.validateArgumentSize(args, 6, 6, MixerData.CMD_USAGE_PLAYLOC);
					mxs = PlayerManager.LOADED_SOUNDS.get(args[1]);
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);

					double x = this.validateNumber(args[2], MixerData.NO_NUMBER + args[2]);
					double y = this.validateNumber(args[3], MixerData.NO_NUMBER + args[3]);
					double z = this.validateNumber(args[4], MixerData.NO_NUMBER + args[4]);
					World w = this.validateWorld(args[5], MixerData.WORLD_DOESNT_EXIST + args[5]);

					new LocationPlayer(new Location(w, x, y, z)).playInstruction(mxs.getInstructions());
					break;
				case "playarea": // 	/mx playarea <sound> <x> <y> <z> <xr> <yr> <zy> <world>
					this.validatePermision(sender, "mixer.admin.play.area", MixerData.NO_PERM_CMD);
					this.validateArgumentSize(args, 9, 9, MixerData.CMD_USAGE_PLAYAREA);
					mxs = PlayerManager.LOADED_SOUNDS.get(args[1].toLowerCase());
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);

					x = this.validateNumber(args[2], MixerData.NO_NUMBER + args[2]);
					y = this.validateNumber(args[3], MixerData.NO_NUMBER + args[3]);
					z = this.validateNumber(args[4], MixerData.NO_NUMBER + args[4]);

					double xr = this.validateNumber(args[5], MixerData.NO_NUMBER + args[5]);
					double yr = this.validateNumber(args[6], MixerData.NO_NUMBER + args[6]);
					double zr = this.validateNumber(args[7], MixerData.NO_NUMBER + args[7]);

					w = this.validateWorld(args[8], MixerData.WORLD_DOESNT_EXIST + args[8]);

					new AreaPlayer(new Location(w, x, y, z), xr, yr, zr).playInstruction(mxs.getInstructions());
					break;
				case "playhere": // 	/mx playhere <sound> [r]
					this.validatePermision(sender, "mixer.admin.play.here", MixerData.NO_PERM_CMD);
					p = this.validatePlayer(sender, MixerData.NO_PLAYER);
					this.validateArgumentSize(args, 2, 3, MixerData.CMD_USAGE_PLAYHERE);

					mxs = PlayerManager.LOADED_SOUNDS.get(args[1].toLowerCase());
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);

					if (args.length == 2) {
						new PublicPlayer(p.getWorld().getPlayers()).playInstruction(mxs.getInstructions());
					} else {
						double r = this.validateNumber(args[2], MixerData.NO_NUMBER);
						new AreaPlayer(p.getLocation(), r, r, r).playInstruction(mxs.getInstructions());
					}

					break;
				case "regloc": //   /mx regloc <name> <sound>
					this.validateArgumentSize(args, 3, 3, MixerData.CMD_USAGE_REGLOC);
					this.validatePermision(sender, "mixer.admin.regloc", MixerData.NO_PERM_CMD);

					if (LocationPlayer.loop_players.containsKey(args[1])) {
						sender.sendMessage(MixerData.MIXER_HEADER + MixerData.REGISTER_ALREADY_EXISTS);
						return true;
					}

					mxs = PlayerManager.LOADED_SOUNDS.get(args[2].toLowerCase());
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);
					LocationPlayer.registerLoopLocPlayer(args[1],
							this.validatePlayer(sender, MixerData.NO_PLAYER).getLocation(), mxs);
					sender.sendMessage(MixerData.MIXER_HEADER + MixerData.REGISTERED + args[1]);
					break;
				case "unregloc":
					this.validateArgumentSize(args, 2, 2, MixerData.CMD_USAGE_UNREGLOC);
					this.validatePermision(sender, "mixer.admin.unregloc", MixerData.NO_PERM_CMD);
					if (LocationPlayer.loop_players.containsKey(args[1])) {
						LocationPlayer.unregLoopLocPlayer(args[1]);
						sender.sendMessage(MixerData.MIXER_HEADER + MixerData.UNREGISTERED + args[1]);
					} else {
						sender.sendMessage(MixerData.MIXER_HEADER + MixerData.REGISTER_NOT_EXISTS);
					}
					break;
				case "radio": // 		/mx radio <station|on|off|list>
					p = this.validatePlayer(sender, MixerData.NO_PLAYER);
					this.validatePermision(sender, "mixer.user.radio", MixerData.RADIO_NO_PERM);
					this.validateArgumentSize(args, 1, 2, MixerData.CMD_USAGE_RADIO);
					
					if(args.length == 1) {
						String rpp = RadioManager.getFromPlayerName(p);
						p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_TUNNED_TO + (rpp == null ? "OFF" : rpp));
						return true;
					}
					
					if (MixerData.RADIO) {
						switch (args[1].toLowerCase()) {
						case "on":
							if (RadioManager.getFromPlayer(p) != null) {
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_ALREADY_ON);
							} else {
								RadioPublicPlayer rpp = RadioManager.getDefault();
								if (rpp == null) {
									p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_PLEASE_SELECT_CHANNEL);
								} else {
									rpp.getPlayers().add(p);
									p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_TURNED_ON);
								}
							}
							break;
						case "off":
							RadioPublicPlayer rpp = RadioManager.getFromPlayer(p);
							if (rpp == null) {
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_ALREADY_OFF);
							} else {
								rpp.getPlayers().remove(p);
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_TURNED_OFF);
							}
							break;
						case "list":
							sender.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_LIST_PREFIX);
							for (String s : RadioStation.radios.keySet()) {
								sender.sendMessage(MixerData.MX_LIST_ENTRY + s);
							}
							break;
						default:
							rpp = RadioManager.getFromString(args[1]);
							if (rpp == null) {
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_DOESNT_EXIST);
							} else {
								RadioManager.putInAnother(RadioManager.getFromPlayer(p), p, rpp);
								p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_TUNNED_TO + args[1]);
							}
							break;
						}
					} else {
						p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_NO_PERM);
					}
					break;
				case "reload":
					this.validatePermision(sender, "mixer.admin.reload", MixerData.NO_PERM_CMD);
					this.validateArgumentSize(args, 1, 1, MixerData.CMD_USAGE_RELOAD);
					Config.reloadAll();
					PlayerManager.reloadSounds();
					RadioStation.loadRadios();
					LocationPlayer.saveLoopLocs();
					LocationPlayer.reloadLoopLocs();
					sender.sendMessage(MixerData.MIXER_HEADER + MixerData.RELOADED);
					break;
				case "stop":
					this.validateArgumentSize(args, 1, 1, MixerData.CMD_USAGE_STOP);
					this.validatePermision(sender, "mixer.admin.stop", MixerData.NO_PERM_CMD);
					AbstractPlayer.cancellAll();
					sender.sendMessage(MixerData.MIXER_HEADER + MixerData.STOPPED);
					break;
				default:
					this.validateArgumentSize(args, 1, 1, MixerData.CMD_USAGE_MX);
					this.validatePermision(sender, "mixer.user.quickplay", MixerData.NO_PERM_CMD);
					mxs = PlayerManager.LOADED_SOUNDS.get(args[0].toLowerCase());
					this.validateNotNull(mxs, MixerData.SOUND_DOESNT_EXIST);
					this.validatePermision(sender, mxs.getPermPlay(), MixerData.NO_PERM_SOUND);
					new PersonalLocationPlayer(this.validatePlayer(sender, MixerData.NO_PLAYER))
							.playInstruction(mxs.getInstructions());
					break;
				}
			} catch (Exception e) {
				sender.sendMessage(MixerData.MIXER_HEADER + e.getMessage());
			}
		} else {
			sender.sendMessage(MixerData.MIXER_HEADER + MixerData.CMD_USAGE_MX);
		}

		return true;
	}

	public static void playAround(Player p, MixerSound mxs) {
		new PersonalLocationPlayer(p).playInstruction(mxs.getInstructions());
	}

	public void validateNotNull(Object o, String msg) {
		if (o == null)
			throw new IllegalArgumentException(msg);
	}

	public void validatePermision(CommandSender sender, String perm, String msg) {
		if (!sender.hasPermission(perm))
			throw new IllegalArgumentException(msg);
	}

	public double validateNumber(String number, String msg) {
		try {
			return Double.parseDouble(number);
		} catch (Exception e) {
			throw new IllegalArgumentException(msg);
		}
	}

	public World validateWorld(String name, String msg) {
		World w = Bukkit.getWorld(name);
		if (w == null)
			throw new IllegalArgumentException(msg);
		return w;
	}

	public Player validatePlayer(String name, String msg) {
		Player p = Bukkit.getPlayer(name);
		if (p == null)
			throw new IllegalArgumentException(msg);
		return p;
	}

	public Player validatePlayer(CommandSender sender, String msg) {
		if (sender instanceof Player) {
			return (Player) sender;
		} else {
			throw new IllegalArgumentException(msg);
		}
	}

	public void validateArgumentSize(String[] args, int min, int max, String msg) {
		if (args.length < min)
			throw new IllegalArgumentException(msg);
		if (args.length > max)
			throw new IllegalArgumentException(msg);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onCommnad(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("/radio ")) {
			e.setMessage("/mixer " + e.getMessage().substring(1));
		}
	}

	public void onBlock(BlockEvent e) {
		if (!MixerData.BLOCK_EVENTS)
			return;

		String block = e.getBlock().getType().toString();
		String clazz = e.getClass().getSimpleName();
		String name = events.getString("blocks." + block + "." + clazz);

		if (name == null) {
			events.write("blocks." + block + "." + clazz, "");
			return;
		}

		MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(name);
		if (mxs == null)
			return;

		new LocationPlayer(e.getBlock().getLocation()).playInstruction(mxs.getInstructions());
	}

	public void onEntity(EntityEvent e) {
		if (!MixerData.ENTITY_EVENTS)
			return;

		if (e instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent ed = (EntityDamageByEntityEvent) e;

			Entity att = ed.getDamager();

			if (att instanceof Projectile) {
				ProjectileSource ps = ((Projectile) att).getShooter();

				if (ps != null) {
					if (ps instanceof Entity) {
						att = (Entity) ps;
					}
				}
			}

			String type = att.getType().toString();
			String path = "entities." + type + ".EntityDamageByEntityEvent.onAttack";
			String sound_att = events.getString(path);

			if (sound_att == null) {
				events.write(path, "");
			} else {
				MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound_att);
				if (mxs != null) {
					new LocationPlayer(att.getLocation()).playInstruction(mxs.getInstructions());
				}
			}

			String d_type = ed.getEntity().getType().toString();
			String d_path = "entities." + d_type + ".EntityDamageByEntityEvent.onDamage";
			String sound_dmg = events.getString(d_path);

			if (sound_dmg == null) {
				events.write(d_path, "");
			} else {
				MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound_dmg);
				if (mxs != null) {
					new LocationPlayer(ed.getEntity().getLocation()).playInstruction(mxs.getInstructions());
				}
			}
		} else if (e instanceof EntityDamageByBlockEvent) {
			EntityDamageByBlockEvent de = (EntityDamageByBlockEvent) e;
			String clazz = de.getClass().getSimpleName();
			String damager = de.getCause().toString();

			if (de.getDamager() != null) {
				if (de.getDamager().getType() != null) {
					damager = de.getDamager().getType().toString();
				}
			}

			String path = "entities." + de.getEntity().getType().toString() + "." + clazz + "." + damager;
			String sound = events.getString(path);

			if (sound == null) {
				events.write(path, "");
			} else {
				MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound);
				if (mxs != null) {
					new LocationPlayer(e.getEntity().getLocation()).playInstruction(mxs.getInstructions());
				}
			}

		} else if (e instanceof EntityDamageEvent) {
			EntityDamageEvent de = (EntityDamageEvent) e;
			String clazz = de.getClass().getSimpleName();
			String path = "entities." + de.getEntity().getType().toString() + "." + clazz + "."
					+ de.getCause().toString();
			String sound = events.getString(path);

			if (sound == null) {
				events.write(path, "");
			} else {
				MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound);
				if (mxs != null) {
					new LocationPlayer(e.getEntity().getLocation()).playInstruction(mxs.getInstructions());
				}
			}
		} else {

			String clazz = e.getClass().getSimpleName();
			String path = "entities." + e.getEntity().getType().toString() + "." + clazz;
			String sound = events.getString(path);

			if (sound == null) {
				events.write(path, "");
			} else {
				MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound);
				if (mxs != null) {
					new LocationPlayer(e.getEntity().getLocation()).playInstruction(mxs.getInstructions());
				}
			}
		}

	}

	public void onPlayer(PlayerEvent e) {
		if (!MixerData.PLAYER_EVENTS)
			return;
		String path = "players." + e.getClass().getSimpleName();

		if (e instanceof PlayerToggleSneakEvent) {
			PlayerToggleSneakEvent te = (PlayerToggleSneakEvent) e;
			if (te.isSneaking()) {
				path += ".onStart";
			} else {
				path += ".onStop";
			}
		} else if (e instanceof PlayerToggleSprintEvent) {
			PlayerToggleSprintEvent te = (PlayerToggleSprintEvent) e;
			if (te.isSprinting()) {
				path += ".onStart";
			} else {
				path += ".onStop";
			}
		} else if (e instanceof PlayerToggleFlightEvent) {
			PlayerToggleFlightEvent te = (PlayerToggleFlightEvent) e;
			if (te.isFlying()) {
				path += ".onStart";
			} else {
				path += ".onStop";
			}
		} else if (e instanceof PlayerInteractEvent) {
			PlayerInteractEvent ie = (PlayerInteractEvent) e;
			if (ie.getClickedBlock() == null) {
				path += ".nothing";
			} else {
				path += "." + ie.getClickedBlock().getType().toString();
			}
		} else if (e instanceof PlayerInteractEntityEvent) {
			PlayerInteractEntityEvent it = (PlayerInteractEntityEvent) e;
			if (it.getRightClicked() == null) {
				path += ".nothing";
			} else {
				path += "." + it.getRightClicked().getType().toString();
			}
		} else if (e instanceof PlayerItemConsumeEvent) {
			PlayerItemConsumeEvent ce = (PlayerItemConsumeEvent) e;
			path += "." + ce.getItem().getType().toString();
		}

		String sound = events.getString(path);

		if (sound == null) {
			events.write(path, "");
		} else {
			MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(sound);
			if (mxs != null) {
				new LocationPlayer(e.getPlayer().getLocation()).playInstruction(mxs.getInstructions());
			}
		}

	}

	public boolean isCancelled(Event e) {
		if (e instanceof Cancellable) {
			return ((Cancellable) e).isCancelled();
		}

		return false;
	}

}
