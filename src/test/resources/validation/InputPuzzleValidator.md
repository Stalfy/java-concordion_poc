# InputPuzzleValidator

The InputPuzzleValidator must verify that the given puzzle is supported by the solving system.

### [PuzzleValidation](- "PuzzleValidationSuite")
Only two criterias are required for a puzzle to be considered valid:  
    1. The input must be 81 characters long.  
    2. The input must contain only the characters 0 to 9. 0 means an empty square in the initial state of the puzzle.  

The following table gives some valid and invalid inputs:

| [validate][][Input][input]                                                                      | Description                             | [Valid input][valid] | [Invalidity reason][message] |
| :--------------------------------------------------------------------------------------------   | :-------------------------------------: | :------------------: | :--------------------------: |
| 000000000000000000000000000000000000000000000000000000000000000000000000000000000|                Empty grid, no hints.                   | true                 | (null)                       |
| 00000000000000000000000000000000000000000000000000000000000000000000000000000000000|              83 characters input, 81 required.       | false                | Invalid input puzzle.        |
| 000000000000000000000000000000000000000000000000000000000000000000000000000000|                   78 characters input, 81 required.       | false                | Invalid input puzzle.        |
| 010000000000000300000000000000050000000000000006000000000000090000000000080000000|                Some hints allowed.                     | true                 | (null)                       |
| 0000000000000000000000000000000 0000000000000000000000000000000000000000000000000|                Contains a space, an illegal character. | false                | Invalid input puzzle.        |
| 0000000000000000000000000000000abc00000000000000000000000000000000000000000000000|                Contains letters, illegal characters.   | false                | Invalid input puzzle.        |
| aa000000000000000000000000000000000000000000000000000000000000000000000000000000000|              Extra characters at the start.          | false                | Invalid input puzzle.        |
| 000000000000000000000000000000000000000000000000000000000000000000000000000000000bb|              Extra characters at the end.            | false                | Invalid input puzzle.        |

[input]: - "#input"
[validate]: - "#result = validateInput(#input)"
[valid]: - "?=#result.validInput"
[message]: - "?=#result.message"
