package org.ckitty.compiler;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class Play extends Instruction {

	protected Sound s;
	protected float vol, pitch;

	public Play(Sound s, float vol, float pitch) {
		this.s = s;
		this.pitch = pitch;
		this.vol = vol;
	}

	@Override
	public void instruct(List<Player> e) {
		for (Player p : e) {
			if (p.isOnline())
				p.playSound(p.getLocation(), s, SoundCategory.RECORDS, vol, pitch);
		}
	}

	@Override
	public void instruct(Location l) {
		l.getWorld().playSound(l, s, SoundCategory.RECORDS, vol, pitch);
	}

	@Override
	public void instruct(Player p) {
		if (p.isOnline())
			p.playSound(p.getLocation(), s, SoundCategory.RECORDS, vol, pitch);
	}

}
