package org.ckitty.mixer;

import static org.ckitty.mixer.MixerData.SECOND;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.ckitty.compiler.Instruction;
import org.ckitty.compiler.MixerCompiler;
import org.ckitty.mixer.Config.ConfigPlanet;
import org.ckitty.mixer.Mixer.TimeStep;
import org.ckitty.player.PlayerManager;

public class MixerSound {
	
	public static void saveNew(String name, TimeStep ts, int ups, String perm_play, List<String> notes, List<String> chorus) {
		ConfigPlanet cp = Config.getConfig("sounds");
		
		cp.write(name + ".timestep", ts + (ts.equals(TimeStep.UPDATES_PER_SECOND) ? ":" + Integer.toString(ups) : ""));
		cp.write(name + ".play_perm", perm_play);
		cp.write(name + ".notes", notes);
		cp.write(name + ".chorus", chorus);
	}

	protected List<String> notes;
	protected List<String> chorus;
	protected String name, perm_play;
	protected long step_size;
	protected Instruction[] inst;

	public MixerSound(String name) {
		if (name == null)
			throw new IllegalArgumentException("A sound name cannot be null!");
	
		this.name = name;
		FileConfiguration cp = PlayerManager.config;
		String[] ts = cp.getString(name + ".timestep").split(":");
		perm_play = cp.getString(name + ".play_perm");

		switch (TimeStep.valueOf(ts[0])) {
		case MINECRAFT:
			double mc_ns = SECOND / 20d;
			step_size = Math.round(mc_ns);
			break;
		case MILISECONDS:
			double ms = SECOND / 1000d;
			step_size = Math.round(ms);
			break;
		case NANO_SECONDS:
			step_size = 1;
			break;
		case REDSTONE:
			double rs_ns = SECOND / 10d;
			step_size = Math.round(rs_ns);
			break;
		case UPDATES_PER_SECOND:
			double ns = SECOND / (double) Integer.parseInt(ts[1]);
			step_size = Math.round(ns);
			break;
		default:
			throw new IllegalArgumentException("There must be a timestep value!");
		}
		
		notes = cp.getStringList(name + ".notes");
		chorus = cp.getStringList(name + ".chorus");
	}
	
	public void compile() {
		this.inst = MixerData.toArray(MixerCompiler.compileSound(this));
	}
	
	public boolean isCompiled() {
		return this.inst != null;
	}
	
	public Instruction[] getInstructions() {
		return this.inst;
	}
	
	public List<String> getNotes() {
		return notes;
	}

	public List<String> getChorus() {
		return chorus;
	}

	public String getPermPlay() {
		return perm_play;
	}

	public long getStepSize() {
		return step_size;
	}

	public boolean canPlay(Player p) {
		return p.hasPermission(this.perm_play);
	}
	
	public long getTimeForPause(long time) {
		return time * step_size;
	}
	
	public String getName() {
		return this.name;
	}

}
