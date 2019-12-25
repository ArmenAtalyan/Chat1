import java.util.Scanner;

public class ChatMember {

    User user = new User();

    public void memberCall() {

        System.out.println("Enter number of members.");
        Scanner sc1 = new Scanner(System.in);
        int memberSum = sc1.nextInt();
        String[] memberNameList = new String[memberSum];

        while (memberSum > 0) {
            int index = 1+(int)(Math.random()*memberSum - 1);
            if (memberNameList[index] == null) {
                System.out.println("Enter your name.");
                Scanner sc2 = new Scanner(System.in);
                String memberName = sc2.nextLine();
                memberNameList[index] = memberName;
            } else {
                System.out.println("\n" + memberNameList[index] + " is typing.");
            }
            System.out.println("Press number for action.");
            memberSum = workWithInputNumber(sc1.next(), index, user.getDate(), memberSum, memberNameList);
        }
    }


    public int workWithInputNumber(String forAct, int index, String date, int memberSum, String[] memberNameList) {

        Scanner sc4 = new Scanner(System.in);
        while (!Character.isDigit(forAct.charAt(0)) || Integer.parseInt(forAct) < 1 || Integer.parseInt(forAct) > 2) {
            System.out.println("Invalid input!");
            forAct = sc4.nextLine();
        }

        switch (forAct) {
            case ("1"):
                System.out.println("Send message.");
                User user = new User(index, date, memberNameList[index], sc4.nextLine());
                System.out.println(user);
                break;
            case ("2"):
                System.out.println( memberNameList[index] + " Exit chat.");
                memberNameList[index] = null;
                memberSum--;
        }
        return memberSum;
    }
}