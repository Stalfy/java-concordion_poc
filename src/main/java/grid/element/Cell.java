package grid.element;

public abstract class Cell {

    protected int value;
    protected String notes;

    protected Cell() {}

    protected Cell(int value) {
        this.value = value;
    }

    public abstract void setValue(int value);

    public int getValue() {
        return this.value;
    }

    public abstract void setNotes(String notes);

    public String getNotes() {
        return this.notes;
    }
}
