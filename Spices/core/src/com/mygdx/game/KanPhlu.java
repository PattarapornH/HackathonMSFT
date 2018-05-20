package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class KanPhlu {
    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;
    private boolean isPlayed = false;
    Sound correct;
    Sound wrong;

    public KanPhlu(int x,int y,World world){
        this.world = world;
        width = 470;
        height = 194;
        position = new Vector2(x,y);
        rectangle = new Rectangle(x,y,width,height);
        correct = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
//        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }
    public void render(float delta){
        if(this.world.pointOnKan(Gdx.input.getX(),Gdx.input.getY())){
            width = 450;
            height = 180;
            if(Gdx.input.justTouched()) {
                correct.play();
                if (this.world.gameState == 0) {
                    this.world.gameState = 1;
//                this.world.chooseChan = true;
                } else if (this.world.gameState == 2) {

                    this.world.gameState = 3;
                    this.world.startTime = this.world.totalTime;
                    isPlayed = true;

                }
            }
        }
        else{
            width = 470;
            height = 194;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
