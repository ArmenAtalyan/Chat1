import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatMember {

    public void memberCall()throws InterruptedException{
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String data = f.format(new Date());

        System.out.println("Enter number of members.");
        Scanner sc1 = new Scanner(System.in);
        int memberSum = sc1.nextInt();
        String[] memberNameList = new String[memberSum];

        while(memberSum > 0){
           int index = 1 + (int)(Math.random() * memberSum - 1);
           if(memberNameList[index] == null) {
                System.out.println("\n" + "Enter your name.");
                Scanner sc2 = new Scanner(System.in);
                String memberName = sc2.nextLine();
                memberNameList[index] = memberName;
            }
             else{
               Thread.sleep(1000);
               System.out.println("\n" + memberNameList[index] + " is typing again.");
           }
            System.out.println("\n" + "Press number for action.");
            Scanner sc3 = new Scanner(System.in);
            while (!sc3.hasNextInt()) {
                System.out.println("That's not a number!");
                sc3.next();
            }
            int forAct = sc3.nextInt();
            memberSum = workWithInputNumber(forAct, index, data, memberSum, memberNameList);
        }
    }


    public int workWithInputNumber(int forAct, int index, String data, int memberSum, String[] memberNameList) throws InterruptedException{
        while (forAct < 1 || forAct > 2) {
            System.out.println("Invalid input.");
            System.out.println("Input 1 or 2.");
            Thread.sleep(1000);
            System.out.println("\n" + "Press again number for action.");
            Scanner sc4 = new Scanner(System.in);
            forAct = sc4.nextInt();
        }
        switch(forAct){
            case(1):
                System.out.println("Send message.");
                Scanner scanner3 = new Scanner(System.in);
                String messageText = scanner3.nextLine();
                User user = new User(index, data, memberNameList[index], messageText);
                System.out.println(user);
                break;
            case(2):
                System.out.println("Exit chat.");
                Thread.sleep(1000);
                memberNameList[index] = null;
                memberSum --;
        }
        return memberSum;
    }
}
