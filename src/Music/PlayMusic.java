package Music;

import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class PlayMusic {

	private boolean exist = false;

    public void playMusic(String musicLocation)
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
                clip.loop(Clip.LOOP_CONTINUOUSLY); 

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
}
