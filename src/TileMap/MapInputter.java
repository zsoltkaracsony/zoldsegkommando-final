package TileMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MapInputter {
	
	String filePath;
	String jsonPath;
	BufferedReader br;
	String line;
	String[] lineSplit;
	Map<Integer, Integer> tileTypes;
	
	int mapHeight = 0;
	int[][] map;
	
	JsonTileLayerObject tileLayer = null;
	ArrayList<JsonTileLayerObject> tileLayers  = new ArrayList<JsonTileLayerObject>();
	JsonObjectLayerObject jsonObject = null;
	ArrayList<JsonObjectLayerObject> objectsList = new ArrayList<JsonObjectLayerObject>();
	
	public ArrayList<JsonTileLayerObject> getTileLayers() 						{return tileLayers;}
	public void setTileLayers(ArrayList<JsonTileLayerObject> tileLayers) 		{this.tileLayers = tileLayers;}
	public ArrayList<JsonObjectLayerObject> getObjectsList() 					{return objectsList;}
	public void setObjectsList(ArrayList<JsonObjectLayerObject> objectsList) 	{this.objectsList = objectsList;}

	
	public void readMapTilePairs() throws IOException{
		
		br = new BufferedReader(new FileReader(filePath));
		line = br.readLine();
		
		while(line != null){
		
			lineSplit = line.split(";");
			
			tileTypes = new HashMap<Integer,Integer>();
			tileTypes.put(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]));
			
			line = br.readLine();
			
		}
		
	}
	
	public void readJsonMap(String jsonPath) throws IOException{
		boolean layers = false;
		boolean objects = false;
		boolean op = false;
		
		
		
		
		br = new BufferedReader(new FileReader(jsonPath));
		line = br.readLine();
		
		
		
		while (line != null){
			if(line.contains("layers")){
				layers = true;
				tileLayer = new JsonTileLayerObject();
			}
			if(line.contains("\"name\":\"Objects\"") && layers){
				layers = false;
				objects = true;
				line = br.readLine();
			}
			if(line.contains("data") && layers){
				tileLayer.setTiles(readTileData(line));
			}
			if(line.contains("width") && layers){
				tileLayer.setWidth(readHeightWeight(line));
			}
			if(line.contains("height") && layers){
				tileLayer.setHeight(readHeightWeight(line));
			}
			if(line.contains("},") && layers){
				tileLayers.add(tileLayer);
				tileLayer = new JsonTileLayerObject();
			}
			if(line.contains("name") && layers){
				tileLayer.setName(line.split(":")[1].replaceAll("\"", "").replaceAll(":", "").replaceAll(",", ""));
			}
			if(line.contains("type") && layers){
				tileLayer.setType(line.split(":")[1].replaceAll("\"", "").replaceAll(":", "").replaceAll(",", ""));
			}
			if(line.contains("name") && objects){
				jsonObject.setName(line.split(":")[1].replaceAll("\"", "").replaceAll(":", "").replaceAll(",", ""));
			}
			if(line.contains("\"X\"") && objects && op){
					jsonObject.setCoordX(Integer.parseInt(line.split(":")[1].replaceAll("[\\D]", "")));
			}
			if(line.contains("\"Y\"") && objects && op){
					jsonObject.setCoordY(Integer.parseInt(line.split(":")[1].replaceAll("[\\D]", "")));
			}
			if(line.contains("DoorX") && objects && op){
					jsonObject.setDoorX(Integer.parseInt(line.split(":")[1].replaceAll("[\\D]", "")));
			}
			if(line.contains("DoorY") && objects && op){
					jsonObject.setDoorY(Integer.parseInt(line.split(":")[1].replaceAll("[\\D]", "")));
			}
			if(line.contains("\"type\":") && objects){
				jsonObject.setType(line.split(":")[1].replaceAll("\"", "").replaceAll(":", "").replaceAll(",", ""));
			}
			if(line.contains("\"gid\":") && objects){
				if(jsonObject != null){
					objectsList.add(jsonObject);
				}
				jsonObject = new JsonObjectLayerObject();
				op = true;
			}
			
			if(line.contains("\"propertytypes\":") && objects){
				op = false;
			}
			if(line.contains("\"tilesets\":") && objects){
				objectsList.add(jsonObject);
				break;
			}
			
			line = br.readLine();
		}
	}
	
	public int[] readTileData(String line){
		
		String[] stringArray;
		stringArray = line.split(",");
		int[] intArray = new int[stringArray.length];
		for(int i = 0; i< stringArray.length; i++){
			intArray[i] = Integer.parseInt(stringArray[i].replaceAll("[^0-9]", ""));
		}
		return intArray;
	}
	
	public int readHeightWeight(String line){
		return Integer.parseInt(line.replaceAll("[^0-9]", ""));
	}
}


