package com.github.nolwn.jlife;

public class World {
	public static final char DEAD = ' ';
	public static final char ALIVE = '*';

	private int width;
	private int height;
	private Cell[] cells;

	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Cell[width * height];
		
		for(int i = 0; i < width * height; i++) {
			this.cells[i] = new Cell(false);
		}
	}

	public String toString() {
		String output = "";

		for(int i = 0; i < width * height; i++) {
			output += DEAD;

			if ((i + 1) % width == 0) {
				output += '\n';
			}

		}

		return output;
	}
	
	public boolean getCell(int x, int y) {
		if (!checkCoords(x, y)) {}

		int len = (y - 1) * this.height + this.width;

		return this.cells[len].isAlive();
	}

	private boolean checkCoords(int x, int y) {
		if (x >= this.width) {
			return false;

		} else if (y >= this.height) {
			return false;

		} else {
			return true;
		}
	}
}
