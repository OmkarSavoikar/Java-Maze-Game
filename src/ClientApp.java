import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import com.omkar.cs106.project.maze.*;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Maze maze = new Maze();
		Player player = new Player();
		Enemy enemy1 = new Enemy(4, 14, 8, 14);
		Enemy enemy2 = new Enemy(13, 3, 19, 3);
		Enemy enemy3 = new Enemy(17, 4, 17, 11);
		Enemy enemy[] = {enemy1, enemy2, enemy3};
		String gameInput = "N"; //take input as Y or N to check when to exit
		String moveInput = null; // take input as W, A, S, D to move player		
		do {
			maze.displayInstruction();
		 	maze.displayStart(); //display game start
		 	gameInput = scan.next();
		 	gameInput = gameInput.toUpperCase();
			if (gameInput.compareTo("Y") == 0) { //if user input Y, start game
				Timer timer = new Timer(); //timer and task to move enemy constantly
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						for (int i = 0; i < enemy.length; i++)
							enemy[i].move(maze, player);
						if (player.checkLost(maze, player.getPosX(), player.getPosY()) == false) //after enemy movement check if player lost
							timer.cancel(); //if so, stop enemy movement
					}
				};
			 	timer.schedule(task, 0, 1000); //starting task to move enemy, calls after every 1000 milliseconds
				do {
					maze.displayMaze(player); //display maze
					System.out.println("Move player using W, A, S, D or press N to exit.");
					moveInput = scan.next();
					moveInput = moveInput.toUpperCase();
					player.movePlayer(maze, moveInput); // take input from user and accordingly move player
				} while(player.getWin() == 0); // do it till player wins or looses
				timer.cancel(); //because timer is cancelled here, if user wants to play again, it can't be scheduled again
				maze.displayEnd(player); //display end game and ask user if they want to play again
				gameInput = scan.next();
				gameInput = gameInput.toUpperCase();
				//set player position to start[0,12] and win to 0 before starting new game
				maze.getCell(player.getPosX(), player.getPosY()).setPlayerPresent(false);
				player.setPosX(0);
				player.setPosY(12);
				player.setWin(0);
				maze.getCell(player.getPosX(), player.getPosY()).setPlayerPresent(true);
			}
			else if (gameInput.compareTo("N") == 0) //if user inputs N, exit game
				break;
			else
				System.out.println("Invalid Input. Enter Y or N.");
		 } while (gameInput.compareTo("Y") == 0);
		System.out.println("|                                 Game Over Thank You For Playing                                   |");
		scan.close();
	}
}
