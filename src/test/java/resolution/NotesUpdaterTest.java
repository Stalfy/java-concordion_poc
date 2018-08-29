package resolution;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import grid.element.Cell;
import grid.element.impl.GuessCell;
import grid.element.impl.NotesCell;

@RunWith(ConcordionRunner.class)
public class NotesUpdaterTest {

    public boolean updateNotes() {
        Cell cell = new NotesCell();    
    
        List<Cell> listA = new ArrayList<>();
        List<Cell> listB = new ArrayList<>();

        listA.add(cell);
        listB.add(cell);

        listA.get(0).setNotes("123");
        listA.set(0, new GuessCell().setValue(1));


        System.out.println(listA.get(0));
        System.out.println(listB.get(0).getNotes());

        return true;
    }
}
