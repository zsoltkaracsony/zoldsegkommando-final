package Objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

public class ZPM extends MapObject {

	@Override
	public void draw(Graphics2D g, int x, int y, HashMap tm) {
		g.drawImage((Image) tm.get(15), x*32, y*32,null);
	}
}