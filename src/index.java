import java.util.Scanner;
// menu + đặt nhà + nhà + người
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        while(true){
            System.out.println ("============================================");
            System.out.println ("|1.no.house                                |");
            System.out.println ("|2.booking                                 |");
            System.out.println ("|3.client                                  |");
            System.out.println ("|4.worker                                  |");
            System.out.println ("|5.print file                              |");
            System.out.println ("|0.exit                                    |");
            System.out.println ("============================================");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println ("nhap file vao");
                    break;
                case 2:
                    // nhap file vao
                    break;
                case 3:
                    // nhap file vao
                    break;
                case 4:
                    // nhap file vao
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                    break;
                case 0:
                    System.exit(0);
                    // return;
            }
        }
    }
}