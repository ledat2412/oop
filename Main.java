import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true; // Cờ kiểm soát vòng lặp

        while (isRunning) {
            System.out.println("============================================");
            System.out.println("|1.no.house                                |");
            System.out.println("|2.booking                                 |");
            System.out.println("|3.client                                  |");
            System.out.println("|4.worker                                  |");
            System.out.println("|5.print file                              |");
            System.out.println("|0.exit                                    |");
            System.out.println("============================================");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn: Nhập dữ liệu.");
                    // Thực hiện logic nhập dữ liệu
                    break;
                case 2:
                    System.out.println("Bạn đã chọn: Xử lý dữ liệu.");
                    // Thực hiện logic xử lý dữ liệu
                    break;
                case 3:
                    System.out.println("Bạn đã chọn: Hiển thị kết quả.");
                    // Thực hiện logic hiển thị kết quả
                    break;
                case 4:
                    System.out.println("Bạn đã chọn: Thoát chương trình.");
                    isRunning = false; // Thay đổi cờ để thoát vòng lặp
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
        System.out.println("Chương trình đã kết thúc.");
    }
}
