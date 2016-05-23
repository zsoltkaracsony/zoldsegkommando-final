package Entities;

import java.awt.Graphics2D;
import java.awt.Image;

import Stargate.Stargate;
import Testing.testOutPutter;
import Tiles.Tile;

public class Projectile extends Entity {

	private String color;
	private Player owner;
	private int step;

	public Projectile(String color, Player p) {
		this.owner = p;
		this.tileMap = p.tileMap;
		this.color = color;
		this.actualTile = p.actualTile;
		this.direction = p.direction;
		step = 0;
	}

//	@Override
//	public void move(int dir) {
//	}

	@Override
	public void draw(Graphics2D g) {
		switch(color){
		case "blue":
			g.drawImage((Image) tileMap.getTextureMap(11), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case "orange":
			g.drawImage((Image) tileMap.getTextureMap(19), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case "red":
			g.drawImage((Image) tileMap.getTextureMap(20), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case "green":
			g.drawImage((Image) tileMap.getTextureMap(21), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void destroy() {
		System.out.format("A lovedek megsemmisult%n");
		if(color.equals("blue") || (color.equals("red"))){
			owner.projectilePrimary = null;
		}else{
			owner.projectileSecondary = null;
		}
	}

	@Override
	public void moveTo(Tile t) {
		this.actualTile = t;
	}

	@Override
	public void hitWall(Tile t) {
		System.out.format("%s entitas nekiütközött valaminek az X: %d Y: %d helyen%n", this.getClass().getSimpleName(),t.getX(),t.getY());
		destroy();
		
	}

	@Override
	public void hitGap(Tile t) {
		System.out.format("%s entitas %s csempre lepett az X: %d Y: %d helyen%n", this.getClass().getSimpleName(),t.getClass().getSimpleName(),t.getX(),t.getY());
		moveTo(t);
	}

	@Override
	public void hitFloor(Tile t) {
		System.out.format("%s entitas ralepett %s csempere az X: %d Y: %d helyen%n",this.getClass().getSimpleName(),t.getClass().getSimpleName(),t.getX(),t.getY());
		moveTo(t);
		if(tileMap.getReplicator() != null){
			if(tileMap.getReplicator().getActualTile() == this.actualTile){
				tileMap.setReplicator(null);
				destroy();
				System.out.format("%s entitas replikatornak utkozott es megsemmisitette azt a X: %d Y: %d helyen%n",this.getClass().getSimpleName(),t.getX(),t.getY());
			}
		}
	}

	@Override
	public void hitSpecialWall(Tile t) {
		System.out.format("%s entitas specialis falnak utkozott X: %d Y: %d helyen es csillagkaput hozott letre%n", this.getClass().getSimpleName(),t.getX(),t.getY());
		tileMap.getWormhole().setStargate(color, new Stargate(t,invertDir(direction),color,tileMap.textureMap));
		destroy();
	}

	@Override
	public void hitZPM(Tile t) {
		System.out.format("%s entitas ZPM-nek utkozott az X:%d Y: %d helyen",this.getClass().getSimpleName(),t.getX(),t.getY());
		destroy();	
	}

	@Override
	public void update() {
		if(step == 4){
			move(direction);
			xOff = 0;
			yOff = 0;
			step = 0;
			System.out.println("lovedek lep");
		}else{
			step++;
			switch(direction){
			case 0:
				yOff = yOff - 8; 
				break;
			case 1: 
				xOff = xOff + 8;
				break;
			case 2:
				yOff = yOff + 8;
				break;
			case 3: 
				xOff = xOff - 8;
				break;
			default: break;
			}
		}
	}

}