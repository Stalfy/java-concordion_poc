package grid.element.impl;

import grid.element.Cell;

public class GuessCell extends Cell {

    public GuessCell() {
        super();
    }

    @Override
    public Cell setValue(int value) {
        // Become immutable after setting the value.
        return new ImmutableGuessCell(value);
    }

    @Override
    public void setNotes(String notes) {
        // Do nothing.
    }
}
