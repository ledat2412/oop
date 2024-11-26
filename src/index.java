import java.util.Scanner;
import house.booking.Main2;
import house.showoff.house;
import house.showoff.filterfile;
import people.slave.slavemenu;

import people.client.Project;
import people.slave.Main1;
// menu + đặt nhà + nhà + người

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
                    Main2 booking = new Main2();
                    booking.main(args);
                    break;
                case 3:
                    Project client = new Project();
                    client.main(args);
                    break;
                case 4:
                    Main1 worker = new Main1();
                    worker.main(args);
                    break;
                case 5:
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