package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class shipCaravel {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    private World world;
    Sound correct;
    boolean isPlayed = false;


    public shipCaravel(int x,int y,World world){
        this.world = world;
        correct = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
//        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
        position = new Vector2(x,y);
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        rectangle = new Rectangle(x,y,width,height);
    }

    public void render(float delta){
        if(this.world.pointOnShipcar(Gdx.input.getX(),Gdx.input.getY())){
            width = 300;
            height = 220;
            if(Gdx.input.isTouched()){
                this.world.gameState = 1;
                if(!isPlayed) {
                    correct.play();
                    isPlayed = true;
                }
//                correct.stop();
//                correct.dispose();
            }
        }
        else{
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
