// import javafx.application.Application;
// import javafx.stage.Stage;
// import javafx.scene.Scene;
// import javafx.scene.layout.Pane;
// import javafx.scene.shape.Circle;
// import javafx.scene.paint.Color;
//
// public  class Snomann extends Application {
//
//   public void start(Stage stage){
//
//     //Kropp
//     Circle c1 = new Circle(120);
//     Circle c2 = new Circle(100);
//     Circle c3 = new Circle(70);
//
//     c1.setCenterX(100);
//     c1.setCenterY(400);
//     c1.setFill(Color.WHITE);
//     c1.setStroke(Color.BLACK);
//
//     c2.setCenterX(100);
//     c2.setCenterY(300);
//     c2.setFill(Color.WHITE);
//     c2.setStroke(Color.BLACK);
//
//     c3.setCenterX(100);
//     c3.setCenterY(200);
//     c3.setFill(Color.WHITE);
//     c3.setStroke(Color.BLACK);
//
//     //Fjes
//     Circle oye1 = new Circle(75, 180, 15);
//     Circle oye2 = new Circle(130, 180, 10);
//     Circle nese = new Circle(100, 250, 13);
//     nese.setFill(Color.ORANGE);
//
//     // Sett scenen
//     Pane pane = new Pane();
//     pane.getChildren().addAll(c1, c2, c3, oye1, oye2, nese);
//     Scene scene = new Scene(pane);
//     stage.setScene(scene);
//     stage.setTitle("Snowman");
//     stage.show();
//   }
//
//   public static void main(String[] args) {
//     Application.launch(args);
//   }
// }

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Snomann extends Application {

    public void start(Stage stage) {

        //Kropp
        Circle c1 = new Circle(120);
        Circle c2 = new Circle(100);
        Circle c3 = new Circle(70);

        c1.setCenterX(100);
        c1.setCenterY(400);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);

        c2.setCenterX(100);
        c2.setCenterY(300);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);

        c3.setCenterX(100);
        c3.setCenterY(200);
        c3.setFill(Color.WHITE);
        c3.setStroke(Color.BLACK);

        //Fjes
        Circle oye1 = new Circle(75, 180, 10);
        Circle oye2 = new Circle(130, 180, 10);
        Circle nese = new Circle(100, 210, 13);
        nese.setFill(Color.ORANGE);

        //Sett scenen!
        Pane pane = new Pane();
        pane.getChildren().addAll(c1, c2, c3, oye1, oye2, nese);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Snomann!");
        stage.show();

}

    public static void main(String[] args) {
    Application.launch(args);
    }
}
