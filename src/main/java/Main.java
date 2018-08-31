import java.util.logging.Level;
import java.util.logging.Logger;

import display.PrettyPrinter;
import exception.validation.InvalidInputException;
import generation.PuzzleGenerator;
import grid.Grid;
import resolution.NotesUpdater;
import resolution.Solver;
import resolution.result.ResolutionResult;
import validation.InputPuzzleValidator;

public class Main {
    public static void main(String[] args) {
        int exitCode = 0;

        try {
            exitCode = solve(args[0]);
        } catch (Exception e) {
            System.err.println("Could not parse argument.");
            System.exit(1);
        }

        System.exit(exitCode);
    }

    private static int solve(String input) {
        int exitCode = 0;
        Logger logger = Logger.getLogger("Main");

        try {
            InputPuzzleValidator iv = new InputPuzzleValidator();
            String puzzle = iv.validate(input);
            
            PuzzleGenerator pg = new PuzzleGenerator();
            Grid grid = pg.generateGrid(puzzle);

            PrettyPrinter pp = new PrettyPrinter();
            logger.log(Level.INFO, "Input: \n" + pp.convert(grid));

            Solver solver = new Solver();
            solver.setNotesUpdater(new NotesUpdater());

            ResolutionResult result = solver.solve(grid);
            logger.log(Level.INFO, result.getMessage() + "\n");
            logger.log(Level.INFO, "Resulting Grid: \n" + pp.convert(grid));
        } catch (InvalidInputException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            exitCode = 1;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occured during execution.", e);
            exitCode = 1;
        }

        return exitCode;
    }
}
