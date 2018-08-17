package grid.element;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import grid.element.impl.GuessCell;
import grid.element.impl.HintCell;


@RunWith(ConcordionRunner.class)
public class CellTest {

    public boolean modifyHintCellValue() {
        Cell cell = new HintCell(4);
        cell.setValue(3);

        return 4 == cell.getValue();
    }

    public boolean modifyHintCellNotes() {
        Cell cell = new HintCell(4);
        cell.setNotes("1234567");

        return null == cell.getNotes();
    }
    
    public boolean modifyGuessCellValue() {
        Cell cell = new GuessCell();

        cell.setNotes("192736");
        cell.setValue(3);

        return cell.getNotes().isEmpty();
    }
}
