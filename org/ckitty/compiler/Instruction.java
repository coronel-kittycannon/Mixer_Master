package org.ckitty.compiler;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Instruction {
	
	public abstract void instruct(List<Player> p);
	public abstract void instruct(Player p);
	public abstract void instruct(Location l);
	
}
