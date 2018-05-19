package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import javafx.beans.binding.BooleanExpression;

public class World {

    private Ship ship;
    private Board Board;
    private Kodung kodung;
    private Mall mall;
    public int gameState = 1; // first question
    Sound wrong;

    World(Board Board){
        this.Board = Board;
        ship = new Ship(150,580,this);
        kodung = new Kodung(490,580,this);
        mall = new Mall(830,580,this);
        wrong = Gdx.audio.newSound(Gdx.files.internal("wrong.mp3"));
    }

    public void update(float delta){
//        if(gameState == 1 && !)
        ship.render(delta);
        kodung.render(delta);
        mall.render(delta);
        wrongFirst(Gdx.input.getX(),Gdx.input.getY());
        wrongSecond(Gdx.input.getX(),Gdx.input.getY());
    }

    public boolean pointOnShip(int x,int y){
        return (x >= 152 && x <= 464) && (y >= 31 && y <= 133);
    }
    public boolean pointOnKodung(int x,int y) {
        return (x >= 494 && x <= 801) && (y >= 31 && y <= 133);
    }
    public boolean pointOnMall(int x,int y) {
        return (x >= 833 && x <= 1147) && (y >= 31 && y <= 133);
    }

    public void wrongFirst(int x,int y){
        if((pointOnKodung(x,y) || pointOnMall(x,y)) && Gdx.input.isTouched() && gameState == 1){
            wrong.play();
        }
    }

    public void wrongSecond(int x,int y){
        if(pointOnKodung(x,y) && Gdx.input.isTouched() && gameState == 2){
            wrong.play();
        }
    }

    Ship getship(){
        return ship;
    }
    Kodung getKodung() { return kodung; }
    Mall getMall() { return mall; }
}