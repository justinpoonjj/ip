import java.util.Scanner;

public class Capo {
    public static void main(String[] args) {
        String userInput;
        Scanner input = new Scanner(System.in);

        System.out.println("_____________________________________________________________");
        System.out.println("Hello! I'm CAPO\nWhat can I do for you?\n");
        System.out.println("_____________________________________________________________");
        do {
            userInput = input.nextLine();
            System.out.println("_____________________________________________________________");
            System.out.println(userInput);
            System.out.println("_____________________________________________________________");
        }
        while(!userInput.equals("bye"));
        System.out.println("Buh bye. Hope to see you again soon!");
    }
}
