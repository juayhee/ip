/**
 * Decides which type of command to generate given user input
 */
public class CommandFactory {

    /**
     * Extracts the command portion of the input provided by the user (usually first word)
     *
     * @param input Input from the user
     * @return One word string
     */
    private String isolateCommand(String input) {
        int whiteSpaceIndex = input.indexOf(" "); // Index of first whitespace
        if (whiteSpaceIndex == -1) { // If the input string has no whitespaces (i.e. one word)
            return input;
        }
        return input.substring(0, whiteSpaceIndex);
    }

    /**
     * Extracts the command parameters portion of the input provided by the user (stuff after first word)
     *
     * @param input Input from the user
     * @return Multiple-word string
     */
    private String isolateParameters(String input) {
        int whiteSpaceIndex = input.indexOf(" "); // Index of first whitespace
        if (whiteSpaceIndex == -1) { // If the input string has no whitespaces (i.e. one word)
            return null;
        }
        return input.substring(whiteSpaceIndex + 1); // Return the rest of the word, starting from after whitespace
    }

    /**
     * Generates the appropriate command type given the input
     *
     * @param input Input from the user
     * @return Value of parent type Command
     */
    public Command makeCommand(String input) {
        String commandWord = isolateCommand(input);
        String commandParameters = isolateParameters(input);

        if (commandWord.equals("bye")) {
            return new ByeCommand();
        } else if (commandWord.equals("list")) {
            return new ListCommand();
        } else if (commandWord.equals("mark")) {
            return new MarkCommand(commandParameters);
        } else if (commandWord.equals("unmark")) {
            return new UnmarkCommand(commandParameters);
        } else {
            return new AddTaskCommand(input);
        }
    }
}
