package projectbms;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GifExample extends Application {

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    int sceneWidth = screenWidth;
    int sceneHeight = screenHeight;

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("Done");
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(b1);

        // Load the GIF file
        Image image = new Image("C:\\IMS\\splash.gif");
        ImageView imageView = new ImageView(image);
        imageView.setOpacity(0.0);

        // Create the scene
        Scene scene = new Scene(new Group(), 600, 350);
        ((Group) scene.getRoot()).getChildren().addAll(imageView);

        // Set up the timeline animation
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(0), new KeyValue(imageView.opacityProperty(), 0.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(imageView.opacityProperty(), 1.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue(imageView.opacityProperty(), 1.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5100), new KeyValue(imageView.opacityProperty(), 0.0)));
        timeline.setCycleCount(1);
        timeline.setOnFinished(event -> {
            // Create the new scene
            Scene sc = new Scene(new Group(), sceneWidth, sceneHeight - 70);

            // Add the HBox to the scene
            ((Group) sc.getRoot()).getChildren().addAll(hb1);

            // Set the new scene to the stage
            stage.setScene(sc);
            
            // Maximize the stage
            stage.setMaximized(true);

            // Show the stage
            stage.show();
        });

        // Start the animation
        timeline.play();

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
