package com.omkar.cs106.project.maze;

public class Player {
	private Integer posX; //row, can range from 0 to 19
	private Integer posY; //column, can range from 0 to 24
	private Integer win; //1 for true (won), -1 for false (lost), 0 for null (game going on)
	private Character rep; // O
	
	public Player() {
		this.posX = 0; //starting position row
		this.posY = 12; //starting position column
		this.win = 0;
		this.rep = 'O';
	}

	public Integer getPosX() {
		return posX;
	}
	
	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}
	
	public void setPosY(Integer posY) {
		this.posY = posY;
	}
	
	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}
	
	public Character getRep() {
		return rep;
	}
	
	public void movePlayer(Maze maze, String move) {
		// checks inputs move and calls appropriate function to change current position of player
		Boolean check = false; //if false, player cannot move to next cell, if true, player can move to next cell
		switch (move) {
			case "W" : {
				check = moveUp(maze);
				break;
			}
			case "A" : {
				check = moveLeft(maze);
				break;
			}
			case "S" : {
				check = moveDown(maze);
				break;
			}
			case "D" : {
				check = moveRight(maze);
				break;
			}
			case "N": {
				win = -1;
				break;
			}
			default : {
				System.out.println("Enter W, A, S or D to move the player. Press N to exit.");
				break;
			}
		}
		if (check == true)
			transport(maze); //checks if player is at one of the transportation doors, if so, transports player to another set of the door
		if (win == 0)
			checkWin(maze); //after moving player to next cell, checks if player won the game
	}
	
	private Boolean moveLeft(Maze maze) {
		Cell cell = null;
		if (posY == 0) //player can't move left if player is at column 0
			return false;
		if (checkMove(maze, posX, posY, posX, posY-1) == true) { //checks if it can move left
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(false); //makes player false at current position
			this.posY = this.posY - 1; //changes current position to current's left
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(true); //makes player true at new position
			return true;
		}
		return false;
	}
	
	private Boolean moveRight(Maze maze) {
		Cell cell = null;
		if (posY == maze.getLength()-1) //player can't move right if player is at column 24
			return false;
		if (checkMove(maze, posX, posY, posX, posY+1) == true) { //checks if it can move right
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(false);
			this.posY = this.posY + 1; //changes current position to current's right
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(true);
			return true;
		}
		return false;
	}
	
	private Boolean moveUp(Maze maze) {
		Cell cell = null;
		if (posX == 0) //player can't move up if player is at row 0
			return false;
		if (checkMove(maze, posX, posY, posX-1, posY) == true) { //checks if it can move up
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(false);
			this.posX = this.posX - 1; //changes current position to current's top
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(true);
			return true;
		}
		return false;
	}
	
	private Boolean moveDown(Maze maze) {
		Cell cell = null;
		if (posX == maze.getHeight()-1) //player can't move down if player is at row 19
			return false;
		if (checkMove(maze, posX, posY, posX+1, posY) == true) { //checks if it can move down
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(false);
			this.posX = this.posX + 1; //changes current position to current's down
			cell = maze.getCell(posX, posY);
			cell.setPlayerPresent(true);
			return true;
		}
		return false;
	}
	
	private Boolean checkMove(Maze maze, Integer cX, Integer cY, Integer nX, Integer nY) {
		Boolean check; //true if player can go to next cell
		Cell cell = null;
		if (cX == nX) { //moving left or right
			if (cY > nY) //moving left
				cell = maze.getCell(cX, cY); //current cell
			else // moving right
				cell = maze.getCell(nX, nY); //right cell
			check = (!cell.getLeft()); //if cell don't have left, player can move to next cell
		}
		else { //moving up or down
			if (cX > nX) // moving up
				cell = maze.getCell(nX, nY); //upper cell
			else
				cell = maze.getCell(cX, cY); //current cell
			check = (!cell.getDown()); //if cell don't have down, player can move to next cell
		}
		if (check == true)
			check = checkLost(maze, nX, nY); //checks if new cell has enemy present
		return check;
	}
	
	public Boolean checkLost(Maze maze, Integer X, Integer Y) {
		//if player touching enemy, it sets win to -1, returns false
		//if player not touching enemy, returns true 
		Cell cell = maze.getCell(X, Y);
		if (cell.getEnemyPresent() == true) {
			win = -1;
			return false;
		}
		return true;
	}
	
	private void transport(Maze maze) { //checks if player is at a transporter door, if so, transports player to other door
		if ((maze.getTransporter().getD1().getPosX() == posX) && (maze.getTransporter().getD1().getPosY() == posY)) { //check if player present at door1
			maze.getCell(posX, posY).setPlayerPresent(false); //makes player false at current door
			posX = maze.getTransporter().getD2().getPosX(); //change player position to new door
			posY = maze.getTransporter().getD2().getPosY();
			maze.getCell(posX, posY).setPlayerPresent(true); //make player true at new door
		}
		else if ((maze.getTransporter().getD2().getPosX() == posX) && (maze.getTransporter().getD2().getPosY() == posY)) { //check if player present at door2
			maze.getCell(posX, posY).setPlayerPresent(false);
			posX = maze.getTransporter().getD1().getPosX();
			posY = maze.getTransporter().getD1().getPosY();
			maze.getCell(posX, posY).setPlayerPresent(true);
		}
	}
	
	private void checkWin(Maze maze) { //checks if player is at wining position [19, 12]
		if ((posX == 19) && (posY == 12))
			win = 1;
	}
}
