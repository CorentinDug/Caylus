package Caylus;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class BackgroundMusic implements Runnable {
    Thread  UnThread ;
    Clip clip;
    boolean isPlay = true;
    boolean isMenu = true;

    /**
     * Créer une musique de fond
     */
    BackgroundMusic () {
        UnThread = new Thread ( this , "thread secondaire" );
        UnThread.start();
    }

    /**
     * Changer l'état de la musique (Play/Pause)
     * @return True si la musique est jouée, false sinon
     */
    public boolean change(){
        if(isPlay){
            clip.stop();
            isPlay = false;
        }else{
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            isPlay = true;
        }
        return isPlay;
    }


    public void stop(){
        clip.stop();
    }

    /**
     * Lancer la musique
     */
    public void run() {
        try {


            if (isMenu){
                clip = AudioSystem.getClip();
                File file;
                file = new File("res/sound/musiqueIntro.wav");
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                clip.open(inputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }else {
                clip.stop();
                clip = AudioSystem.getClip();
                File file;
                file = new File("res/sound/musique1.wav");
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                clip.open(inputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }


        } catch (IOException e) {
            System.err.println(e);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupérer l'état de la musique
     * @return True si la musique est jouée, false sinon
     */
    public boolean isPlay() {
        return isPlay;
    }
}
