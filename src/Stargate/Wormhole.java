package Stargate;

import java.awt.Graphics2D;

import Tiles.Tile;

public class Wormhole {

	private Stargate stargateBlue = null;
	private Stargate stargateOrange = null;
	private Stargate stargateRed = null;
	private Stargate stargateGreen = null;
	private Boolean open;
	private int attribute;

	public void draw(Graphics2D g) {
		if(stargateBlue != null)stargateBlue.draw(g);
		if(stargateOrange != null)stargateOrange.draw(g);
		if(stargateRed != null)stargateRed.draw(g);
		if(stargateGreen != null)stargateGreen.draw(g);
	}

	public void setStargate(String color, Stargate s) {
		
		if (color.equals("blue")) { this.stargateBlue = s; }
		if (color.equals("orange")){ this.stargateOrange = s; }
		if (color.equals("red")){ this.stargateRed = s; }
		if (color.equals("green")){ this.stargateGreen = s; }
	}

	public Stargate getStargate(String color) {
		
		if (color.equals("blue")){ return stargateBlue; }
		if (color.equals("orange")){ return stargateOrange; }
		if (color.equals("red")){ return stargateRed; }
		if (color.equals("green")){ return stargateGreen; }
		
		return null;
	}
	public Stargate getOtherStargate(Tile t) {
		if((stargateBlue!=null) && stargateBlue.getTile() == t){ return stargateOrange; }
		if((stargateOrange!=null) && stargateOrange.getTile() == t){ return stargateBlue; }
		if((stargateRed!=null) &&stargateRed.getTile() == t){ return stargateGreen; }
		if((stargateGreen!=null) &&stargateGreen.getTile() == t){ return stargateRed; }
		
		return null;
	}

}