# Classic Grid
A classic grid is the representation of a classic Sudoku grid.  
The classic grid is a 9x9 square divided in 9 regions of size 3x3.

### [Puzzle Creation](- "PuzzleCreationSuite")
[Sample Passing Test](- "c:assert-true=true")  
[Sample Failing Test](- "c:assert-true=false")

The creation of the string will be handled via the setPuzzle(String puzzle) method.  
The input parameter is a simple String object of 81 characters.

This string should only contain the following characters:
<ul>
    <li>The character 0, which reprensents an empty cell;</li>
    <li>The characters 1-9, the accepted values of the sudoku grid.</li>
</ul>
