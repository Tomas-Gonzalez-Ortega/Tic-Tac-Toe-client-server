import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.*;

public class GUIView extends JFrame {

	private final static JButton[] buttons = {
		new JButton("1"), new JButton("2"), new JButton("2"),
		new JButton("1"), new JButton("2"), new JButton("2"),
		new JButton("1"), new JButton("2"), new JButton("2")};

	private DataOutputStream outgoing;
	private DataInputStream receiving;
	private Socket socket;
	private ServerSocket server;

	public GUIView() {

		setLayout(new BorderLayout());

		//all buttons
		JPanel gameArea = new JPanel();
		gameArea.setLayout(new GridLayout(3,3));
	    for (JButton button : buttons) {
	        gameArea.add(button);
	    }
		JButton reset = new JButton("Reset");
	    add(gameArea, BorderLayout.CENTER);
	    add(reset, BorderLayout.SOUTH);

		setSize(450, 500);
		setVisible(true);
	}

	public void setup() {
		try {
			server = new ServerSocket(1234, 2);
			while(true){
				//waitForPlayer();
				//createGame();
				//connected();
			}
		} catch (Exception e){
			System.out.println("Start fail");
		}
	}

	public void update() {}

}
