package duke.command;

import duke.exception.InvalidCommandFormatException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Message;

public class FindCommand implements Command {
    private String command;

    public FindCommand(String command) {
        this.command = command;
    }

    @Override
    public Message execute(TaskList taskList, Storage storage) throws InvalidCommandFormatException {
        if (command.length() <= 5) {
            throw new InvalidCommandFormatException("Please enter the keywords you are searching for.");
        }
        String keyword = command.substring(5).trim();
        return taskList.find(keyword);
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof FindCommand) {
            return this.command.equals(((FindCommand) obj).command);
        } else {
            return false;
        }
    }
}
