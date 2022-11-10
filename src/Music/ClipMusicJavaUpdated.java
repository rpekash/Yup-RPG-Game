package Music;

public class ClipMusicJavaUpdated {
    
	public boolean musicPlaying = false;
	
    public void playMusicInScreen(String music) {
        String filepath = music; 

        ClipMusic musicObjective = new ClipMusic(); 
        musicObjective.clipMusic(filepath);
        if (musicObjective.check()) {
        	musicPlaying = true;
        } else {
        	musicPlaying = false;
        }
    }
    
    public void endMusic() {
    	
    }
    
    public boolean isPlaying() {
    	return musicPlaying;
    }
}
