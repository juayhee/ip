/**
 * Generates the correct type of task and adds it to the task list
 */

public class AddTaskCommand extends Command {

    private String input; // Details of the task
    private String type; // Type of task

    public AddTaskCommand(String input, String type) {
        this.input = input;
        this.type = type;
    }

    /**
     * Formats the echo for the task that was added to the user as confirmation
     * @return Formatted echo
     */
    private String formatOutput(Task newTask) {
        String response = "added: " + newTask.toString();
        String formattedString = Duke.indent(response, 1);
        String finalFormatted = Duke.formatLines(formattedString);

        return finalFormatted;
    }

    @Override
    public void execute() {
        Task newTask;
        if (this.type.equals("todo")) {
            newTask = new TodoTask(this.input);
        } else if (this.type.equals("deadline")) {
            newTask = new DeadlineTask(this.input);
        } else if (this.type.equals("event")) {
            newTask = new EventTask(this.input);
        } else {
            newTask = null;
        }

        // Adding task to TaskManager
        TaskManager.taskList.add(newTask);

        // System prints
        String output = formatOutput(newTask);
        System.out.println(output);
    }
}
