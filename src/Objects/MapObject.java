package Objects;

import java.awt.Graphics2D;
import java.util.HashMap;

public abstract class MapObject {

	protected int textureID;

	/**
	 * 
	 * @param g
	 */
	public abstract void draw(Graphics2D g,int x, int y, HashMap tm);

}