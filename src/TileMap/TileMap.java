package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import Entities.Jaffa;
import Entities.ONeill;
import Entities.Replicator;
import GameStates.GameState;
import GameStates.GameStateManager;
import Objects.Box;
import Objects.Door;
import Objects.Scale;
import Objects.ZPM;
import Stargate.Stargate;
import Stargate.Wormhole;
import Tiles.Floor;
import Tiles.Gap;
import Tiles.Tile;
import Tiles.Wall;

public class TileMap {
	
	private GameState gameState;

	
	
	public HashMap<Integer, BufferedImage> textureMap;
	private Tile[][] tiles;
	private int mapX;
	private int mapY;
	private Wormhole wormhole;

	private int numOfZPMs = 0;
	
	private ONeill oneill;
	private Jaffa jaffa;
	
	
	
	private Replicator replicator;
	
	public void setTiles(Tile[][] t){
		this.tiles = t;
	}
	public Tile[][] getTiles(){
		return tiles;
	}

	
	public TileMap(GameState gs){
		wormhole = new Wormhole();
		this.gameState = gs;
		textureMap = new HashMap<Integer, BufferedImage>();
		System.out.println("Sikeres Generalas");
		
	}
	public BufferedImage getTextureMap(int textureID) {
		return textureMap.get(textureID);
	}

	public void loadTextureMap(String filePath) {
	}

	public void loadMap(String filePath) {
		MapInputter mip = new MapInputter();
		try {
			mip.readJsonMap(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapX = mip.getTileLayers().get(0).getWidth();
		mapY = mip.getTileLayers().get(0).getHeight();
		for(int i = 0; i<mip.getTileLayers().get(0).getTiles().length;i++){
			System.out.format("[%s] ",mip.getTileLayers().get(0).getTiles()[i]);
		}
		numOfZPMs = 0;
		int k = 0;
		tiles = new Tile[mip.getTileLayers().get(0).getWidth()][mip.getTileLayers().get(0).getHeight()];
		for(int j = 0; j<mip.getTileLayers().get(0).getWidth();j++){
			for(int i = 0; i<mip.getTileLayers().get(0).getHeight();i++){
				
				switch(mip.getTileLayers().get(0).getTiles()[k]){
				case 1:
					tiles[i][j] = new Wall(false,i,j,textureMap);
					break;
				case 2:
					tiles[i][j] = new Wall(true,i,j,textureMap);
					break;
				case 3:
					tiles[i][j] = new Floor(i,j,textureMap);
					break;
				case 4:
					tiles[i][j] = new Gap(i,j,textureMap);
					break;
				default: break;
				}
				k++;
			}
		}
		k = 0;
		for(int j = 0; j<mip.getTileLayers().get(1).getWidth();j++){
			for(int i = 0; i<mip.getTileLayers().get(1).getHeight();i++){
				
				switch(mip.getTileLayers().get(1).getTiles()[k]){
				case 5:
					tiles[i][j].setDoor(new Door());
					break;
				case 6:
					tiles[i][j].setDoor(new Door());
					break;
				case 7:
					tiles[i][j].setScale(new Scale(2));
					break;
				case 8:
					tiles[i][j].setScale(new Scale(2));
					break;
				case 9:
					tiles[i][j].addObject(new Box());
					break;
				case 10:
					tiles[i][j].addObject(new ZPM());
					numOfZPMs++;
					break;
				case 13:
					oneill = new ONeill(this,tiles[i][j],1);
					break;
				case 14:
					jaffa = new Jaffa(this,tiles[i][j],1);
					break;
				case 15:
					replicator = new Replicator(this, tiles[i][j], 1);
					break;
				}
				k++;
			}
		}
		
		for(JsonObjectLayerObject i : mip.getObjectsList()){
			tiles[i.getCoordX()][i.getCoordY()].getScale().setDoor(tiles[i.getDoorX()][i.getDoorY()].getDoor());
		}
		
	}
	
	public void checkZPM(){
		if (numOfZPMs == 0){
			gameState.getGsm().setState(GameStateManager.MENUSTATE);
		}
	}
	
	public void lowerZPM(){
		numOfZPMs--;
		checkZPM();
	}
	
	public void spawnZPM(){
		int floorNumber = 0;
		int winnerFloor;
		for(int i = 0; i < mapX; i++){
			for(int j = 0; j < mapY; j++){
				if(tiles[i][j].getClass().getSimpleName().equals("Floor")){
					floorNumber++;
				}
			}
		}
		Random r = new Random();
		System.out.println(floorNumber);
		winnerFloor = r.nextInt(floorNumber);
		floorNumber = 0;
		for(int i = 0; i < mapX; i++){
			for(int j = 0; j < mapY; j++){
				if(tiles[i][j].getClass().getSimpleName().equals("Floor")){
					floorNumber++;
					if (floorNumber == winnerFloor){
						tiles[i][j].mapObjects.add(new ZPM());
						break;
					}
				}
			}
		}		
		numOfZPMs++;
		
	}
	
	public Tile 		getTile(int x, int y) {return tiles[x][y];}
	public void 		setTile(int x, int y, Tile t){this.tiles[x][y] = t;}
	public Replicator 	getReplicator() {return replicator;}
	public void 		setReplicator(Replicator replicator) {this.replicator = replicator;}
	public Wormhole 	getWormhole() {return wormhole;}
	public ONeill getOneil() {return oneill;}
	public void setOneil(ONeill oneil) {this.oneill = oneil;}
	public Jaffa getJaffa() {return jaffa;}
	public void setJaffa(Jaffa jaffa) {this.jaffa = jaffa;}	
	public GameState getGameState() {return gameState;}
	public void setGameState(GameState gameState) {this.gameState = gameState;}

	public void draw(Graphics2D g){
		
		g.drawImage(textureMap.get(9),0,0,null);
		
		for (int i = 0; i<tiles[0].length; i++){
			for (int j = 0; j<tiles.length; j++){
				tiles[j][i].draw(g);
			}
		}
		wormhole.draw(g);
	}
	
	//Teszteléshez
	
	public void generateTestMap(){
		tiles = new Tile[5][5];
		tiles[0][0] = new Wall(false,0,0,textureMap);
		tiles[1][0] = new Wall(false,1,0,textureMap);
		tiles[2][0] = new Wall(false,2,0,textureMap);
		tiles[3][0] = new Wall(true,3,0,textureMap);
		tiles[4][0] = new Wall(false,4,0,textureMap);
		tiles[0][4] = new Wall(false,0,4,textureMap);
		tiles[1][4] = new Wall(true,1,4,textureMap);
		tiles[2][4] = new Wall(true,2,4,textureMap);
		tiles[3][4] = new Wall(true,3,4,textureMap);
		tiles[4][4] = new Wall(false,4,4,textureMap);
		tiles[0][1] = new Wall(false,0,1,textureMap);
		tiles[0][2] = new Wall(false,0,2,textureMap);
		tiles[0][3] = new Wall(false,0,3,textureMap);
		tiles[4][1] = new Wall(false,4,1,textureMap);
		tiles[4][2] = new Wall(false,4,2,textureMap);
		tiles[4][3] = new Wall(false,4,3,textureMap);
		
		tiles[1][1] = new Floor(1,1,textureMap);
		tiles[1][2] = new Floor(1,2,textureMap);
		tiles[1][3] = new Floor(1,3,textureMap);
		tiles[2][1] = new Floor(2,1,textureMap);
		tiles[2][2] = new Gap(2,2,textureMap);
		tiles[2][3] = new Floor(2,3,textureMap);
		tiles[3][1] = new Floor(3,1,textureMap);
		tiles[3][2] = new Floor(3,2,textureMap);
		tiles[3][3] = new Floor(3,3,textureMap);
		
		numOfZPMs = 1;
		
		tiles[3][2].addObject(new ZPM());
		tiles[3][3].addObject(new Box());
		tiles[1][3].addObject(new Box());
		tiles[3][1].setDoor(new Door());
		tiles[2][1].setScale(new Scale(2));
		tiles[2][1].getScale().setDoor(tiles[3][1].getDoor());
		
		getWormhole().setStargate("blue", new Stargate(getTile(3, 0),2,"blue",textureMap));
		getWormhole().setStargate("orange", new Stargate(getTile(3, 4),0,"orange",textureMap));
		
		oneill = new ONeill(this,tiles[2][3],1);
		jaffa = new Jaffa(this,tiles[1][1],3);
//		replicator = new Replicator(this,tiles[1][2],1);
	}
	
	public void generateTestTextureMap(){
		
		String[] testPics = {
		/*0*/	"/resources/floor01.png", 
		/*1*/	"/resources/specialWallproba03.png", 
		/*2*/	"/resources/wall01.png",
		/*3*/	"/resources/oneill4dir.png", 
		/*4*/	"/resources/jaffa4dir.png",
		/*5*/	"/resources/sg_blue4dir.png",
		/*6*/	"/resources/sg_yellow4dir.png",
		/*7*/	"/resources/sg_red4dir.png",
		/*8*/	"/resources/sg_green4dir.png",
		/*9*/	"/resources/background.png",
		/*10*/	"/resources/replikator4dir.png",
		/*11*/	"/resources/blue.png",
		/*12*/	"/resources/box01.png",
		/*13*/	"/resources/ajto_nyitva01.png",
		/*14*/	"/resources/ajto_csukva01.png",
		/*15*/	"/resources/zpm01.png",
		/*16*/	"/resources/scale_up5.png",
		/*17*/	"/resources/scale_down3.png",
		/*18*/	"/resources/szakadek02.png",
		/*19*/	"/resources/yellow.png",
		/*20*/	"/resources/red.png",
		/*21*/	"/resources/green.png"};
		
		BufferedImage in = null;
		
		for (int i = 0; i< testPics.length; i++){
			try {
				in = ImageIO.read(getClass().getResource(testPics[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textureMap.put(i, in);
		}
		
	}
	 public void testInit(){
		 generateTestTextureMap();
		 generateTestMap();
		 
	 }

	

}