import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class Knapper extends Application {
  @Override
  public void start(Stage stage){

    Button knapp = new Button("Knapp");
    knapp.setOnAction(new KnappFunksjonalitet());

    Button knapp2 = new Button("Knapp 2");
    knapp2.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent e){
        System.out.println("Dette kommer fra EN ANANANNSND");
      }
    });

    Button knapp3 = new Button("Knapp 3");
    knapp3.setOnAction(e -> System.out.println("Lamda!!!"));


    // HBox root = new HBox(knapp, knapp2, knapp3);
    // VBox root = new VBox(knapp, knapp2, knapp3);
    Pane root = new Pane(knapp, knapp2, knapp3);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  private class KnappFunksjonalitet implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      System.out.println("Funk for kanpp!!!!");
    }
  }
}
