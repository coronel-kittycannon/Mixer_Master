package org.ckitty.compiler;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Sound;
import org.ckitty.mixer.Mixer;
import org.ckitty.mixer.MixerData;
import org.ckitty.mixer.MixerSound;

public class MixerCompiler {

	public static List<Instruction> compileSound(MixerSound s) {
		MixerCompiler c = new MixerCompiler(s);
		
		try {
			c.compile();
		} catch (Exception e) {
			Mixer.plugin.getLogger().warning("Could not compile sound " + s.getName());
			Mixer.plugin.getLogger().warning("Error Type: " + e.getClass().getSimpleName());
			Mixer.plugin.getLogger().warning("Message: " + e.getMessage());
			
			e.printStackTrace();
		}
		
		return c.notes;
	}

	protected List<Instruction> notes;
	protected List<Instruction> chorus;
	protected float vol = 1f;
	protected MixerSound mxs;

	public MixerCompiler(MixerSound mxs) {
		this.mxs = mxs;
		notes = new ArrayList<Instruction>();
		chorus = new ArrayList<Instruction>();
	}

	public void compile() throws Exception {
		chorus = this.generalCompiler(mxs.getChorus());
		notes = this.generalCompiler(mxs.getNotes());
	}

	public List<Instruction> generalCompiler(List<String> compile) {
		List<Instruction> res = new ArrayList<Instruction>();
		
		for (int i = 0; i < compile.size(); i++) {
			String s = compile.get(i);
			parseLine(s, res);
		}
		
		return res;
	}

	public void parseLine(String line, List<Instruction> res) {
		String[] split = line.split(" ");

		for (int i = 0; i < split.length; i++) {
			String s = split[i];

			if (s.isEmpty())
				continue;
			
			if(s.equals("chorus")) {
				res.addAll(chorus);
				continue;
			}

			if (s.startsWith("wait")) {
				res.add(this.handleWait(s));
				continue;
			}
			
			if(s.startsWith("-")) {
				res.add(this.handleHyphenWait(s));
				continue;
			}
			
			if(s.startsWith("vol")) {
				this.handleVolume(s);
				continue;
			}
			
			if(s.startsWith("%")) {
				this.handleVolume("vol" + s.substring(1));
				continue;
			}
			
			Sound sound = Sound.BLOCK_NOTE_HARP;

			int pos = 0;
			char cha = s.charAt(pos);
			if (cha >= 'a' && cha <= 'z') {
				sound = MixerData.getSound(Character.toString(cha));
				pos++;
			}
			
			float pitch = MixerData.getNotePitch(s.substring(pos));

			res.add(new Play(sound, vol, pitch));
		}

	}
	
	public void handleVolume(String s) {
		float v = 1f;
		
		s = s.replaceFirst("vol", "");
		if(!s.isEmpty()) {
			v = Float.parseFloat(s);
		}
		
		this.vol = v;
	}
	
	public Instruction handleHyphenWait(String s) {
		long l = 0;
		int pos = 0;
		int cha = s.charAt(pos);
		
		while(cha == '-') {
			l++;
			cha = (++pos >= s.length()) ? -1 : s.charAt(pos);
		}
		
		return handleWait("wait" + l);
	}

	public Instruction handleWait(String s) {
		long l = 1;

		s = s.replaceFirst("wait", "");
		if (!s.isEmpty()) {
			l = Long.parseLong(s);
		}

		return new Wait(mxs.getTimeForPause(l));
	}

}
