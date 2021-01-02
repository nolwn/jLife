package jLife;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CellTest {
    @Test
    public void CreateCells() {
        Cell deadCell = new Cell(false);
        Cell livingCell = new Cell(true);

        assertEquals(false, deadCell.isAlive(), "the cell should not be alive");
        assertEquals(true, livingCell.isAlive(), "the cells should be alive");
    }

    @Test
    public void KillAndResurectACell() {
        Cell cell = new Cell(true);

        cell.kill();
        assertEquals(false, cell.isAlive(), "the cell should have been killed");

        cell.live();
        assertEquals(true, cell.isAlive(), "The cell should have been brought back to life");
    }
}
