package Objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

public class Door {

	private Boolean open;
	private int textureIdOpen;
	private int textureIdClose;

	/**
	 * 
	 * @param b
	 */
	public Door(){
		this.open = false;
//		System.out.println("Ajto letrehozva");
	}
	public void setOpen(Boolean b) {
		if(b){
			this.open = true;
			System.out.println("Az ajto kinyilt");
		}else{
			this.open = false;
			System.out.println("Az ajto bezarult");
		}
	}

	public Boolean getOpen() {
		return open;
	}

	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g,int x, int y, HashMap tm) {
		if(open){
			g.drawImage((Image) tm.get(13), x*32, y*32,null);
		}
		else{
			g.drawImage((Image) tm.get(14), x*32, y*32,null);
		}
	}

}