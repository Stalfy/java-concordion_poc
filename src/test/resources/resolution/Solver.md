# Solver
The solver's responsibility is to solve the grid.  

For all examples, refer to the following grid where 0s represent empty cells:  

| Line \\ Column | 1  2  3 | 4  5  6 | 7  8  9 |
| -------------: | :-----: | :-----: | :-----: |
| 1              | 0  0  8 | 3  0  0 | 0  0  0 |
| 2              | 6  0  7 | 0  0  8 | 0  4  3 |
| 3              | 0  2  3 | 0  0  6 | 5  9  0 |
| ============== | ======= | ======= | ======= |
| 4              | 0  3  0 | 0  7  0 | 0  5  9 |
| 5              | 7  0  0 | 6  0  3 | 0  0  2 |
| 6              | 5  6  0 | 0  8  0 | 0  7  0 |
| ============== | ======= | ======= | ======= |
| 7              | 0  7  6 | 4  0  0 | 8  1  0 |
| 8              | 2  4  0 | 8  0  0 | 9  0  6 |
| 9              | 0  0  0 | 0  0  5 | 7  0  0 |
           
### [Process of resolution](- "ProcessSuite")  
The solver functions in a very simple three steps process, and repeats it until it cannot do so anymore.  

#### 1. Set the notes of all NotesCells to all possible values  
At this step, the solver [adds](- "#result=addNotes()") the notes to every NotesCell.  
After this step, every notes cell should have "[123456789](- "?=#result")" as its notes.

#### 2. Update the notes in the NotesCells using the NotesUpdater  
At this step, the [NotesUpdater](./NotesUpdater.html) removes all used values from possible value candidates.  
See the NotesUpdater page for further details.

#### 3. Replace NotesCells with a single value in its notes by GuessCells containing this note as a value  
Finally, the notes cell with a single value in its notes get replaced by a GuessCell with this value.
For example, cell C[8](- "#col")R[5](- "#row"), after one [pass](- "#result=singleStep(#col, #row)"), will have a value of [8](- "?=#result").

 
### [Outcomes](- "OutcomesSuite")  
Only two outcomes are possible for this solver.  

#### A. The puzzle is unsolvable
If the grid still contains NotesCells after the [resolution process](- "#result=solveBadGrid()"), the solver will return a "[Puzzle cannot be solved.](- "?=result")" message.

#### B. The puzzle is solved
If the grid contains no NotesCells after the [resolution process](- "#result=solveGoodGrid()"), the solver will send a "[Puzzle solved.](- "?=result")" message.
