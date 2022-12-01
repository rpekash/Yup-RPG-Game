package Engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Game.GameState;
import Game.ScreenCoordinator;

/*
 * The JFrame that holds the GamePanel
 * Just does some setup and exposes the gamePanel's screenManager to allow an external class to setup their own content and attach it to this engine.
 */
public class GameWindow implements KeyListener {
	private JFrame gameWindow;
	private GamePanel gamePanel;
	private JLabel gifLabel = new JLabel();
	private Timer timer;
	protected ImageIcon gif;
	protected KeyLocker keyLocker = new KeyLocker();
	
	public GameWindow() {
		gameWindow = new JFrame("Game");
		gamePanel = new GamePanel();
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		gameWindow.setContentPane(gamePanel);
		gameWindow.setResizable(false);
		gameWindow.setSize(Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it'd be nice if this actually worked more than 1/3rd of the time
		gamePanel.setupGame();
	}
	
	public void switchToGamePanel() {
		gamePanel = new GamePanel();
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		gamePanel.setSize(800, 605);
		gameWindow.setContentPane(gamePanel);
		gamePanel.requestFocus();
		gamePanel.setupGame();
		startGame();
		ScreenManager screenManager = getScreenManager();
		screenManager.setCurrentScreen(new ScreenCoordinator(null));
	}

	public void playVideo() {	
		try {
			JPanel contentPane = new JPanel();
			contentPane.setFocusable(true);
			contentPane.requestFocus();
			contentPane.setLayout(new BorderLayout());
			contentPane.setBackground(Color.BLACK);
			contentPane.addKeyListener(this);

			gif = new ImageIcon(new ImageIcon("./src/test2.gif").getImage().getScaledInstance(800, 305, Image.SCALE_DEFAULT));
			gifLabel.setIcon(gif);
			gifLabel.setLocation(0, 0);
			gameWindow.setContentPane(contentPane);
			gifLabel.setFocusable(false);
			contentPane.add(gifLabel, BorderLayout.CENTER);
			int videoLenght = 30000;

			timer = new Timer(1, new ActionListener() {
				long startTime = System.currentTimeMillis();
				public void actionPerformed(ActionEvent e) {
					
				if (System.currentTimeMillis() - startTime >= videoLenght) {
						timer.stop();
						switchToGamePanel();
					}
				}
			});
			timer.start();
			timer.setRepeats(true);
			gameWindow.setVisible(true);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void startGame() {
		gamePanel.startGame();
	}

	public ScreenManager getScreenManager() {
		return gamePanel.getScreenManager();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}