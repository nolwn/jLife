package com.github.nolwn.jlife;

public class Cell {
	public static final boolean ALIVE = true;
	public static final boolean DEAD = false;
	
	private boolean isAlive;
	
	public Cell(boolean alive) {
		this.isAlive = alive;
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
	
	