package resolution;

import grid.Grid;
import resolution.result.ResolutionResult;

public class Solver {

    private final String NOTES = "123456789";

    public Solver() {}
    
    public ResolutionResult solve(Grid grid) {
    
        step(grid);
        return new ResolutionResult();
    }

    private void addNotes(Grid grid) {
        grid.getRows().stream().forEach((row) -> row.stream().forEach((cell) -> cell.setNotes(NOTES)));
    }

    private Grid step(Grid grid) {
    
        return grid;
    }
}
