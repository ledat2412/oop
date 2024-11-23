package house.showoff;

import java.util.Scanner;

public class editfile {
    Scanner sc = new Scanner(System.in);
    public void showmenedit() {
        while (true) {
            readfile r = new readfile();
            System.out.println("===============================================================edit===============================================================");
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1.select row to edit                                                                                                            |");
            System.out.println("|0.exit                                                                                                                          |");
            System.out.println("==================================================================================================================================");
            int choice_1 = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choice_1){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("select invalid. Please select again!");
                    break;
            }
            
        }
    }
    public void edit() {
        System.out.println("===============================================================edit===============================================================");

        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|  Enter the part to edit:                                                                                                       |");
        System.out.println("==================================================================================================================================");
        int lineNumber = sc.nextInt();
        System.out.print("\033[2A"); // Di chuyển con trỏ lên 2 dòng
        System.out.print("\033[33C");
        

    }
}
