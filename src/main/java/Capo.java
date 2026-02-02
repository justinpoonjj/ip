import java.util.Arrays;
import java.util.Scanner;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        int index = 0;
        Task[] list = new Task[100];
        Scanner input = new Scanner(System.in);

        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
        userInput = input.nextLine();
        while (true) {
            if (userInput.equals("bye")) {
                break;
            }
            else if (userInput.equals("list")) {
                System.out.println("_____________________________________________________________");
                System.out.println("Here are your list of tasks");
                for (int i = 0; i < index; i++) {
                    System.out.println((i+1) + ".[" + list[i].getStatusIcon() + "] " + list[i].getDescription());

                }
                System.out.println("_____________________________________________________________");
            }
            else if (userInput.contains("unmark")) {
                String[] splitUserInput = userInput.split(" ");
                int item = Integer.parseInt(splitUserInput[1]);
                list[item].setIsDone(false);
                System.out.println("_____________________________________________________________");
                System.out.println("OK!! This task shall be marked as not done yet");
                System.out.println("["+list[item].getStatusIcon()+"] " + list[item].getDescription());
                System.out.println("_____________________________________________________________");
            }
            else if (userInput.contains("mark")) {
                String[] splitUserInput = userInput.split(" ");
                int item = Integer.parseInt(splitUserInput[1]) - 1;
                list[item].setIsDone(true);
                System.out.println("_____________________________________________________________");
                System.out.println("Alrighty!! I've marked this task as done:");
                System.out.println("[" + list[item].getStatusIcon() + "] " + list[item].getDescription());
                System.out.println("_____________________________________________________________");
            }
            else {
                System.out.println("_____________________________________________________________");
                System.out.println(userInput);
                System.out.println("_____________________________________________________________");
                Task t = new Task(userInput);
                list[index] = t;
                index++;
            }
            userInput = input.nextLine();
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");

    }
}
