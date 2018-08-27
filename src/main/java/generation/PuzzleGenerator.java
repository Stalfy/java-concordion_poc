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

        grid.setCells(cells);

        return grid;
    }
}
