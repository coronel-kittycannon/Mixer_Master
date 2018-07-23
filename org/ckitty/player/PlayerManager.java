package org.ckitty.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.ckitty.event.Trigger;
import org.ckitty.mixer.Mixer;
import org.ckitty.mixer.MixerSound;

public class PlayerManager {

	public static final Map<String, MixerSound> LOADED_SOUNDS = new HashMap<String, MixerSound>();
	public static FileConfiguration config;
	public static Trigger trigger = new Trigger();

	public static void play(Player p, String name) {
		PersonalPlayer player = new PersonalPlayer(p);
		player.playInstruction(LOADED_SOUNDS.get(name).getInstructions());
	}

	public static boolean canPlay(Player p, String sound) {
		MixerSound mx = LOADED_SOUNDS.get(sound);
		if (mx == null)
			return false;
		return mx.canPlay(p);
	}

	public static void loadSounds(FileConfiguration config) {
		PlayerManager.config = config;
		
		reloadSounds();
	}

	public static void reloadSounds() {
		LOADED_SOUNDS.clear();

		for (String s : config.getKeys(false)) {
			try {
				MixerSound mxs = new MixerSound(s);
				mxs.compile();
				LOADED_SOUNDS.put(s, mxs);
			} catch (Exception e) {
				Mixer.plugin.getLogger().warning("Could not load sound " + s);
				Mixer.plugin.getLogger().warning("Error Type: " + e.getClass().getSimpleName());
				Mixer.plugin.getLogger().warning("Message: " + e.getMessage());
				
				e.printStackTrace();
			}
		}
	}

	public static MixerSound getLoadedSound(String name) {
		return LOADED_SOUNDS.get(name);
	}

	public static boolean hasLoadedSound(String name) {
		return LOADED_SOUNDS.get(name) != null;
	}

}
