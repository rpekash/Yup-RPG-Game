package Music;

import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class ClipMusic {

	private boolean exist = false;
	private boolean playing = false;

    public void clipMusic(String musicLocation)
    {
    	
    	
    	File musicPath = new File(musicLocation);

        try 
        {

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (clip.isRunning()) {
                	playing = true;
                } else {
                	playing = false;
                }
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
    
    public boolean check() {
    	return playing;
    }
    
}
