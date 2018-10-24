import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.*;

/** A Server side class to run the GUI for the TIC TAC TOE game.
    @author Tomas Gonzalez Ortega @ Langara
    @version 2017-07-26 23h00
    @see <a href="https://d2l.langara.bc.ca/d2l/lms/dropbox/user/folder_submit_files.d2l?db=51872&grpid=95747&isprv=0&bp=0&ou=88736">a11: Sockets - Tic-Tak-Toe</a>
*/

public class ServerSide extends JFrame {

	private final static JButton[] buttons = {
		new JButton(" "), new JButton(" "), new JButton(" "),
		new JButton(" "), new JButton(" "), new JButton(" "),
		new JButton(" "), new JButton(" "), new JButton(" ")
	};

	private DataOutputStream outgoing;
	private DataInputStream receiving;
	private Socket socket;
	private ServerSocket server;

	/**
	* Contructs the server side Tic-Tac-Toe game layout
	*/
	public ServerSide() {
		super("Tic-Tac-Toe");
		setLayout(new BorderLayout());

		//all buttons
		JPanel gameArea = new JPanel();
		gameArea.setLayout(new GridLayout(3,3));
	    for (JButton button : buttons) {
	        gameArea.add(button);
	    }
		JButton reset = new JButton("Reset");
		reset.addActionListener(event -> {
			closeGame();
		});
	    add(gameArea, BorderLayout.CENTER);
	    add(reset, BorderLayout.SOUTH);

		setSize(450, 500);
		setVisible(true);
	}

	/**
	* Sets up a serverSocket to connect into the game
	*/
	public void setup() {
		try {
			server = new ServerSocket(1234, 2);
			while(true) {
				waitForPlayer();
				createGame();
				connected();
			}
		} catch (Exception e) {System.out.println("Start fail");}
	}

	/**
	* Waits for the player until connected into the game
	*/
	public void waitForPlayer() throws IOException {
		System.out.println("Connecting...");
		socket = server.accept();
		System.out.println("Connected");
	}

	/**
	* Creates the input and output for the Tic-Tac-Toe game
	*/
	public void createGame() throws IOException {
		outgoing = new DataOutputStream(socket.getOutputStream());
		receiving = new DataInputStream(socket.getInputStream());
		System.out.println("IO & game created");
	}

	/**
	* Acknowledges connection into the Tic-Tac-Toe game
	*/
	public void connected() throws IOException {
		int message = 0;
		do {
			try {
				message = (int) receiving.readInt();
			} catch (IOException e) {System.out.println("Message cannot be decrypted");}
		} while (message != -1);
	}

	/**
	* Closes the connection into the Tic-Tac-Toe game
	*/
	public void closeGame() {
		try {
			outgoing.close();
			receiving.close();
			socket.close();
		} catch (IOException e) {System.out.println("Shutdown process unavailable");}
	}

	/**
	* Updates the Tic-Tac-Toe game
	*/
	public void update() {

	}
}
