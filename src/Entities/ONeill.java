package Entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImageOp;

import Objects.Box;
import TileMap.TileMap;
import Tiles.Tile;

public class ONeill extends Player {
	private int ZPM;
	private Box hasBox;
	private Projectile projectileBlue;
	private Projectile projectileOrange;
	private boolean isDead;

	public ONeill(TileMap m, Tile t, int d){
		super(m,t,d);
	}
	@Override
	public void shootProjectile(String type) {
		super.shootProjectile(type);
		if(type.equals("primary")){
			projectilePrimary = new Projectile("blue",this);
		}
		if(type.equals("secondary")){
			projectileSecondary = new Projectile("orange",this);
		}else{
			
		}
	}


	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		switch(direction){
		case 0:
			g.drawImage((Image) tileMap.getTextureMap(3).getSubimage(0, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 1:
			g.drawImage((Image) tileMap.getTextureMap(3).getSubimage(32, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 2:
			g.drawImage((Image) tileMap.getTextureMap(3).getSubimage(64, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		case 3:
			g.drawImage((Image) tileMap.getTextureMap(3).getSubimage(96, 0, 32, 32), actualTile.getX()*32+xOff,actualTile.getY()*32+yOff,null);
			break;
		default: break;
		}
		
//		g.drawImage((Image) tileMap.getTextureMap(3), actualTile.getX()*32,actualTile.getY()*32,null);
	}



}