# NotesUpdater
The notes updater must remove impossible values from the different cells notes.  
The notes update takes two assumptions into account:  
1. Only NotesCells must be updated.  
2. NotesCells notes always have zero or more values in them.

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
           
### [Updating Rows](- "RowsSuite")  
Updating a row will remove all values already present in a row from said row's notes cells.  
Given row 2, represented as [607008043](- "#row"), the [update](- "#result=updateRow(#row)") will leave only the values [1259](- "?=#result") in the notes.  

### [Updating Columns](- "ColumnsSuite")  
Updating a column will remove all values already present in a column from said column's notes cells.  
Given column 8, represented as [049507100](- "#col"), the [update](- "#result=updateCol(#col)") will leave only the values [2368](- "?=#result") in the notes.  

### [Updating Regions](- "RegionsSuite")  
Updating a region will remove all values already present in a region from said region's notes cells.  
Given the top left region, represented as [008607023](- "#region"), the [update](- "#result=updateRegion(#region)") will leave only the values [1459](- "?=#result") in the notes.  

### [Updating crossed lines and columns](- "CrossUpdateSuite")  
The updater will also need to update cells from multiple sources of data.  
For example, the cell at C2R2 will be updated by both column 2 and row 2.  
This notes cell, using only row [2](- "#rowIndex") \([607008043](- "#row")\) and column [2](- "#colIndex") \([002306740](- "#column")\)
to [update](- "#result=crossUpdate(#row, #rowIndex, #col, #colIndex)") shall only have [159](- "?=#result") as its values.

### [Full update](- "FullUpdateSuite")
A full update is when the line, column and region of a cell are used to update the notes.  
Cell C8R5, for example, is in the middle right region.  
Three elements are then used to proceed with the update:  
*  The middle right region, represented as [059002070](- "#region") with the cell at the [5](- "#regPos")th position;  
*  The [8](- "#colIndex")th column, represented as [049507100](- "#column");  
*  The [5](- "#rowIndex")th row, represented as [700603002](- "#row").  
After the [update](- "#result=fullUpdate(#row, #rowIndex, #column, #colIndex, #region, #regPos)"), the notes should be only the value [8](- "?=#result").
