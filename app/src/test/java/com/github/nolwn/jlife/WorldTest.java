package com.github.nolwn.jlife;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class WorldTest {
	@Test
	public void createsNewWorldFromDimensions() {
		World world = new World(4, 4);

		assertNotNull(world);
	}

	@Test
	public void createsNewWorldFromCellArray() {
		Cell[] map = {
			new Cell(Cell.DEAD), 
			new Cell(Cell.DEAD), 
			new Cell(Cell.ALIVE), 
			new Cell(Cell.DEAD), 
			new Cell(Cell.ALIVE), 
			new Cell(Cell.DEAD), 
			new Cell(Cell.DEAD), 
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD)
		};

		World world = new World(3, 3, map);
	
		assertNotNull(world);
	}

	@Test
	public void outputsWorldWithToStringMethod() {
		Cell[] map = {
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.ALIVE),
			new Cell(Cell.DEAD),
			new Cell(Cell.ALIVE),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD)
		};

		String d = String.valueOf(World.DEAD);
		String a = String.valueOf(World.ALIVE);

		String expectedWorld = 
			d + d + a + "\n" +
			d + a + d + "\n" +
			d + d + d + "\n";

		World world = new World(3, 3, map);
	
		assertEquals(expectedWorld, world.toString());
	}

	@Test
	public void getCellStatusWithinRange() {
		Cell[] map = {
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.ALIVE),
			new Cell(Cell.DEAD),
			new Cell(Cell.ALIVE),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD),
			new Cell(Cell.DEAD) 
		};

		World world = new World(3, 3, map);

		assertEquals(Cell.DEAD, world.getCell(0, 0), "1, 1 should be dead");
		assertEquals(Cell.ALIVE, world.getCell(2, 0), "3, 1 should be alive");
		assertEquals(Cell.ALIVE, world.getCell(1, 1), "2, 2 should be alive");
		assertEquals(Cell.DEAD, world.getCell(2, 2), "3, 3 should be dead");
	}

	@Test
	public void getCellThrowsWhenCoordinatesOutOfRange() {
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
	public void setCellThrowsWhenCoordinatesOutOfRange() {
		World world = new World(4, 4);

		assertThrows(
			IndexOutOfBoundsException.class, 
			() -> world.setCell(2, 5, Cell.ALIVE)
		);
	}
}
