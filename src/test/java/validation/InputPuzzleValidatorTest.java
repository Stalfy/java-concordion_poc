package validation;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import exception.validation.InvalidInputException;
import validation.InputPuzzleValidator;

@RunWith(ConcordionRunner.class)
public class InputPuzzleValidatorTest {

    private class PuzzleValidationResult {

        private boolean validInput;
        private String message;

        public PuzzleValidationResult() {}

        public boolean isValidInput() {
            return this.validInput;
        }

        public void setValidInput(boolean validInput) {
            this.validInput = validInput;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        } 
    }

    public PuzzleValidationResult validateInput(String input) {
        PuzzleValidationResult result = new PuzzleValidationResult();
        
        try {
            InputPuzzleValidator validator = new InputPuzzleValidator();
            String output = validator.validate(input);
            
            result.setValidInput(input.equals(output));
        } catch (InvalidInputException e) {
            result.setValidInput(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }
}
