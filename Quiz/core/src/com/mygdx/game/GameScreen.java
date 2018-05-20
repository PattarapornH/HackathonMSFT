package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
    public SpriteBatch batch;
    private Quiz Quiz;

    private World world;
    private WorldRenderer WorldRenderer;

    public GameScreen(Quiz quiz) {
        this.Quiz = quiz;
        this.world = new World(quiz);
        this.WorldRenderer = new WorldRenderer(this.Quiz,world);
    }

    public void render (float delta) {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = Quiz.batch;

        //batch.begin();
        WorldRenderer.render(delta);
        world.update(delta);
        // batch.end();
    }
}
