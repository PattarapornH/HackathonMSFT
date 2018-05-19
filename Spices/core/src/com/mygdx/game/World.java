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
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        System.out.println(gameState);
        chan.render(delta);
        kan.render(delta);
        yee.render(delta);
        gin.render(delta);
        pep.render(delta);
    }

    public boolean pointOnChan(int x,int y){
        return (x >= 29 && x <= 390) && (y>=536 && y<= 704);
    }
    public boolean pointOnKan(int x,int y){
        return (x >= 213 && x <= 613) && (y>=431 && y<= 581);
    }
    public boolean pointOnYee(int x,int y){
        return (x >= 852 && x <= 1228) && (y>=534 && y<= 695);
    }
    public boolean pointOnGin(int x,int y){
        return (x >= 455 && x <= 815) && (y>=561 && y<= 709);
    }
    public boolean pointOnPep(int x,int y){
        return (x >= 648 && x <= 1068) && (y>=431 && y<= 581);
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
