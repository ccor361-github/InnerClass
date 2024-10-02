package es.ieslosmontecillos.innerclass;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/// @author: Corina Cordobez


public class ControlCircle extends Application {

    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage escenarioPrincipal) {

        //Crear HBox para contener los botones
        HBox hBox = new HBox(10);
        Button btnAgrandar = new Button("Agrandar");
        Button btnEncoger = new Button("Encoger");

        //Añadir botones al HBox
        hBox.getChildren().addAll(btnAgrandar, btnEncoger);
        hBox.setAlignment(Pos.CENTER);

        //Acciones para los botones
        btnAgrandar.setOnAction(new ManejadorAgrandar());
        btnEncoger.setOnAction(new ManejadorEncoger());

        //Estructurar el diseño
        BorderPane borde = new BorderPane();
        borde.setCenter(circlePane);
        borde.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        //Estructurar la escena y el escenario
        Scene escena = new Scene(borde, 200, 150);
        escenarioPrincipal.setTitle("Controlar Círculo");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    //Clase interna para manejar el boton "Agrandar"
    class ManejadorAgrandar implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.agrandar();
        }
    }

    //Clase interna para manejar el botón "Encoger"
    class ManejadorEncoger implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.encoger();
        }
    }

    //Clase personalizada StackPane que contiene y maneja el círculo
    class CirclePane extends StackPane {
        private Circle circulo = new Circle(50); // Círculo con radio inicial de 50

        public CirclePane() {
            getChildren().add(circulo);
            circulo.setStroke(Color.BLACK);
            circulo.setFill(Color.WHITE);
        }

        //Metodo para agrandar el círculo
        public void agrandar() {
            circulo.setRadius(circulo.getRadius() + 2);
        }

        //Metodo para encoger el círculo
        public void encoger() {
            if (circulo.getRadius() > 2) {
                circulo.setRadius(circulo.getRadius() - 2);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
