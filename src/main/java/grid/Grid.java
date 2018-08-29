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
    private List<List<Cell>> columns;
    private List<List<Cell>> rows;

    public Grid() {}

    public Cell getCell(int row, int col) {
       return this.cells.get(row * DIMENSION + col);
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getColumns() {
        return this.columns; 
    }

    public void setColumns(List<List<Cell>> columns) {
        this.columns = columns;
    }

    public List<List<Cell>> getRows() {
        return this.rows; 
    }

    public void setRows(List<List<Cell>> rows) {
        this.rows = rows;
    }
}
