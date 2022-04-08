package com.omkar.cs106.project.maze;

public class Maze {
	private Integer height; //rows in maze
	private Integer length; //columns in maze
	private Cell[][] cell = { //20x25
			{new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(true, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(true, false)},
			{new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(true, false)},
			{new Cell(true, true), new Cell(true, true), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(true, true), new Cell(true, true), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(true, false)},
			{new Cell(true, true), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, false), new Cell(true, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(true, true), new Cell(true, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, false), new Cell(true, false)},
			{new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(false, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(true, true), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, true), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, true), new Cell(true, true), new Cell(false, false), new Cell(false, false), new Cell(false, true), new Cell(false, false), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(false, false), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(true, true), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(true, false), new Cell(false, true), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, false), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, false), new Cell(false, true), new Cell(true, false)},
			{new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(true, false), new Cell(false, true), new Cell(false, false), new Cell(true, true), new Cell(true, true), new Cell(false, false), new Cell(true, true), new Cell(false, true), new Cell(false, false), new Cell(true, false), new Cell(false, false), new Cell(false, true), new Cell(false, true), new Cell(true, false), new Cell(true, false)},
			{new Cell(true, true), new Cell(true, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(true, false), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, true), new Cell(true, true), new Cell(false, true), new Cell(false, true), new Cell(false, true), new Cell(true, false)}
			}; //all the cells in the maze
	private String line0 = " _______________________________________________  S  ________________________________________________"; //top line and bottom line of maze
	private String line1 = "|_______________________________________________  E  _______________________________________________|";
	private Transporter transporter = new Transporter(9, 19, 19, 0);  // transporter doors - d1[x][y], d2[x][y]
	
	public Maze() {
		this.height = 20;
		this.length = 25;
		this.cell[0][12].setPlayerPresent(true); //setting player at start of maze [0, 12]
		this.cell[transporter.getD1().getPosX()][transporter.getD1().getPosY()].setDoorPresent(true); //setting transporter door 1
		this.cell[transporter.getD2().getPosX()][transporter.getD2().getPosY()].setDoorPresent(true); //setting transporter door 2
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getLength() {
		return length;
	}
	
	public Cell getCell(Integer i, Integer j) {
		return cell[i][j]; //returns cell at row i, column j
	}

	public Transporter getTransporter() {
		return transporter;
	}
	
	public void displayInstruction() {
		System.out.println("The player is represented by 'O'.");
		System.out.println("The enemy is represented by '+' and is continuously moving along a fixed path.");
		System.out.println("Transport doors are represented by 'X'. They transport the player from one door to another.");
		System.out.println("The goal of player is to move to the end and avoid the enemies on the way there.");
		System.out.println("The end is marked by E.");
		System.out.println("If player touches the enemy, player looses the game.");
		System.out.println("Move the player using WASD keys.");
		System.out.println("Press N to exit the game at any moment.");
	}

	public void displayStart() { //Welcome screen at start of the game
		System.out.println(line0);
		System.out.println("|                                              Welcome                                              |");
		System.out.println("|                                             Maze Game                                             |");
		System.out.println("|                                       Press Y to Start Game                                       |");
		System.out.println("|                                       Press N to Exit Game                                        |");
		System.out.println(line1);
	}
	
	public void displayMaze(Player player) { //maze display
		System.out.println();
		System.out.println(line0);
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j <= getLength(); j++)
				cell[i][j].printCell(); //using double for loop to print all the cells
			System.out.println();
		}
		System.out.println(line1);
		System.out.println();
	}
	
	public void displayEnd(Player player) { //Show proper message at the end of the game
		System.out.println(line0);
		if(player.getWin() == 1) {
			System.out.println("|                                          Congratulations                                          |");
			System.out.println("|                                              You Win                                              |");
			System.out.println("|                                         It Is Party Time                                          |");
		}
		else {
			System.out.println("|                                               Sorry                                               |");
			System.out.println("|                                             You Lost                                              |");
			System.out.println("|                                       Better Luck Next Time                                       |");
		}
		System.out.println("|                                       Press Y to Start Game                                       |");
		System.out.println("|                                       Press N to Exit Game                                        |");
		System.out.println(line1);
	}
}
