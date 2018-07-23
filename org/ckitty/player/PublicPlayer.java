package org.ckitty.player;

import java.util.List;

import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;

public class PublicPlayer extends AbstractPlayer {

	protected List<Player> players;
	
	public PublicPlayer(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public void play(Instruction inst) {
		inst.instruct(players);
	}

	@Override
	public PublicPlayer clone() {
		return new PublicPlayer(players);
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}

}
