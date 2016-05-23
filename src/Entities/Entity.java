package Entities;

import java.awt.Graphics2D;

import Testing.testOutPutter;
import TileMap.TileMap;
import Tiles.Tile;

//entitásokat leíró absztrakt osztály

public abstract class Entity {

	protected Tile actualTile;
	private int textureID;
	public TileMap tileMap;
	private int speed;
	public int direction;
	public int xOff = 0;
	public int yOff = 0;

	
	public Tile getActualTile() {
		return actualTile;
	}

	public void setActualTile(Tile actualTile) {
		this.actualTile = actualTile;
	}

	public void move(int dir){
		if(dir == this.direction){
		switch (dir){
		case 0:
			tileMap.getTile(actualTile.getX(), actualTile.getY()-1).onStep(this, 2);;
			break;
		case 1:
			tileMap.getTile(actualTile.getX()+1, actualTile.getY()).onStep(this, 3);;
			break;
		case 2:
			tileMap.getTile(actualTile.getX(), actualTile.getY()+1).onStep(this, 0);;
			break;
		case 3:
			tileMap.getTile(actualTile.getX()-1, actualTile.getY()).onStep(this, 1);;
			break;
		default:
			break;
		}
		}else{
			this.direction = dir;
			System.out.format("%s entitas forgott %d iranyba%n",this.getClass().getSimpleName(),this.direction);
		}
		
	}
public abstract void update();
	
	
//	Kirajzolás
	public abstract void draw(Graphics2D g);

	//entitás megsemmisítése
	public void destroy(){
	}
//	entitás mozgatási másik csempére
	public void moveTo(Tile t){
		System.out.format("%s entitas sikeresen ralepett a %s csempere X: %d Y: %d koordinatan%n",this.getClass().getSimpleName(),t.getClass().getSimpleName(),t.getX(),t.getY());
		this.actualTile = t;
		
	}

	public int invertDir(int d){
		switch(d){
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return d;
		}
	}
	
	
//	falra lépés esetén hívódik meg
	public abstract void hitWall(Tile t);
//	Szakadékba lépés esetén hívódik meg
	public abstract void hitGap(Tile t);
//	ZPMre lépés esetén  hívódik meg
	public abstract void hitZPM(Tile t);
//	Padlóra lépés esetén hívódik meg
	public abstract void hitFloor(Tile t);
//	Speciális falra lépésnél hívódik meg 
	public abstract void hitSpecialWall(Tile t);

}