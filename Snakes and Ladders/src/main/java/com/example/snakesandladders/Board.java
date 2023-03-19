package com.example.snakesandladders;

import javafx.util.Pair;

import java.util.ArrayList;


public class Board {

    private ArrayList<Pair<Integer,Integer>> positionCoordinate;
    private ArrayList<Integer> snakeLadder;
    public Board()
    {
        populatePositionCoordinates();
        setSnakeLadder();
    }
    private void populatePositionCoordinates() {
        positionCoordinate = new ArrayList<>();
        positionCoordinate.add(new Pair<>(0,0));
        for(int i = 0; i< SnakeLadder.height; i++)
        {
            for(int j = 0; j< SnakeLadder.width; j++)
            {
                int xCord = 0;
                if(i%2==0)
                {
                    xCord = j* SnakeLadder.tileSize +SnakeLadder.tileSize/2;
                }
                else {
                    xCord = SnakeLadder.height*SnakeLadder.tileSize -j*SnakeLadder.tileSize +SnakeLadder.tileSize /2;
                }
                int yCord = SnakeLadder.height*SnakeLadder.tileSize - i*SnakeLadder.tileSize - SnakeLadder.tileSize/2;

                positionCoordinate.add(new Pair<>(xCord,yCord));
            }

        }
    }
    private void setSnakeLadder()
    {
        snakeLadder = new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            snakeLadder.add(i);
        }
        snakeLadder.set(4,25);
        snakeLadder.set(13,46);
        snakeLadder.set(33,49);
        snakeLadder.set(50,69);
        snakeLadder.set(42,63);
        snakeLadder.set(62,81);
        snakeLadder.set(74,92);

        snakeLadder.set(99,41);
        snakeLadder.set(89,53);
        snakeLadder.set(76,58);
        snakeLadder.set(66,45);
        snakeLadder.set(54,31);
        snakeLadder.set(43,17);
        snakeLadder.set(40,3);
        snakeLadder.set(27,5);


    }

    //
    public int getXCoordinate(int position){
        if(position >0 && position <=100)
        {
            return positionCoordinate.get(position).getKey();
        }
        return -1;
    }

    public int getYCoordinate(int position){
        if(position >0 && position <=100)
        {
            return positionCoordinate.get(position).getValue();
        }
        return -1;
    }
    public int getSnakeLadder(int position)
    {
        return snakeLadder.get(position);
    }
}


