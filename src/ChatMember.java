import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatMember {

    public void memberCall()throws InterruptedException{
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        String data = f.format(new Date());

        String[] arr = {"Vardan", "Lusine", "Matrin", "Nona", "Narek"};

        for(int i = 0; i < 5; i++){
            Thread.sleep(1000);
            System.out.println("\n" + "Press Number for action.");
            Scanner scanner1 = new Scanner(System.in);
            int num = scanner1.nextInt();
            String text = "";

            switch(num){
                case(1):
                    Thread.sleep(1000);
                    System.out.println("Send message.");
                    Scanner scanner2 = new Scanner(System.in);
                    text = scanner2.nextLine();
                    break;
                case(2):
                    Thread.sleep(1000);
                    System.out.println("Exit chat.");
                    i = 5;
                    break;
            }
            User user = new User(i+1, data, arr[i], text);
            System.out.println(user);
        }
    }
}
