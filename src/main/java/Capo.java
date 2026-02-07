import java.util.Scanner;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        int index = 0;
        Task[] list = new Task[100];
        Scanner input = new Scanner(System.in);

        greetings();
        userInput = input.nextLine();
        while (true) {
            String[] splitUserInput = userInput.split(" ");
            if (userInput.equals("bye")) {
                break;
            }
            else if (userInput.equals("list")) {
                printTaskList(list,index);
            }
            else if (userInput.startsWith("unmark")) {
                printUnmarkedTask(splitUserInput,list);
            }
            else if (userInput.startsWith("mark")) {
                printMarkedTask(splitUserInput,list);
            }
            else {
                String keyword = splitUserInput[0];
                index = addTask(keyword,userInput,list,index);
            }
            userInput = input.nextLine();
        }
        farewell();
    }

    public static void printTaskList(Task[] list, int index) {
        System.out.println("_____________________________________________________________");
        System.out.println("Here are your list of tasks");
        for (int i = 0; i < index; i++) {
            list[i].printList(i);
        }
        System.out.println("_____________________________________________________________");
    }

    public static void printMarkedTask(String[] userInput, Task[] list){
        int index = Integer.parseInt(userInput[1]) - 1;
        list[index].setIsDone(true);
        System.out.println("_____________________________________________________________");
        System.out.println("Alrighty!! I've marked this task as done:");
        System.out.println("[" + list[index].taskType() + "]" + "[" + list[index].getStatusIcon() + "] " + list[index].getDescription());
        System.out.println("_____________________________________________________________");
    }

    public static void printUnmarkedTask(String[] userInput, Task[] list) {
        int index = Integer.parseInt(userInput[1]) - 1;
        list[index].setIsDone(false);
        System.out.println("_____________________________________________________________");
        System.out.println("OK!! This task shall be marked as not done yet");
        System.out.println("[" + list[index].taskType() + "]"+"["+list[index].getStatusIcon()+"] " + list[index].getDescription());
        System.out.println("_____________________________________________________________");
    }

    public static int addTask(String keyword, String userInput, Task[] list, int index) {
        Task t;
        switch (keyword) {
        case "todo":
            t = new Todo(userInput.substring(keyword.length() + 1));
            break;
        case "deadline":
            t = new Deadline(userInput.substring(keyword.length() + 1));
            break;
        case "event":
            t = new Event(userInput.substring(keyword.length() + 1));
            break;
        default:
            System.out.println("Invalid task type");
            return index;
        }
        list[index] = t;
        t.printMessage(index);
        return index+1;
    }

    public static void greetings() {
        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
    }

    public static void farewell() {
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");
    }
}
