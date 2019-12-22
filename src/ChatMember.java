import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatMember {

    public void memberCall()throws InterruptedException{
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String data = f.format(new Date());
        Scanner sc1 = new Scanner(System.in);
        int memberNum = sc1.nextInt();

        String[] text = new String[memberNum];

        for(int i = 0; i < memberNum; i++){
            System.out.println("\n" + "Enter your name.");
            Scanner sc2 = new Scanner(System.in);
            String memberName = sc2.nextLine();
            Thread.sleep(1000);
            System.out.println("\n" + "Press number for action.");
            Scanner sc3 = new Scanner(System.in);
            int forAct = sc3.nextInt();

            if(forAct > 2 || forAct < 1){
                System.out.println("Invalid input.");
                i -= 1;
            }

            switch(forAct){
                case(1):
                    Thread.sleep(1000);
                    System.out.println("Send message.");
                    Scanner scanner3 = new Scanner(System.in);
                    text[i] = scanner3.nextLine();

                        User user = new User(i+1, data, memberName, text[i]);
                        System.out.println(user);
                    break;
                case(2):
                    Thread.sleep(1000);
                    System.out.println("Exit chat.");
            }
        }
    }
}
