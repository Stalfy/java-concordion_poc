# Cell
A cell is the basic unit used in the grid. 
Cells are POJO objects responsible for holding a value and notes.  

### [GuessCell](- "GuessCellSuite")
The GuessCell is the cell that can be modified by the solver in order to fill the grid.  
Setting the value of a GuessCell will [clear its notes](- "c:assert-true=modifyGuessCellValue()").

### [HintCell](- "HintCellSuite")
The HintCell is the cell that contains hints towards solving the puzzle.  
This grid element is also a POJO, so it should contain no logic.

This cell contains a value at creation and [this value cannot be changed](- "c:assert-true=modifyHintCellValue()").  

Notes [cannot be added](- "c:assertTrue=modifyHintCellNotes()") to a HintCell.
