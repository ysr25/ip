package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ListCommand implements Command {
    String[] command;

    public ListCommand(String[] command) {
        this.command = command;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if (command.length == 1) {
            taskList.showList(ui);
        } else if (command.length == 2) {
            try {
                LocalDate date = LocalDate.parse(command[1]);
                taskList.showList(date, ui);
            } catch (DateTimeException e) {
                throw new DukeException("Please provide date in yyyy-mm-dd format.");
            }
        } else {
            throw new DukeException("Wrong format.");
        }
    }

    public boolean isDone() {
        return false;
    }
}
