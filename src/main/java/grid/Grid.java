package grid;

import java.util.List;

import grid.element.Cell;

/**
 *  Grid
 *
 *  The POJO of a the classic sudoku grid.
 */
public class Grid {

    public final int DIMENSION = 9;
    private List<Cell> cells;

    public Grid() {}

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

   public Cell getCell(int row, int col) {
       return this.cells.get(row * DIMENSION + col);
   }
}
