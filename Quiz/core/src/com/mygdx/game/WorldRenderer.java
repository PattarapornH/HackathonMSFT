package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    private Texture bg;
    private Texture ch1;
    private Texture ch2;
    private Texture ch3;
    Quiz quiz;
    World world;
    
    public WorldRenderer(Quiz quiz,World world){
        this.quiz = quiz;
        this.world = world;
        bg = new Texture("quiz_question.png");
        ch1 = new Texture("quiz_ch1.png");
        ch2 = new Texture("quiz_ch2.png");
        ch3 = new Texture("quiz_ch3.png");
    }

    public void render(float delta){
        SpriteBatch batch = this.quiz.batch;
        Ch1 posCh1 = world.getCh1();
        Ch2 posCh2 = world.getCh2();
        Ch3 posCh3 = world.getCh3();

        batch.draw(bg,0,0);
        batch.draw(ch1,posCh1.getPosition().x,posCh1.getPosition().y,posCh1.width,posCh1.height);
        batch.draw(ch2,posCh2.getPosition().x,posCh2.getPosition().y,posCh2.width,posCh2.height);
        batch.draw(ch3,posCh3.getPosition().x,posCh3.getPosition().y,posCh3.width,posCh3.height);

    }
}
