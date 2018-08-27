package generation;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import generation.PuzzleGenerator;
import grid.Grid;
import grid.element.Cell;

@RunWith(ConcordionRunner.class)
public class PuzzleGeneratorTest {

    private final String CELL_TEST_INPUT_SUFFIX = "00000000000000000000000000000000000000000000000000000000000000000000000000000000";

    public String generateCell(String inputChar) {
        PuzzleGenerator generator = new PuzzleGenerator();
        Grid grid = generator.generateGrid(inputChar + CELL_TEST_INPUT_SUFFIX);
        Cell cell = grid.getCell(0, 0);

        return cell.getClass().getSimpleName();
    }
}
