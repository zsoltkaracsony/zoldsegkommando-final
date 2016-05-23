package Tiles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import Entities.Entity;
import Entities.Player;
import Objects.Box;

public class Floor extends Tile {
	

	public Floor(int x, int y, HashMap textureMap){
		super(x,y,textureMap);
	}
	
	public void killZPM() {
	}

	@Override
	public void onStep(Entity e, int directionFrom) {
		System.out.format("%s entitas megprobal ralepni %s csempere%n",e.getClass().getSimpleName(), this.getClass().getSimpleName() );
		if(hasObject("Box")){
			e.hitWall(this);
		}else{

			if((door != null) && !(door.getOpen())){
				e.hitWall(this);
			}else{
				if((e.getActualTile().getScale() != null) && (this.getDoor() != null) && (e.getActualTile().getScale().getDoor() == this.getDoor())){
					e.hitWall(this);
				}else{
					e.hitFloor(this);
					if(hasObject("ZPM")){
						e.hitZPM(this);
					}
				}
			}
		}
		
	}

	@Override
	public void putBox(Player p, Box box) {
		
		if((hasObject("ZPM")) || (door != null)){
			System.out.format("%s entitas nem tud dobozt letenni X:%d Y:%d helyre ZPM vagy ajto miatt%n",p.getClass().getSimpleName(),this.getX(),this.getY());
			
		}else{
		mapObjects.add(box);
		p.dropBox();
		System.out.format("%s entitas sikeresen letette a dobozt a %s csempere az X:%d Y:%d helyre%n",p.getClass().getSimpleName(),this.getClass().getSimpleName(),this.getX(),this.getY());
		if(scale != null){
			if(this.scale.checkWeight(this.countObject("Box"))){
				scale.setPressed(true);
			}else{
				System.out.println("Nincs elég súly");
			}
		}
		}
		
	}

	
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) textureMap.get(0), x*32, y*32,null);
		super.draw(g);
	}
	

	@Override	
	public void pickBox(Player p) {
		if(p.hasBox != null){
			System.out.format("%s entitas nem tud egynel tobb dobozt felvenni%n",p.getClass().getSimpleName());
		}else{
			if(getObject("Box")==null){
				System.out.format("%s csempen nincs doboz",this.getClass().getSimpleName());
			}else{
				p.setBox((Box) getObject("Box"));
				mapObjects.remove(getObject("Box"));
				System.out.println(countObject("Box"));
				if(scale != null){
					if(scale.checkWeight(countObject("Box"))){
					}else{
						scale.setPressed(false);
					}
				}
				System.out.format("%s entitas felvett egy dobozt a X:%d Y:%d helyrol%n",p.getClass().getSimpleName(),this.x,this.y);
			}
		}
	}

}