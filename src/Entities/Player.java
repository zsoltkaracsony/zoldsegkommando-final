package Entities;

import java.awt.Graphics2D;

import GameStates.GameStateManager;
import Objects.Box;
import Objects.Scale;
import Stargate.Stargate;
import Testing.testOutPutter;
import TileMap.TileMap;
import Tiles.Tile;

public class Player extends Entity {
	
	private int ZPM;
	public Box hasBox;
	public Projectile projectilePrimary;
	public Projectile projectileSecondary;
	public boolean isDead;
	private boolean isMoving = false;
	private int moveCount = 0;
	
	
	
	public Player(TileMap tm, Tile t, int dir){
		this.tileMap = tm;
		this.actualTile = t;
		this.direction = dir;
		this.ZPM = 0;
		this.hasBox = null;
		testOutPutter.printEntityAdd(this);
	}
	
	@Override
	public void moveTo(Tile t){
//		isMoving = true;
//		moveCount = 0;
//		while(isMoving){
//			System.out.println("asd"); //feketemagia, ne nyulj hozza enelkül nem mukodik.
//		}
		super.moveTo(t);
	}
	@Override
	public void move(int dir){
		if(isMoving){
			System.out.println("asd");
		}
		super.move(dir);
	}
	
	public void pickUpBox() {
//		Box box = (Box) t.getObject("Box");
//		hasBox = box;
//		t.mapObjects.remove(box);
		switch (direction){
		case 0: 
				System.out.format("%s entitas megprobal dobozt felvenni az X: %d Y: %d csemperol%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()-1).getX(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()-1).getY());
				tileMap.getTile(actualTile.getX(), actualTile.getY()-1).pickBox(this);
				break;
		case 1: 
				System.out.format("%s entitas megprobal dobozt felvenni az X: %d Y: %d csemperol%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX()+1, actualTile.getY()).getX(),
					tileMap.getTile(actualTile.getX()+1, actualTile.getY()).getY());
				tileMap.getTile(actualTile.getX()+1, actualTile.getY()).pickBox(this);
				break;
		case 2: 
				System.out.format("%s entitas megprobal dobozt felvenni az X: %d Y: %d csemperol%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()+1).getX(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()+1).getY());
				tileMap.getTile(actualTile.getX(), actualTile.getY()+1).pickBox(this);
				break;
		case 3: 
				System.out.format("%s entitás megprobal dobozt felvenni az X: %d Y: %d csemperol%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX()-1, actualTile.getY()).getX(),
					tileMap.getTile(actualTile.getX()-1, actualTile.getY()).getY());
				tileMap.getTile(actualTile.getX()-1, actualTile.getY()).pickBox(this);
				break;
		default : break;
		}
	}
	
	public void putDownBox(){
		if (hasBox != null){
		switch (direction){
		case 0: 
				System.out.format("%s entitas megprobal dobozt letenni az X: %d Y: %d csempere%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()-1).getX(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()-1).getY());
				tileMap.getTile(actualTile.getX(), actualTile.getY()-1).putBox(this, hasBox);
				break;
		case 1: 
				System.out.format("%s entitas megprobal dobozt letenni az X: %d Y: %d csempere%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX()+1, actualTile.getY()).getX(),
					tileMap.getTile(actualTile.getX()+1, actualTile.getY()).getY());
				tileMap.getTile(actualTile.getX()+1, actualTile.getY()).putBox(this, hasBox);
				break;
		case 2: 
				System.out.format("%s entitas megprobal dobozt letenni az X: %d Y: %d csempere%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()+1).getX(),
					tileMap.getTile(actualTile.getX(), actualTile.getY()+1).getY());
				tileMap.getTile(actualTile.getX(), actualTile.getY()+1).putBox(this, hasBox);
				break;
		case 3: 
				System.out.format("%s entitas megprobal dobozt letenni az X:%d Y: %d csempere%n",
					this.getClass().getSimpleName(),
					tileMap.getTile(actualTile.getX()-1, actualTile.getY()).getX(),
					tileMap.getTile(actualTile.getX()-1, actualTile.getY()).getY());
				tileMap.getTile(actualTile.getX()-1, actualTile.getY()).putBox(this, hasBox);
				break;
		default : break;
		}
		}else{
			System.out.format("%s entitas nem tud dobozt letenni mert nincs nala doboz",this.getClass().getSimpleName());
		}
	}
	
	public void setBox(Box b){
		this.hasBox = b;
	}
	
	public Box getBox(){
		return hasBox;
	}
	
	public void dropBox() {
		this.hasBox = null;
	}

	@Override
	public void destroy() {
		tileMap.getGameState().getGsm().setState(GameStateManager.MENUSTATE);
		
	}
	
	@Override
	public void hitFloor(Tile t) {
		if(actualTile.getScale() != null){
			actualTile.getScale().setPressed(false);
		}
			moveTo(t);
			Scale s = t.getScale();
			if(s != null){
				System.out.format("%s entitas lenyomta a merleget a X: %d Y: %d helyen%n",this.getClass().getSimpleName(),t.getX(),t.getY());
				s.setPressed(true);
			}
	}
	

	@Override
	public void hitSpecialWall(Tile t) {
		try {
			Stargate toSG;
			toSG = tileMap.getWormhole().getOtherStargate(t);
			switch (toSG.getDirection()){
			case 0: 
					tileMap.getTile(toSG.getTile().getX(), toSG.getTile().getY()-1).onStep(this, this.direction);
					break;
			case 1: 
					tileMap.getTile(toSG.getTile().getX()+1, toSG.getTile().getY()).onStep(this, this.direction);
					break;
			case 2: 
					tileMap.getTile(toSG.getTile().getX(), toSG.getTile().getY()+1).onStep(this, this.direction);
					break;
			case 3: 
					tileMap.getTile(toSG.getTile().getX()-1, toSG.getTile().getY()).onStep(this, this.direction);
					break;
			default : break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(projectilePrimary != null){
			projectilePrimary.draw(g);
		}
		if(projectileSecondary != null){
			projectileSecondary.draw(g);
		}
	}

	@Override
	public void hitWall(Tile t) {
		System.out.format("%s entitas doboz/fal/zart ajtó miatt nem tud lepni%n",this.getClass().getSimpleName());
	}

	@Override
	public void hitGap(Tile t) {
		System.out.format("%s entitas szakadekba lep és meghal%n",this.getClass().getSimpleName());
		destroy();
	}

	@Override
	public void hitZPM(Tile t) {
		ZPM++;
		System.out.format("%s entitas ZPM-re lepett a %s csempen és felvette azt%nZPMek szama: %d",this.getClass().getSimpleName(),t.getClass().getSimpleName(),this.ZPM);
		t.mapObjects.remove(t.getObject("ZPM"));
		if(this.ZPM%2 == 0){
			tileMap.spawnZPM();
		}
		tileMap.lowerZPM();
	}

	public void shootProjectile(String type) {
		System.out.format("%s entitas kilott egy %s tipusu lovedeket%n", this.getClass().getSimpleName(),type);
	}


	@Override
	public void update() {
//		if (isMoving){
//			if(moveCount == 7){
//				
//				moveCount = 0;
//				xOff = 0;
//				yOff = 0;
//				isMoving = false;
//				System.out.println("isMoving == false");
//			}else{
//				moveCount ++;
//				switch(direction){
//				case 0:
//					yOff = yOff - 4; 
//					break;
//				case 1: 
//					xOff = xOff + 4;
//					break;
//				case 2:
//					yOff = yOff + 4;
//					break;
//				case 3: 
//					xOff = xOff - 4;
//					break;
//				default: break;
//				}
//			}
//				
//		}
		
		if(projectilePrimary != null){
			projectilePrimary.update();
		}
		if(projectileSecondary != null){
			projectileSecondary.update();
		}
	}

}
