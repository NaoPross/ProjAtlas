package raffa.atlasengine.support;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Audio implements LineListener {
	
	DecimalFormat df;
	Clip clip;
	double duration; // duration of the clip
	boolean loop; 		// True if the clip is repeated continously
	FloatControl volume; // Volume manager
	
	/**
	 * Volume constants
	 */
	
	public static final int VOLUME_DEFAULT = 85;
	public static final int VOLUME_MAX = 107;
	public static final int VOLUME_MUTE = 0;
	public static final int VOLUME_HIGH = 100;
	public static final int VOLUME_MEDIUM = 75;
	public static final int VOLUME_LOW = 60;
	
	/**
	 * Execute a sound file adapting on its format
	 */
	
	public Audio (String path) {
		
		df = new DecimalFormat("0.#");
		loop = false;
		loadClip(path);
		setVolume(VOLUME_DEFAULT);
		play();
	}
	
	public Audio(String path, boolean loop) {
		
		df = new DecimalFormat("0.#");
		this.loop = loop;
		loadClip(path);
		setVolume(VOLUME_DEFAULT);
		play();
	}
	
	/**
	 * Load the file in the program but not start it
	 */
	
	private void loadClip(String path) {
		
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
			AudioFormat format = stream.getFormat();
			
			/**
			 * Convertion of the file in case the format is unsupported
			 */
			
			if ((format.getEncoding() == AudioFormat.Encoding.ULAW) || (format.getEncoding() == AudioFormat.Encoding.ALAW)) {
				
				AudioFormat newFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(),
														format.getSampleSizeInBits(), format.getChannels(), format.getFrameSize() * 2,
														format.getFrameRate(), true);
				
				stream = AudioSystem.getAudioInputStream(newFormat, stream);
				format = newFormat;
			}
			
			/**
			 * Create the sound clip
			 */
			
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("Unsupported Clip File: " + path);
			}
			
			clip = (Clip) AudioSystem.getLine(info);
			clip.addLineListener(this);
			clip.open(stream);
			stream.close();
			
			duration = clip.getMicrosecondLength() / 1000000; // Duration in seconds
			
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
		} catch (UnsupportedAudioFileException e){
			System.out.println("Unsupported audio file :" + path);
		} catch (LineUnavailableException e) {
			System.out.println("No audio line available for :" + path);
		} catch (IOException e) {
			System.out.println("Could not read: " + path);
		} catch (Exception e) {
			System.out.println("Problem with: " + path);
			e.printStackTrace();
		}
	}
	
	/**
	 * Return the duration in integer seconds
	 */
	
	public int loopCount() {
		
		int loopCount = (int) (duration);
		return loopCount;
	}
	
	/**
	 * Start the clip basing the loop variable
	 * If it's false the sound is played once
	 * Else it enter in a loop
	 */
	
	public void play() {
		
		if (clip != null) {
			if (!loop)
				clip.start();
			else
				clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	/**
	 * Stop the clip
	 */
	
	public void stop() {
		
		if (clip != null && clip.isRunning())
			clip.stop();
		else
			System.out.println("Audioclip is not running");
	}
	
	/**
	 * Set the loop variable
	 */
	
	public void setLoop(boolean loop) {
		
		this.loop = loop;
	}
	
	/**
	 * Set the decibel volume using a percent value
	 */
	
	public void setVolume(int perc) {
		
		float value = 80.0f * ((float)(perc / 100.0f) - 1.0f);
		volume.setValue(value);
	}
	
	/**
	 * Get the volume in a percent value
	 */
	
	public int getVolume() {
		
		float value = volume.getValue();
		int perc = (int)((value / 80 + 1) * 100);
		return perc;
	}

	@Override
	public void update(LineEvent lineEvent) {
		
		if (lineEvent.getType() == LineEvent.Type.STOP) {
			System.out.println("Exiting..");
			
			clip.stop();
			lineEvent.getLine().close();
		}
	}
	
	
}
