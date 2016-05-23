package Testing;
//spackage Stargate;
//
//public class Tests {
//	
//	//Men� - �j j�t�k
//	public void test1(){
//		System.out.println("Men� - �j j�t�k");
//		GameStateManager gsm = new GameStateManager();
//		System.out.println("Teszt kezdete:");
//		gsm.setState(1);
//	}
//	//Men� � kil�p�s
//	public void test2(){
//		System.out.println("Men� � kil�p�s");
//		System.out.println(">System.exit");
//		System.out.println("<System.exit");
//	}
//	
//	//padl�ra l�p�s
//	public void test3(){
//		System.out.println("padl�ra l�p�s");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//szakad�kba l�p�s
//	public void test4(){
//		System.out.println("szakad�kba l�p�s");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Gap(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//falba l�p�s
//	public void test5(){
//		System.out.println("falba l�p�s");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Wall(false,0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].onStep(oneill, 3);
//	}
//	
//	//m�rlegre l�p�s ajt�nyit�ssal
//	public void test6(){
//		System.out.println("m�rlegre l�p�s ajt�nyit�ssal");
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
//	//Z�rt ajt�nak nekimegy
//	public void test7(){
//		System.out.println("Z�rt ajt�nak nekimegy");
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
//	//Nyitott ajt�ba l�p
//	public void test8(){
//		System.out.println("Nyitott ajt�ba l�p");
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
//	//Dobozra l�p�s
//	public void test9(){
//		System.out.println("Dobozra l�p�s");
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
//	//ZPM felv�tel
//	public void test10(){
//		System.out.println("ZPM felv�tel");
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
//	//Teleport�l
//	public void test11(){
//		System.out.println("Teleport�l");
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
//	//Doboz felv�tel
//	public void test12(){
//		System.out.println("Doboz felv�tel");
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
//	//Doboz lerak�sa csemp�re
//	public void test13(){
//		System.out.println("Doboz lerak�sa csemp�re");
//		TileMap map = new TileMap();
//		map.tiles = new Tile[1][2];
//		map.tiles[0][0] = new Floor(0,0);
//		map.tiles[0][1] = new Floor(0,1);
//		ONeill oneill = new ONeill(map,map.tiles[0][0],1);
//		oneill.setBox(new Box());
//		System.out.println("Teszt kezdete:");
//		map.tiles[0][1].putBox(oneill, oneill.getBox());
//	}
//	//Doboz lerak�sa falba
//	public void test14(){
//		System.out.println("Doboz lerak�sa falra");
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
//	//Doboz lerak�sa ajt�ba
//	public void test15(){
//		System.out.println("Doboz lerak�sa ajt�ba");
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
//	//Doboz lerak�sa szakad�kba
//	public void test16(){
//		System.out.println("Doboz lerak�sa szakad�kba");
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
//	//Doboz lerak�sa dobozra
//	public void test17(){
//		System.out.println("Doboz lerak�sa dobozra");
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
//	//Doboz lerak�sa m�rlegre
//	public void test18(){
//		System.out.println("Doboz lerak�sa m�rlegre");
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
//	//Doboz lerak�sa ZPM-re
//	public void test19(){
//		System.out.println("Doboz lerak�sa ZPM-re");
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
//	//L�ved�k doboznak �tk�z�s
//	public void test20(){
//		System.out.println("L�ved�k doboznak �tk�z�s");
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
//	//L�ved�k ZPM-nek �tk�z�s
//	public void test21(){
//		System.out.println("L�ved�k ZPM-nek �tk�z�s");
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
//	//L�ved�k sima falnak �tk�z�s
//	public void test22(){
//		System.out.println("L�ved�k sima falnak �tk�z�s");
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
//	//L�ved�k speci�lis falnak �tk�z�s
//	public void test23(){
//		System.out.println("L�ved�k speci�lis falnak �tk�z�s");
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
//	//L�ved�k szakad�k felett halad�s
//	public void test24(){
//		System.out.println("L�ved�k szakad�k felett halad�s");
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
//	//L�ved�k nyitott ajt�nak �thalad�s
//	public void test25(){
//		System.out.println("L�ved�k nyitott ajt�n �thalad�s");
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
//	//L�ved�k csukott ajt�nak �tk�z�s
//	public void test26(){
//		System.out.println("L�ved�k csukott ajt�nak �tk�z�s");
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
//	//L�ved�k padl� felett rep�l
//	public void test27(){
//		System.out.println("L�ved�k padl� felett halad�s");
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
