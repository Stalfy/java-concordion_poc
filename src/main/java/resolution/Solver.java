package resolution;

import java.util.stream.Collectors;

import grid.Grid;
import grid.element.Cell;
import grid.element.impl.GuessCell;
import grid.element.impl.NotesCell;
import resolution.result.ResolutionResult;

public class Solver {

    private final String NOTES = "123456789";
    private NotesUpdater updater;

    public Solver() {}

    public Solver (NotesUpdater updater) {
        this.updater = updater;
    }

    public ResolutionResult solve(Grid grid) {
        step(grid);
        return new ResolutionResult();
    }

    private void addNotes(Grid grid) {
        grid.getRows().stream().forEach((row) -> row.stream().forEach((cell) -> cell.setNotes(NOTES)));
    }

    private void updateNotes(Grid grid) {
        updater.updateGridNotes(grid);
    }

    private void replaceSingleNotesCells(Grid grid) {
        grid.getRows().stream()
            .forEach((row) -> {
                row.stream()
                    .filter((c) -> c instanceof NotesCell)
                    .filter((c) -> 1 == c.getNotes().length())
                    .forEach((cell) -> swapCell(cell, grid));
            });
    }

    private void swapCell(Cell cell, Grid grid) {
        Cell swappedInCell = new GuessCell().setValue(Integer.parseInt(cell.getNotes()));

        // Swap the cell in all locations to avoid misrepresentation.
        grid.getColumns().stream().filter((x) -> x.contains(cell)).forEach((x) -> x.set(x.indexOf(cell), swappedInCell));
        grid.getRegions().stream().filter((x) -> x.contains(cell)).forEach((x) -> x.set(x.indexOf(cell), swappedInCell));
        grid.getRows().stream().filter((x) -> x.contains(cell)).forEach((x) -> x.set(x.indexOf(cell), swappedInCell));
    }

    private void step(Grid grid) {
        updateNotes(grid);
        replaceSingleNotesCells(grid);
    }
}
