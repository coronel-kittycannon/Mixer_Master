package org.ckitty.radio;

import java.util.List;

import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;
import org.ckitty.mixer.MixerData;

public class RadioPublicPlayer extends AbstractRadio {

	protected List<Player> players;
	
	public RadioPublicPlayer(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public void play(Instruction inst) {
		inst.instruct(players);
	}

	@Override
	public RadioPublicPlayer clone() {
		return new RadioPublicPlayer(players);
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	@Override
	public void nowPlaying(String s) {
		for(Player p : players) {
			p.sendMessage(MixerData.MIXER_HEADER + MixerData.RADIO_PLAYING_NOW + s);
		}
	}

}
