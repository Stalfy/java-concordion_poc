package grid.element.impl;

import grid.element.Cell;

public class ImmutableHintCell extends Cell {

    public ImmutableHintCell(int value) {
        super(value);
    }

    @Override
    public Cell setValue(int value) {
        // Once the value is set, it cannot be changed.
        return this;
    }

    @Override
    public void setNotes(String notes) {
        // As per requirements, the value cannot be changed.
    }
}
