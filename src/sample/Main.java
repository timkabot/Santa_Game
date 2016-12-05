package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.awt.Font;
import java.sql.Time;

public class Main extends Application {
    Character santa = new Character();
    Timeline gameLoop,adding_kids;
    My_label score = new My_label(1700,10);
    int schet = 0;
    int count = 0,last_score = 0;
    Group menu = new Group();
    gift[] gifts = new gift[1000];
    int number_of_gift = 0;
    My_label start = new My_label(610,200);
    Group game = new Group();
    Image s = new Image("menu_bg.jpeg");
    ImageView s2 = new ImageView(s);
    Scene menu_scene = new Scene(menu,800,600);
    Scene game_scene = new Scene(game,1720,980);
    Kids[] deti = new Kids[1000];
    Stage thestage;
    ImageView my_bg = new ImageView( new Image("bg2.jpg"));
    AudioClip song = new AudioClip(this.getClass().getResource("/new_year.mp3").toExternalForm());
    @Override
    public void start( Stage primaryStage) throws Exception{
        song.setCycleCount(-1);
        primaryStage.setResizable(false);
        thestage = primaryStage;
        s2.setFitHeight(600);
        s2.setFitWidth(800);
        menu.getChildren().add(s2);
        menu.getChildren().add(start);
        score.setText("Score : 0");
        score.status.setFont(javafx.scene.text.Font.font(javafx.scene.text.Font.getDefault().getName(), FontWeight.BOLD, 55));
        start.status.setFill(Color.BLACK);
        score.setPrefWidth(400);
        start.setOpacity(1);
        start.setStyle("-fx-background-color: white;"
                + "-fx-background-radius:20px");
        for(int i=0;i<100;i++)
        {
            deti[i] = new Kids();
        }
        my_bg.setFitHeight(980);
        my_bg.setFitWidth(1820);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(menu_scene);

        primaryStage.show();
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(game_scene);
                start_game();

            }
        });
        adding_kids = new Timeline(new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                   game.getChildren().add(deti[count].child);
                   deti[count].move.play();
                count++;
            }
        }
        ));

        game_scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gift g = new gift();
                g.child.setTranslateX(santa.ded_moroz.getTranslateX());
                game.getChildren().add(g.child);
                gifts[number_of_gift] = g;
                number_of_gift++;
                g.move.play();
            }
        });
        adding_kids.setCycleCount(100);
        adding_kids.play();
        gameLoop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                if(b.getX()>santa.ded_moroz.getTranslateX() && b.getX()-santa.ded_moroz.getTranslateX()<70 || b.getX()<santa.ded_moroz.getTranslateX() && santa.ded_moroz.getTranslateX()-b.getX()<70){}
               else  if(b.getX()>santa.ded_moroz.getTranslateX()){santa.moverightX();}
                else if(b.getX()<santa.ded_moroz.getTranslateX()){santa.moveleftX();}
                intersects();
            }
        }
        ));
        gameLoop.setCycleCount(-1);
         }
    public void intersects()
    { boolean zadel =false;
        for(int i=0;i<number_of_gift;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(deti[j].child.getTranslateX()>0 && deti[j].child.getTranslateX()<1920)
                {
                    if(gifts[i].child.getBoundsInParent().intersects(deti[j].child.getBoundsInParent()) && deti[j].j==3)
                    {
                        game_over();
                    }
                    else if(gifts[i].child.getBoundsInParent().intersects(deti[j].child.getBoundsInParent()))
                    {
                        zadel = true;
                        game.getChildren().removeAll(deti[j].child,gifts[i].child);
                    }
                }
            }

        }
        if(zadel) {schet++;score.setText("Score : " + schet);}
    }
    public void game_over()
    {
        game.getChildren().clear();
        My_label end = new My_label(500,500);
        end.status.setFill(Color.RED);
        end.setStyle("-fx-background-color: gray;"
                + "-fx-background-radius:20px");
        end.setText("Your score is " + schet);
        end.setPrefWidth(900);
        ImageView end_image = new ImageView( new Image("game_over.jpg"));
        Group sq = new Group();
        end_image.setFitHeight(1000);
        end_image.setFitWidth(1000);
        sq.getChildren().addAll(end_image,end);
        Scene end_over = new Scene(sq,1000,1000);
        thestage.setScene(end_over);
        end_over.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode pushed = event.getCode();
                if(pushed == KeyCode.K)
                {
                    thestage.setScene(menu_scene);
                }
            }
        });
    }
    public void start_game()
    {
        song.stop();
        song.play();

        schet = 0;
        score.setText("Score : " + schet);
        game.getChildren().addAll(my_bg );
        game.getChildren().add(score);
        gameLoop.play();
        game.getChildren().add(santa.ded_moroz);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
