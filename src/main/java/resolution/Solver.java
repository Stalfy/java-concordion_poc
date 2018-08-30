package resolution;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import grid.Grid;
import grid.element.Cell;
import grid.element.impl.GuessCell;
import grid.element.impl.NotesCell;
import resolution.result.ResolutionResult;

public class Solver {

    private final Map<Long, String> outcomes;
    private final String NOTES = "123456789";
    private final String SOLVED_MSG = "Puzzle solved.";
    private final String UNSOLVED_MSG = "Puzzle cannot be solved.";
    
    private NotesUpdater updater;

    public Solver() {
        outcomes = new HashMap<>();
        outcomes.put(0l, SOLVED_MSG);
    }

    public Solver (NotesUpdater updater) {
        this();
        this.updater = updater;
    }

    public ResolutionResult solve(Grid grid) {
        long notesCellsBeforeStep = 0;
        long notesCellsAfterStep = 0;
        addNotes(grid);

        boolean keepSolving = true;
        while(keepSolving) {
            notesCellsBeforeStep = grid.getRows().stream().flatMap(Collection::stream).filter((x) -> x instanceof NotesCell).count();
            step(grid);
            notesCellsAfterStep = grid.getRows().stream().flatMap(Collection::stream).filter((x) -> x instanceof NotesCell).count();
            keepSolving = (0 != notesCellsAfterStep) && (notesCellsAfterStep < notesCellsBeforeStep);
        }

        ResolutionResult result = new ResolutionResult();
        result.setMessage(outcomes.getOrDefault(notesCellsAfterStep, UNSOLVED_MSG));
        result.setResultGrid(grid);
        
        return result;
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
