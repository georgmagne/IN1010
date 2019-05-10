import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;


public class FilVelger extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX App");

    FileChooser fileChooser = new FileChooser();

    Button button = new Button("Velg fil");
    button.setOnAction(e -> {
      File selectedFile = fileChooser.showOpenDialog(primaryStage);
    });

    VBox vBox = new VBox(button);
    Scene scene = new Scene(vBox, 960, 600);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}