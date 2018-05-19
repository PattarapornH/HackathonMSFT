package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
    public SpriteBatch batch;
    private Board Board;

    private World world;
    private WorldRenderer WorldRenderer;


    public GameScreen(Board board) {
        this.Board = board;
        this.world = new World(board);
        this.WorldRenderer = new WorldRenderer(this.Board,world);

    }

    public void render (float delta) {
//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //SpriteBatch batch = Board.batch;

//        batch.begin();
        WorldRenderer.render(delta);
        world.update(delta);
        //batch.end();
    }
}
