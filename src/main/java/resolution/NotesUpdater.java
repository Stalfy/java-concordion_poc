package resolution;

import java.util.List;

import grid.Grid;
import grid.element.Cell;

public class NotesUpdater {

    public NotesUpdater() {}

    public void updateGridNotes(Grid grid) {
        grid.getRows().stream().forEach(this::updateRow);
    }

    private void updateRow(List<Cell> row) {
        // Build the replacement regex.
        StringBuilder sb = new StringBuilder("[");
        row.stream().filter((x) -> 0 != x.getValue()).forEach((c) -> sb.append(c.getValue()));
        sb.append("]");

        // Then replace the values.
        row.stream().filter((x) -> null != x.getNotes()).forEach((c) -> c.setNotes(c.getNotes().replaceAll(sb.toString(), "")));
    }
}
