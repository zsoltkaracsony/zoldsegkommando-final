package Tiles;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Entities.Entity;
import Entities.Player;
import Objects.Box;
import Objects.Door;
import Objects.MapObject;
import Objects.Scale;

public abstract class Tile {

	protected int textureID;
	public List<MapObject> mapObjects;
	protected HashMap textureMap;
	protected Door door;
	protected Scale scale;
	protected int x;
	protected int y;

	/**
	 * 
	 * @param e
	 * @param directionFrom
	 */
	public Tile(int x, int y, HashMap textureMap){
		mapObjects = new ArrayList<MapObject>();
		door = null;
		scale = null;
		this.x = x;
		this.y = y;
		this.textureMap = textureMap;
		System.out.format("%s csempe hozzaadva. X: %d Y: %d%n",this.getClass().getSimpleName(),x,y);
	}
	
	public abstract void onStep(Entity e, int directionFrom);

	public boolean hasObject(String string) {
		if(mapObjects == null){
			return false;
		}
		for (MapObject i : mapObjects){
			if(i.getClass().getSimpleName().equals(string)){
				return true;
			}
		}
		return false;
	}
	
	public MapObject getObject(String string){
		for (MapObject i : mapObjects){
			if(i.getClass().getSimpleName().equals(string)){
				return i;
			}
		}
		return null;
	}
	
	public int countObject(String string){
		int count = 0;
		for(MapObject i : mapObjects){
			if (i.getClass().getSimpleName().equals(string)){
				count++;
			}
		}
		return count;
	}
	
	public void addObject(MapObject mo){
		mapObjects.add(mo);
		System.out.format("%s hozzaadva. X: %d Y: %d%n",mo.getClass().getSimpleName(),this.getX(),this.getY());
	}
	
	public void removeObject(MapObject mo){
		mapObjects.remove(mo);
		System.out.format("%s eltavolitva X: %d Y: %d%n",mo.getClass().getSimpleName(),this.getX(),this.getY());
	}

	public abstract void putBox(Player p, Box box);
	public abstract void pickBox(Player p);
	public void draw(Graphics2D g){
		if(scale != null) scale.draw(g,x,y,textureMap);
		if(door != null) door.draw(g,x,y,textureMap);
		for(MapObject i : mapObjects){
			i.draw(g,x,y,textureMap);
		}
		
	}


	public Door getDoor() {
		return door;
	}
	
	public void setDoor(Door d){
		this.door = d;
		System.out.format("%s hozzaadva. X: %d Y: %d%n",d.getClass().getSimpleName(), this.x,this.y);
	}

	public Scale getScale() {
		return scale;
	}
	
	public void setScale(Scale s){
		this.scale = s;
		System.out.format("%s hozzaadva. X: %d Y: %d%n",s.getClass().getSimpleName(), this.x,this.y);
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	

}