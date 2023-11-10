
package input;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundHandler {
    
    public static void RunMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        
        File file = new File("music.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        
        clip.start();
        clip.loop(10);
        
    }
}
