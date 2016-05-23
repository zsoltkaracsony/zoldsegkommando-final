package GameStates;


public class GameStateManager {

	private GameState[] gameStates;
	private int currentState;
	public static final int NUMGAMESTATES = 4;
	public static final int MENUSTATE = 0;
	public static final int LEVELSTATE = 1;
	public static final int GAMEOVERSTATE = 2;
	public static final int GAMEWINSTATE = 3;

	public GameStateManager() {
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = MENUSTATE;
		loadState(currentState);
	}
	
	public void loadState(int state){
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		if(state == LEVELSTATE)
			gameStates[state] = new LevelState(this);
	}
	
	public void unloadState(int state){
		gameStates[state] = null;
	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
		if(gameStates[currentState]== null){
			System.out.println("ASDASDADSADA");
		}else{
			System.out.println("nemnull");
		}
	}
	
	public int getCurrentState(){
		return currentState;
	}

	public void update() {
		try {
			gameStates[currentState].update();
		} catch (Exception e) {
		}
	}

	public void draw(java.awt.Graphics2D g) {
		try {
			gameStates[currentState].draw(g);
		} catch (Exception e) {
		}
	}

	public void keyPressed(int k) {
		gameStates[currentState].keyPressed(k);
	}

	public void keyReleased(int k) {
		try {
			gameStates[currentState].keyReleased(k);
		} catch (Exception e) {
		}
	}

}