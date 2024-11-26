package people.slave;

import java.util.Scanner;

public class slavemenu {
    Scanner sc = new Scanner(System.in);

    public boolean password() {
        System.out.println("Nhap account: ");
        String account = sc.nextLine();
        System.out.println("Nhap password: ");
        String password = sc.nextLine();
        
        if (account.equals("1") && password.equals("1")) {
            System.out.println("you have permission!");
            return true; // Đăng nhập thành công
        } else {
            System.out.println("You have no permission!");
            return false; // Đăng nhập thất bại
        }
    }

    public void showmenu() {
        // Kiểm tra đăng nhập
        if (!password()) {
            System.out.println("Chuong trinh ket thuc do dang nhap that bai.");
            return; // Thoát nếu đăng nhập sai
        }

        while (true) {

            System.out.println("=============================================================Employee=============================================================");

            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1.select row to edit                                                                                                            |");
            System.out.println("|0.exit                                                                                                                          |");
            System.out.println("==================================================================================================================================");
            int choice = sc.nextInt();
            sc.nextLine(); // Bỏ qua ký tự newline sau khi nhập số
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (choice) {
                case 1:
                    // Logic chỉnh sửa hàng
                    System.out.println("Editing...");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return; // Thoát khỏi chương trình
                default:
                    System.out.println("Lua chon khong hop le. Thu lai.");
                    break;
            }
        }
    }
}

