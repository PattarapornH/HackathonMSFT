package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Select;

import java.util.Random;

public class World {
    private SelectShip SelectShip;
    private shipCaravel shipcar;
    private shipChinese shipchi;
    private shipViking shipvik;
    private Correct correct;
    private Wrong wrong;
    public int gameState = -2 ; //before select = -2 -1 select = 0 after select = 1
    public float deltaTime;
    public float totalTime = 0;
    public float startTime;
//    Sound music;

    World(SelectShip SelectShip) {
        this.SelectShip = SelectShip;
        shipcar = new shipCaravel(1250,700,this);
        shipchi = new shipChinese(1250,700,this);
        shipvik = new shipViking(1250,700,this);
        correct = new Correct(1250,700,this);
        wrong = new Wrong(1250,700,this);
//        music = Gdx.audio.newSound(Gdx.files.internal("GamingBG.mp3"));
    }

    public void update(float delta){
        Timer();
        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
//        music.play();
//        if((int)totalTime >= 3){
//            gameState = -1;
//        }
        shipcar.render(delta);
        shipchi.render(delta);
        shipvik.render(delta);
    }

    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
//        sec = (int) (totalTime % 60);
        totalTime += deltaTime;
//        return sec;
    }


    public boolean pointOnShipcar(int x,int y){
        return (x >= 516 && x <= 938) && (y >= 97 && y <= 446);
    }

    public boolean pointOnShipchi(int x,int y){
        return (x >= 163 && x <= 633) && (y >= 535 && y <= 857);
    }

    public boolean pointOnShipvik(int x,int y){
        return (x >= 731 && x <= 1198) && (y >= 514 && y <= 853);
    }


    shipCaravel getshipcar(){
        return shipcar;
    }
    shipChinese getshipchi(){
        return shipchi;
    }
    shipViking getshipvik(){ return shipvik; }
    Correct getCorrect(){ return correct;}
    Wrong getWrong(){ return wrong; }
}