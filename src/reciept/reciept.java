package reciept;

import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.util.regex.Pattern;

public class reciept {
    // Hàm loại bỏ dấu tiếng Việt
    public static String removeDiacritics(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").replace("đ", "d").replace("Đ", "D");
    }

    public void printReciept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nha can in hoa don: ");
        String bookingID = sc.nextLine().trim().toLowerCase(); // Loại bỏ khoảng trắng và chuẩn hóa chữ thường
        boolean found = false;
    
        try (BufferedReader brBooking = new BufferedReader(new FileReader("src/input/booking.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/output/output.txt", true))) {
            String lineBooking;
            while ((lineBooking = brBooking.readLine()) != null) {
                String[] bookingData = lineBooking.split(", ");
                if (bookingData.length >= 3 && bookingData[2].trim().toLowerCase().equals(bookingID)) { // So sánh mã nhà
                    found = true;
                    // In ra hóa đơn
                    System.out.println("=== Reciept ===");
                    System.out.println("District: " + removeDiacritics(bookingData[0]));
                    System.out.println("House Name: " + removeDiacritics(bookingData[1]));
                    System.out.println("Booking ID: " + bookingData[2]);
                    System.out.println("Start Date: " + bookingData[3]);
                    System.out.println("Check-in Date: " + bookingData[4]);
                    System.out.println("Check-out Date: " + bookingData[5]);
                    System.out.println("================");
    
                    // Ghi hóa đơn vào file
                    bw.write("=== Reciept ===\n");
                    bw.write("District: " + removeDiacritics(bookingData[0]) + "\n");
                    bw.write("House Name: " + removeDiacritics(bookingData[1]) + "\n");
                    bw.write("Booking ID: " + bookingData[2] + "\n");
                    bw.write("Start Date: " + bookingData[3] + "\n");
                    bw.write("Check-in Date: " + bookingData[4] + "\n");
                    bw.write("Check-out Date: " + bookingData[5] + "\n");
                    bw.write("================\n");
                    break; // Tìm thấy thì thoát
                }
            }
            if (!found) {
                System.out.println("Khong co ma nha ban kiem.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý file booking.txt: " + e.getMessage());
        }
    }
    
}
