package Tiles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import Entities.Entity;
import Entities.Player;
import Objects.Box;
import Stargate.Stargate;

public class Wall extends Tile {

	private Boolean isSpecial;
	private Stargate stargate;

	public Wall(Boolean isSpecial, int x, int y, HashMap textureMap) {
		super(x,y,textureMap);
		this.isSpecial = isSpecial;
		System.out.format("Specialis: %s%n",this.isSpecial.toString());
	}


	public Boolean getIsSpecial() {
		return isSpecial;
	}


	public void setIsSpecial(Boolean isSpecial) {
		this.isSpecial = isSpecial;
	}


	@Override
	public void onStep(Entity e, int directionFrom) {
		System.out.format("%s entitás megpróbál rálépni %s csempére%n",e.getClass().getSimpleName(), this.getClass().getSimpleName() );
			if(isSpecial){
				e.hitSpecialWall(this);
			}else{
				e.hitWall(this);  
			}

	}

	@Override
	public void putBox(Player p, Box box) {
		System.out.format("%s entitas nem tud dobozt letenni a %s csempre X:%d Y:%d helyen", p.getClass().getSimpleName(),this.getClass().getSimpleName(),this.getX(),this.getY());
	}

	@Override
	public void draw(Graphics2D g) {
		if(isSpecial){
			g.drawImage((Image) textureMap.get(1), x*32, y*32,null);
		}else{
			g.drawImage((Image) textureMap.get(2), x*32, y*32,null);
		}
	}

	@Override
	public void pickBox(Player p) {
		// TODO Auto-generated method stub
		
	}

}