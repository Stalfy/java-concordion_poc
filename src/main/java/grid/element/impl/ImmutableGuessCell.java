package grid.element.impl;

import grid.element.Cell;

public class ImmutableGuessCell extends Cell {

    public ImmutableGuessCell(int value) {
        super(value);
    }

    @Override
    public Cell setValue(int value) {
        // Do nothing.
        return this;
    }

    @Override
    public void setNotes(String notes) {
        // Do nothing.
    }
}
