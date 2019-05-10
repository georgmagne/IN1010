import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Minesveiper extends Application{
  private final int str = 10;

  public void start(Stage stage){
    GridPane root = new GridPane();
    Scene scene = new Scene(root);


    for (int i = 0; i < str; i++){
      for (int j = 0; j < str; j++){
        Rectangle rect = new Rectangle(30, 30, Color.GREY);
        rect.setStroke(Color.BLACK);
        rect.setOnMouseClicked(e -> rect.setFill(Color.WHITE));
        root.add(rect, i, j);
      }
    }


    stage.setScene(scene);
    stage.setTitle("Minesveiper");
    stage.show();
  }
}
