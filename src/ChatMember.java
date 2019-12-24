import java.util.Scanner;

public class ChatMember {

    User user = new User();

    public void memberCall() throws InterruptedException {

        System.out.println("Enter number of members.");
        Scanner sc1 = new Scanner(System.in);
        int memberSum = sc1.nextInt();
        String[] memberNameList = new String[memberSum];

        while (memberSum > 0) {
            int index = 1 + (int) (Math.random() * memberSum - 1);
            if (memberNameList[index] == null) {
                System.out.println("\n" + "Enter your name.");
                Scanner sc2 = new Scanner(System.in);
                String memberName = sc2.nextLine();
                memberNameList[index] = memberName;
            } else {
                Thread.sleep(1000);
                System.out.println("\n" + memberNameList[index] + " is typing again.");
            }
            System.out.println("\n" + "Press number for action.");
            memberSum = workWithInputNumber(sc1.next(), index, user.getDate(), memberSum, memberNameList);
        }
    }


    public int workWithInputNumber(String forAct, int index, String date, int memberSum, String[] memberNameList) throws InterruptedException {

        Scanner sc4 = new Scanner(System.in);
        while (!Character.isDigit(forAct.charAt(0)) || Integer.parseInt(forAct) < 1 || Integer.parseInt(forAct) > 2) {
            System.out.println("Invalid input!");
            forAct = sc4.nextLine();
        }

        switch (forAct) {
            case ("1"):
                System.out.println("Send message.");
                Scanner scanner3 = new Scanner(System.in);
                String messageText = scanner3.nextLine();
                User user = new User(index, date, memberNameList[index], messageText);
                System.out.println(user);
                break;
            case ("2"):
                System.out.println("Exit chat.");
                Thread.sleep(1000);
                memberNameList[index] = null;
                memberSum--;
        }
        return memberSum;
    }
}