package resolution;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import grid.Grid;
import grid.element.Cell;
import grid.element.CellTypes;
import grid.element.impl.GuessCell;
import grid.element.impl.NotesCell;
import resolution.NotesUpdater;

@RunWith(ConcordionRunner.class)
public class NotesUpdaterTest {

    // 48 is the ASCII position of the "0" character.
    private final int OFFSET = 48;

    private final Map<Integer, CellTypes> map;
    private final String BASE_NOTES = "123456789";

    public NotesUpdaterTest() {
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

    private List<Cell> generateCellsList(String input) {

        // Streams do not support Stream<char> from String types so a workaround is obligated.
        List<Cell> cells = input.chars()
            .map((x) -> x - OFFSET)
            .mapToObj((val) -> {Cell c = map.get(val).factory.get(); return c.setValue(val);})
            .collect(Collectors.toList());

        return cells;
    }

    private Grid generateMockGrid() {
        Grid grid = new Grid();

        grid.setColumns(createMockList());
        grid.setRegions(createMockList());
        grid.setRows(createMockList());

        return grid;
    }

    private List<List<Cell>> createMockList() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {

            List<Cell> line = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                line.add(new NotesCell());
            }

            list.add(line);
        }

        return list;
    }

    public String crossUpdate(String rowInput, int rowIndex, String columnInput, int colIndex) {
        colIndex = colIndex - 1;
        rowIndex = rowIndex - 1;
        
        List<Cell> col = generateCellsList(columnInput);
        List<Cell> row = generateCellsList(rowInput);

        col.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));
        row.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        // Ensure that the cross-cell is the same instance is both lists.
        col.set(rowIndex, row.get(colIndex));

        List<List<Cell>> cols = new ArrayList<>();
        cols.add(col);

        List<List<Cell>> rows = new ArrayList<>();
        rows.add(row);

        Grid grid = generateMockGrid();
        grid.setColumns(cols);
        grid.setRows(rows);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        return col.get(rowIndex).getNotes();
    }

    public String fullUpdate(String rowInput, int rowIndex, String columnInput, int colIndex, String regionInput, int regionIndex) {
        colIndex = colIndex - 1;
        regionIndex = regionIndex - 1;
        rowIndex = rowIndex - 1;
        
        List<Cell> col = generateCellsList(columnInput);
        List<Cell> region = generateCellsList(regionInput);
        List<Cell> row = generateCellsList(rowInput);

        col.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));
        region.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));
        row.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        // Ensure that the cell is the same instance is all lists.
        col.set(rowIndex, row.get(colIndex));
        region.set(regionIndex, row.get(colIndex));

        List<List<Cell>> cols = new ArrayList<>();
        cols.add(col);
        
        List<List<Cell>> regions = new ArrayList<>();
        regions.add(region);

        List<List<Cell>> rows = new ArrayList<>();
        rows.add(row);

        Grid grid = generateMockGrid();
        grid.setColumns(cols);
        grid.setRegions(regions);
        grid.setRows(rows);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        return col.get(rowIndex).getNotes();
    }


    public String updateCol(String input) {

        List<Cell> col = generateCellsList(input);
        col.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        List<List<Cell>> cols = new ArrayList<>();
        cols.add(col);

        Grid grid = generateMockGrid();
        grid.setColumns(cols);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        // Since it is a line update, any NotesCell is acceptable.
        return col.stream().filter((x) -> x instanceof NotesCell).findAny().get().getNotes();
    }

    public String updateRegion(String input) {

        List<Cell> region = generateCellsList(input);
        region.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        List<List<Cell>> regions = new ArrayList<>();
        regions.add(region);

        Grid grid = generateMockGrid();
        grid.setRegions(regions);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        // Since it is a line update, any NotesCell is acceptable.
        return region.stream().filter((x) -> x instanceof NotesCell).findAny().get().getNotes();
    }

    public String updateRow(String input) {

        List<Cell> row = generateCellsList(input);
        row.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        List<List<Cell>> rows = new ArrayList<>();
        rows.add(row);

        Grid grid = generateMockGrid();
        grid.setRows(rows);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        // Since it is a line update, any NotesCell is acceptable.
        return row.stream().filter((x) -> x instanceof NotesCell).findAny().get().getNotes();
    }
}
