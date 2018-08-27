package grid.element;

import java.util.function.Supplier;
import java.util.Objects;

import grid.element.impl.GuessCell;
import grid.element.impl.HintCell;
import grid.element.impl.NotesCell;

public enum CellTypes {

    GUESS_CELL(GuessCell::new),
    HINT_CELL(HintCell::new),
    NOTES_CELL(NotesCell::new);

    public final Supplier<Cell> factory;

    CellTypes(Supplier<Cell> factory) {
        this.factory = Objects.requireNonNull(factory);
    }
}
