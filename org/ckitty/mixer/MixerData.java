package org.ckitty.mixer;

import java.util.List;

import org.bukkit.Sound;
import org.ckitty.compiler.Instruction;

public class MixerData {

	public static boolean RADIO = true;
	public static boolean BIOME_SOUNDS = false;
	public static int BIOME_TRACKER_RATE = 50;
	public static boolean BLOCK_EVENTS = true;
	public static boolean ENTITY_EVENTS = true;
	public static boolean PLAYER_EVENTS = true;

	// sorry for bäd grammar
	public static String MIXER_HEADER = "§9§l[§7§lMixerMaster§9§l] §r";
	public static String TOO_MANY_ARGS = "There of were too much args";
	public static String TOO_LITTLE_ARGS = "There of were too little args";
	public static String SPEAKER_DOESNT_EXIST = "No speaker of foundings";
	public static String SOUND_DOESNT_EXIST = "No sound of foundings";
	public static String PLAYER_DOESNT_EXIST = "No player of foundings";
	public static String WORLD_DOESNT_EXIST = "No player of foundings";
	public static String NO_PLAYER = "You not of player!";
	public static String NO_NUMBER = "I of needings a number";
	public static String PLAYING_SOUND = "Playings: ";
	public static String NO_PERM_CMD = "You not of havings permission!";
	public static String NO_PERM_SOUND = "You not of havings permission!";
	public static String COMPILING = "Is of compiling...";
	public static String COMPILING_END = "End of compiling!";
	public static String COMPILING_ERROR = "Oh no! An error has of ocurred!";

	public static String CMD_USAGE_MX = "Use: /mx <sound>";
	public static String CMD_USAGE_LIST = "Use: /mx <list>";
	public static String CMD_USAGE_HELP = "There is nothing I can do 2 help u lols";
	public static String CMD_USAGE_PLAY = "Use: /mx play <sound> [player]";
	public static String CMD_USAGE_PLAYLOC = "Use /mx playloc <sound> <x> <y> <z> <world>";
	public static String CMD_USAGE_PLAYAREA = "Use: /mx playloca <sound> <x> <y> <z> <xr> <yr> <zy> <world>";
	public static String CMD_USAGE_PLAYHERE = "Use: /mx playhere <sound> [r]";
	public static String CMD_USAGE_REGLOC = "Use: /mx regloc <name> <sound>";
	public static String CMD_USAGE_UNREGLOC = "Use: /mx unregloc <name>";
	public static String CMD_USAGE_RADIO = "Use: /mx radio <channel|on|off>";
	
	public static String CMD_USAGE_RELOAD = "Use: /mx reload";
	public static String CMD_USAGE_STOP = "Use: /mx stop";
	public static String CMD_USAGE_EDIT = "Use: /mx edit <sound> <#line> <newline>";
	public static String CMD_USAGE_TELL = "Use: /mx tell <sound> <#line>";
	public static String CMD_USAGE_COMPILE = "Use: /mx compile <args...>";

	public static String REGISTERED = "Registered speaker: ";
	public static String UNREGISTERED = "Unregistered speaker: ";
	public static String RELOADED = "Reloaded MixerMaster!";
	public static String STOPPED = "Stopped Mixer. Please reload to enable again.";
	public static String REGISTER_ALREADY_EXISTS = "That speaker already exists!";
	public static String REGISTER_NOT_EXISTS = "That speaker doesn't exists!";
	
	public static String RADIO_TURNED_OFF = "Radio of turned off";
	public static String RADIO_TURNED_ON = "Radio of turned on";
	public static String RADIO_TUNNED_TO = "Radio tunned to: ";
	public static String RADIO_ALREADY_ON = "Radio of on anyway";
	public static String RADIO_ALREADY_OFF = "Radio of off anyway";
	public static String RADIO_NO_PERM = "Yuo cannot use radios";
	public static String RADIO_DOESNT_EXIST = "That channel does not of exists";
	public static String RADIO_PLAYING_NOW = "Now of playings: ";
	
	public static String RADIO_DEFAULT;
	public static String RADIO_PLEASE_SELECT_CHANNEL = "No default channel! Please use /mx radio <channel> instead";
	
	public static String MIXER_LIST_PREFIX = "Loaded Sounds: ";
	public static String RADIO_LIST_PREFIX = "Loaded Radios: ";
	public static String MX_LIST_ENTRY = " - ";
	
	public static final double SECOND = 1_000_000_000;

	public static Instruction[] toArray(List<Instruction> inst) {
		Instruction[] inst_array = new Instruction[inst.size()];

		for (int i = 0; i < inst.size(); i++) {
			inst_array[i] = inst.get(i);
		}

		return inst_array;
	}

	//	public static void playTo(Player p) {
	//		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, SoundCategory.RECORDS, 1, 1);
	//		p.playNote(p.getLocation(), Instrument.CHIME, Note.natural(0, Tone.A));
	//
	//	}

	public static void waitNanos(long ns) {
		long start = System.nanoTime();
		while (start + ns > System.nanoTime())
			;
	}

	public static float getNotePitch(String s) {
		if (s.isEmpty())
			throw new IllegalArgumentException("String must not be empty");

		char cha = s.charAt(0);

		if (cha >= '0' && cha <= '9') { // is number
			return getNotePitchByNumber(Integer.parseInt(s));
		}

		if (cha >= 'A' && cha <= 'G') { // is letter
			return getNotePitchByLetter(s);
		}

		throw new IllegalArgumentException("Unrecognized note format: [" + s + "]");
	}

	public static float getNotePitchByLetter(String s) {
		switch (s) {
		case "F#":
			return 0.5f;
		case "G":
			return 0.529732f;
		case "G#":
			return 0.561231f;
		case "A":
			return 0.594604f;
		case "A#":
			return 0.629961f;
		case "B":
			return 0.667420f;
		case "C":
			return 0.707107f;
		case "C#":
			return 0.749154f;
		case "D":
			return 0.793701f;
		case "D#":
			return 0.840896f;
		case "E":
			return 0.890899f;
		case "F":
			return 0.943874f;
		case "F#+":
			return 1f;
		case "G+":
			return 1.059463f;
		case "G#+":
			return 1.122462f;
		case "A+":
			return 1.189207f;
		case "A#+":
			return 1.259921f;
		case "B+":
			return 1.334840f;
		case "C+":
			return 1.414214f;
		case "C#+":
			return 1.498307f;
		case "D+":
			return 1.587401f;
		case "D#+":
			return 1.681793f;
		case "E+":
			return 1.781797f;
		case "F+":
			return 1.887749f;
		case "F#++":
			return 2f;
		}

		throw new IllegalArgumentException("Unknown note with id: [" + s + "]");
	}

	public static float getNotePitchByNumber(int i) {
		switch (i) {
		case 0:
			return 0.5f;
		case 1:
			return 0.529732f;
		case 2:
			return 0.561231f;
		case 3:
			return 0.594604f;
		case 4:
			return 0.629961f;
		case 5:
			return 0.667420f;
		case 6:
			return 0.707107f;
		case 7:
			return 0.749154f;
		case 8:
			return 0.793701f;
		case 9:
			return 0.840896f;
		case 10:
			return 0.890899f;
		case 11:
			return 0.943874f;
		case 12:
			return 1f;
		case 13:
			return 1.059463f;
		case 14:
			return 1.122462f;
		case 15:
			return 1.189207f;
		case 16:
			return 1.259921f;
		case 17:
			return 1.334840f;
		case 18:
			return 1.414214f;
		case 19:
			return 1.498307f;
		case 20:
			return 1.587401f;
		case 21:
			return 1.681793f;
		case 22:
			return 1.781797f;
		case 23:
			return 1.887749f;
		case 24:
			return 2f;
		}

		throw new IllegalArgumentException("Unknown note with id: [" + i + "]");
	}

	public static Sound getSound(String s) {
		switch (s) {
		case "a":
			return Sound.BLOCK_NOTE_HARP;
		case "b":
			return Sound.BLOCK_NOTE_BASS;
		case "s":
			return Sound.BLOCK_NOTE_SNARE;
		case "h":
			return Sound.BLOCK_NOTE_HAT;
		case "d":
			return Sound.BLOCK_NOTE_BASEDRUM;
		case "k":
			return Sound.BLOCK_NOTE_BELL;
		case "f":
			return Sound.BLOCK_NOTE_FLUTE;
		case "c":
			return Sound.BLOCK_NOTE_CHIME;
		case "g":
			return Sound.BLOCK_NOTE_GUITAR;
		case "x":
			return Sound.BLOCK_NOTE_XYLOPHONE;
		default:
			throw new IllegalArgumentException("Unknown sound instrument: [" + s + "]");
		}
	}

}
