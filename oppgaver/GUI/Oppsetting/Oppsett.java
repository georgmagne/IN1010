import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import java.io.File;

public class Oppsett extends Application {
  File aktuellFil;

  @Override
  public void start(Stage teater){

    Pane kulisser  = new Pane();
    Scene scene = new Scene(kulisser);

    FileChooser filvelger = new FileChooser();
    filvelger.setTitle("velg fil..");

    Button knapp = new Button("Velg fil");
    knapp.setOnAction((event) -> {
      File valgtfil = filvelger.showOpenDialog(teater);
    });


    kulisser.getChildren().add(knapp);
    teater.setTitle("Overskrift");
    teater.setScene(scene);
    teater.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
