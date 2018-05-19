package com.mygdx.game;

public class World {

    private Ship ship;
    private Board Board;
    private Kodung kodung;
    private Mall mall;

    World(Board Board){
        this.Board = Board;
        ship = new Ship(150,580,this);
        kodung = new Kodung(490,580,this);
        mall = new Mall(830,580,this);
    }

    public void update(float delta){
        ship.render(delta);
        kodung.render(delta);
        mall.render(delta);
    }

    public boolean pointOnShip(int x,int y){
        return (x >= 152 && x <= 464) && (y >= 31 && y <= 133);
    }
    public boolean pointOnKodung(int x,int y) {
        return (x >= 494 && x <= 801) && (y >= 31 && y <= 133);
    }
    public boolean pointOnMall(int x,int y) {
        return (x >= 833 && x <= 1147) && (y >= 31 && y <= 133);
    }

    Ship getship(){
        return ship;
    }
    Kodung getKodung() { return kodung; }
    Mall getMall() { return mall; }
}