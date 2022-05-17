package com.example.pro2;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //Nupud ja sisestuskast
        Text tekst = new Text();
        tekst.setText("Arva ära number. Saad vihjeid.");
        TextField tekstiRida = new TextField();
        tekstiRida.setMaxWidth(80);
        Button nuppEnter = new Button("Enter");

        Button num0 = new Button("0");
        Button num1 = new Button("1");
        Button num2 = new Button("2");
        Button num3 = new Button("3");
        Button num4 = new Button("4");
        Button num5 = new Button("5");
        Button num6 = new Button("6");
        Button num7 = new Button("7");
        Button num8 = new Button("8");
        Button num9 = new Button("9");

        //Events
        Button[] numbrid = {num0, num1, num2, num3, num4, num5, num6, num7, num8, num9};
        for (Button button : numbrid) {
            button.setOnMouseClicked(event -> {
                String vana = tekstiRida.getText();
                tekstiRida.setText(vana + button.getText());
            });
        }

        GridPane nupudr = new GridPane();
        nupudr.setVgap(3);
        nupudr.setHgap(3);
        nupudr.setPadding(new Insets(3, 3, 3, 3));
        nupudr.add(num7, 0, 0);
        nupudr.add(num8, 1, 0);
        nupudr.add(num9, 2, 0);
        nupudr.add(num4, 0, 1);
        nupudr.add(num5, 1, 1);
        nupudr.add(num6, 2, 1);
        nupudr.add(num1, 0, 2);
        nupudr.add(num2, 1, 2);
        nupudr.add(num3, 2, 2);

        FlowPane things = new FlowPane();
        things.getChildren().addAll(tekstiRida, tekst);
        things.setPadding(new Insets(3));
        BorderPane borderPane = new BorderPane();
        //borderPane.setAlignment(tekstiRida, Pos.TOP_CENTER);
        //borderPane.setTop(tekst);
        borderPane.setTop(things);
        borderPane.setCenter(nupudr);
        Scene scene = new Scene(borderPane, 500, 500, Color.web("9F9F9F"));
        stage.setScene(scene);
        stage.show();

    }
}