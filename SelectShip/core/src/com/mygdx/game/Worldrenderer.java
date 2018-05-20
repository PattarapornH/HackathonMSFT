package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Worldrenderer {
//    public SpriteBatch batch;
    private Texture ship1;
    private Texture ship2;
    private Texture ship3;
    private Texture bg;
    private Texture harbor;
    private Texture harborShip;
    private Texture correct;
    private Texture wrong;
    private Texture solCar;
    private Texture solChi;
    private Texture solVik;
    private World world;
    private SelectShip SelectShip;

    public Worldrenderer(SelectShip SelectShip,World world){
        bg = new Texture("BG_harbor_select_ship2.png");
        ship1 = new Texture("ship_caravel.png");
        ship2 = new Texture("ship_chinese.png");
        ship3 = new Texture("ship_viking.png");
        harborShip = new Texture("BG_harbor.png");
        harbor = new Texture("BG_harbor_select_ship1.png");
        correct = new Texture("icon_correct.png");
        wrong = new Texture("icon_wrong.png");
        solCar = new Texture("ship_caravel_sol.png");
        solChi = new Texture("ship_chinese_sol.png");
        solVik = new Texture("ship_viking_sol.png");

        //        shipCaravel ship1;
        this.world = world;
        this.SelectShip = SelectShip;

    }

    public void render(float delta){
        System.out.println(this.world.gameState);
//        this.world.Timer();
//        System.out.println((int)this.world.totalTime + " " + (int)this.world.startTime);
        if((int)this.world.totalTime == 3 && this.world.gameState == -2){
//            System.out.println("pass");
            this.world.gameState = -1;
        }
        if((int)this.world.totalTime == 5 && this.world.gameState == -1){
//            System.out.println("pass");
            this.world.gameState = 0;
        }
        SpriteBatch batch = SelectShip.batch;
        batch.begin();
        if(this.world.gameState == -2){
            beforeSelectShipHarbor();
        }
        else if(this.world.gameState == -1){
            beforeSelectHarbor();
        }
        else if(this.world.gameState == 0) {
            select();
        }
        else if(this.world.gameState == 1){
            afterCorrect();
        }
        else if(this.world.gameState == 2){
            afterWrongChinese();
            if(this.world.totalTime - this.world.startTime >= 5){
                this.world.gameState = 0;
            }
        }
        else if(this.world.gameState == 3){
            afterWrongViking();
            if(this.world.totalTime - this.world.startTime >= 5){
                this.world.gameState = 0;
            }
        }
        batch.end();
    }

    public void select(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(bg,0,0);
        shipCaravel positionshicar = world.getshipcar();
        shipChinese positionshipchi = world.getshipchi();
        shipViking positionshipvik = world.getshipvik();
        batch.draw(ship1,300,400,positionshicar.width,positionshicar.height);
        batch.draw(ship2,100,100,positionshipchi.width,positionshipchi.height);
        batch.draw(ship3,480,100,positionshipvik.width,positionshipvik.height);
    }

    public void afterCorrect(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(solCar,0,0);
//        batch.draw(correct,10,10);
        Correct positionCorrect = world.getCorrect();
        batch.draw(correct,1050,20,positionCorrect.width,positionCorrect.height);
    }

    public void afterWrongChinese(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(solChi,0,0);
        Wrong positionWrong = world.getWrong();
        batch.draw(wrong,1050,20,positionWrong.width,positionWrong.height);
    }

    public void afterWrongViking(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(solVik,0,0);
        Wrong positionWrong = world.getWrong();
        batch.draw(wrong,1050,20,positionWrong.width,positionWrong.height);

    }

    public void beforeSelectShipHarbor(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(harborShip,0,0);
    }

    public void beforeSelectHarbor(){
        SpriteBatch batch = SelectShip.batch;
        batch.draw(harbor,0,0);
    }
}
