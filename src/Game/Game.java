package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import Entities.Entity;
import Entities.Jaffa;
import Entities.Player;
//import Testing.ProtoTestManager;
//import Testing.ProtoTests;
import Testing.testOutPutter;
import TileMap.TileMap;
import Tiles.Floor;
import Tiles.Tile;

public class Game {

	public static void main(String[] args) {

		
//		testOutPutter top = new testOutPutter();
//		ProtoTests pt = new ProtoTests();
//		pt.test22();
		
		
//		int selection = 30;
//		Scanner in = new Scanner(System.in);
//		
//		try{
//			if (args[0].toLowerCase().equals("test")){
//					ProtoTestManager ptm = new ProtoTestManager(args);
//					ptm.startTest();
//			}
//		}
//		catch (Exception e){
//			System.out.println(e);
//		}
		
		JFrame window = new JFrame("O'Neill and the ZPMs");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		
	}


}
