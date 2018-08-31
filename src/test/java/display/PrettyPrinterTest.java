package display;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import display.PrettyPrinter;
import generation.PuzzleGenerator;
import grid.Grid;

@RunWith(ConcordionRunner.class)
public class PrettyPrinterTest {

    private class PrinterResult {
        private final int LINE_LENGTH = 12;
        private String result;

        public PrinterResult() {}

        public void setResult(String result) {
            this.result = result;
        }

        public String getLine(int index) {
            index = index - 1;

            int startIndex = index * LINE_LENGTH;
            int endIndex = 1 + startIndex + LINE_LENGTH;

            try {
                return result.substring(startIndex, endIndex);
            } catch (StringIndexOutOfBoundsException e) {
                return result.substring(startIndex);
            }
        }
    }

    public PrinterResult convert(String input) {
        PuzzleGenerator pg = new PuzzleGenerator();
        PrettyPrinter pp = new PrettyPrinter();

        Grid grid = pg.generateGrid(input);
        String output = pp.convert(grid);

        PrinterResult pr = new PrinterResult();
        pr.setResult(output);

        return pr;
    }
}
