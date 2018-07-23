package org.ckitty.mixer;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.ckitty.event.Trigger;
import org.ckitty.mixer.Config.ConfigPlanet;
import org.ckitty.player.AbstractPlayer;
import org.ckitty.player.LocationPlayer;
import org.ckitty.player.PlayerManager;
import org.ckitty.radio.RadioStation;

public class Mixer extends JavaPlugin implements ConfigPlanet {

	public static Mixer plugin;

	@Override
	public void onEnable() {
		plugin = this;
		this.initConfig();
		this.getCommand("mixer").setExecutor(PlayerManager.trigger);
		this.getServer().getPluginManager().registerEvents(PlayerManager.trigger, this);

		RegisteredListener registeredListener = new RegisteredListener(PlayerManager.trigger, new EventExecutor() {

			Trigger t = PlayerManager.trigger;

			@Override
			public void execute(Listener listener, Event e) throws EventException {
				if (t.isCancelled(e))
					return;
				if (e instanceof BlockEvent) {
					t.onBlock((BlockEvent) e);
					return;
				}

				if (e instanceof EntityEvent) {
					t.onEntity((EntityEvent) e);
					return;
				}

				if (e instanceof PlayerEvent) {
					t.onPlayer((PlayerEvent) e);
					return;
				}
			}

		}, EventPriority.HIGHEST, this, true);
		for (HandlerList handler : HandlerList.getHandlerLists())
			handler.register(registeredListener);
	}

	private void initConfig() {
		if(!this.getDataFolder().exists()) {
			this.getDataFolder().mkdirs();
		}
		
		if(!new File(getDataFolder(), "config.yml").exists()) {
			this.saveDefaultConfig();
		}
		
		Config.init(this, "sounds", "events", "radios");
		RadioStation.loadRadios();

		new BukkitRunnable() {
			public void run() {
				plugin.getLogger().info("Loading looping sounds...");
				LocationPlayer.reloadLoopLocs();
			}
		}.runTaskLaterAsynchronously(plugin, 200);
	}

	@Override
	public void onDisable() {
		LocationPlayer.saveLoopLocs();
		RadioStation.saveRadios();
		Config.saveAll();
		AbstractPlayer.cancellAll();
		Bukkit.getScheduler().cancelTasks(this);
	}

	public static enum TimeStep {
		MINECRAFT, REDSTONE, MILISECONDS, NANO_SECONDS, UPDATES_PER_SECOND;
	}

	@Override
	public void write(String path, Object data) {
		this.getConfig().set(path, data);
		this.save();
	}

	@Override
	public List<String> getStringList(String path) {
		return this.getConfig().getStringList(path);
	}

	@Override
	public String getString(String path) {
		return getConfig().getString(path);
	}

	@Override
	public Integer getInteger(String path) {
		return getConfig().getInt(path);
	}

	@Override
	public Double getDouble(String path) {
		return getConfig().getDouble(path);
	}

	@Override
	public Boolean getBoolean(String path) {
		return getConfig().getBoolean(path);
	}

	@Override
	public ItemStack getItemStack(String path) {
		return getConfig().getItemStack(path);
	}

	@Override
	public void save() {
		this.saveConfig();
	}

	@Override
	public void reload() {
		this.reloadConfig();
	}

	@Override
	public boolean contains(String path) {
		return getConfig().isSet(path);
	}

}
