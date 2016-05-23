package Testing;

import Entities.Entity;
import Objects.Scale;
import Tiles.Tile;

public class testOutPutter {
	
	public static void printTileAdd (Tile t){
		System.out.format("%s csempe hozzáadva X:%d Y:%d helyre %n",t.getClass().getSimpleName(),t.getX(),t.getY());
	}
	
	public static void printEntityAdd (Entity e){
		System.out.format("%s entitás hozzáadva az X:%d Y:%d helyre %d irányban%n",e.getClass().getSimpleName(),e.getActualTile().getX(),e.getActualTile().getY(),e.direction);
	}
	
	public static void printEntityMove (Entity e){
		System.out.format("A %s entitás mozgott a %d irányba",e.getClass().getSimpleName(),e.direction);
	}
	
	public static void printScaleDoorAdd (int scaleX, int scaleY, int doorX, int doorY){
		System.out.format("Merleg (X: %d Y: %d) es ajto (X: %d Y: %d) paros hozzaadva.%n", scaleX,scaleY,doorX,doorY);
	}
	
	public static void printEntityMoveFrom(Entity e){
		System.out.format("%s entitas X: %d Y: %d helyrol %d iranyba mozog, ", e.getClass().getSimpleName(),e.getActualTile().getX(),e.getActualTile().getY(),e.direction);
	}
	public static void printEntityMoveTo(Entity e){
		System.out.format("majd rálép az X: %d Y:%d mezőre%n",e.getActualTile().getX(),e.getActualTile().getY());
	}
	
	public static void printScalePress(Scale s){
		if(s.isPressed()){
			System.out.println("A mérleget lenyomták");
		}else{
			System.out.println("A mérleget felengedték");
		}
	}
	
	

}
