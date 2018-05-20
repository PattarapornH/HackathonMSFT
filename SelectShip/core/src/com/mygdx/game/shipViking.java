package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class shipViking {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;
    private boolean isPlayed = false;
    Sound wrong;

    public shipViking(int x,int y,World world){
        this.world = world;
        position = new Vector2(x,y);
        width = 330;
        height = 250;
        rectangle = new Rectangle(x,y,width,height);
        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void render(float delta){
        if (this.world.pointOnShipvik(Gdx.input.getX(), Gdx.input.getY())) {
            width = 300;
            height = 220;
            if(Gdx.input.isTouched()){
                this.world.gameState = 3;
                this.world.startTime = this.world.totalTime;
                if(!isPlayed){
                    wrong.play();
                    isPlayed = true;
                }
            }
        }
        else {
            width = 330;
            height = 250;
        }
    }
    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
