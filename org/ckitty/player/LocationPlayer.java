package org.ckitty.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.ckitty.compiler.Instruction;
import org.ckitty.mixer.Config;
import org.ckitty.mixer.Config.ConfigPlanet;
import org.ckitty.mixer.MixerSound;

public class LocationPlayer extends AbstractPlayer {
	
	public static Map<String, LocationPlayer> loop_players = new HashMap<String, LocationPlayer>();
	
	public static void registerLoopLocPlayer(String name, Location loc, MixerSound sound) {
		LocationPlayer lp = new LocationPlayer(loc);
		lp.setRepeating(true);
		lp.sound = sound.getName();
		lp.playInstruction(sound.getInstructions());
		
		loop_players.put(name, lp);
	}
	
	public static void unregLoopLocPlayer(String name) {
		LocationPlayer lp = loop_players.get(name);
		lp.forceStop();
		loop_players.remove(name);
	}
	
	public static void unregAll() {
		for(String s : loop_players.keySet()) {
			unregLoopLocPlayer(s);
		}
	}
	
	public static void unloadAll() {
		for(String s : loop_players.keySet()) {
			LocationPlayer lp = loop_players.get(s);
			lp.forceStop();
		}
	}
	
	public static void saveLoopLocs() {
		ConfigPlanet cp = Config.getConfig("radios");
		
		for(String s : loop_players.keySet()) {
			LocationPlayer lp = loop_players.get(s);
			
			cp.write("looplocs.data." + s + ".x", lp.getLocation().getX());
			cp.write("looplocs.data." + s + ".y", lp.getLocation().getY());
			cp.write("looplocs.data." + s + ".z", lp.getLocation().getZ());
			cp.write("looplocs.data." + s + ".world", lp.getLocation().getWorld().getName());
			cp.write("looplocs.data." + s + ".sound", lp.sound);
			
		}
		
		List<String> saves = new ArrayList<String>();
		saves.addAll(loop_players.keySet());
		cp.write("looplocs.saves", saves);
	}
	
	public static void reloadLoopLocs() {
		unloadAll();
		ConfigPlanet cp = Config.getConfig("radios");
		
		for(String s : cp.getStringList("looplocs.saves")) {
			double x = cp.getDouble("looplocs.data." + s + ".x");
			double y = cp.getDouble("looplocs.data." + s + ".y");
			double z = cp.getDouble("looplocs.data." + s + ".z");
			World w = Bukkit.getWorld(cp.getString("looplocs.data." + s + ".world"));
			MixerSound mxs = PlayerManager.LOADED_SOUNDS.get(cp.getString("looplocs.data." + s + ".sound"));
			
			LocationPlayer.registerLoopLocPlayer(s, new Location(w, x, y, z), mxs);
		}
	}

	protected String sound;
	protected Location loc;
	
	public LocationPlayer(Location loc) {
		this.loc = loc;
	}
	
	@Override
	protected void play(Instruction inst) {
		
		inst.instruct(loc);
	}

	@Override
	public LocationPlayer clone() {
		return new LocationPlayer(loc);
	}
	
	public Location getLocation() {
		return this.loc.clone();
	}
	
}
