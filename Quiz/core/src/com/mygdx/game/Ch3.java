package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Ch3 {

    private Vector2 position;
    public int height;
    public int width;
    private Rectangle rectangle;
    World world;
    private boolean isPlayed = false;
    Sound correct;
//    Sound wrong;

    public Ch3(int x, int y, World world) {
        this.world = world;
        position = new Vector2(x, y);
        rectangle = new Rectangle(x, y, width, height);
        correct = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
//        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void render(float delta) {
        if(this.world.pointCh3(Gdx.input.getX(),Gdx.input.getY())){
            width = 353;
            height = 80;
            if(Gdx.input.justTouched() /*&& this.world.gameState == 0*/ ) {
//                this.world.gameState = 2;
//                this.world.chooseChan = true;
//                if (!isPlayed) {
                correct.play();
//                    isPlayed = tzrue;
//                }
            }
        }
        else{
            width = 363;
            height = 90;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
