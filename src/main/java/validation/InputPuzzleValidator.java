package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.validation.InvalidInputException;

public class InputPuzzleValidator {
   
    private final String EXPRESSION = "^[0-9]{81}$";

    public InputPuzzleValidator() {}

    public String validate(String input) throws InvalidInputException {
        Pattern pattern = Pattern.compile(EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        matcher.results().findFirst().orElseThrow(() -> new InvalidInputException("Invalid input puzzle."));
        return input;
    }
}
