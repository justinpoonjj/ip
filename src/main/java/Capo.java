import java.util.Scanner;

public class Capo {
     public static void main(String[] args) {
        String userInput;
        int index = 0;
        Task[] list = new Task[100];
        Scanner input = new Scanner(System.in);
        int item;

        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
        userInput = input.nextLine();
        while (true) {
            String[] splitUserInput = userInput.split(" ");
            if (userInput.equals("bye")) {
                break;
            }
            else if (userInput.equals("list")) {
                System.out.println("_____________________________________________________________");
                System.out.println("Here are your list of tasks");
                for (int i = 0; i < index; i++) {
                    list[i].printList(i);

                }
                System.out.println("_____________________________________________________________");
            }
            else if (userInput.startsWith("unmark")) {
                item = Integer.parseInt(splitUserInput[1]);
                list[item].setIsDone(false);
                System.out.println("_____________________________________________________________");
                System.out.println("OK!! This task shall be marked as not done yet");
                System.out.println("[" + list[item].taskType() + "]"+"["+list[item].getStatusIcon()+"] " + list[item].getDescription());
                System.out.println("_____________________________________________________________");
            }
            else if (userInput.startsWith("mark")) {
                item = Integer.parseInt(splitUserInput[1]) - 1;
                list[item].setIsDone(true);
                System.out.println("_____________________________________________________________");
                System.out.println("Alrighty!! I've marked this task as done:");
                System.out.println("[" + list[item].getStatusIcon() + "] " + list[item].getDescription());
                System.out.println("_____________________________________________________________");
            }
            else {
                String keyword = splitUserInput[0];
                Task t;
                switch (keyword) {
                case "todo":
                    t = new Todo(userInput.substring(keyword.length() + 1));
                    list[index] = t;
                    t.printMessage(index);
                    index++;
                    break;
                case "deadline":
                    t = new Deadline(userInput.substring(keyword.length() + 1));
                    list[index] = t;
                    t.printMessage(index);
                    index++;
                    break;
                case "event":
                    t = new Event(userInput.substring(keyword.length() + 1));
                    list[index] = t;
                    t.printMessage(index);
                    index++;
                    break;
                }
            }
            userInput = input.nextLine();
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");
    }
}
