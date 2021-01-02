package com.github.nolwn.jlife;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	public void getCellStatusWithinRange() {
		World world = new World(4, 4);
		boolean status = world.getCell(1, 2);

		assertEquals(false, status);
	}
}
