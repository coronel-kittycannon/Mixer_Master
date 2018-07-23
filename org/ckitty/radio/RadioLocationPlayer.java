package org.ckitty.radio;

import org.bukkit.Location;
import org.ckitty.compiler.Instruction;

public class RadioLocationPlayer extends AbstractRadio {

	protected Location loc;
	
	public RadioLocationPlayer(Location loc) {
		this.loc = loc;
	}
	
	@Override
	public void play(Instruction inst) {
		inst.instruct(loc);
	}

	@Override
	public RadioLocationPlayer clone() {
		return new RadioLocationPlayer(loc);
	}
	
	
	@Override
	public void nowPlaying(String s) {
		
	}
}
