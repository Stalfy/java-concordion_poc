package resolution;

import java.util.List;

import grid.Grid;
import grid.element.Cell;

public class NotesUpdater {

    public NotesUpdater() {}

    public void updateGridNotes(Grid grid) {
        grid.getColumns().stream().forEach(this::updateCells);
        grid.getRegions().stream().forEach(this::updateCells);
        grid.getRows().stream().forEach(this::updateCells);
    }

    private void updateCells(List<Cell> cells) {
        // Build the replacement regex.
        StringBuilder sb = new StringBuilder("[ ");
        cells.stream().filter((x) -> 0 != x.getValue()).forEach((c) -> sb.append(c.getValue()));
        sb.append("]");

        // Then replace the values.
        cells.stream().filter((x) -> null != x.getNotes()).forEach((c) -> c.setNotes(c.getNotes().replaceAll(sb.toString(), "")));
    }
}
