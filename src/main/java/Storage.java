import Parser.Parser;
import TaskType.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Scanner;
import Exception.CapoException;

public class Storage {
    private final String filePath;
    private final File file;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public int Status(Task t) {
        if (t.getStatusIcon().equals("X")) {
            return 1;
        }
        return 0;
    }

    public String parseEvent(String input) {
        int open = input.indexOf('(');
        int close = input.indexOf(')',open);

        String description = input.substring(0,open).trim();
        String inside = input.substring(open+1,close).trim();
        inside = inside.substring("from:".length()).trim();
        int toIndex = inside.indexOf("to:");
        String from = inside.substring(0,toIndex).trim();
        String to = inside.substring(toIndex+3).trim();
        return description+ " /from " +from+ " /to " +to;
    }

    public String parseDeadline(String input) {
        int open = input.indexOf('(');
        int close = input.indexOf(')',open);
        String description = input.substring(0,open).trim();
        String inside = input.substring(open+1,close).trim();
        String by = inside.substring("by:".length());
        return description + " /by " +by;
    }

    public String fileWrite(TaskList list) {
        StringBuilder content = new StringBuilder();
        for (Task t : list) {
            content.append(t.taskType());
            content.append(" | ");
            content.append(Status(t));
            content.append(" | ");
            switch (t.taskType()) {
            case "T":
                content.append(t.getDescription());
                break;
            case "D":
                content.append(parseDeadline(t.getDescription()));
                break;
            case "E":
                content.append(parseEvent(t.getDescription()));
                break;
            }

            content.append("\n");
        }
        return content.toString();
    }

    public TaskList loadFile() throws CapoException, IOException {
        TaskList list = new TaskList();

        if (!file.exists()){
            File parent = file.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }
            file.createNewFile();
            return list;
        }

        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            System.out.println(line);
            Task t = Parser.parseStoredFile(line);
            list.add(t);
        }
        s.close();
        return list;
    }

    public void saveFile(TaskList list) throws IOException {
        File parent = file.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        try (FileWriter fw = new FileWriter(filePath)) {
            String content = fileWrite(list);
            fw.write(content);
        }
    }
}
