# Shapes
Shapes are fun!

### [Squares](- "square")
Area tests:

| [getArea][][Width][width] | [Expected Area][area] | [No Failed Assertions][success] | [Error Message][message] |
| :-----------------------: | :----------:          | :-----------------------------: | :----------------------: |
| -1                        | 0                     | true                            | (null)                   |
| 0                         | 0                     | true                            | (null)                   |
| 1                         | 1                     | true                            | (null)                   |
| 5                         | 25                    | true                            | (null)                   |

[getArea]: - "#result = getArea(#width)"
[width]:   - "#width"
[area]:    - "?=#result.area"
[success]: - "?=#result.passed"
[message]: - "?=#result.message"
