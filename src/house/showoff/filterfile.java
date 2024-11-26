package house.showoff;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
// import java.util.Random;

public class filterfile {
    Scanner sc = new Scanner(System.in);
    public void showmenfilter() {
        while (true) {
            readfile r = new readfile();
            System.out.println("===============================================================edit===============================================================");
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1.District                                                                                                                      |");
            System.out.println("|2.Condition                                                                                                                     |");
            System.out.println("|0.exit                                                                                                                          |");
            System.out.println("==================================================================================================================================");
            int choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choice){
                case 1:
                    districts_filter();
                    break;
                case 2:
                    condition_filter();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("select invalid. Please select again!");
                    break;
            }
        }
    }
    public void districts_filter() {
        String[] districts = new String[100];
        String[] names = new String[100];
        String[] conditions = new String[100];
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    districts[count] = parts[0].trim();
                    names[count] = parts[1].trim(); 
                    conditions[count] = parts[2].trim();
                    count++;
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Hiển thị menu để chọn điều kiện lọc
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn điều kiện là:");
        System.out.println("1. Chỉ hiển thị nhà trong điều kiện lọc");
        System.out.println("2. Chỉ hiển thị nhà trong điều kiện inuse");
        System.out.println("3. Chỉ hiển thị nhà trong điều kiện clear");
        System.out.print("Nhập lựa chọn (1, 2 hoặc 3): ");
        int choice = sc.nextInt();

        // Lọc và in kết quả dựa trên lựa chọn
        switch (choice) {
            case 1:
                for (int i = 0; i < count; i++) {
                    if (conditions[i].equals("inuse")) {
                        System.out.println("District: " + districts[i]);
                        System.out.println("Name: " + names[i]);
                        System.out.println("Condition: " + conditions[i]);
                        System.out.println("---------------------------------------------------------------");
                    }
                }
                break;
            case 2:
                for (int i = 0; i < count; i++) {
                    if (conditions[i].equals("clear")) {
                        System.out.println("District: " + districts[i]);
                        System.out.println("Name: " + names[i]);
                        System.out.println("Condition: " + conditions[i]);
                        System.out.println("---------------------------------------------------------------");
                    }
                }
                break;
            default:
            }
        }
    public void condition_filter() {
        String[] districts = new String[100];
        String[] names = new String[100];
        String[] conditions = new String[100];
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    districts[count] = parts[0].trim();
                    names[count] = parts[1].trim();
                    conditions[count] = parts[2].trim();
                    count++;
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Hiển thị menu để chọn điều kiện lọc
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn điều kiện để lọc:");
        System.out.println("1. Chỉ hiển thị nhà có condition là 'inuse'");
        System.out.println("2. Chỉ hiển thị nhà có condition là 'clear'");
        System.out.print("Nhập lựa chọn (1 hoặc 2): ");
        int choice = sc.nextInt();

        // Lọc và in kết quả dựa trên lựa chọn
        System.out.println("Kết quả lọc:");
        for (int i = 0; i < count; i++) {
            if ((choice == 1 && conditions[i].equalsIgnoreCase("inuse")) ||
                (choice == 2 && conditions[i].equalsIgnoreCase("clear"))) {
                System.out.println(districts[i] + ", " + names[i] + ", " + conditions[i]);
            }
        }
    }
}
    // public void condition_filter() {
    //     String[] districts = new String[100];
    //     String[] names = new String[100];   
    //     String[] condition = new String[100];
    //     int count = 0;
    //     try{
    //     BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"));
    //     String line = br.readLine();
    //     while (line != null) {
    //         String[] parts = line.split(", ");
    //         if (parts.length == 3) {
    //             districts[count] = parts[0].trim();
    //             names[count] = parts[1].trim();
    //             condition[count] = parts[2].trim().equalsIgnoreCase("clear");
    //             count++;
                
    //         }
    //         line = br.readLine();
    //     }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    // }
    // }

    // public void districts_filter() {
    //     String ID = randomString(10);
    //         System.out.println("random string: " + randomString(10));
    //         if (sc.nextLine().equals(randomString(10))) {
    //             System.out.println("Input correct!");
    //         }
    // }

    // String randomString(int length) {
    //     String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    //     Random random = new Random();
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < length; i++) {
    //         int index = random.nextInt(chars.length());
    //         sb.append(chars.charAt(index));
    //     }
    //     return sb.toString();
    // }

