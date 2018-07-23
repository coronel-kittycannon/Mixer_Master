package org.ckitty.mixer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.ckitty.event.Trigger;
import org.ckitty.player.PlayerManager;

public class Config {

	protected static Map<String, ConfigPlanet> configs;

	public static void init(ConfigPlanet config, String... files) {
		configs = new HashMap<String, ConfigPlanet>();
		configs.put("config", config);
		reloadmsg();
		for (String s : files) {
			configs.put(s, new ComboConfig(s));
		}

		Trigger.events = Config.getConfig("events");
	}

	public static ConfigPlanet getConfig(String name) {
		return configs.get(name);
	}

	public static void saveAll() {
		for (ConfigPlanet cp : configs.values()) {
			cp.save();
		}
	}

	public static void reloadAll() {
		for (ConfigPlanet cp : configs.values()) {
			cp.reload();
		}

		reloadmsg();
	}

	public static void reloadmsg() {
		ConfigPlanet cp = configs.get("config");
		MixerData.RADIO = cp.getBoolean("mx.radio");
		MixerData.BLOCK_EVENTS = cp.getBoolean("mx.events.block");
		MixerData.ENTITY_EVENTS = cp.getBoolean("mx.events.entity");
		MixerData.PLAYER_EVENTS = cp.getBoolean("mx.events.player");

		MixerData.MIXER_HEADER = cp.getString("mx.msg.MIXER_HEADER");
		MixerData.TOO_MANY_ARGS = cp.getString("mx.msg.TOO_MANY_ARGS");
		MixerData.TOO_LITTLE_ARGS = cp.getString("mx.msg.TOO_LITTLE_ARGS");
		MixerData.SPEAKER_DOESNT_EXIST = cp.getString("mx.msg.SPEAKER_DOESNT_EXIST");
		MixerData.SOUND_DOESNT_EXIST = cp.getString("mx.msg.SOUND_DOESNT_EXIST");
		MixerData.PLAYER_DOESNT_EXIST = cp.getString("mx.msg.PLAYER_DOESNT_EXIST");
		MixerData.WORLD_DOESNT_EXIST = cp.getString("mx.msg.WORLD_DOESNT_EXIST");
		MixerData.NO_PLAYER = cp.getString("mx.msg.NO_PLAYER");
		MixerData.PLAYING_SOUND = cp.getString("mx.msg.PLAYING_SOUND");
		MixerData.NO_PERM_CMD = cp.getString("mx.msg.NO_PERM_CMD");
		MixerData.NO_PERM_SOUND = cp.getString("mx.msg.NO_PERM_SOUND");
		MixerData.COMPILING = cp.getString("mx.msg.COMPILING");
		MixerData.COMPILING_END = cp.getString("mx.msg.COMPILING_END");
		MixerData.COMPILING_ERROR = cp.getString("mx.msg.COMPILING_ERROR");
		MixerData.CMD_USAGE_MX = cp.getString("mx.msg.CMD_USAGE_MX");
		MixerData.CMD_USAGE_LIST = cp.getString("mx.msg.CMD_USAGE_LIST");
		MixerData.CMD_USAGE_HELP = cp.getString("mx.msg.CMD_USAGE_HELP");
		MixerData.CMD_USAGE_PLAY = cp.getString("mx.msg.CMD_USAGE_PLAY");
		MixerData.CMD_USAGE_PLAYLOC = cp.getString("mx.msg.CMD_USAGE_PLAYLOC");
		MixerData.CMD_USAGE_PLAYAREA = cp.getString("mx.msg.CMD_USAGE_PLAYAREA");
		MixerData.CMD_USAGE_PLAYHERE = cp.getString("mx.msg.CMD_USAGE_PLAYHERE");
		MixerData.CMD_USAGE_REGLOC = cp.getString("mx.msg.CMD_USAGE_REGLOC");
		MixerData.CMD_USAGE_UNREGLOC = cp.getString("mx.msg.CMD_USAGE_UNREGLOC");
		MixerData.CMD_USAGE_RADIO = cp.getString("mx.msg.CMD_USAGE_RADIO");
		MixerData.CMD_USAGE_RELOAD = cp.getString("mx.msg.CMD_USAGE_RELOAD");
		MixerData.CMD_USAGE_STOP = cp.getString("mx.msg.CMD_USAGE_STOP");
		MixerData.CMD_USAGE_COMPILE = cp.getString("mx.msg.CMD_USAGE_COMPILE");
		MixerData.REGISTERED = cp.getString("mx.msg.REGISTERED");
		MixerData.UNREGISTERED = cp.getString("mx.msg.UNREGISTERED");
		MixerData.RELOADED = cp.getString("mx.msg.RELOADED");
		MixerData.STOPPED = cp.getString("mx.msg.STOPPED");
		MixerData.REGISTER_ALREADY_EXISTS = cp.getString("mx.msg.REGISTER_ALREADY_EXISTS");
		MixerData.REGISTER_NOT_EXISTS = cp.getString("mx.msg.REGISTER_NOT_EXISTS");
		MixerData.RADIO_TURNED_OFF = cp.getString("mx.msg.RADIO_TURNED_OFF");
		MixerData.RADIO_TURNED_ON = cp.getString("mx.msg.RADIO_TURNED_ON");
		MixerData.RADIO_TUNNED_TO = cp.getString("mx.msg.RADIO_TUNNED_TO");
		MixerData.RADIO_ALREADY_ON = cp.getString("mx.msg.RADIO_ALREADY_ON");
		MixerData.RADIO_ALREADY_OFF = cp.getString("mx.msg.RADIO_ALREADY_OFF");
		MixerData.RADIO_NO_PERM = cp.getString("mx.msg.RADIO_NO_PERM");
		MixerData.RADIO_DOESNT_EXIST = cp.getString("mx.msg.RADIO_DOESNT_EXIST");
		MixerData.RADIO_PLAYING_NOW = cp.getString("mx.msg.RADIO_PLAYING_NOW");
		MixerData.RADIO_DEFAULT = cp.getString("mx.msg.RADIO_DEFAULT");
		MixerData.RADIO_PLEASE_SELECT_CHANNEL = cp.getString("mx.msg.RADIO_PLEASE_SELECT_CHANNEL");
		MixerData.MIXER_LIST_PREFIX = cp.getString("mx.msg.MIXER_LIST_PREFIX");
		MixerData.RADIO_LIST_PREFIX = cp.getString("mx.msg.RADIO_LIST_PREFIX");
		MixerData.MX_LIST_ENTRY = cp.getString("mx.msg.MX_LIST_ENTRY");
	}

	public static class ComboConfig implements ConfigPlanet {

		public FileConfiguration file_config;
		public File file;

		public ComboConfig(String name) {
			file = new File(Mixer.plugin.getDataFolder(), name + ".yml");
			if (!file.exists()) {
				try {
					file.createNewFile();
					Bukkit.getServer().getConsoleSender().sendMessage("Made " + file.getPath());
				} catch (IOException e) {
					Bukkit.getServer().getConsoleSender().sendMessage("Could not make" + file.getPath());
					e.printStackTrace();
				}
			}
			file_config = YamlConfiguration.loadConfiguration(file);

			if (name.equals("sounds")) {
				PlayerManager.loadSounds(file_config);
			}
		}

		@Override
		public void write(String path, Object data) {
			this.file_config.set(path, data);
			this.save();
		}

		@Override
		public List<String> getStringList(String path) {
			return this.file_config.getStringList(path);
		}

		@Override
		public String getString(String path) {
			return this.file_config.getString(path);
		}

		@Override
		public Integer getInteger(String path) {
			if (!this.file_config.contains(path))
				return null;
			return this.file_config.getInt(path);
		}

		@Override
		public Double getDouble(String path) {
			if (!this.file_config.contains(path))
				return null;
			return this.file_config.getDouble(path);
		}

		@Override
		public Boolean getBoolean(String path) {
			return this.file_config.getBoolean(path);
		}

		@Override
		public ItemStack getItemStack(String path) {
			return this.file_config.getItemStack(path);
		}

		@Override
		public void save() {
			try {
				file_config.save(file);
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage("[New Planet] Error al guardar " + file.getPath());
			}
		}

		@Override
		public void reload() {
			try {
				file_config.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean contains(String path) {
			return file_config.isSet(path);
		}

	}

	public static interface ConfigPlanet {
		public void write(String path, Object data);

		public List<String> getStringList(String path);

		public String getString(String path);

		public Integer getInteger(String path);

		public Double getDouble(String path);

		public Boolean getBoolean(String path);

		public ItemStack getItemStack(String path);

		public void save();

		public void reload();

		public boolean contains(String path);
	}

}
