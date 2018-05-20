package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    /*Texture*/
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
    private Texture check;
    private Texture map1;
    private Texture map2;
    private Texture map3;

    Spices spices;
    World world;
    Music first;
    Music second;
    Music ask;
    Music win;
//    Music bgMusic;
    private int cnt = 0;
    /*The end*/
    Texture end1;
    Texture end2;
    Texture end3;
    Texture end4;
    Texture end5;
    Texture end6;
    Texture end7;
    Music s1;
    Music s3;
    Music s5_1;
    Music s5_2;
    Music s6;
    Music asean;

    public WorldRenderer(Spices spices,World world) {
        this.spices = spices;
        this.world = world;
        /*Texture*/
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
        check = new Texture("checklist5.png");
        map1 = new Texture("map_03_01.png");
        map2 = new Texture("map_03_02.png");
        map3 = new Texture("map_03_03.png");

        /*Sound*/
        first = Gdx.audio.newMusic(Gdx.files.internal("scene16.2.mp3"));
        second = Gdx.audio.newMusic(Gdx.files.internal("scene16.3.mp3"));
        win = Gdx.audio.newMusic(Gdx.files.internal("winner.mp3"));
        ask = Gdx.audio.newMusic(Gdx.files.internal("scene16.1.mp3"));
//        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("GamingBG.mp3"));

        /*The End Texture*/
        end1 = new Texture("the_end_1.png");
        end2 = new Texture("the_end_2.png");
        end3 = new Texture("the_end_3.png");
        end4 = new Texture("the_end_4.png");
        end5 = new Texture("the_end_5.png");
        end6 = new Texture("the_end_6.png");
        end7 = new Texture("the_end_7.png");
        /*The End Sound*/
        s1 = Gdx.audio.newMusic(Gdx.files.internal("scene19.3.mp3"));
        s3 = Gdx.audio.newMusic(Gdx.files.internal("scene19.2.mp3"));
        s5_1 = Gdx.audio.newMusic(Gdx.files.internal("scene19.4.mp3"));
        s5_2 = Gdx.audio.newMusic(Gdx.files.internal("scene19.5.mp3"));
        s6 = Gdx.audio.newMusic(Gdx.files.internal("scene19.6.mp3"));
        asean = Gdx.audio.newMusic(Gdx.files.internal("TheASEANWAY.mp3"));
    }

    public void render(float delta){
        SpriteBatch batch = this.spices.batch;
//        System.out.println("pass");\
//        bgMusic.play();
        batch.begin();
        if(this.world.gameState == -5){
            drawMap1();
            if(this.world.totalTime - this.world.startTime >= 1){
                this.world.gameState = -4;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == -4){
            drawMap2();
            if(this.world.totalTime - this.world.startTime >= 1){
                this.world.gameState = -3;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == -3){
            drawMap3();
            if(this.world.totalTime - this.world.startTime >= 2){
                this.world.gameState = -2;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == -2){
            merchant1();
            if(cnt == 0) {
                ask.play();
                cnt++;
            }
            if(this.world.totalTime - this.world.startTime >= 5){
                this.world.gameState = -1;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == -1){
            merchant2();
//            if(cnt == 1) {
//                second.play();
//                cnt++;
//            }
            if(this.world.totalTime - this.world.startTime <= 3){
                first.play();
            }
            else if(this.world.totalTime - this.world.startTime > 3 && this.world.totalTime - this.world.startTime <= 5  && cnt == 1){
                second.play();
                cnt++;
            }
            else if(this.world.totalTime - this.world.startTime > 8){
                this.world.gameState = 0;
                this.world.startTime = this.world.totalTime;
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
            if((this.world.totalTime - this.world.startTime) >= 1){
//                System.out.println("pass");
                this.world.startTime = this.world.totalTime;
                this.world.gameState = 4;
            }
        }
        else if(this.world.gameState == 4){
            detail();
            if((this.world.totalTime - this.world.startTime)>= 3){
                this.world.gameState = 5;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 5){
            checklist();
            if(cnt == 2) {
                win.play();
                cnt++;
            }
            if((this.world.totalTime - this.world.startTime) >= 5){
                this.world.gameState = 6;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 6){
            drawEnd1();
            if(cnt == 3){
//                System.out.println("pass");
                s1.play();
                cnt++;
            }
            if((this.world.totalTime - this.world.startTime) >= 37){
//                System.out.println("pass");
                this.world.gameState = 7;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 7){
            drawEnd2();
            if((this.world.totalTime - this.world.startTime) >= 1){
                this.world.gameState = 8;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 8){
            drawEnd3();
            if(cnt == 4){
                s3.play();
                cnt++;
            }
            if((this.world.totalTime - this.world.startTime) >= 10){
                this.world.gameState = 9;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 9){
            drawEnd4();
            if((this.world.totalTime - this.world.startTime) >= 0.5){
                this.world.gameState = 10;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 10){
            drawEnd5();
            if(this.world.totalTime - this.world.startTime <= 5){
                s5_1.play();
            }
            else if(this.world.totalTime - this.world.startTime > 5 && this.world.totalTime - this.world.startTime <= 8  && cnt == 5){
                s5_2.play();
                cnt++;
            }
            else if(this.world.totalTime - this.world.startTime > 8){
                this.world.gameState = 11;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 11){
            drawEnd6();
            if(cnt == 6){
                s6.play();
                cnt++;
            }
            if((this.world.totalTime - this.world.startTime) >= 4){
                this.world.gameState = 12;
                this.world.startTime = this.world.totalTime;
            }
        }
        else if(this.world.gameState == 12){
            drawEnd7();
            asean.play();
        }
        batch.end();
    }

    public void drawMap1(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(map1,0,0);
    }

    public void drawMap2(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(map2,0,0);
    }

    public void drawMap3(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(map3,0,0);
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

    public void checklist(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(check,0,0);
    }

    public void drawEnd1(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end1,0,0);
    }

    public void drawEnd2(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end2,0,0);
    }

    public void drawEnd3(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end3,0,0);
    }

    public void drawEnd4(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end4,0,0);
    }

    public void drawEnd5(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end5,0,0);
    }

    public void drawEnd6(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end6,0,0);
    }

    public void drawEnd7(){
        SpriteBatch batch = this.spices.batch;
        batch.draw(end7,0,0);
    }
}
