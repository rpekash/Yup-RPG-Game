package Music;

import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class ClipMusic {

	private boolean exist = false;

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
