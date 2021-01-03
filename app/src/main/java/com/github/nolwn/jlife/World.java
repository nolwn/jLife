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

	public World(int width, int height, char[] map) {
		this.width = width;
		this.height = height;
		this.cells = toCells(map);
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
	
	public boolean getCell(int x, int y) throws IndexOutOfBoundsException {
		Cell cell = this.getCellFromCoords(x, y);

		return cell.isAlive();
	}

	public void setCell(int x, int y, boolean value) throws IndexOutOfBoundsException {
		Cell cell = this.getCellFromCoords(x, y);

		cell.setIsAlive(value);
	}

	private Cell getCellFromCoords(int x, int y) throws IndexOutOfBoundsException {
		if (!checkCoords(x, y)) {
			throw new IndexOutOfBoundsException();
		}

		int len = y * this.height + x;

		return this.cells[len];
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

	private Cell[] toCells(char[] map) {
		Cell[] cells = new Cell[map.length];

		for (int i = 0; i < cells.length; i++) {
			cells[i] = new Cell(map[i] == World.ALIVE);
		}

		return cells;
	}
}
