package com.omkar.cs106.project.maze;

public class Door {
	private Integer posX; //position of door
	private Integer posY;
	private Character rep;
	
	public Door(Integer posX, Integer posY) {
		this.posX = posX;
		this.posY = posY;
		this.rep = 'X'; 
	}

	public Integer getPosX() {
		return posX;
	}

	public Integer getPosY() {
		return posY;
	}
	
	public Character getRep() {
		return rep;
	}
}
