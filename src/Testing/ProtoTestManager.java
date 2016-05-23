	package Testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import Entities.Jaffa;
import Entities.ONeill;
import Entities.Replicator;
import Objects.Box;
import Objects.Door;
import Objects.MapObject;
import Objects.Scale;
import Objects.ZPM;
import Stargate.Stargate;
import TileMap.TileMap;
import Tiles.Floor;
import Tiles.Gap;
import Tiles.Tile;
import Tiles.Wall;


//public class ProtoTestManager {
//	public static Boolean random;
//	public static Boolean testing = false;
//	public String inPath;
//	public static String outPath;
//	private static String method;
//	
//	public ProtoTestManager(String[] args) {
//		
//		testing = true;
//		switch (args[1].toLowerCase()) {
//		case "true":
//			random = true;
//			break;
//		case "false":
//			random = false;
//			break;
//		default:
//			throw new IllegalArgumentException("Helytelen teszt parameter!");
//		}
//		
//		if (args.length == 3) {
//			this.inPath = args[2];
//			String scriptNo = inPath.replaceAll("\\D+","");
//			outPath = "ProtoTestOut/" + scriptNo + "-out.txt";
//			method = "script";
//		} else method = "manual";
//	}
//
//	public void startTest() {
//		switch (method) {
//		case "manual":
//			this.manualTest();
//			break;
//		case "script":
//			this.scriptTest();
//			break;
//		default:
//			throw new IllegalArgumentException("Helytelen teszt inditasi mod!");
//		}
//	}
//	
//	private void manualTest(){
//	String line = null;
//	TestBed tb = new TestBed();
//		do {
//			Scanner in = new Scanner(System.in);
//			line = in.nextLine();
//			this.ProcessCommand(line,tb);
//		}
//		while(!line.equals("exit"));
//	}
//	
//	private void scriptTest(){
//		TestBed tb = new TestBed();
//		
//		PrintStream out = null;
//		try {
//			out = new PrintStream(new FileOutputStream(ProtoTestManager.outPath));
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		System.setOut(out);
//		
//		// Bemeneti script olvasása
//		BufferedReader in;
//		try {
//			in = new BufferedReader(new FileReader(inPath));
//	
//			String line = null;
//		
//			while ((line = in.readLine()) != null) {
//				this.ProcessCommand(line,tb);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void ProcessCommand(String line, TestBed tb) {
//		String[] c = line.split("\\s+");
//		try{
//			switch (c[0]) {
//			case "Generate" : 		this.Generate(c[1], c[2],tb); break;
//			case "AddFloorTile" : 	this.AddFloorTile(c[1], c[2],tb); break;
//			case "AddWallTile" : 	this.AddWallTile(c[1], c[2], c[3],tb); break;
//			case "AddGapTile" : 	this.AddGapTile(c[1], c[2],tb); break;
//			case "AddJaffa" : 		this.AddJaffa(c[1], c[2], c[3],tb); break;
//			case "AddONeill" : 		this.AddONeill(c[1], c[2], c[3],tb); break;
//			case "AddReplicator" : 	this.AddReplicator(c[1], c[2], c[3],tb); break;
//			case "AddScaleDoor" : 	this.AddScaleDoor(c[1], c[2], c[3], c[4],tb); break;
//			case "AddZPM" : 		this.AddZPM(c[1], c[2],tb); break;
//			case "AddBox" : 		this.AddBox(c[1], c[2],tb); break;
//			case "Move" : 			this.Move(c[1], c[2],tb); break;
//			case "PickBox" : 		this.PickBox(c[1],tb); break;
//			case "DropBox" : 		this.DropBox(c[1],tb); break;
//			case "Shoot" : 			this.Shoot(c[1], c[2],tb); break;
//			case "MoveProjectile" : this.MoveProjectile (c[1],tb); break;
//			case "AddGate" : 		this.AddGate(c[1], c[2], c[3], c[4],tb); break;
//			case "PrintMap" : 		this.PrintMap(tb); break;
//			case "ListEntities" : 	this.ListEntities(tb); break;
//			case "ListWormHoles" : 	this.ListWormHoles(tb); break;
//			case "ListDoorScaleState" : this.ListDoorScaleState(tb); break;
//			case "ListBoxes" : 		this.ListBoxes(tb); break;
//			case "ListZPM" : 		this.ListZPM(tb); break;
//			case "exit" :			System.out.println("Kilepes"); break;
//			default: 				System.out.println("Helytelen parancs!");
//			}
//		} 
//		catch(Exception e){
//			System.out.println(e);
//		}
//		
//	}
//
//	private void Generate(String sx, String sy, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
////		tb.tm = new TileMap();
//		tb.tm.setTiles(new Tile[x][y]);
//	}
//
//	private void AddFloorTile(String sx, String sy, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		tb.tm.setTile(x, y, new Floor(x,y));
//	}
//
//	private void AddWallTile(String sx, String sy, String sIsSpecial, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		Boolean isSpecial = Boolean.parseBoolean(sIsSpecial);
//		tb.tm.setTile(x, y, new Wall(isSpecial,x,y));
//	}
//
//	private void AddGapTile(String sx, String sy, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		tb.tm.setTile(x, y, new Gap(x,y));
//	}
//
//	private void AddJaffa(String sx, String sy, String sd, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		int d = Integer.parseInt(sd);
//		
//		tb.j = new Jaffa(tb.tm, tb.tm.getTile(x, y), d);
//	}
//
//	private void AddONeill(String sx, String sy, String sd, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		int d = Integer.parseInt(sd);	
//		
//		tb.o = new ONeill(tb.tm, tb.tm.getTile(x, y), d);
//	}
//
//	private void AddReplicator(String sx, String sy, String sd, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		int d = Integer.parseInt(sd);
//		
//		tb.r = new Replicator(tb.tm, tb.tm.getTile(x, y), d);
//	}
//
//	private void AddScaleDoor(String sx1, String sy1, String sx2, String sy2, TestBed tb) {
//		int x1 = Integer.parseInt(sx1);
//		int y1 = Integer.parseInt(sy1);
//		int x2 = Integer.parseInt(sx2);
//		int y2 = Integer.parseInt(sy2);
//		tb.tm.getTile(x1, y2).setScale(new Scale(2));
//		tb.tm.getTile(x2, y2).setDoor(new Door());
//		tb.tm.getTile(x1, y1).getScale().setDoor(tb.tm.getTile(x2, y2).getDoor());
//	}
//
//	private void AddZPM(String sx, String sy, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		
//		tb.tm.getTile(x, y).addObject(new ZPM());
//	}
//
//	private void AddBox(String sx, String sy, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		
//		tb.tm.getTile(x, y).addObject(new Box());
//	}
//
//	private void Move(String entity, String sd, TestBed tb) {
//		int d = Integer.parseInt(sd);
//		
//		switch (entity.toLowerCase()) {
//		case "oneill" : 
//			tb.o.move(d);
//			break;
//		case "jaffa" : 
//			tb.j.move(d);
//			break;
//		case "replicator" : 
//			tb.r.move(d);
//			break;
//		default : 
//			System.out.println("Helytelen entitas!");
//		}
//	}
//
//	private void PickBox(String entity, TestBed tb) {
//		switch (entity.toLowerCase()) {
//		case "oneill" : 
//			tb.o.pickUpBox();
//			break;
//		case "jaffa" : 
//			tb.j.pickUpBox();
//			break;
//		default : 
//			System.out.println("Helytelen entitas!");
//		}	
//	}
//
//	private void DropBox(String entity, TestBed tb) {
//		switch (entity.toLowerCase()) {
//		case "oneill" : 
//			tb.o.putDownBox();
//			break;
//		case "jaffa" : 
//			tb.j.putDownBox();
//			break;
//		default : 
//			System.out.println("Helytelen entitas!");
//		}		
//	}
//
//	private void Shoot(String type, String entity, TestBed tb) {
//		switch (entity.toLowerCase()) {
//		case "oneill" : 
//			switch (type.toLowerCase()) {
//			case "primary" :
//				tb.o.shootProjectile("primary");
//				break;
//			case "secondary" :
//				tb.o.shootProjectile("secondary");
//				break;
//			default : 
//				System.out.println("Helytelen lovedektipus!");
//			}
//			break;
//		case "jaffa" : 
//			switch (type.toLowerCase()) {
//			case "primary" :
//				tb.j.shootProjectile("primary");
//				break;
//			case "secondary" :
//				tb.j.shootProjectile("secondary");
//				break;
//			default : 
//				System.out.println("Helytelen lovedektipus!");
//			}
//			break;
//		default : 
//			System.out.println("Helytelen entitas!");
//		}	
//	}
//
//	private void MoveProjectile(String entity, TestBed tb) {
//		switch (entity.toLowerCase()) {
//		case "oneill" : 
//			if (tb.o.projectilePrimary != null){
//				tb.o.projectilePrimary.move(tb.o.projectilePrimary.direction);
//			}
//			if (tb.o.projectileSecondary != null){
//				tb.o.projectileSecondary.move(tb.o.projectileSecondary.direction);
//			}
//			break;
//		case "jaffa" : 
//			if (tb.j.projectilePrimary != null){
//				tb.j.projectilePrimary.move(tb.o.projectilePrimary.direction);
//			}
//			if (tb.j.projectileSecondary != null){
//				tb.o.projectileSecondary.move(tb.o.projectileSecondary.direction);
//			}
//			break;
//		default : 
//			System.out.println("Helytelen entitas!");
//		}	
//	}
//	
//	private void AddGate(String color, String sx, String sy, String sd, TestBed tb) {
//		int x = Integer.parseInt(sx);
//		int y = Integer.parseInt(sy);
//		int d = Integer.parseInt(sd);
//		tb.tm.getWormhole().setStargate(color, new Stargate(tb.tm.getTile(x, y), d, color));
//	}
//
//	private void PrintMap(TestBed tb) {
//		// TODO hivasok
//		for (int j=0; j<tb.tm.getTiles()[0].length; j++){
//			for (int i=0; i<tb.tm.getTiles().length; i++){
//				System.out.format("|");
//				switch(tb.tm.getTile(i,j).getClass().getSimpleName()){
//				case "Floor":
//					if(tb.tm.getTile(i,j).hasObject("ZPM")){
//						System.out.format("Z");
//					}else if(tb.tm.getTile(i,j).hasObject("Box")){
//						System.out.format("B");
//					}else if((tb.o != null) && (tb.o.getActualTile().getX() == i) && (tb.o.getActualTile().getY() == j)){
//						System.out.format("O");
//					}else if((tb.o != null) && (tb.j.getActualTile().getX() == i) && (tb.j.getActualTile().getY() == j)){
//						System.out.format("J");
//					}else if((tb.o != null) && (tb.r.getActualTile().getX() == i) && (tb.r.getActualTile().getY() == j)){
//						System.out.format("R");
//					}else {
//						System.out.format("F");
//					}
//					break;
//				case "Gap":
//					System.out.format("G");
//					break;
//				case "Wall":
//					Wall w;
//					w = (Wall) tb.tm.getTile(i,j);
//					if(w.getIsSpecial()){
//						System.out.format("S");
//					}else{
//						System.out.format("W");
//					}
//					break;
//				}
//			}
//			System.out.format("|%n");
//		}
//		
//	}
//
//	private void ListEntities(TestBed tb) {
//		// TODO hivasok
//		if(tb.o != null){
//			System.out.format("ONeill X: %d Y: %d%n",tb.o.getActualTile().getX(), tb.o.getActualTile().getY());
//		}
//		if(tb.j != null){
//			System.out.format("Jaffa X: %d Y: %d%n",tb.j.getActualTile().getX(), tb.j.getActualTile().getY());
//		}
//		if(tb.r != null){
//			System.out.format("Replicator X: %d Y: %d%n",tb.r.getActualTile().getX(), tb.r.getActualTile().getY());
//		}
//	}
//
//	private void ListWormHoles(TestBed tb) {
//		if(tb.tm.getWormhole().getStargate("blue") != null){
//			System.out.format("Blue csillagkapu X: %d Y: %d%n", tb.tm.getWormhole().getStargate("blue").getTile().getX(), tb.tm.getWormhole().getStargate("blue").getTile().getY());
//		}
//		if(tb.tm.getWormhole().getStargate("orange") != null){
//			System.out.format("Orange csillagkapu X: %d Y: %d%n", tb.tm.getWormhole().getStargate("orange").getTile().getX(), tb.tm.getWormhole().getStargate("orange").getTile().getY());
//		}
//		if(tb.tm.getWormhole().getStargate("red") != null){
//			System.out.format("Red csillagkapu X: %d Y: %d%n", tb.tm.getWormhole().getStargate("red").getTile().getX(), tb.tm.getWormhole().getStargate("red").getTile().getY());
//		}
//		if(tb.tm.getWormhole().getStargate("green") != null){
//			System.out.format("Green csillagkapu X: %d Y: %d%n", tb.tm.getWormhole().getStargate("green").getTile().getX(), tb.tm.getWormhole().getStargate("green").getTile().getY());
//		}
//	}
//
//	private void ListDoorScaleState(TestBed tb) {
//		// TODO hivasok
//		System.out.println("not yet implemented%n");
//	}
//
//	private void ListBoxes(TestBed tb) {
//		// TODO hivasok
//		for (int i=0; i<tb.tm.getTiles().length; i++){
//			for (int j=0; j<tb.tm.getTiles()[0].length; j++){
//				for (MapObject mo : tb.tm.getTile(i, j).mapObjects){
//					if(mo.getClass().getSimpleName().equals("Box")){
//						System.out.format("Box: X: %d Y: %d%n",tb.tm.getTile(i, j).getX(),tb.tm.getTile(i, j).getY());
//					}
//				}
//			}
//		}
//	}
//
//	private void ListZPM(TestBed tb) {
//		for (int i=0; i<tb.tm.getTiles().length; i++){
//			for (int j=0; j<tb.tm.getTiles()[0].length; j++){
//				for (MapObject mo : tb.tm.getTile(i, j).mapObjects){
//					if(mo.getClass().getSimpleName().equals("ZPM")){
//						System.out.format("ZPM: X: %d Y: %d%n",tb.tm.getTile(i, j).getX(),tb.tm.getTile(i, j).getY());
//					}
//				}
//			}
//		}
//	}
//	
//}
