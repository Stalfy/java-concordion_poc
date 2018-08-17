package grid.element.impl;

import grid.element.Cell;

public class HintCell extends Cell {

    public HintCell(int value) {
        super(value);
    }

    @Override
    public void setValue(int value) {
        // As per requirements, the value cannot be changed.
    }

    @Override
    public void setNotes(String notes) {
        // As per requirements, the value cannot be changed.
    }
}
