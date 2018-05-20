package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    private Texture bg;
    private Texture chan;
    private Texture kan;
    private Texture yee;
    private Texture gin;
    private Texture pep;
    private Texture corr1;
    private Texture corr2;
    private Texture info;
    Spices spices;
    World world;

    public WorldRenderer(Spices spices,World world) {
        this.spices = spices;
        this.world = world;
        bg = new Texture("spices_BG.png");
        chan = new Texture("spices_chantes.png");
        kan = new Texture("spices_kanplu.png");
        yee = new Texture("spices_yeerah.png");
        gin = new Texture("spices_ginger.png");
        pep = new Texture("spices_pepper.png");
        corr1 = new Texture("icon_correct.png");
        corr2 = new Texture("icon_correct.png");
        info = new Texture("spices_new.png");
    }

    public void render(float delta){
        SpriteBatch batch = this.spices.batch;
//        System.out.println("pass");
        batch.begin();
        if(this.world.gameState == 0) {
            play();
        }
        else if(this.world.gameState == 1){
            chooseKan();
        }
        else if(this.world.gameState == 2){
            chooseChan();
        }
        else if(this.world.gameState == 3){
            chooseBoth();
            if((System.currentTimeMillis() - this.world.startTime) / 1000 == 1){
                this.world.gameState = 4;
            }
        }
        else if(this.world.gameState == 4){
            detail();
        }
        batch.end();
    }
    public void play(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(bg,0,0);

        Chan positionChan = world.getChan();
        KanPhlu positionKan = world.getKan();
        Yeera positionYee = world.getYee();
        Ginger positionGin = world.getGin();
        Pepper positionPep = world.getPep();

        batch.draw(kan,positionKan.getPosition().x,positionKan.getPosition().y,positionKan.width,positionKan.height);
        batch.draw(pep,positionPep.getPosition().x,positionPep.getPosition().y,positionPep.width,positionPep.height);

        batch.draw(chan,positionChan.getPosition().x,positionChan.getPosition().y,positionChan.width,positionChan.height);
        batch.draw(yee,positionYee.getPosition().x,positionYee.getPosition().y,positionYee.width,positionYee.height);
        batch.draw(gin,positionGin.getPosition().x,positionGin.getPosition().y,positionGin.width,positionGin.height);

    }

    public void chooseKan(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(bg,0,0);

        Chan positionChan = world.getChan();
        KanPhlu positionKan = world.getKan();
        Yeera positionYee = world.getYee();
        Ginger positionGin = world.getGin();
        Pepper positionPep = world.getPep();
        Correct positonCorr1 = world.getCorrectKhan();

        batch.draw(corr1,positonCorr1.getPosition().x,positonCorr1.getPosition().y,positonCorr1.width,positonCorr1.height);

        batch.draw(kan,positionKan.getPosition().x,positionKan.getPosition().y,positionKan.width,positionKan.height);
        batch.draw(pep,positionPep.getPosition().x,positionPep.getPosition().y,positionPep.width,positionPep.height);

        batch.draw(chan,positionChan.getPosition().x,positionChan.getPosition().y,positionChan.width,positionChan.height);
        batch.draw(yee,positionYee.getPosition().x,positionYee.getPosition().y,positionYee.width,positionYee.height);
        batch.draw(gin,positionGin.getPosition().x,positionGin.getPosition().y,positionGin.width,positionGin.height);
    }

    public void chooseChan(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(bg,0,0);

        Chan positionChan = world.getChan();
        KanPhlu positionKan = world.getKan();
        Yeera positionYee = world.getYee();
        Ginger positionGin = world.getGin();
        Pepper positionPep = world.getPep();
        Correct positonCorr2 = world.getCorrectChan();

        batch.draw(corr2,positonCorr2.getPosition().x,positonCorr2.getPosition().y,positonCorr2.width,positonCorr2.height);

        batch.draw(kan,positionKan.getPosition().x,positionKan.getPosition().y,positionKan.width,positionKan.height);
        batch.draw(pep,positionPep.getPosition().x,positionPep.getPosition().y,positionPep.width,positionPep.height);

        batch.draw(chan,positionChan.getPosition().x,positionChan.getPosition().y,positionChan.width,positionChan.height);
        batch.draw(yee,positionYee.getPosition().x,positionYee.getPosition().y,positionYee.width,positionYee.height);
        batch.draw(gin,positionGin.getPosition().x,positionGin.getPosition().y,positionGin.width,positionGin.height);
    }

    public void chooseBoth(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(bg,0,0);

        Chan positionChan = world.getChan();
        KanPhlu positionKan = world.getKan();
        Yeera positionYee = world.getYee();
        Ginger positionGin = world.getGin();
        Pepper positionPep = world.getPep();
        Correct positonCorr2 = world.getCorrectChan();
        Correct positonCorr1 = world.getCorrectKhan();

        batch.draw(corr1,positonCorr1.getPosition().x,positonCorr1.getPosition().y,positonCorr1.width,positonCorr1.height);
        batch.draw(corr2,positonCorr2.getPosition().x,positonCorr2.getPosition().y,positonCorr2.width,positonCorr2.height);

        batch.draw(kan,positionKan.getPosition().x,positionKan.getPosition().y,positionKan.width,positionKan.height);
        batch.draw(pep,positionPep.getPosition().x,positionPep.getPosition().y,positionPep.width,positionPep.height);

        batch.draw(chan,positionChan.getPosition().x,positionChan.getPosition().y,positionChan.width,positionChan.height);
        batch.draw(yee,positionYee.getPosition().x,positionYee.getPosition().y,positionYee.width,positionYee.height);
        batch.draw(gin,positionGin.getPosition().x,positionGin.getPosition().y,positionGin.width,positionGin.height);
    }

    public void detail(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(info,0,0);
    }
}
