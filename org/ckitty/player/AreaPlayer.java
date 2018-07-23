package org.ckitty.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;

public class AreaPlayer extends AbstractPlayer {

	protected double x_radius, y_radius, z_radius;
	protected Location center;

	public AreaPlayer(Location center, double x_radius, double y_radius, double z_radius) {
		this.x_radius = x_radius;
		this.y_radius = y_radius;
		this.z_radius = z_radius;
		this.center = center;
	}

	@Override
	protected void play(Instruction inst) {
		inst.instruct(this.playersInLoc());
	}

	public List<Player> playersInLoc() {
		List<Player> players = new ArrayList<Player>();

		for (Entity e : center.getWorld().getNearbyEntities(center, x_radius, y_radius, z_radius)) {
			if (e instanceof Player)
				players.add((Player) e);
		}

		return players;
	}

	public double getRadiusX() {
		return x_radius;
	}

	public double getRadiusY() {
		return y_radius;
	}

	public double getRadiusZ() {
		return z_radius;
	}

	public Location getCenter() {
		return center;
	}

	@Override
	public AreaPlayer clone() {
		return new AreaPlayer(center, x_radius, y_radius, z_radius);
	}

}
