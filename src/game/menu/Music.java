package game.menu;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import java.io.File;

public class Music {
    private AudioClip mediaPlayer;
    String s;
    public Music(String name) {
        s="music//" + name;
        music();
    }
    private void music(){
        Media h=new Media(new File(s).toURI().toString());
        mediaPlayer= new AudioClip(h.getSource());
        mediaPlayer.play();
    }
    public void turnOnOff(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        else{
            mediaPlayer.play();
        }
    }
}
