package TileMap;

public class JsonTileLayerObject {
	
	private String name;
	private int height;
	private int width;
	private int[] tiles;
	private String type;
	
	
	
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int[] getTiles() {return tiles;}
	public void setTiles(int[] tiles) {this.tiles = tiles;}

}
