package org.ckitty.compiler;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.ckitty.mixer.MixerData;

public class Wait extends Instruction {

	protected long time;
	
	public Wait(long time) {
		this.time = time;
	}
	
	@Override
	public void instruct(List<Player> e) {
		MixerData.waitNanos(time);
	}

	@Override
	public void instruct(Location l) {
		MixerData.waitNanos(time);
	}

	@Override
	public void instruct(Player p) {
		MixerData.waitNanos(time);
	}

}
