package org.ckitty.player;

import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;

public class PersonalLocationPlayer extends PersonalPlayer {

	public PersonalLocationPlayer(Player p) {
		super(p);
	}
	
	@Override
	public void play(Instruction inst) {
		inst.instruct(p.getLocation());
	}

}
