# Cell
A cell is the basic unit used in the grid. 
Cells are POJO objects responsible for holding a value and notes.  

### [NotesCell](- "NotesCellSuite")
The NotesCell allows to take notes about the possible values available for the cell.  
A value [cannot be added](- "c:assert-true=changeNotesCellValue()") to a NotesCell.

### [GuessCell](- "GuessCellSuite")
The GuessCell is the cell that can be modified by the solver in order to fill the grid.  
The value of a GuessCell [cannot be changed](- "c:assertTrue=changeGuessCellValue()").  
Notes [cannot be added](- "c:assertTrue=changeGuessCellNotes()") to a GuessCell.

### [HintCell](- "HintCellSuite")
The HintCell is the cell that contains hints towards solving the puzzle.  
The value of a hint cell [cannot be changed](- "c:assert-true=changeHintCellValue()").  
Notes [cannot be added](- "c:assertTrue=changeHintCellNotes()") to a HintCell.
