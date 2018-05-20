package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen extends ScreenAdapter{
    public SpriteBatch batch;
    private SelectShip SelectShip;

    private World world;
    private Worldrenderer Worldrenderer;


    public GameScreen(SelectShip SelectShip) {
        this.SelectShip = SelectShip;
        this.world = new World(SelectShip);
        this.Worldrenderer = new Worldrenderer(this.SelectShip,world);

    }

    public void render (float delta) {
//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = SelectShip.batch;

//        batch.begin();
        Worldrenderer.render(delta);
        world.update(delta);
        //batch.end();
    }

//    private void update(float delta) {
//        world.Timer();
//    }
}
