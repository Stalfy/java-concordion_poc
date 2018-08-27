package grid.element.impl;

import grid.element.Cell;

public class NotesCell extends Cell {

    public NotesCell() {
        super();
    }

    @Override
    public Cell setValue(int value) {
        // Do nothing.
        return this;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
