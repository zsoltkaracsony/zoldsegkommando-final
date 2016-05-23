package Testing;
//spackage Stargate;
//
//public class Tests {
//	
//	//Menü - új játék
//	public void test1(){
//		System.out.println("Menü - új játék");
//		GameStateManager gsm = new GameStateManager();
//		System.out.println("Teszt kezdete:");
//		gsm.setState(1);
//	}
//	//Menü – kilépés
//	public void test2(){
//		System.out.println("Menü – kilépés");
//		System.out.println(">System.exit");
//		System.out.println("<System.exit");
//	}
//	
//	//padlóra lépés
//	public void test3(){
//		System.out.println("padlóra lépés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//szakadékba lépés
//	public void test4(){
//		System.out.println("szakadékba lépés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Gap(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//falba lépés
//	public void test5(){
//		System.out.println("falba lépés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(false,0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//mérlegre lépés ajtónyitással
//	public void test6(){
//		System.out.println("mérlegre lépés ajtónyitással");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][3];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][2] = new Floor(0,2);
//		map.tiles[0][1].scale = new Scale();
//		map.tiles[0][2].door = new Door();
//		map.tiles[0][2].door.setOpen(true);
//		map.tiles[0][1].scale.setDoor(map.tiles[0][2].door);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//Zárt ajtónak nekimegy
//	public void test7(){
//		System.out.println("Zárt ajtónak nekimegy");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][3];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].door = new Door();
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//Nyitott ajtóba lép
//	public void test8(){
//		System.out.println("Nyitott ajtóba lép");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][3];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].door = new Door();
//		map.tiles[0][1].door.setOpen(true);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//Dobozra lépés
//	public void test9(){
//		System.out.println("Dobozra lépés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new Box());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//ZPM felvétel
//	public void test10(){
//		System.out.println("ZPM felvétel");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new ZPM());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//Teleportál
//	public void test11(){
//		System.out.println("Teleportál");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][4];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(true,0,1);
//		map.tiles[0][2] = new Wall(true,0,2);
//		map.tiles[0][3] = new Floor(0,3);
//		Stargate sgb = new Stargate(map.tiles[0][1],3,"blue");
//		Stargate sgo = new Stargate(map.tiles[0][2],1,"orange");
//		map.getWormhole().setStargate("blue",sgb);
//		map.getWormhole().setStargate("orange", sgo);
//
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//Doboz felvétel
//	public void test12(){
//		System.out.println("Doboz felvétel");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new Box());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		oneill.pickBox(map.tiles[0][1]);
//	}
//	
//	//Doboz lerakása csempére
//	public void test13(){
//		System.out.println("Doboz lerakása csempére");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	//Doboz lerakása falba
//	public void test14(){
//		System.out.println("Doboz lerakása falra");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(false,0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Doboz lerakása ajtóba
//	public void test15(){
//		System.out.println("Doboz lerakása ajtóba");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].door = new Door();
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Doboz lerakása szakadékba
//	public void test16(){
//		System.out.println("Doboz lerakása szakadékba");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Gap(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Doboz lerakása dobozra
//	public void test17(){
//		System.out.println("Doboz lerakása dobozra");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new Box());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Doboz lerakása mérlegre
//	public void test18(){
//		System.out.println("Doboz lerakása mérlegre");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][3];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][2] = new Floor(0,2);
//		map.tiles[0][1].scale = new Scale();
//		map.tiles[0][2].door = new Door();
//		map.tiles[0][1].scale.setDoor(map.tiles[0][2].door);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Doboz lerakása ZPM-re
//	public void test19(){
//		System.out.println("Doboz lerakása ZPM-re");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new ZPM());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	
//	//Lövedék doboznak ütközés
//	public void test20(){
//		System.out.println("Lövedék doboznak ütközés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new Box());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék ZPM-nek ütközés
//	public void test21(){
//		System.out.println("Lövedék ZPM-nek ütközés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].mapObjects.add(new ZPM());
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék sima falnak ütközés
//	public void test22(){
//		System.out.println("Lövedék sima falnak ütközés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(false,0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék speciális falnak ütközés
//	public void test23(){
//		System.out.println("Lövedék speciális falnak ütközés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(true,0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék szakadék felett haladás
//	public void test24(){
//		System.out.println("Lövedék szakadék felett haladás");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Gap(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék nyitott ajtónak áthaladás
//	public void test25(){
//		System.out.println("Lövedék nyitott ajtón áthaladás");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].door = new Door();
//		map.tiles[0][1].door.setOpen(true);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék csukott ajtónak ütközés
//	public void test26(){
//		System.out.println("Lövedék csukott ajtónak ütközés");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		map.tiles[0][1].door = new Door();
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//	
//	//Lövedék padló felett repül
//	public void test27(){
//		System.out.println("Lövedék padló felett haladás");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		Projectile proj = new Projectile("blue",oneill);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(proj, 3);
//	}
//}
