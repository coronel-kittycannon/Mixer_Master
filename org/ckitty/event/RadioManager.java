package org.ckitty.event;

import org.bukkit.entity.Player;
import org.ckitty.mixer.MixerData;
import org.ckitty.radio.RadioPublicPlayer;
import org.ckitty.radio.RadioStation;

public class RadioManager {

	public static RadioPublicPlayer getFromPlayer(Player p) {
		for (RadioPublicPlayer rs : RadioStation.radios.values()) {
			if (rs.getPlayers().contains(p))
				return rs;
		}
		return null;
	}
	
	public static String getFromPlayerName(Player p) {
		for (String s : RadioStation.radios.keySet()) {
			if(RadioStation.radios.get(s).getPlayers().contains(p)) return s;
		}
		return null;
	}

	public static RadioPublicPlayer getFromString(String s) {
		return RadioStation.radios.get(s);
	}

	public static void putInAnother(RadioPublicPlayer quit, Player p, RadioPublicPlayer put) {
		if (quit != null)
			quit.getPlayers().remove(p);
		if (put != null)
			put.getPlayers().add(p);
	}

	public static RadioPublicPlayer getDefault() {
		return getFromString(MixerData.RADIO_DEFAULT);
	}

}
