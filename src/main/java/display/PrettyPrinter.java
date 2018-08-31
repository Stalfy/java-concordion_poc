package display;

import java.util.Collection;

import grid.Grid;

public class PrettyPrinter {
    
    private final int REGION_DIM = 3;
    private final int FORMATTED_LINE_LENGTH = 12;
    private final String LINE_SEPARATOR = "---+---+---\n";

    public PrettyPrinter() {}

    public String convert(Grid grid) {
        StringBuilder output = new StringBuilder();
        
        // Fetch the values.
        grid.getRows().stream().flatMap(Collection::stream).forEach((x) -> output.append(x.getValue()));

        // Add vertical separators.
        // Going backwards help to not keep track of the additions.
        int cursor = output.length();
        while(cursor > REGION_DIM) {
            cursor -= REGION_DIM;
            output.insert(cursor, "|");

            cursor -= REGION_DIM;
            output.insert(cursor, "|");

            cursor -= REGION_DIM;
            output.insert(cursor, "\n");
        }

        // Add Horizontal Separators.
        // +1 because the last line does not contain a linebreak char.
        int step = REGION_DIM * FORMATTED_LINE_LENGTH;
        cursor = 1 + output.length();
        while(cursor > 1 + step) {
            cursor -= step;
            output.insert(cursor, LINE_SEPARATOR);
        } 

        return output.toString();
    }
}
