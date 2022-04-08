package com.omkar.cs106.project.maze;

public class Enemy {
	//moves back and forth between point[fPosX][fPosY] and point[tPosX][tPosY]
	private Integer posX; //position of enemy
	private Integer posY;
	private Integer fPosX;
	private Integer fPosY;
	private Integer tPosX;
	private Integer tPosY;
	private Boolean ahead; //true when moving towards tPos, false when moving towards fPos
	private Character rep;
	
	public Enemy(Integer fPosX, Integer fPosY, Integer tPosX, Integer tPosY) {
		//starting position is same as fPos
		this.posX = fPosX;
		this.posY = fPosY;
		this.fPosX = fPosX;
		this.fPosY = fPosY;
		this.tPosX = tPosX;
		this.tPosY = tPosY;
		this.ahead = true; //at start moves from fPos to tPos
		this.rep = '+';
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

	public Integer getfPosX() {
		return fPosX;
	}

	public Integer getfPosY() {
		return fPosY;
	}

	public Integer gettPosX() {
		return tPosX;
	}

	public Integer gettPosY() {
		return tPosY;
	}

	public Boolean getAhead() {
		return ahead;
	}

	public void setAhead(Boolean ahead) {
		this.ahead = ahead;
	}

	public Character getRep() {
		return rep;
	}

	public void move(Maze maze, Player player) {
		Cell cell = maze.getCell(posX, posY);
		cell.setEnemyPresent(false); //make enemy false at current position
		if (fPosX == tPosX) { //enemy moves left and right
			if (ahead == true) { //moving towards tPos
				if (posY == tPosY) { //reached at tPos
					ahead = false; //turn back towards fPos
					posY = posY - 1; //move towards fPos 
				}
				else
					posY = posY + 1; //move towards tPos
			}
			else if (ahead == false) { //moving towards fPos
				if (posY == fPosY) {
					ahead = true;
					posY = posY + 1;
				}
				else
					posY = posY - 1;
			}
		}
		else if (fPosY == tPosY) { // enemy moves up and down
			if (ahead == true) {
				if (posX == tPosX) {
					ahead = false;
					posX = posX - 1;
				}
				else
					posX = posX + 1;
			}
			else if (ahead == false) {
				if (posX == fPosX) {
					ahead = true;
					posX = posX + 1;
				}
				else
					posX = posX - 1;
			}
		}
		cell = maze.getCell(posX, posY);
		cell.setEnemyPresent(true); //make enemy true at new position
		maze.displayMaze(player); //display maze with updated enemy position
	}
}
