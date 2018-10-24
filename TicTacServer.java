import javax.swing.JFrame;

/** A Tic Tac Toe class that runs the main method to start the game on the server side.
    @author Tomas Gonzalez Ortega @ Langara
    @version 2017-07-26 23h00
    @see <a href="https://d2l.langara.bc.ca/d2l/lms/dropbox/user/folder_submit_files.d2l?db=51872&grpid=95747&isprv=0&bp=0&ou=88736">a11: Sockets - Tic-Tak-Toe</a>
*/

/**
* Creates a new ServerSide object and runs the game
* @param args line arguments -- ignored in this assignment
*/
public class TicTacServer {

    public static void main(String[] args) {
        ServerSide test = new ServerSide();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setup();
    }
}
