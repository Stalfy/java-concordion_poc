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

    public String updateRow(String input) {
    
        List<Cell> row = generateCellsList(input);
        row.stream().filter((x) -> x instanceof NotesCell).forEach((c) -> c.setNotes(BASE_NOTES));

        List<List<Cell>> lines = new ArrayList<>();
        lines.add(row);

        Grid grid = new Grid();
        grid.setRows(lines);

        NotesUpdater updater = new NotesUpdater();
        updater.updateGridNotes(grid);

        // Since it is a line update, any NotesCell is acceptable.
        return row.stream().filter((x) -> x instanceof NotesCell).findAny().get().getNotes();
    }
}
