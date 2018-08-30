package grid;

import java.util.Collection;
import java.util.List;

import grid.element.Cell;

/**
 *  Grid
 *
 *  The POJO of a the classic sudoku grid.
 */
public class Grid {

    public final int DIMENSION = 9;
    private List<List<Cell>> columns;
    private List<List<Cell>> regions;
    private List<List<Cell>> rows;

    public Grid() {}

    public Cell getCell(int row, int col) {
       return this.rows.get(row).get(col);
    }

    public List<List<Cell>> getColumns() {
        return this.columns; 
    }

    public void setColumns(List<List<Cell>> columns) {
        this.columns = columns;
    }

    public List<List<Cell>> getRegions() {
        return this.regions; 
    }

    public void setRegions(List<List<Cell>> regions) {
        this.regions = regions;
    }

    public List<List<Cell>> getRows() {
        return this.rows; 
    }

    public void setRows(List<List<Cell>> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        rows.stream().flatMap(Collection::stream).forEach((x) -> sb.append(x.getValue()));
        return sb.toString();
    }
}
