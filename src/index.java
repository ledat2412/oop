import java.util.Scanner;

import house.showoff.house;
import house.showoff.filterfile;
import people.slave.slavemenu;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        while(true){
            System.out.println ("==================================================================================================================================");
            System.out.println ("|1.no.house                                                                                                                      |");
            System.out.println ("|2.booking                                                                                                                       |");
            System.out.println ("|3.client                                                                                                                        |");
            System.out.println ("|4.worker                                                                                                                        |");
            System.out.println ("|5.print reciept                                                                                                                 |");
            System.out.println ("|0.exit                                                                                                                          |");
            System.out.println ("==================================================================================================================================");
            int choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (choice) {
                case 1:
                    house house = new house();
                    house.household(args);
                    break;
                case 2:
                    filterfile house2 = new filterfile();
                    house2.showmenfilter();
                    break;
                case 3:
                    // nhap file vao
                    break;
                case 4:
                    slavemenu menu = new slavemenu();
                    menu.showmenu();
                    break;
                default:
                    System.out.println("select invalid. Please select again!");
                    break;
                case 0:
                    System.exit(0);
                    // return;
            }
        }
    }
}