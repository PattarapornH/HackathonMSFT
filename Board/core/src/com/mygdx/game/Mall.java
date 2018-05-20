package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Mall {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;
    private boolean isPlayed = false;
    Sound correct;
    Sound wrong;

    public Mall(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
        rectangle = new Rectangle(x,y,width,height);
        correct = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void render(float delta){
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        if(this.world.pointOnMall(Gdx.input.getX(),Gdx.input.getY())){
//            System.out.println("pass");
            width = 310;
            height = 95;
            if(Gdx.input.justTouched() && this.world.gameState == 2){
                this.world.gameState = 3;
                correct.play();
            }
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
