package Stargate;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import Tiles.Tile;

public class Stargate {

	private Tile actualTile;
	private HashMap<Integer,BufferedImage> textureMap;
	private int textureId;
	private int direction;
	private String color;

	public Stargate(Tile t,int dir, String color,HashMap<Integer,BufferedImage> hm) {
		this.actualTile = t;
		this.color = color;
		this.direction = dir;
		this.textureMap = hm;
		setTextureID();
		System.out.format("%s szinu csillagkapu jott letre, X: %d Y: %d helyen, %d iranyban.%n",color,t.getX(),t.getY(),dir);
	}

	public void setTile(Tile t){
		this.actualTile = t;
	}
	public Tile getTile(){
		return actualTile;
	}
	
	private void setTextureID(){
		switch (color){
		case "blue":
			textureId = 5;
			break;
		case "orange":
			textureId = 6;
			break;
		case "red":
			textureId = 7;
			break;
		case "green":
			textureId = 8;
			break;
		default:
			break;
		}
	}
	
	public void draw(Graphics2D g) {
		switch(direction){
		case 0:
			g.drawImage((Image) textureMap.get(textureId).getSubimage(0, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 1:
			g.drawImage((Image) textureMap.get(textureId).getSubimage(32, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 2:
			g.drawImage((Image) textureMap.get(textureId).getSubimage(64, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		case 3:
			g.drawImage((Image) textureMap.get(textureId).getSubimage(96, 0, 32, 32), actualTile.getX()*32,actualTile.getY()*32,null);
			break;
		default: break;
		}
	}
	public void setDirection(int d){
		this.direction = d;
	}
	public int getDirection(){
		return direction;
	}
}