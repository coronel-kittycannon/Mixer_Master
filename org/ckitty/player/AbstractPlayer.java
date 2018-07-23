package org.ckitty.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.scheduler.BukkitRunnable;
import org.ckitty.compiler.Instruction;
import org.ckitty.mixer.Mixer;

public abstract class AbstractPlayer extends BukkitRunnable {

	protected static List<AbstractPlayer> players = new ArrayList<AbstractPlayer>();

	public static List<AbstractPlayer> getAllPlayers() {
		return players;
	}

	public static void cancellAll() {
		for (AbstractPlayer a : players) {
			a.forceStop();
			a.busy = false;
		}
	}

	public AbstractPlayer() {
		players.add(this);
	}

	protected boolean busy, repeat;
	protected Instruction[] inst = new Instruction[0];;

	@Override
	public void run() {
		this.busy = true;

		start();

		do {

			for (int i = 0; i < inst.length; i++) {
				if(!busy) return;
				this.play(inst[i]);
			}

		} while (repeat);

		end();

		this.busy = false;
	}

	public void playInstruction(Instruction[] inst) {
		if (inst == null)
			return;
		if (busy)
			return;
		this.inst = inst;
		this.runTaskAsynchronously(Mixer.plugin);
	}

	protected void start() {

	}

	protected void end() {

	}

	protected abstract void play(Instruction inst);

	@Override
	public abstract AbstractPlayer clone();

	public boolean isBusy() {
		return this.busy;
	}

	public void setRepeating(boolean repeat) {
		this.repeat = repeat;
	}

	public boolean isRepeating() {
		return this.repeat;
	}

	public final void forceStop() {

		if (busy) {
			this.busy = false;
			this.cancel();
		}
		
		this.repeat = false;
		this.inst = new Instruction[0];
		
	}

}
