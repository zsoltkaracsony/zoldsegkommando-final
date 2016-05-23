package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import Entities.Jaffa;
import Entities.ONeill;
import Game.GamePanel;
import TileMap.TileMap;

public class LevelState extends GameState {

	private TileMap tileMap;
	
	private ONeill oneill;
	private Jaffa jaffa;
	
	private Color timerColor;
	private Font timerFont;
	
	private Integer timer = 0;
	int k = 0;

	public LevelState(GameStateManager gsm) {
		this.gsm = gsm;
		timerColor = new Color(128,0,0);
		timerFont = new Font("Arial", Font.PLAIN, 22);
		init();
	}

	public void init() {
		tileMap = new TileMap(this);
//		tileMap.testInit();
		tileMap.generateTestTextureMap();
		tileMap.loadMap("resources/maps/tmap2.json");
		
	}

	public void update() {
		
		tileMap.getOneil().update();
		tileMap.getJaffa().update();
		if(tileMap.getReplicator() != null){
			tileMap.getReplicator().update();
		}
		if(k == GamePanel.FPS){
			timer++;
			k=0;
		}{
			k++;
		}
	}

	public void keyPressed(int k) {
		
		//player 1
		if(k == KeyEvent.VK_A) tileMap.getOneil().move(3);
		if(k == KeyEvent.VK_D) tileMap.getOneil().move(1);
		if(k == KeyEvent.VK_W) tileMap.getOneil().move(0);
		if(k == KeyEvent.VK_S) tileMap.getOneil().move(2);
		if(k == KeyEvent.VK_G) tileMap.getOneil().shootProjectile("primary");
		if(k == KeyEvent.VK_H) tileMap.getOneil().shootProjectile("secondary");
		if(k == KeyEvent.VK_J) tileMap.getOneil().pickUpBox();
		if(k == KeyEvent.VK_K) tileMap.getOneil().putDownBox();
		//player 2
		if(k == KeyEvent.VK_LEFT) 	 tileMap.getJaffa().move(3);
		if(k == KeyEvent.VK_RIGHT) 	 tileMap.getJaffa().move(1);
		if(k == KeyEvent.VK_UP) 	 tileMap.getJaffa().move(0);
		if(k == KeyEvent.VK_DOWN) 	 tileMap.getJaffa().move(2);
		if(k == KeyEvent.VK_NUMPAD7) tileMap.getJaffa().shootProjectile("primary");
		if(k == KeyEvent.VK_NUMPAD9) tileMap.getJaffa().shootProjectile("secondary");
		if(k == KeyEvent.VK_NUMPAD8) tileMap.getJaffa().pickUpBox();
		if(k == KeyEvent.VK_NUMPAD5) tileMap.getJaffa().putDownBox();
		
	}

	public void keyReleased(int k) {
	}

	public void draw(java.awt.Graphics2D g) {
		
		tileMap.draw(g);
		tileMap.getOneil().draw(g);
		tileMap.getJaffa().draw(g);
		if(tileMap.getReplicator() != null){
			tileMap.getReplicator().draw(g);
		}
		g.setColor(timerColor);
		g.setFont(timerFont);
		g.drawString(timer.toString(),5,24);
		
	}

	
}