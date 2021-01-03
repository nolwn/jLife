package com.github.nolwn.jlife;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class WorldTest {
	@Test
	public void createDeadWorld() {
		World world = new World(4, 4);
		String deadWorld = String.format(
			"%1$c%1$c%1$c%1$c\n" + 
			"%1$c%1$c%1$c%1$c\n" +
			"%1$c%1$c%1$c%1$c\n" +
			"%1$c%1$c%1$c%1$c\n", 
			World.DEAD
		);

		assertEquals(deadWorld, world.toString(), "world should be a 4x4 dead world");
	}

	@Test
	// TODO: adjust this test to actually verify it gets the correct cell.
	public void getCellStatusWithinRange() throws IndexOutOfBoundsException{
		World world = new World(4, 4);
		boolean status = world.getCell(1, 3);

		assertEquals(Cell.DEAD, status);
	}

	@Test
	public void getCellthrowsWhenCoordsOutOfRange() {
		World world = new World(4, 4);

		assertThrows(IndexOutOfBoundsException.class, () -> world.getCell(3, 4));
	}

	@Test
	public void setCellStatusWithinRange() throws IndexOutOfBoundsException {
		World world = new World(4, 4);
		int x = 2;
		int y = 3;

		world.setCell(x, y, Cell.ALIVE);

		boolean cell = world.getCell(x, y);

		assertEquals(Cell.ALIVE, cell);
	}

	@Test
	public void setCellthrowsWhenCoordsOutOfRange() {
		World world = new World(4, 4);

		assertThrows(
			IndexOutOfBoundsException.class, 
			() -> world.setCell(2, 5, Cell.ALIVE)
		);
	}

	@Test
	public void loadsFromArray() {
		char[] map = {
			World.DEAD, 
			World.DEAD, 
			World.ALIVE, 
			World.DEAD, 
			World.ALIVE, 
			World.DEAD, 
			World.DEAD, 
			World.DEAD,
			World.DEAD
		};

		World world = new World(3, 3, map);

		assertEquals(Cell.DEAD, world.getCell(0, 0), "1, 1 should be dead");
		assertEquals(Cell.ALIVE, world.getCell(2, 0), "3, 1 should be alive");
		assertEquals(Cell.ALIVE, world.getCell(1, 1), "2, 2 should be alive");
		assertEquals(Cell.DEAD, world.getCell(2, 2), "3, 3 should be dead");
	}
}
