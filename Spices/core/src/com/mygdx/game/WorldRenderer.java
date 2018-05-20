package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
    private Texture merch1;
    private Texture merch2;

    Spices spices;
    World world;
    Music first;
    Music second;
    Music bgMusic;
    private int cnt = 0;

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
        merch1 = new Texture("spices_merchant1.png");
        merch2 = new Texture("spices_merchant2.png");
        first = Gdx.audio.newMusic(Gdx.files.internal("scene16.2.mp3"));
        second = Gdx.audio.newMusic(Gdx.files.internal("scene16.3.mp3"));
        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("GamingBG.mp3"));
    }

    public void render(float delta){
        SpriteBatch batch = this.spices.batch;
//        System.out.println("pass");\
        bgMusic.play();
        batch.begin();
        if(this.world.gameState == -2){
            merchant1();
            if(cnt == 0) {
                first.play();
                cnt++;
            }
            if((int)this.world.totalTime == 4){
                this.world.gameState = -1;
            }
        }
        else if(this.world.gameState == -1){
            merchant2();
            if(cnt == 1) {
                second.play();
                cnt++;
            }
            if((int)this.world.totalTime == 7){
                this.world.gameState = 0;
            }
        }
        else if(this.world.gameState == 0) {
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

    public void merchant1(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(merch1,0,0);
    }


    public void merchant2(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(merch2,0,0);
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
