package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    private Texture ship;
    private World world;
    private Texture bg;
    private Texture kodung;
    private Texture mall;
    private Texture q1;
    private Texture q2;
    private Texture q3;
    Board board;

    public WorldRenderer(Board board,World world){
        this.world = world;
        this.board = board;
        ship = new Texture("learn_choice1.png");
        kodung = new Texture("learn_choice2.png");
        mall = new Texture("learn_choice3.png");
        bg = new Texture("learn_blackboard.png");
        q1 = new Texture("learn_Q1.png");
        q2 = new Texture("learn_Q2.png");
        q3 = new Texture("learn_Q3.png");
    }

    public void render(float delta){
        SpriteBatch batch = board.batch;
//        System.out.println(this.world.gameState);
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        batch.begin();
//        Ship positionship = world.getship();
        if(this.world.gameState == 1) {
            firstAsk();
        }
        else if(this.world.gameState == 2){
            secondAsk();
        }
        else if(this.world.gameState == 3){
            thirdAsk();
        }
        else if(this.world.gameState == 4){
            finish();
        }
        batch.end();
    }

    public void firstAsk(){
        SpriteBatch batch = board.batch;
        Ship positionship = world.getship();
        Kodung positionkodung = world.getKodung();
        Mall positionmall = world.getMall();
        batch.draw(bg,0,0);
        batch.draw(ship,positionship.getPosition().x,positionship.getPosition().y,positionship.width,positionship.height);
        batch.draw(kodung,positionkodung.getPosition().x,positionkodung.getPosition().y,positionkodung.width,positionkodung.height);
        batch.draw(mall,positionmall.getPosition().x,positionmall.getPosition().y,positionmall.width,positionmall.height);
        batch.draw(q1,250,150);
    }

    public void secondAsk(){
        SpriteBatch batch = board.batch;
        Ship positionship = world.getship();
        Kodung positionkodung = world.getKodung();
        Mall positionmall = world.getMall();
        batch.draw(bg,0,0);
//        batch.draw(ship,positionship.getPosition().x,positionship.getPosition().y,positionship.width,positionship.height);
        batch.draw(kodung,positionkodung.getPosition().x,positionkodung.getPosition().y,positionkodung.width,positionkodung.height);
        batch.draw(mall,positionmall.getPosition().x,positionmall.getPosition().y,positionmall.width,positionmall.height);
        batch.draw(q2,250,150);
    }

    public void thirdAsk(){
        SpriteBatch batch = board.batch;
        Ship positionship = world.getship();
        Kodung positionkodung = world.getKodung();
        Mall positionmall = world.getMall();
        batch.draw(bg,0,0);
//        batch.draw(ship,positionship.getPosition().x,positionship.getPosition().y,positionship.width,positionship.height);
        batch.draw(kodung,positionkodung.getPosition().x,positionkodung.getPosition().y,positionkodung.width,positionkodung.height);
//        batch.draw(mall,positionmall.getPosition().x,positionmall.getPosition().y,positionmall.width,positionmall.height);
        batch.draw(q3,250,150);
    }

    public void finish(){
        SpriteBatch batch = board.batch;
        batch.draw(bg,0,0);
    }
}
