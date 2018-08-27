# Cell
A cell is the basic unit used in the grid. 
Cells are POJO objects responsible for holding a value and notes.  

### [GuessCell](- "GuessCellSuite")
The GuessCell is a cell set by the solver in order to fill the grid.  
After setting its value, a [GuessCell](- "#result=changeGuessCellValue()") becomes an [ImmutableGuessCell](- "?=#result").  
Notes [cannot be added](- "c:assertTrue=changeGuessCellNotes()") to a GuessCell.

### [ImmutableGuessCell](- "ImmutableGuessCellSuite")
An ImmutableGuessCell is a GuessCell whose value has been set.  
The value of an ImmutableGuessCell [cannot be changed](- "c:assert-true=changeImmutableGuessCellValue()").  
Notes [cannot be added](- "c:assertTrue=changeImmutableGuessCellNotes()") to an ImmutableGuessCell.

### [HintCell](- "HintCellSuite")
The HintCell is the cell that contains hints towards solving the puzzle.  
After setting its value, a [HintCell](- "#result=changeHintCellValue()") becomes an [ImmutableHintCell](- "?=#result").  
Notes [cannot be added](- "c:assertTrue=changeHintCellNotes()") to a HintCell.

### [ImmutableHintCell](- "ImmutableHintCellSuite")
An ImmutableHintCell is a HintCell whose value has been set.  
The value of an ImmutableHintCell [cannot be changed](- "c:assert-true=changeImmutableHintCellValue()").  
Notes [cannot be added](- "c:assertTrue=changeImmutableHintCellNotes()") to an ImmutableHintCell.

### [NotesCell](- "NotesCellSuite")
The NotesCell allows to take notes about the possible values available for the cell.  
A value [cannot be added](- "c:assert-true=changeNotesCellValue()") to a NotesCell.
