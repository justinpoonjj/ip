public class Parser {
    public static Commands parse (String userInput) throws CapoException {
        String[] split = userInput.split(" ");
        String keyword = split[0];
        Task t;

        switch(keyword) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            int markIndex = Integer.parseInt(split[1]) - 1;
            return new MarkCommand(markIndex);
        case "unmark":
            int unmarkIndex = Integer.parseInt(split[1]) - 1;
            return new UnmarkCommand(unmarkIndex);
        case "todo":
            if (split.length < 2) {
                throw new CapoException("The description of todo task cannot be empty");
            }
            t = new Todo(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        case "deadline":
            t = new Deadline(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        case "event":
            t = new Event(userInput.substring(keyword.length() + 1));
            return new AddCommand(t);
        default:
            System.out.println("I'm sorry there is no such command. Please try either:");
            System.out.println("- todo\n- deadline\n- event");
        }
        return null;
    }
}
