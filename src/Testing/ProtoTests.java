//package Testing;
//
//import Entities.Jaffa;
//import Entities.ONeill;
//import Entities.Replicator;
//import Objects.Box;
//import Objects.Door;
//import Objects.Scale;
//import Objects.ZPM;
//import Stargate.Stargate;
//import TileMap.TileMap;
//import Tiles.Floor;
//import Tiles.Gap;
//import Tiles.Tile;
//import Tiles.Wall;
//
//public class ProtoTests {
//	
//	public void test1(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[2][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test2(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[2][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Gap(1,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test3(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[2][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Wall(false,1,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test4(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.getTile(1, 0).setScale(new Scale(2));
//		tm.getTile(2, 0).setDoor(new Door());
//		tm.getTile(1, 0).getScale().setDoor(tm.getTile(2, 0).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test5(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.getTile(2, 0).setScale(new Scale(2));
//		tm.getTile(1, 0).setDoor(new Door());
//		tm.getTile(2, 0).getScale().setDoor(tm.getTile(2, 0).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test6(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		tm.setTile(4, 0, new Floor(4,0));
//		tm.getTile(3, 0).setScale(new Scale(2));
//		tm.getTile(1, 0).setDoor(new Door());
//		tm.getTile(3, 0).getScale().setDoor(tm.getTile(1, 0).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		Jaffa j = new Jaffa(tm,tm.getTile(4, 0),3);
//		j.move(3);
//		o.move(1);
//		o.move(1);
//	}
//	
//	public void test7(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.getTile(1, 0).mapObjects.add(new Box());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//	
//	public void test8(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.getTile(1, 0).mapObjects.add(new ZPM());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//	}
//
//	public void test9(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Wall(true,1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.getWormhole().setStargate("blue", new Stargate(tm.getTile(1, 0),3,"blue"));
//		tm.getWormhole().setStargate("orange", new Stargate(tm.getTile(1, 0),1,"orange"));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.move(1);
//		System.out.format("%d %d %s", o.getActualTile().getX(),o.getActualTile().getY(),o.getActualTile().getClass().getSimpleName());
//	}
//	
//	public void test10(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.getTile(1, 0).mapObjects.add(new Box());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.pickUpBox();
//	}
//	
//	public void test11(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.setBox(new Box());
//		o.putDownBox();
//	}
//	
//	public void test12(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][2]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(0, 1, new Floor(0,1));
//		tm.setTile(1, 1, new Floor(1,1));
//		tm.setTile(2, 1, new Floor(2,1));
//		tm.getTile(1, 1).addObject(new Box());
//		tm.getTile(2, 0).addObject(new Box());
//		tm.getTile(0, 0).setScale(new Scale(2));
//		tm.getTile(0, 1).setDoor(new Door());
//		tm.getTile(0, 0).getScale().setDoor(tm.getTile(0, 1).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.pickUpBox();
//		o.move(3);
//		o.putDownBox();
//		o.move(2);
//		o.pickUpBox();
//		o.move(3);
//		o.putDownBox();
//	}
//	
//	public void test13(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Gap(2,0));
//		tm.getTile(0, 0).addObject(new Box());
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),3);
//		o.pickUpBox();
//		o.move(1);
//		o.putDownBox();
//	}
//	
//	public void test14(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Wall(false,2,0));
//		tm.getTile(0, 0).addObject(new Box());
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),3);
//		o.pickUpBox();
//		o.move(1);
//		o.putDownBox();
//	}
//	
//	public void test15(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[5][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		tm.setTile(4, 0, new Floor(4,0));
//		tm.getTile(3, 0).setScale(new Scale(2));
//		tm.getTile(2, 0).setDoor(new Door());
//		tm.getTile(3, 0).getScale().setDoor(tm.getTile(2, 0).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),3);
//		Jaffa j = new Jaffa(tm,tm.getTile(4, 0),3);
//		o.pickUpBox();
//		o.move(1);
//		o.putDownBox();
//		j.move(3);
//		o.putDownBox();
//	}
//	
//	public void test16(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[2][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.putDownBox();
//	}
//	
//	public void test17(){
//		
//	}
//	
//	
//	public void test18(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[2][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.shootProjectile("primary");
//	}
//	
//	public void test19(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Gap(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test20(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Wall(false,2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test21(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.getTile(2, 0).addObject(new Box());
//		ONeill o = new ONeill(tm,tm.getTile(1, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test22(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Wall(true,2,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test23(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[3][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		Replicator r = new Replicator(tm,tm.getTile(2, 0), 3);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test24(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		tm.getTile(3, 0).setScale(new Scale(2));
//		tm.getTile(2, 0).setDoor(new Door());
//		tm.getTile(3, 0).getScale().setDoor(tm.getTile(2, 0).getDoor());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test25(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		tm.getTile(3, 0).setScale(new Scale(2));
//		tm.getTile(2, 0).setDoor(new Door());
//		tm.getTile(3, 0).getScale().setDoor(tm.getTile(2, 0).getDoor());
//		tm.getTile(2, 0).getDoor().setOpen(true);
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test26(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Floor(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		tm.getTile(2, 0).addObject(new ZPM());
//		ONeill o = new ONeill(tm,tm.getTile(0, 0),1);
//		o.shootProjectile("primary");
//		o.projectilePrimary.move(1);
//		o.projectilePrimary.move(1);
//	}
//	
//	public void test27(){
//		TileMap tm = new TileMap();
//		tm.setTiles(new Tile[4][1]);
//		tm.setTile(0, 0, new Floor(0,0));
//		tm.setTile(1, 0, new Gap(1,0));
//		tm.setTile(2, 0, new Floor(2,0));
//		tm.setTile(3, 0, new Floor(3,0));
//		Replicator r = new Replicator(tm,tm.getTile(0, 0), 1);
//		r.move(1);
//	}
//}
