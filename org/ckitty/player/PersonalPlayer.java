package org.ckitty.player;

import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;

public class PersonalPlayer extends AbstractPlayer {

	protected Player p;
	
	public PersonalPlayer(Player p) {
		this.p = p;
	}

	@Override
	public void play(Instruction inst) {
		inst.instruct(p);
	}
	
	@Override
	public PersonalPlayer clone() {
		return new PersonalPlayer(p);
	}
	
	public Player getPlayer() {
		return this.p;
	}
	
}
