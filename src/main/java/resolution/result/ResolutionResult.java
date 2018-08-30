package resolution.result;

import grid.Grid;

public class ResolutionResult {

    private String message;
    private Grid resultGrid;

    public ResolutionResult() {}

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Grid getResultGrid() {
        return this.resultGrid;
    }

    public void setResultGrid(Grid resultGrid) {
        this.resultGrid = resultGrid;
    }
}
