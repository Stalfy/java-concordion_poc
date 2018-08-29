package generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import grid.Grid;
import grid.element.Cell;
import grid.element.CellTypes;
import grid.element.impl.HintCell;
import grid.element.impl.NotesCell;

public class PuzzleGenerator {

    // 48 is the ASCII position of the "0" character.
    private final int OFFSET = 48;
    private final int GRID_DIM = 9;
    private final int REGION_DIM = 3;

    private final Map<Integer, CellTypes> map;

    public PuzzleGenerator() {
        map = new HashMap<>();
        map.put(0, CellTypes.NOTES_CELL);
        map.put(1, CellTypes.HINT_CELL);
        map.put(2, CellTypes.HINT_CELL);
        map.put(3, CellTypes.HINT_CELL);
        map.put(4, CellTypes.HINT_CELL);
        map.put(5, CellTypes.HINT_CELL);
        map.put(6, CellTypes.HINT_CELL);
        map.put(7, CellTypes.HINT_CELL);
        map.put(8, CellTypes.HINT_CELL);
        map.put(9, CellTypes.HINT_CELL);
    }

    public Grid generateGrid(String input) {
        Grid grid = new Grid();

        // Streams do not support Stream<char> from String types so a workaround is obligated.
        List<Cell> cells = input.chars()
            .map((x) -> x - OFFSET)
            .mapToObj((val) -> {Cell c = map.get(val).factory.get(); return c.setValue(val);})
            .collect(Collectors.toList());

        createCols(cells, grid);
        createRegions(cells, grid);
        createRows(cells, grid);

        return grid;
    }

    private void createCols(List<Cell> cells, Grid grid) {
        List<List<Cell>> cols = new ArrayList<>();

        for(int i = 0; i < GRID_DIM; i++) {
            List<Cell> col = new ArrayList<>();
            cols.add(col);
        }

        // For example, 012345678012345678 will be the column indexes for the first 18 elements.
        for(int i = 0; i < cells.size(); i++) {
            cols.get(i % GRID_DIM).add(cells.get(i));
        }

        grid.setColumns(cols);
    }

    private void createRegions(List<Cell> cells, Grid grid) {
        List<List<Cell>> regions = new ArrayList<>();

        for(int i = 0; i < GRID_DIM; i++) {
            List<Cell> region = new ArrayList<>();
            regions.add(region);
        }

        // 000111222
        // 000111222
        // 000111222
        // 333444555
        // 333444555
        // 333444555
        // 666777888
        // 666777888
        // 666777888
        // 3 * row/3 + col/3 gives the desired region separation.
        for(int i = 0; i < cells.size(); i++) {
            int rowIndex = i / GRID_DIM;
            int colIndex = i % GRID_DIM;

            // Do remember that this is an integer division. Otherwise it will fail.
            int regionIndex = (REGION_DIM * (rowIndex / REGION_DIM)) + (colIndex / REGION_DIM);
            regions.get(regionIndex).add(cells.get(i));
        }

        grid.setRegions(regions);
    }

    private void createRows(List<Cell> cells, Grid grid) {
        List<List<Cell>> rows = new ArrayList<>();

        for(int i = 0; i < GRID_DIM; i++) {

            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < GRID_DIM; j++) {
                row.add(cells.get(GRID_DIM * i + j));
            }

            rows.add(row);
        }

        grid.setRows(rows);
    }
}
