package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

    World(SelectShip SelectShip) {
        this.SelectShip = SelectShip;
        shipcar = new shipCaravel(1250,700,this);
        shipchi = new shipChinese(1250,700,this);
        shipvik = new shipViking(1250,700,this);
        correct = new Correct(1250,700,this);
        wrong = new Wrong(1250,700,this);
    }

    public void update(float delta){
        Timer();
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
        return (x >= 347 && x <= 629) && (y >= 70 && y <= 317);
    }

    public boolean pointOnShipchi(int x,int y){
        return (x >= 110 && x <= 426) && (y >= 368 && y <= 621);
    }

    public boolean pointOnShipvik(int x,int y){
        return (x >= 484 && x <= 808) && (y >= 369 && y <= 616);
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