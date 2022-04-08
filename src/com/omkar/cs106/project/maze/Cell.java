package com.omkar.cs106.project.maze;

public class Cell { //each cell has only left and down part. All cells come together to form maze
	private Boolean left; 
	private Boolean down;
	private Boolean playerPresent; //to check if player is present in current cell or not
	private Boolean enemyPresent; //to check if enemy is present in current cell or not
	private Boolean doorPresent; //to check if door is present in current cell or not
	
	public Cell(Boolean left, Boolean down) {
		//by default, no cell will have player or enemy or door present in them 
		this.left = left;
		this.down = down;
		this.playerPresent = false;
		this.enemyPresent = false;
		this.doorPresent = false;
	}

	public Boolean getLeft() {
		return left;
	}

	public Boolean getDown() {
		return down;
	}
	
	public Boolean getPlayerPresent() {
		return playerPresent;
	}

	public void setPlayerPresent(Boolean playerPresent) {
		this.playerPresent = playerPresent;
	}
	
	public Boolean getEnemyPresent() {
		return enemyPresent;
	}

	public void setEnemyPresent(Boolean enemyPresent) {
		this.enemyPresent = enemyPresent;
	}

	public Boolean getDoorPresent() {
		return doorPresent;
	}

	public void setDoorPresent(Boolean doorPresent) {
		this.doorPresent = doorPresent;
	}

	public void printCell() {
		if (left == true)
			System.out.print("|"); //left side of cell
		else
			System.out.print(" "); //empty left side of cell
		if (playerPresent == true)
			if (down == true)
				System.out.print("_O_"); //cell when player is present
			else
				System.out.print(" O ");
		else if (enemyPresent == true)
			if (down == true)
				System.out.print("_+_"); //cell when enemy is present
			else
				System.out.print(" + ");
		else if (doorPresent == true)
			if (down == true)
				System.out.print("_X_"); //cell when door is present
			else
				System.out.print(" X ");
		else
			if (down == true)
				System.out.print("___"); //down side of cell
			else
				System.out.print("   "); //empty down side of cell
	}
}
