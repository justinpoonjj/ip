import java.util.Arrays;
import java.util.Scanner;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        int index = 0;
        String[] list = new String[100];
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
                for (int i = 0; i < index; i++) {
                    System.out.println(i + ". " + list[i]);

                }
                System.out.println("_____________________________________________________________");
            }
            else {
                System.out.println("_____________________________________________________________");
                System.out.println(userInput);
                System.out.println("_____________________________________________________________");
                list[index] = userInput;
                index++;
            }
            userInput = input.nextLine();
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Buh bye. Hope to see you again soon!");
        System.out.println("_____________________________________________________________");
    }
}
