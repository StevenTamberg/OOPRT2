package com.example.pro2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller extends Application {
    public void start(final Stage primaryStage) {

        Button button = new Button();
        button.setText("Alusta mängu!");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                StackPane secondaryLayout = new StackPane();
                TextField sisesta = new TextField();
                BorderPane bp = new BorderPane();
                Text tööjuhend = new Text("Mõtlesin ühe numbri vahemikus (0-100)\n " +
                        "Arva ära, mis numbri ma mõtlesin");
                tööjuhend.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                Button nupp = new Button("Sisesta");

                bp.setTop(tööjuhend);
                bp.setLeft(nupp);

                secondaryLayout.getChildren().addAll(sisesta,bp);

                Scene secondScene = new Scene(secondaryLayout, primaryStage.getWidth(), primaryStage.getHeight());
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Arvamise mäng");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX());
                newWindow.setY(primaryStage.getY());

                newWindow.show();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 450, 250);

        primaryStage.setTitle("Arvamise mäng");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
