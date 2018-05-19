package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Ship {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    private boolean isPlayed = false;
    World world;
    Sound correct;
    Sound wrong;

    public Ship(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
//        width = 312;
//        height = 100;
        rectangle = new Rectangle(x,y,width,height);
        correct = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void render(float delta){
        if(this.world.pointOnShip(Gdx.input.getX(),Gdx.input.getY())){
            width = 310;
            height = 95;
            if(Gdx.input.isTouched() && this.world.gameState == 1){
                this.world.gameState = 2;
                if(!isPlayed){
                    correct.play();
                    isPlayed = true;
                }
            }
//            else if(Gdx.input.isTouched() && this.world.gameState != 1){
//                wrong.play();
//            }
        }
        else{
            width = 317;
            height = 111;
//            wrong.play();
//            if(Gdx.input.isTouched() && this.world.gameState != 1){
//                wrong.play();
//            }
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
