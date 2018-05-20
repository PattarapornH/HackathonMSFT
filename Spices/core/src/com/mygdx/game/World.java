package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class World {

    private Chan chan;
    private KanPhlu kan;
    private Yeera yee;
    private Ginger gin;
    private Pepper pep;
    private Correct correctKhan;
    private Correct correctChan;
    public int gameState = 0; // no ans 1=chooseKan 2=chooseChan 3 = chooseBoth
//    public boolean chooseKan = false;
//    public boolean chooseChan = false;
    public long startTime;

    public World(Spices spices){
        chan = new Chan(10,10,this);
        gin = new Ginger(400,10,this);
        yee = new Yeera(800,10,this);

        kan = new KanPhlu(200,120,this);
        pep = new Pepper(620,120,this);

        correctKhan = new Correct(340,344,this);
        correctChan = new Correct(638,344,this);
    }

    public void update(float delta){
        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
//        System.out.println(gameState);
        chan.render(delta);
        kan.render(delta);
        yee.render(delta);
        gin.render(delta);
        pep.render(delta);
    }

    public boolean pointOnChan(int x,int y){
        return (x >= 41 && x <= 633) && (y>=750 && y<= 976);
    }
    public boolean pointOnKan(int x,int y){
        return (x >= 318 && x <= 917) && (y>=599 && y<= 809);
    }
    public boolean pointOnYee(int x,int y){
        return (x >= 1278 && x <= 1863) && (y>=743 && y<= 960);
    }
    public boolean pointOnGin(int x,int y){
        return (x >= 665 && x <= 1249) && (y>=769 && y<= 975);
    }
    public boolean pointOnPep(int x,int y){
        return (x >= 991 && x <= 1604) && (y>=590 && y<= 807);
    }

    Chan getChan(){
        return chan;
    }
    KanPhlu getKan(){ return kan; }
    Yeera getYee(){ return yee; }
    Ginger getGin(){ return gin; }
    Pepper getPep(){ return pep;}
    Correct getCorrectKhan() { return correctKhan; }
    Correct getCorrectChan() { return correctChan; }
}
