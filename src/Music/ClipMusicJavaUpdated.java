package Music;

public class ClipMusicJavaUpdated {
    
    public void playMusicInScreen(String music) {
        String filepath = music; 

        ClipMusic musicObjective = new ClipMusic(); 
        musicObjective.clipMusic(filepath); 
    }
    
    public void endMusic() {
    	
    }
}
