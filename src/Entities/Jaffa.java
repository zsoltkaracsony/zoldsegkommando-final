package Entities;

import java.awt.Graphics2D;
import java.awt.Image;

import Objects.Box;
import TileMap.TileMap;
import Tiles.Tile;

public class Jaffa extends Player{
	private int ZPM;
	private Box hasBox;
	private Projectile projectileRed;
	private Projectile projectileGreen;
	private boolean isDead;
	
	public Jaffa(TileMap m, Tile t, int d){
		super(m,t,d);
	}
	@Override
	public void shootProjectile(String type) {
		super.shootProjectile(type);
		if(type.equals("primary")){
			projectilePrimary = new Projectile("red",this);
		}
		if(type.equals("secondary")){
			projectileSecondary = new Projectile("green",this);
		}else{
			
		}
	}


	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
		switch(direction){
		case 0:
			g.drawImage((Image) tileMap.getTextureMap(4).getSubimage(0, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 1:
			g.drawImage((Image) tileMap.getTextureMap(4).getSubimage(32, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 2:
			g.drawImage((Image) tileMap.getTextureMap(4).getSubimage(64, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 3:
			g.drawImage((Image) tileMap.getTextureMap(4).getSubimage(96, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		default: break;
		}
//		g.drawImage((Image) tileMap.getTextureMap(4), actualTile.getX()*32, actualTile.getY()*32,null);
	}
}
