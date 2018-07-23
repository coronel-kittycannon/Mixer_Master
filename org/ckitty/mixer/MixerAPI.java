package org.ckitty.mixer;

import static org.ckitty.mixer.MixerData.SECOND;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;
import org.ckitty.compiler.Instruction;
import org.ckitty.compiler.MixerCompiler;
import org.ckitty.compiler.Wait;
import org.ckitty.event.RadioManager;
import org.ckitty.mixer.Mixer.TimeStep;
import org.ckitty.player.PlayerManager;
import org.ckitty.radio.RadioPublicPlayer;

public class MixerAPI {

	public JavaPlugin getPlugin() {
		return Mixer.plugin;
	}
	
	public MixerSound getSound(String name) {
		return PlayerManager.getLoadedSound(name);
	}
	
	public RadioPublicPlayer getRadioStation(String name) {
		return RadioManager.getFromString(name);
	}
	
	public Instruction[] compileString(List<String> s, TimeStep ts, int ups) throws Exception {
		double step_size;
		
		switch (ts) {
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
			double ns = SECOND / (double) ups;
			step_size = Math.round(ns);
			break;
		default:
			throw new IllegalArgumentException("There must be a timestep value!");
		}
		
		return new MixerCompiler(null) {
			@Override
			public Instruction handleWait(String s) {
				long l = 1;
				s = s.replaceFirst("wait", "");
				if (!s.isEmpty()) {
					l = Long.parseLong(s);
				}
				return new Wait(Math.round(l * step_size));
			}
		}.generalCompiler(s).toArray(new Instruction[0]);
	}
	
}
