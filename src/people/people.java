package people;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class people {
    private String name;       // Tên người
    private String telNumber;  // Số điện thoại
    private String email;      // Email
    private String address;    // Địa chỉ
    private LocalDate birthday; // Ngày sinh (sử dụng LocalDate để quản lý ngày tháng)
    String filePath = "src/input/people.txt";
    Scanner sc = new Scanner(System.in);
    
    // Constructor
    public people(String name, String telNumber, String email, String address, LocalDate birthday) {
        this.name = name;
        this.telNumber = telNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    // Phương thức nhập thông tin người
    public void nhapThongTin() {
        System.out.print("Nhập tên người: ");
        name = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        telNumber = sc.nextLine();
        System.out.println("email: ");
        email = sc.nextLine();
        System.out.println("address: ");
        address = sc.nextLine();
        System.out.println("birthday: ");
        birthday = LocalDate.parse(sc.nextLine());
    }

    // Phương thức ghi thông tin người vào file
    public void gopThongTinDenFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(name + "," + telNumber + "," + email + "," + address + "," + birthday + "\n");
            System.out.println("Đã lưu thông tin người vào file.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    // Phương thức đọc thông tin từ file và hiển thị
    public static void hienThiNoiDungTuFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Nội dung trong file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // Phương thức đọc thông tin người từ file
    public static void layThongTinTuFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Tách thông tin theo dấu phẩy
                System.out.println("Tên: " + data[0]);
                System.out.println("Số điện thoại: " + data[1]);
                System.out.println("Email: " + data[2]);
                System.out.println("Ngày sinh: " + data[3]);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
