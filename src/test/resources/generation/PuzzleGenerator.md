# PuzzleGenerator

The PuzzleGenerator builds the internal representation of the grid.
Since the [InputPuzzleValidator](../validation/InputPuzzleValidator.html)

### [Generation](- "PuzzleGeneratorSuite")

The puzzle generation can only generate two types of cells: [NotesCells](../grid/element/Cell.html) and [HintCells](../grid/element/Cell.html).  
When the input character is a [0](- "#input"), the generator will [instantiate](- "#result=generateCell(#input)") a [NotesCell](- "?=#result").  
When the input character is between 1 and [9](- "#input"), the generator will [instantiate](- "#result=generateCell(#input)") an [ImmutableHintCell](- "?=#result").
