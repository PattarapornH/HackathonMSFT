package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Wrong {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;

    public Wrong(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
        width = 175;
        height = 207;
        rectangle = new Rectangle(x,y,width,height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
