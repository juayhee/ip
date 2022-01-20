import java.util.ArrayList;

/**
 * Marks the indicated task as undone
 */
public class UnmarkCommand extends Command {
    private String input; // Parameters: 1
    public ArrayList<Task> taskList = TaskManager.taskList;

    public UnmarkCommand(String i) {
        this.input = i;
    }

    @Override
    public void execute() {
        int index = Integer.parseInt(input) - 1; // -1 because list starts at 1 while indexes start at 0
        taskList.get(index).unmarkAsDone();

    }
}