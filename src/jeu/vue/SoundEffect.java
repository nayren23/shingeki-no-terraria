package jeu.vue;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SoundEffect {

    private Clip clip;

    public SoundEffect(String fileLocation) {
        try {
            URL url = getClass().getClassLoader().getResource(fileLocation);
            assert url != null;
            InputStream input = url.openStream();
            InputStream audio = new BufferedInputStream(input);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        if(!clip.isRunning()) {
            clip.start();
            clip.setFramePosition(0);
        }
    }
    
    public void stopSound () {
        if(clip.isRunning()) {
        	clip.stop();
            clip.setFramePosition(0);
        }
    }

}
