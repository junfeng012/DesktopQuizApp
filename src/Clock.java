
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;

public class Clock  extends Pane {

    private Timeline animation;
    private int tmp = 180;
    private String S="";
    private MediaPlayer mdPlayer;

    Label label = new Label("180");

    public Clock(){
        label.setFont(javafx.scene.text.Font.font(35));
        label.setTranslateX(810);
        label.setTranslateY(95);
        label.setLayoutX(-50);
        label.setLayoutY(-5);
        label.setTextFill(Color.web("#ffffff"));

        getChildren().add(label);
        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> timelabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

    }

    private void timelabel(){
        if (tmp >0){
            tmp--;
        }
        S = tmp +"";
        label.setText(S);
        if(tmp==179) {
            label.setTextFill(Color.web("#ffffff"));
        }

        if(tmp==120)
        {
            String musicFile = "data/ring.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            mdPlayer = new MediaPlayer(sound);
            mdPlayer.play();
            label.setTextFill(Color.web("#ADFF2F"));
        }

        if(tmp==60)
        {
            String musicFile = "data/ring.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            mdPlayer = new MediaPlayer(sound);
            mdPlayer.play();
            label.setTextFill(Color.web("#FFFF00"));
        }
        if (tmp ==10)
        {
            String musicFile = "data/clock.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            mdPlayer = new MediaPlayer(sound);
            mdPlayer.play();
            label.setTextFill(Color.web("#ff6961"));
        }


    }
    public void Stop()
    {
        animation.stop();
    }



}