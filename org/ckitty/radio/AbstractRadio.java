package org.ckitty.radio;

import org.ckitty.compiler.Instruction;
import org.ckitty.mixer.Mixer;
import org.ckitty.mixer.MixerSound;
import org.ckitty.player.AbstractPlayer;

public abstract class AbstractRadio extends AbstractPlayer {

	protected MixerSound[] sounds;
	protected int pos;
	
	public MixerSound[] getSounds() {
		return this.sounds;
	}
	
	public int lenght() {
		return this.sounds.length;
	}
	
	@Override
	protected void start() {
		this.repeat = true;
	}
	
	@Override
	public void run() {
		this.busy = true;

		start();

		do {
			
			if(pos == sounds.length) pos = 0;
			MixerSound mxs = sounds[pos++];
			this.nowPlaying(mxs.getName());
			Instruction[] inst = mxs.getInstructions();
			
			for (int i = 0; i < inst.length; i++) {
				if(!busy) return;
				this.play(inst[i]);
			}

		} while (repeat);

		end();

		this.busy = false;
	}

	public void playRadio(MixerSound... mxs) {
		this.sounds = mxs;
		if(sounds.length == 0) return;
		this.runTaskAsynchronously(Mixer.plugin);
	}
	
	public int getCurrent() {
		return this.pos;
	}
	
	public String getCurrentName() {
		return this.sounds[pos].getName();
	}
	
	public void nowPlaying(String s) {
		
	}
	
	
	@Override
	public abstract AbstractRadio clone();
	
	@Override
	public void playInstruction(Instruction[] inst) {
		
	}
	
}
