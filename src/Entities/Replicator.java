package Entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import Stargate.Stargate;
import TileMap.TileMap;
import Tiles.Floor;
import Tiles.Tile;

public class Replicator extends Entity{
	
	int step = 0;
	
	public Replicator(TileMap tm, Tile t, int dir){
		this.tileMap = tm;
		this.actualTile = t;
		this.direction = dir;
		tm.setReplicator(this);
		System.out.format("%s entitas hozzaadva. X: %d Y: %d%n", this.getClass().getSimpleName(),this.actualTile.getX(),this.actualTile.getY());
	}
	
	public void randomStep() throws InterruptedException{
		Random random = new Random();
		int w = random.nextInt(4);
		move(w);
		move(w);
	}
	@Override
	public void destroy(){
		tileMap.setReplicator(null);
	}
	@Override
	public void update(){
		if(step == 60){
			try {
				randomStep();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			step = 0;
		}else{
			step ++;
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		switch(direction){
		case 0:
			g.drawImage((Image) tileMap.getTextureMap(10).getSubimage(0, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 1:
			g.drawImage((Image) tileMap.getTextureMap(10).getSubimage(32, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 2:
			g.drawImage((Image) tileMap.getTextureMap(10).getSubimage(64, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 3:
			g.drawImage((Image) tileMap.getTextureMap(10).getSubimage(96, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		default: break;
		}
	}

	@Override
	public void hitWall(Tile t) {
		System.out.format("%s entitas nekiutkozott valaminek az X: %d Y: %d helyen%n", this.getClass().getSimpleName(),t.getX(),t.getY());
	}

	@Override
	public void hitGap(Tile t) {
		System.out.format("%s entitas szakekba lepett es feltoltotte azt az X: %d Y: %d helyen%n",this.getClass().getSimpleName(),t.getX(),t.getY());
		tileMap.setTile(t.getX(), t.getY(), new Floor(t.getX(), t.getY(), tileMap.textureMap));
		destroy();
	}

	@Override
	public void hitZPM(Tile t) {
	}

	@Override
	public void hitFloor(Tile t) {
		moveTo(t);
	}

	@Override
	public void hitSpecialWall(Tile t) {
		Stargate toSG;
		System.out.println(">ONeill.hitSpecialWall");
		toSG = tileMap.getWormhole().getOtherStargate(t);
		switch (toSG.getDirection()){
		case 0: 
				tileMap.getTile(toSG.getTile().getX()-1, toSG.getTile().getY()).onStep(this, this.direction);
				break;
		case 1: 
				tileMap.getTile(toSG.getTile().getX(), toSG.getTile().getY()+1).onStep(this, this.direction);
				break;
		case 2: 
				tileMap.getTile(toSG.getTile().getX()+1, toSG.getTile().getY()).onStep(this, this.direction);
				break;
		case 3: 
				tileMap.getTile(toSG.getTile().getX(), toSG.getTile().getY()-1).onStep(this, this.direction);
				break;
		default : break;
		}
	}

}
