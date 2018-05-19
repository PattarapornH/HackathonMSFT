package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Kodung {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;

    public Kodung(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
//        width = 312;
//        height = 100;
        rectangle = new Rectangle(x,y,width,height);
    }

    public void render(float delta){
        if(this.world.pointOnKodung(Gdx.input.getX(),Gdx.input.getY())){
            width = 310;
            height = 95;
        }
        else{
            width = 317;
            height = 111;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
