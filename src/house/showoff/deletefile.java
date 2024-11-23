package house.showoff;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("==================================================================================================================================");
        System.out.print("\033[2A"); // Di chuyển con trỏ lên 2 dòng
        System.out.print("\033[33C");

        int lineNumber = sc.nextInt();
        try {
            List<String> fileContent = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/input/house.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    fileContent.add(line);
                }
            }

            // Kiểm tra chỉ số dòng hợp lệ
            if (lineNumber < 1 || lineNumber > fileContent.size()) {
                System.out.println("Chỉ số dòng không hợp lệ.");//dòng này tượng trưng thôi chứ return củng có thấy đâu :v
                return;
            }

            // Xóa dòng
            fileContent.remove(lineNumber - 1);  // Chỉ số dòng bắt đầu từ 0 trong danh sách

            // Ghi lại nội dung mới vào file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/input/house.txt"))) {
                for (String contentLine : fileContent) {
                    bw.write(contentLine);
                    bw.newLine();
                }
            }

            System.out.println("Delete sucess."); //dòng này củng tượng trưng thôi chứ return củng có thấy đâu :v
            System.out.print("\033[H\033[2J"); // do dòng này xoá hết trước khi mà thấy :))) 
            System.out.flush(); // có thể dùng thread để dừng lại một chút sao đó mới xã hết sau :))👌

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void delete_all() {
    try {
        FileWriter writer = new FileWriter("src/input/house.txt", false);
            writer.write("");
            writer.close();
            System.out.println("Xoa thanh cong");
        } catch (IOException e) {
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
            int choice_1 = sc.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choice_1){
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
    
    
