package raffa.atlasengine;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;


public class Audio {
	
	private HashMap soundMap;
	private String[] playList;
	private String currentPlaying;
	
	public Audio() {
		
		playList = new String[0];
	}
	
	public Audio(String[] playList) {
		
		load(playList);
	}
	
	private void addNullSlot() {
		
		int length = playList.length;
		
		String[] prov = new String[length + 1];
		
		for (int i = 0; i < length; i++)
			prov[i] = playList[i];
		
		length++;
		
		playList = new String[length];
		
		for (int i = 0; i < length; i++)
			playList[i] = prov[i];
	}
	
	public void removeNullSlots() {
		
		int countNull = 0;
		
		int length = playList.length;
		
		for (int i = 0; i < length; i++) {
			if (playList[i] == null)
				countNull++;
		}
		
		length -= countNull;
		
		String[] prov = new String[length];
		
		int j = 0;
		int w = 0;
		while (w < length) {
			if (playList[j] == null)
				j++;
			prov[w] = playList[j];
			j++;
			w++;
		}
		
		playList = new String[length];
		
		for (int i = 0; i < length; i++)
			playList[i] = prov[i];
	}
	
	public void load(String path) {
		
		soundMap = new HashMap();
		
		addNullSlot();
		
		playList[playList.length - 1] = path;
		
		for (int i = 0; i < playList.length; i++) {
			AudioClip clip = Applet.newAudioClip(getClass().getResource(playList[i]));
		
		if (clip == null)
			System.out.println("Sound error: " + playList[i]);
		else
			soundMap.put(playList[i], clip);
		}
	}
	
	public void load(String[] playList) {
		
		soundMap = new HashMap();
		this.playList = playList;
		
		for (int i = 0; i < playList.length; i++) {
			AudioClip clip = Applet.newAudioClip(getClass().getResource(playList[i]));
		
		if (clip == null)
			System.out.println("Sound error: " + playList[i]);
		else
			soundMap.put(playList[i], clip);
		}
	}
	
	public void play(String path, boolean toLoop) {
		
		AudioClip clip = (AudioClip) soundMap.get(path);
		if (clip == null) {
			System.out.println("File " + path + " not loaded");
		}
		
		if (toLoop)
			clip.loop();
		else
			clip.play();
		
		currentPlaying = path;
	}
	
	public void play(int index, boolean toLoop) {
		
		play(playList[index], toLoop);
	}
	
	public void stop() {
		
		AudioClip clip = (AudioClip) soundMap.get(currentPlaying);
		clip.stop();
	}
}
