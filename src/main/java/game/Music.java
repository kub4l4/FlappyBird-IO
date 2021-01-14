package main.java.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public boolean musicPlay;
    public String musicLocation = ".\\src\\main\\java\\game\\music\\sound.wav";
    public Clip clip;
    public long clipTimePosition;
    public File musicPath;

    public Music() {
        try {
            musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.setFramePosition(0);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println("Wrong file format");
        }
    }

    public void changeMusic(){
        if (musicPlay) {
            pauseMusic();
        } else {
            resumeMusic();
        }
        musicPlay = !musicPlay;
    }

    protected void pauseMusic() {
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }

    protected void resumeMusic() {
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
    }
}
