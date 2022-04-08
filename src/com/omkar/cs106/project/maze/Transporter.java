package com.omkar.cs106.project.maze;

public class Transporter {
	//transport from one door to another
	//set of two doors
	private Door d1;
	private Door d2;
	
	public Transporter(Integer d1X, Integer d1Y, Integer d2X, Integer d2Y) {
		d1 = new Door(d1X, d1Y);
		d2 = new Door(d2X, d2Y);
	}
	
	public Door getD1() {
		return d1;
	}

	public Door getD2() {
		return d2;
	}
	
}
