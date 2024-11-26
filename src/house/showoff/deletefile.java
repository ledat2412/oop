package house.showoff;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class deletefile {
    Scanner sc = new Scanner(System.in);
    public void delete() {
        readfile r = new readfile();
        System.out.println("==============================================================delete==============================================================");
        r.read();
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|  Insert the num_row to delete:                                                                                                 |");
        System.out.println("|  Press 0 to exit                                                                                                               |");
        System.out.println("==================================================================================================================================");
        System.out.print("\033[3A"); // Di chuyển con trỏ lên 3 dòng
        System.out.print("\033[33C");

        int lineNumber = sc.nextInt();

        try {
            // Đọc dữ liệu từ file vào mảng
            BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"));
            String[] fileContent = br.lines().toArray(String[]::new);
            br.close();

            // Kiểm tra chỉ số dòng hợp lệ
            if (lineNumber < 1 || lineNumber > fileContent.length) {
                System.out.println("Chỉ số dòng không hợp lệ.");//dòng này tượng trưng thôi chứ return củng có thấy đâu :v
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return;
            }

            // Tạo mảng mới mà không có dòng cần xóa
            String[] newFileContent = new String[fileContent.length - 1];
            System.arraycopy(fileContent, 0, newFileContent, 0, lineNumber - 1); // Sao chép các phần tử trước dòng cần xóa
            System.arraycopy(fileContent, lineNumber, newFileContent, lineNumber - 1, fileContent.length - lineNumber); // Sao chép các phần tử sau dòng cần xóa

            // Ghi lại mảng mới vào file
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/input/house.txt"));
            for (String line : newFileContent) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();

            System.out.println("Delete success."); //dòng này củng tượng trưng thôi chứ return củng có thấy đâu :v
            System.out.print("\033[H\033[2J"); // do dòng này xoá hết trước khi mà thấy :))) 
            System.out.flush(); // có thể dùng thread để dừng lại một chút sao đó mới xã hết sau :))👌
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void delete_all() {
        try {
            FileWriter writer = new FileWriter("src/input/house.txt", false);
                writer.write("");
                writer.close();
                System.out.println("Xoa thanh cong");
        } 
            catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void showmenufordelete() {
        while (true) {
            readfile r = new readfile();
            System.out.println("==============================================================delete==============================================================");
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1.delete once                                                                                                                   |");
            System.out.println("|2.delete all                                                                                                                    |");
            System.out.println("|0.exit                                                                                                                          |");
            System.out.println("==================================================================================================================================");
            int choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choice){
                case 1:
                    delete();
                    break;
                case 2:
                    delete_all();
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
    
    
