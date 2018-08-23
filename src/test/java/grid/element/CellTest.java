package grid.element;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import grid.element.impl.GuessCell;
import grid.element.impl.HintCell;
import grid.element.impl.NotesCell;


@RunWith(ConcordionRunner.class)
public class CellTest {
    
    public boolean changeGuessCellValue() {
        Cell cell = new GuessCell(1);
        cell.setValue(3);

        return 1 == cell.getValue();
    }

    public boolean changeGuessCellNotes() {
        Cell cell = new GuessCell(4);
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }

    public boolean changeHintCellValue() {
        Cell cell = new HintCell(4);
        cell.setValue(3);

        return 4 == cell.getValue();
    }

    public boolean changeHintCellNotes() {
        Cell cell = new HintCell(4);
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }

    public boolean changeNotesCellValue() {
        Cell cell = new NotesCell();
        cell.setValue(1);

        return 0 == cell.getValue();
    }
}
