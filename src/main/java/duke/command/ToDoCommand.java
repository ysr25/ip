package duke.command;

import java.io.IOException;

import duke.exception.DuplicateTaskException;
import duke.exception.InvalidCommandFormatException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.ToDo;
import duke.ui.Message;

/**
 * Represents a <code>Command</code> telling Duke to create a new <code>ToDo</code>.
 */
public class ToDoCommand implements Command {
    private String command;

    public ToDoCommand(String command) {
        this.command = command;
    }

    @Override
    public Message execute(TaskList taskList, Storage storage) throws InvalidCommandFormatException, IOException {
        try {
            ToDo toDo = createToDo();
            taskList.add(toDo);
            storage.appendToFile(toDo);
            return Message.getTaskAdded(toDo);
        } catch (DuplicateTaskException e) {
            return new Message(e.getMessage());
        }
    }

    ToDo createToDo() throws InvalidCommandFormatException {
        if (command.length() <= 5) {
            throw new InvalidCommandFormatException("ToDo cannot be empty.");
        }
        String content = command.substring(5).trim();
        return new ToDo(content);
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof ToDoCommand) {
            return this.command.equals(((ToDoCommand) obj).command);
        } else {
            return false;
        }
    }
}
