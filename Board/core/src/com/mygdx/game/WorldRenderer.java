package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
    private Texture mind;
    private int cnt = 0;

    Music first;
    Music second;
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
        mind = new Texture("BG_mindanao_harbor2.png");
        first = Gdx.audio.newMusic(Gdx.files.internal("scene9.mp3"));
        second = Gdx.audio.newMusic(Gdx.files.internal("scene9.2.mp3"));
    }

    public void render(float delta){
        SpriteBatch batch = board.batch;
//        System.out.println(this.world.gameState);
//        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        batch.begin();
//        Ship positionship = world.getship();
        if(this.world.gameState == 0){
            drawMind();
            if(this.world.totalTime - this.world.startTime <= 11){
                first.play();
            }
            else if(this.world.totalTime - this.world.startTime > 11 && this.world.totalTime - this.world.startTime <=16  && cnt == 0){
                second.play();
                cnt++;
            }
            else if(this.world.totalTime - this.world.startTime > 16){
                this.world.gameState = 1;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 1) {
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

    public void drawMind(){
        SpriteBatch batch = board.batch;
        batch.draw(mind,0,0);
    }
}
