package grid.element.impl;

import grid.element.Cell;

public class GuessCell extends Cell {

    public GuessCell() {
        super();
    }

    @Override
    public void setValue(int value) {
        this.notes = "";
        this.value = value;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
