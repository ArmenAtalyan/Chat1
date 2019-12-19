import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatMember {

    public void memberCall()throws InterruptedException{
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String data = f.format(new Date());
        int memNum = 5;

        String[] name = {"Vardan", "Lusine", "Matrin", "Nona", "Narek"};
        String[] text = new String[memNum];

        for(int i = 0; i < memNum; i++){
            Thread.sleep(1000);
            System.out.println("\n" + "Press number for action.");
            Scanner scanner1 = new Scanner(System.in);
            int num = scanner1.nextInt();

            if(num > 2 || num < 1)
                System.out.println("Invalid input.");
            switch(num){
                case(1):
                    Thread.sleep(1000);
                    System.out.println("Send message.");
                    Scanner scanner2 = new Scanner(System.in);
                    text[i] = scanner2.nextLine();
                    break;
                case(2):
                    Thread.sleep(1000);
                    System.out.println("Exit chat.");
                    i = 5;
                    break;
            }
        }
        for(int i = 0; i < memNum; i++){
            User user = new User(i+1, data, name[i], text[i]);
            System.out.println(user);
        }
    }
}
