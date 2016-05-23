package Tiles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import Entities.Entity;
import Entities.Player;
import Objects.Box;

public class Gap extends Tile {

	public Gap(int x, int y, HashMap textureMap) {
		super(x, y, textureMap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onStep(Entity e, int directionFrom) {
		System.out.format("%s entitás megprobal ralepni %s csempere%n",e.getClass().getSimpleName(), this.getClass().getSimpleName() );
			e.hitGap(this);
		
	}

	@Override
	public void putBox(Player p, Box box) {
		p.dropBox();
		System.out.format("%s entitas dobozt tett a %s csempere az X:%d Y:%d helyen es a doboz megsemmisül", p.getClass().getSimpleName(),this.getClass().getSimpleName(),this.getX(),this.getY());
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) textureMap.get(18), x*32, y*32,null);
		super.draw(g);
	}

	@Override
	public void pickBox(Player p) {
		// TODO Auto-generated method stub
		
	}
}