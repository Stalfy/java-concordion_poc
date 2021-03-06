package grid.element.impl;

import grid.element.Cell;

public class HintCell extends Cell {

    public HintCell() {}

    @Override
    public Cell setValue(int value) {
        // Become immutable upon setting the value.
        return new ImmutableHintCell(value);
    }

    @Override
    public void setNotes(String notes) {
        // As per requirements, the value cannot be changed.
    }
}
