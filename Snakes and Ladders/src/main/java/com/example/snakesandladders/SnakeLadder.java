package com.example.snakesandladders;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize=40,width=10,height=10,buttonLine = height*tileSize+50,infoLine=height*tileSize+20;

    Player playerFirst ,playerSecond;
    boolean firstPlayerTurn = true,gameStart = false;

    private Pane CreateContent() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize + 100);
        for (int i = 0; i < height; i++) {
            for(int j=0;j<width;j++)
            {

            Tile tile = new Tile(tileSize);
            tile.setTranslateX(i*tileSize);
            tile.setTranslateY(j*tileSize);
            root.getChildren().addAll(tile);
        }
    }
        Image img = new Image("C:\\Users\\Nishant\\Desktop\\Snakes and Ladders\\src\\board.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setFitWidth(width*tileSize);
        boardImage.setFitHeight(height*tileSize);
        boardImage.setImage(img);

        Button startButton = new Button("Start");
        startButton.setTranslateX(180);
        startButton.setTranslateY(buttonLine);

        Button playerOnebutton = new Button("Player One");
        playerOnebutton.setTranslateX(20);
        playerOnebutton.setTranslateY(buttonLine);

        Button playerTwobutton = new Button("Player Two");
        playerTwobutton.setTranslateX(300);
        playerTwobutton.setTranslateY(buttonLine);

        Label diceLabel = new Label("Start the Game");
        diceLabel.setTranslateX(170);
        diceLabel.setTranslateY(infoLine);


        playerFirst = new Player("nishant", Color.BLACK,tileSize/2);
        playerSecond = new Player("Accio",Color.WHITE,tileSize/2-5);

        playerOnebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart)
                {
                    if(firstPlayerTurn)
                    {
                        int diceValue = rollDice();
                        diceLabel.setText("DICE : " + diceValue);
                        playerFirst.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerFirst.checkWinner())
                        {
                            diceLabel.setText("Winner is" +playerFirst.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn = true;
                            gameStart = false;
                        }
                    }
                }


            }
        });
        playerTwobutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(!firstPlayerTurn)
                    {
                        int diceValue = rollDice();
                        diceLabel.setText("DICE : " + diceValue);
                        playerSecond.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerSecond.checkWinner())
                        {
                            diceLabel.setText("Winner is" +playerSecond.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn = true;
                            gameStart = false;
                        }
                    }
                }

            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStart = true;
                startButton.setDisable(true);
                playerFirst.setStart();
                playerSecond.setStart();
            }
        });

        root.getChildren().addAll(boardImage,startButton,playerOnebutton,playerTwobutton,diceLabel,playerFirst.getCoin(),playerSecond.getCoin());
        return root;
    }
    private int rollDice(){
        return (int) (Math.random()*6+1);
    }


    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(CreateContent());
        stage.setTitle("Snakes & Ladders");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}