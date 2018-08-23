package grid.element.impl;

import grid.element.Cell;

public class NotesCell extends Cell {

    public NotesCell() {
        super();
    }

    @Override
    public void setValue(int value) {
        // Do nothing.
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
