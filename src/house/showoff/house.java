package house.showoff;

import java.util.Scanner;

public class house {
    public void household(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            readfile r = new readfile();
            System.out.println("==============================================================no.house============================================================");
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1.add house                                                                                                                     |");
            System.out.println("|2.delete house                                                                                                                  |");
            System.out.println("|3.edit house                                                                                                                    |");
            System.out.println("|0.exit                                                                                                                          |");
            System.out.println("==================================================================================================================================");
            int choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
                switch(choice){
                    case 1:
                        writefile w = new writefile();
                        w.write();
                        break;
                    case 2:
                        deletefile df = new deletefile();
                        df.showmenufordelete();
                        break;
                    case 3:
                        editfile ef = new editfile();
                        
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("select invalid. Please select again!");
                        break;
            }
        }
    }
}
