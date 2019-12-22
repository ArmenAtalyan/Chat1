import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatMember {

    public void memberCall()throws InterruptedException{
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String data = f.format(new Date());
        Scanner sc1 = new Scanner(System.in);
        int memberSum = sc1.nextInt();
        String[] memberNumList = new String[memberSum];

        while(memberSum > 0){
           int index = 1 + (int)(Math.random() * memberSum - 1);
           if(memberNumList[index] == null) {
                System.out.println("\n" + "Enter your name.");
                Scanner sc2 = new Scanner(System.in);
                String memberNume = sc2.nextLine();
                memberNumList[index] = memberNume;
            }
           else{
               Thread.sleep(1000);
               System.out.println("\n" + memberNumList[index] + " is typing again.");
           }
            Thread.sleep(1000);
            System.out.println("\n" + "Press number for action.");
            Scanner sc3 = new Scanner(System.in);
            int forAct = sc3.nextInt();
            memberSum = workWithMemberCall(forAct, index, data, memberSum, memberNumList);
        }
    }


    public int workWithMemberCall(int forAct, int index, String data, int memberSum, String[] memberNumList) throws InterruptedException{
        if(forAct > 2 || forAct < 1){
            System.out.println("Invalid input.");
            Thread.sleep(1000);
            System.out.println("\n" + "Press again number for action.");
            Scanner sc4 = new Scanner(System.in);
            forAct = sc4.nextInt();
            index -= 1;
        }
        switch(forAct){
            case(1):
                Thread.sleep(1000);
                System.out.println("Send message.");
                Scanner scanner3 = new Scanner(System.in);
                String messageText = scanner3.nextLine();
                User user = new User(index, data, memberNumList[index], messageText);
                System.out.println(user);
                break;
            case(2):
                Thread.sleep(1000);
                System.out.println("Exit chat.");
                memberNumList[index] = null;
                memberSum --;
        }
        return memberSum;
    }
}
