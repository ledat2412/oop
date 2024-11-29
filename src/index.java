import java.util.Scanner;
import house.booking.BookingMenu;
import house.showoff.house;
import people.client.Project;
import people.slave.Worker;
import reciept.reciept;

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
                    BookingMenu booking = new BookingMenu();
                    booking.main();
                    break;
                case 3:
                    Project client = new Project();
                    client.main();
                    break;
                case 4:
                    Worker worker = new Worker();
                    worker.main();
                    break;
                case 5:
                    reciept reciept = new reciept();
                    reciept.printReciept();
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