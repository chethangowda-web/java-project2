import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    public static void main(String[] args) {

        String filePath = "Parichayavade.wav";
        File file = new File(filePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Playing music...");

         
            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file format not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable");
        } catch (IOException e) {
            System.out.println("File not found or IO error");
        } catch (InterruptedException e) {
            System.out.println("Playback interrupted");
        }
    }
}
