package service;
import model.User;
import java.util.Scanner;

public class UserService {

    User user = new User();

    public void memberCall() {

        System.out.println("Please, enter number of members.");
        Scanner scanner = new Scanner(System.in);
        int memberSum = scanner.nextInt();
        String[] memberNameList = new String[memberSum];

        while (memberSum > 0) {
            int index = 1+(int)(Math.random()*memberSum - 1);
            if (memberNameList[index] == null) {
                System.out.println("Enter your name.");
                scanner.nextLine();
                String memberName = scanner.nextLine();
                memberNameList[index] = memberName;
            } else {
                System.out.println("\n" + memberNameList[index] + " is typing again.");
            }
            System.out.println("Press number for action." +
                    "\n" + "'1' to send massage." +
                    "\n" + "'2' to exit chat.");
            memberSum = handleUserAction(scanner.next(), index, memberSum, memberNameList);
        }
    }

    public int handleUserAction(String userAction, int index, int memberSum, String[] memberNameList) {

        Scanner scanner = new Scanner(System.in);
        while (!Character.isDigit(userAction.charAt(0))
                || Integer.parseInt(userAction) < 1
                || Integer.parseInt(userAction) > 2) {
            System.out.println("Invalid input!");
            userAction = scanner.nextLine();
        }

        switch (userAction) {
            case ("1"):
                System.out.println("Send message.");
                user.setId(index);
                user.setName(memberNameList[index]);
                user.setText(scanner.nextLine());
                user.printMassage();
                break;
            case ("2"):
                System.out.println( memberNameList[index] + " Exit chat.");
                memberNameList[index] = null;
                --memberSum;
                break;
        }
        return memberSum;
    }
}