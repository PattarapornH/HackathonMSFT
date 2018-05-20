package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class WorldRenderer {

    private Texture bg;
    private Texture ch1;
    private Texture ch2;
    private Texture ch3;
    private Texture saler1;
    private Texture saler2;
    private Texture check4;
    private int cnt = 0;
    Quiz quiz;
    World world;
    Music sale1;
    Music sale2;
    
    public WorldRenderer(Quiz quiz,World world){
        this.quiz = quiz;
        this.world = world;
        bg = new Texture("quiz_question.png");
        ch1 = new Texture("quiz_ch1.png");
        ch2 = new Texture("quiz_ch2.png");
        ch3 = new Texture("quiz_ch3.png");
        saler1 = new Texture("quiz_saler_1.png");
        saler2 = new Texture("quiz_saler_2.png");
        check4 = new Texture("checklist4.png");
        sale1 = Gdx.audio.newMusic(Gdx.files.internal("scene15.1.mp3"));
        sale2 = Gdx.audio.newMusic(Gdx.files.internal("scene15.2.mp3"));

    }

    public void render(float delta){
        SpriteBatch batch = this.quiz.batch;

        if(this.world.gameState == -1){
            before();
            sale1.play();
            if((int)this.world.totalTime == 7){
                this.world.gameState = 0;
            }
        }
        else if(this.world.gameState == 0){
            play();
        }
        else if(this.world.gameState == 1){
            if(cnt == 0) {
                this.world.startTime = this.world.totalTime;
                sale2.play();
                after();
                cnt++;
            }
            after();
            if(this.world.totalTime - this.world.startTime >= 10.5){
                this.world.gameState = 2;
            }
        }
        else if(this.world.gameState == 2){
            showCheck();
        }
    }

    public void before(){
        SpriteBatch batch = this.quiz.batch;
        batch.draw(saler1,0,0);
    }

    public void play(){
        SpriteBatch batch = this.quiz.batch;
        Ch1 posCh1 = world.getCh1();
        Ch2 posCh2 = world.getCh2();
        Ch3 posCh3 = world.getCh3();

        batch.draw(bg,0,0);
        batch.draw(ch1,posCh1.getPosition().x,posCh1.getPosition().y,posCh1.width,posCh1.height);
        batch.draw(ch2,posCh2.getPosition().x,posCh2.getPosition().y,posCh2.width,posCh2.height);
        batch.draw(ch3,posCh3.getPosition().x,posCh3.getPosition().y,posCh3.width,posCh3.height);
    }

    public void after(){
        SpriteBatch batch = this.quiz.batch;
        batch.draw(saler2,0,0);
    }

    public void showCheck(){
        SpriteBatch batch = this.quiz.batch;
        batch.draw(check4,0,0);


    }
}
