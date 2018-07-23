package org.ckitty.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.ckitty.mixer.Config;
import org.ckitty.mixer.Config.ConfigPlanet;
import org.ckitty.mixer.MixerSound;
import org.ckitty.player.PlayerManager;

public class RadioStation {
	
	public static Map<String, RadioPublicPlayer> radios = new HashMap<String, RadioPublicPlayer>();
	
	public static void saveRadios() {
		ConfigPlanet cp = Config.getConfig("radios");
		List<String> sounds = new ArrayList<String>();
		for(String s : radios.keySet()) {
			RadioPublicPlayer rpp = radios.get(s);
			List<String> ras = new ArrayList<String>();
			sounds.add(s);
			
			for(MixerSound mxs : rpp.sounds) {
				ras.add(mxs.getName());
			}
			
			cp.write("radios." + s , ras);
			
			// save fake players
			
			
		}
		cp.write("radiosave", sounds);
	}
	
	public static void loadRadios() {
		for(RadioPublicPlayer rpp : radios.values()) {
			rpp.forceStop();
		}
		
		radios.clear();
		
		ConfigPlanet cp = Config.getConfig("radios");
		for(String s : cp.getStringList("radiosave")) {
			radios.put(s, getPlayerStation(s));
		}
		
		// load fake players
		
	}

	public static RadioPublicPlayer getPlayerStation(String name) {
		ConfigPlanet cp = Config.getConfig("radios");
		
		List<String> sounds = cp.getStringList("radios." + name);
		RadioPublicPlayer rpp = new RadioPublicPlayer(new ArrayList<Player>());
		rpp.playRadio(getSoundsFrom(sounds));
		return rpp;
	}
	
	public static MixerSound[] getSoundsFrom(List<String> s) {
		MixerSound[] sounds = new MixerSound[s.size()];
		
		for(int i = 0; i < s.size(); i++) {
			sounds[i] = PlayerManager.LOADED_SOUNDS.get(s.get(i));
			if(sounds[i] == null) throw new NullPointerException("Sound cannot be null!");
		}
		
		return sounds;
	}
	
}
