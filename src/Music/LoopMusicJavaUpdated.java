package Music;

public class LoopMusicJavaUpdated {
    
    public void playMusicInScreen(String music) {
        String filepath = music; 

        PlayMusic musicObjective = new PlayMusic(); 
        musicObjective.playMusic(filepath); 
    }
    
    public void endMusic() {
    	
    }
}

