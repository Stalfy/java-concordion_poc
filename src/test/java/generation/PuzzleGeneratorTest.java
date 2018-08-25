package generation;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import generation.PuzzleGenerator;
import grid.Grid;

@RunWith(ConcordionRunner.class)
public class PuzzleGeneratorTest {

    public boolean generateGrid() {
        PuzzleGenerator generator = new PuzzleGenerator();

        return generator.generateGrid("") instanceof Grid;
    }
}
