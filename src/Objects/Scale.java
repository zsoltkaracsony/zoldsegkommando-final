package Objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

public class Scale {

	private Boolean pressed;
	private int textureIdUp;
	private int textureIdDown;
	private Door door;
	private int neededWeight;
	
	public Scale(int nw){
		this.neededWeight = nw;
		this.pressed = false;
		System.out.println("Merleg letrehozva");
	}
	
	public boolean checkWeight(int w){
		if(w >= this.neededWeight){
			return true;
		}else{
			return false;
		}
	}

	public void setPressed(Boolean p) {
		pressed = p;
		door.setOpen(p);
	}
	
	public boolean isPressed(){
		return pressed;
	}

	public Door getDoor(){
		return door;
	}
	public void setDoor(Door d){
		this.door = d;
	}
	public void draw(Graphics2D g,int x,int y,HashMap tm) {
		if(pressed){
			g.drawImage((Image) tm.get(17), x*32, y*32,null);
		}
		else{
			g.drawImage((Image) tm.get(16), x*32, y*32,null);
		}
	}

}