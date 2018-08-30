package resolution;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.powermock.reflect.Whitebox;

import generation.PuzzleGenerator;
import grid.Grid;
import grid.element.Cell;
import grid.element.CellTypes;
import grid.element.impl.GuessCell;
import grid.element.impl.NotesCell;
import resolution.NotesUpdater;
import resolution.Solver;
import resolution.result.ResolutionResult;

@RunWith(ConcordionRunner.class)
public class SolverTest {

    public SolverTest() {}

    public String addNotes() {
        String gridInput = "008300000607008043023006590030070059700603002560080070076400810240800906000005700";
        PuzzleGenerator generator = new PuzzleGenerator();

        Grid grid = generator.generateGrid(gridInput);

        try {
            Solver solver = new Solver();
            Whitebox.invokeMethod(solver, "addNotes", grid);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, "Exception occured.", e);
        }
        
        // Take the top left corner NotesCell.
        return grid.getRegions().get(0).get(0).getNotes();
    }
    
    public int singleStep(int colIndex, int rowIndex) {
        String gridInput = "008300000607008043023006590030070059700603002560080070076400810240800906000005700";

        PuzzleGenerator generator = new PuzzleGenerator();
        Grid grid = generator.generateGrid(gridInput);

        try {
            Solver solver = new Solver(new NotesUpdater());
            Whitebox.invokeMethod(solver, "addNotes", grid);
            Whitebox.invokeMethod(solver, "step", grid);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, "Exception occured.", e);
        }
        
        return grid.getRows().get(rowIndex - 1).get(colIndex - 1).getValue();
    }

    public String solveBadGrid() {
        String gridInput = "100000000000000000000000000000000000000000000000000000000000000000000000000000000";

        PuzzleGenerator generator = new PuzzleGenerator();
        Grid grid = generator.generateGrid(gridInput);

        Solver solver = new Solver(new NotesUpdater());
        ResolutionResult result = solver.solve(grid);
        
        return result.getMessage();
    }

    public String solveGoodGrid() {
        String gridInput = "008300000607008043023006590030070059700603002560080070076400810240800906000005700";

        PuzzleGenerator generator = new PuzzleGenerator();
        Grid grid = generator.generateGrid(gridInput);

        Solver solver = new Solver(new NotesUpdater());
        ResolutionResult result = solver.solve(grid);
       
        return result.getMessage();
    }
}
