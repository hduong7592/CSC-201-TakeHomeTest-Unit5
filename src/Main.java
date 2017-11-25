/**
 * Create by hieuduong on 11/24/17
 * CSC-201 Unit5 Take Home Test
 * 16.22
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class Main extends Application {

    protected Label status;
    protected Media media;
    protected MediaPlayer mediaPlayer;
    private static final String MEDIA_URL = "http://cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3";

    @Override
    public void start(Stage primaryStage) {

        /**
         * Initialize the MediaPlayer
         */
        media = new Media(MEDIA_URL);
        mediaPlayer = new MediaPlayer(media);

        // Create a pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(getHBox());
        pane.setBottom(getSecondHBox());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("16.22"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Create Hbox to hold the control buttons
     * @return
     */
    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));

        /**
         * Add 3 button to the Hbox: start, stop and loop
         */
        Button playBtn = new Button("Play");
        Button loopBtn = new Button("Loop");
        Button stopBtn = new Button("Stop");

        hBox.getChildren().addAll(playBtn, loopBtn, stopBtn);
        hBox.setAlignment(Pos.CENTER);

        /**
         * Assign action to button
         */
        playBtn.setOnAction(e -> actionOnMediaPlayer("play"));
        loopBtn.setOnAction(e -> actionOnMediaPlayer("loop"));
        stopBtn.setOnAction(e -> actionOnMediaPlayer("stop"));

        return hBox;
    }

    /**
     * Create Hbox to hold the status label
     * @return
     */
    private HBox getSecondHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: silver");

        status = new Label("Status");
        hBox.getChildren().addAll(status);
        hBox.setAlignment(Pos.CENTER);

        return hBox;
    }

    private void actionOnMediaPlayer(String action) {

        switch (action){
            case "play":
                //This action will start playing the clip
                mediaPlayer.play();
                status.setText("Playing...");
                break;
            case "loop":
                //This action will loop the clip forever
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
                status.setText("Looping...");
                break;
            case "stop":
                //This action will stop the clip
                mediaPlayer.stop();
                status.setText("Stopped.");
                break;
            default:
                break;
        }
    }
}

