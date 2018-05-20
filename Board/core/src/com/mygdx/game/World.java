package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import javafx.beans.binding.BooleanExpression;

public class World {

    private Ship ship;
    private Board Board;
    private Kodung kodung;
    private Mall mall;
    public int gameState = 0; // first question
    Sound wrong;
    public float deltaTime;
    public float totalTime = 0;
    public float startTime = 0;

    World(Board Board){
        this.Board = Board;
        ship = new Ship(150,580,this);
        kodung = new Kodung(490,580,this);
        mall = new Mall(830,580,this);
        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void update(float delta){
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        ship.render(delta);
        kodung.render(delta);
        mall.render(delta);
        wrongFirst(Gdx.input.getX(),Gdx.input.getY());
        wrongSecond(Gdx.input.getX(),Gdx.input.getY());
        Timer();
    }

    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
        totalTime += deltaTime;
    }

    public boolean pointOnShip(int x,int y){
        return (x >= 229 && x <= 697) && (y >= 39 && y <= 185);
    }
    public boolean pointOnKodung(int x,int y) {
        return (x >= 736 && x <= 1204) && (y >= 39 && y <= 185);
    }
    public boolean pointOnMall(int x,int y) {
        return (x >= 1246 && x <= 1729) && (y >= 39 && y <= 1729);
    }

    public void wrongFirst(int x,int y){
        if((pointOnKodung(x,y) || pointOnMall(x,y)) && Gdx.input.justTouched() && gameState == 1){
            wrong.play();
        }
    }

    public void wrongSecond(int x,int y){
        if(pointOnKodung(x,y) && Gdx.input.justTouched() && gameState == 2){
            wrong.play();
        }
    }

    Ship getship(){
        return ship;
    }
    Kodung getKodung() { return kodung; }
    Mall getMall() { return mall; }
}