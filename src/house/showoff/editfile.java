package house.showoff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class editfile {
    Scanner sc = new Scanner(System.in);
    readfile r = new readfile();
    public void edit_file() {
        String[] names = new String[100];
        String[] districts = new String[100];
        String[] condition = new String[100];
        // Đọc file và hiển thị nội dung hiện tại
        System.out.println("===============================================================edit===============================================================");
        readfile r = new readfile();
        r.read();
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|  Insert the row number to edit:                                                                                                |");
        System.out.println("|  Press 0 to exit                                                                                                               |");
        System.out.println("==================================================================================================================================");
        System.out.print("\033[3A"); // Di chuyển con trỏ lên 2 dòng
        System.out.print("\033[34C");
    
        int lineNumber = sc.nextInt(); // Nhập dòng cần sửa
        sc.nextLine(); // Bỏ qua ký tự newline
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            // Đọc nội dung file vào mảng
            BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"));
            String[] fileContent = br.lines().toArray(String[]::new);
            br.close();
            
            // Kiểm tra dòng hợp lệ
            if (lineNumber < 1 || lineNumber > fileContent.length) {
                return;
            }
            
            // Tách dòng thành các trường
            String[] fields = fileContent[lineNumber - 1 ].split(", "); // Tách dựa trên dấu phẩy
            districts[lineNumber] = fields[0].trim();
            names[lineNumber] = fields[1].trim();
            condition[lineNumber] = fields[2].trim();

            // System.out.println("Current content: " + Arrays.toString(fields));
            int indexWidth = 3;
            int nameWidth = 70;
            int districtWidth = 38;
            int conditionWidth = 10;
            System.out.println("===============================================================edit===============================================================");
            System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + districtWidth + "s|" + " %-" + conditionWidth + "s|", "No.", "Name", "District", "Condition"));
            System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + districtWidth + "s|" + " %-" + conditionWidth + "s|", (lineNumber), names[lineNumber], districts[lineNumber], condition[lineNumber]));
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            // Hiển thị menu chỉnh sửa
            System.out.println("|Choose a field to edit:                                                                                                         |");
            System.out.println("|1. Name                                                                                                                         |");
            System.out.println("|2. District                                                                                                                     |");
            System.out.println("|3. Condition (clear/inuse)                                                                                                      |");
            System.out.println("|0. Cancel                                                                                                                       |");
            System.out.println("==================================================================================================================================");
            System.out.print("\033[6A"); // Di chuyển con trỏ lên 6 dòng
            System.out.print("\033[25C");
            int choice = sc.nextInt();
            sc.nextLine(); // Bỏ qua newline
            switch (choice) {
                case 1:
                    System.out.print("|Enter new Name: ");
                    fields[1] = sc.nextLine().trim(); // Cập nhật quận
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("|Enter new District: ");
                    fields[0] = sc.nextLine().trim(); // Cập nhật quận
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                case 3:
                    System.out.println("|Choose new Condition:");
                    System.out.println("|1. clear");
                    System.out.println("|2. inuse");
                    System.out.print("\033[3A"); // Di chuyển con trỏ lên 3 dòng
                    System.out.print("\033[23C");
                    int conditionChoice = sc.nextInt();
                    sc.nextLine(); // Bỏ qua newline
                    if (conditionChoice == 1) {
                        fields[2] = "clear"; // Cập nhật điều kiện thành "clear"
                    } else if (conditionChoice == 2) {
                        fields[2] = "inuse"; // Cập nhật điều kiện thành "inuse"
                    } else {
                        System.out.println("Invalid condition choice. No changes made.");
                        return;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                case 0:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;
                default:
                    System.out.println("Invalid choice. No changes made.");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;
            }
    
            // Ghi lại mảng đã chỉnh sửa vào file
            fileContent[lineNumber - 1] = String.join(", ", fields); // Kết hợp lại thành chuỗi
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/input/house.txt"));
            for (String line : fileContent) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
    
            System.out.println("Edit success.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void showMenuForEdit() {
        while (true) {
            System.out.println("===============================================================edit===============================================================");
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1. Edit a specific row                                                                                                          |");
            System.out.println("|0. Exit                                                                                                                         |");
            System.out.println("==================================================================================================================================");

            int choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (choice) {
                case 1:
                    edit_file();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
