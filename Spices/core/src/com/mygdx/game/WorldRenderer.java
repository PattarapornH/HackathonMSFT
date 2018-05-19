package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    private Texture img;
    Spices spices;
    World world;

    public WorldRenderer(Spices spices,World world) {
        this.spices = spices;
        this.world = world;
        img = new Texture("badlogic.jpg");
    }

    public void render(float delta){
        SpriteBatch batch = this.spices.batch;
//        System.out.println("pass");
        batch.begin();
        batch.draw(img,0,0);
        batch.end();
    }
}
