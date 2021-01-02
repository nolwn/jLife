package com.github.nolwn.jlife;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CellTest {
	@Test
	public void CreateCells() {
		Cell deadCell = new Cell(Cell.DEAD);
		Cell livingCell = new Cell(Cell.ALIVE);

		assertEquals(Cell.DEAD, deadCell.isAlive(), "the cell should not be alive");
		assertEquals(Cell.ALIVE, livingCell.isAlive(), "the cells should be alive");
	}

	@Test
	public void KillAndResurectACell() {
		Cell cell = new Cell(Cell.ALIVE);

		cell.setIsAlive(Cell.DEAD);
		assertEquals(Cell.DEAD, cell.isAlive(), "the cell should have been killed");

		cell.setIsAlive(Cell.ALIVE);
		assertEquals(Cell.ALIVE, cell.isAlive(), "The cell should have been brought back to life");
	}
}
