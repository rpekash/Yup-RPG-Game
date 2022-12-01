package Music;

import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl; 

public class PlayMusic {

	private Clip clip;
	private boolean exist = false;
	private FloatControl fc;
	public float currVol;

    public void playMusic(String musicLocation)
    {
    	
    	
    	File musicPath = new File(musicLocation);
        try 
        {
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start(); 
                clip.loop(Clip.LOOP_CONTINUOUSLY); 
                fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
            else 
            {
                
            }
        }
        catch(Exception ex)
        {
        	System.out.println("Error"); 
            ex.printStackTrace(); 
        }
    }
    
    public void volumeUp() {
    	currVol += 1.0f;
    	if (currVol > 6.0f) {
    		currVol = 6.0f;
    	}
    	fc.setValue(currVol);
    }
    
    public void volumeDown() {
    	currVol -= 1.0f;
    	if (currVol < -80.0f) {
    		currVol = -80.0f;
    	}
    	fc.setValue(currVol);
    }
    
}
