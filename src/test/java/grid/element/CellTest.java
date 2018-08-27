package grid.element;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import grid.element.impl.GuessCell;
import grid.element.impl.HintCell;
import grid.element.impl.ImmutableGuessCell;
import grid.element.impl.ImmutableHintCell;
import grid.element.impl.NotesCell;


@RunWith(ConcordionRunner.class)
public class CellTest {
    
    public String changeGuessCellValue() {
        Cell cell = new GuessCell();
        cell = cell.setValue(1);

        return cell.getClass().getSimpleName();
    }

    public boolean changeGuessCellNotes() {
        Cell cell = new GuessCell();
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }
    
    public boolean changeImmutableGuessCellValue() {
        Cell cell = new ImmutableGuessCell(1);
        cell = cell.setValue(2);

        return 1 == cell.getValue();
    }

    public boolean changeImmutableGuessCellNotes() {
        Cell cell = new ImmutableGuessCell(1);
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }

    public String changeHintCellValue() {
        Cell cell = new HintCell();
        cell = cell.setValue(4);

        return cell.getClass().getSimpleName();
    }

    public boolean changeHintCellNotes() {
        Cell cell = new HintCell();
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }
    
    public boolean changeImmutableHintCellValue() {
        Cell cell = new ImmutableHintCell(1);
        cell = cell.setValue(2);

        return 1 == cell.getValue();
    }

    public boolean changeImmutableHintCellNotes() {
        Cell cell = new ImmutableHintCell(1);
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }

    public boolean changeNotesCellValue() {
        Cell cell = new NotesCell();
        cell = cell.setValue(1);

        return 0 == cell.getValue();
    }
}
