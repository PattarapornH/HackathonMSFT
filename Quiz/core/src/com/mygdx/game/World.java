package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class World {

    private Ch1 ch1;
    private Ch2 ch2;
    private Ch3 ch3;
    public int gameState = -1; //
    public float deltaTime;
    public float totalTime = 0;
    public float startTime;

    public World(Quiz quiz){
        ch1 = new Ch1(230,400,this);
        ch2 = new Ch2(230,250,this);
        ch3 = new Ch3(230,100,this);
    }

    public void update(float delta){
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        ch1.render(delta);
        ch2.render(delta);
        ch3.render(delta);
        Timer();
    }

    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
//        sec = (int) (totalTime % 60);
        totalTime += deltaTime;
//        return sec;
    }

    public boolean pointCh1(int x,int y){
        return (x >= 364 && x <= 671) && (y >= 336 && y <= 413);
    }

    public boolean pointCh2(int x,int y){
        return (x >= 348 && x <= 754) && (y >= 555 && y <= 628);
    }

    public boolean pointCh3(int x,int y){
        return (x >= 355 && x <= 807) && (y >= 749 && y <= 833);
    }
    Ch1 getCh1() { return ch1; }
    Ch2 getCh2() { return ch2; }
    Ch3 getCh3() { return ch3; }


}
