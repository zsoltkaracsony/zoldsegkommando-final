package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class MenuState extends GameState {

	private int currentChoice = 0;
	private String[] options = {"Start","Quit"};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	private BufferedImage background;

	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		titleColor = new Color(128, 0, 0);
		titleFont = new Font(
				"Century Gothic",
				Font.PLAIN,
				48);
		
		font = new Font("Arial", Font.PLAIN, 12);
	}

	public void init() {
	}

	public void update() {
	}

	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVELSTATE);
		}
		if(currentChoice == 1) {
			System.exit(0);
		}

	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}


	}

	public void keyReleased(int k) {
	}

	public void draw(java.awt.Graphics2D g) {
		
		// draw background
		
		try {
//			ImageInputStream steam = ImageIO.createImageInputStream("/menubckgrnd.jpg");
				background = ImageIO.read(getClass().getResourceAsStream("/resources/bgr.png"));
		} catch (IOException e) {
		}
		g.drawImage(background, 0, 0, null);
		
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("O'Neill menni Amerika", 80, 70);
				
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.lightGray);
			}
			else {
				g.setColor(Color.darkGray);
			}
			g.drawString(options[i], 290, 280 + i * 30);
		}
	}

}