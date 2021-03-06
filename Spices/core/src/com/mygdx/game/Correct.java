package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Correct {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;

    public Correct(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
        width = 100;
        height = 120;
        rectangle = new Rectangle(x,y,width,height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
