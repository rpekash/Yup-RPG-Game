package Music;

public class LoopMusicJavaUpdated {
	
	private PlayMusic pM = new PlayMusic();
    
    public void playMusicInScreen(String music) {
        String filepath = music; 

        pM.playMusic(filepath); 
    }
    
    public void endMusic() {
    	
    }
    
    public void volumeUp() {
    	pM.volumeUp();
    }
    
    public void volumeDown() {
    	pM.volumeDown();
    }
}

