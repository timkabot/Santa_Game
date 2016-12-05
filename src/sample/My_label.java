package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class My_label extends Pane {
    Text status = new Text("START");
    public My_label(double x, double y) {
        setPrefHeight(100);
        setPrefWidth(300);
        setTranslateX(x - 310);
        setTranslateY(y + 10);
        setStyle("-fx-background-color: rgb(40,81,111);"
                + "-fx-background-radius:20px");
        setOpacity(0.8);
        status.setTranslateY(70);
        status.setTranslateX(35);
        getChildren().addAll(status);
        status.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 75));
        status.setFill(new Color(107 / 255.0, 162 / 255.0, 252 / 255.0, 1.0));
    }

    public void setText(String message) {
        status.setText(message);

    }
}
