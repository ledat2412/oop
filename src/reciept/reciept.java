package reciept;

import java.io.*;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        String bookingID = sc.nextLine().trim().toLowerCase();
        boolean found = false;
    
        try (BufferedReader brBooking = new BufferedReader(new FileReader("src/input/booking.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/output/output.txt", true))) {
    
            // Đọc file client.txt sau khi xác định booking
            BufferedReader brClient = new BufferedReader(new FileReader("src/input/client.txt"));
    
            String lineBooking;
            String lineClient;
            String clientName = "";
    
            // Lặp qua từng dòng trong booking.txt
            int lineIndex = 0; // Dùng biến này để theo dõi số dòng trong file booking
            while ((lineBooking = brBooking.readLine()) != null) {
                lineIndex++; // Tăng dòng mỗi khi đọc được một dòng từ booking
    
                String[] bookingData = lineBooking.split(", ");
                if (bookingData.length >= 3 && bookingData[2].trim().toLowerCase().equals(bookingID)) {
                    found = true;
    
                    // Đọc đúng dòng từ client.txt tương ứng với số dòng trong booking.txt
                    for (int i = 0; i < lineIndex; i++) {
                        brClient.readLine(); // Đọc các dòng không liên quan trong client.txt
                    }
    
                    // Lấy tên khách hàng từ dòng tương ứng trong client.txt
                    lineClient = brClient.readLine();
                    if (lineClient != null) {
                        String[] clientData = lineClient.split(", ");
                        if (clientData.length > 0) {
                            clientName = clientData[0];  // Lấy tên khách hàng
                        }
                    }
    
                    // In thông tin ra màn hình và ghi vào file output.txt
                    if (!clientName.isEmpty()) {
                        System.out.println("=== Reciept ===");
                        System.out.println("Customer Name: " + clientName);
                        System.out.println("District: " + removeDiacritics(bookingData[0]));
                        System.out.println("House Name: " + removeDiacritics(bookingData[1]));
                        System.out.println("Booking ID: " + bookingData[2]);
                        System.out.println("Start Date: " + bookingData[3]);
                        System.out.println("Check-in Date: " + bookingData[4]);
                        System.out.println("Check-out Date: " + bookingData[5]);
    
                        String[] ngayNhan = bookingData[4].split("/");
                        String[] ngayTra = bookingData[5].split("/");
    
                        try {
                            int soNgayO = TinhSoNgayGiuaHaiMocThoiGian(
                                Integer.parseInt(ngayNhan[0]), Integer.parseInt(ngayNhan[1]), Integer.parseInt(ngayNhan[2]),
                                Integer.parseInt(ngayTra[0]), Integer.parseInt(ngayTra[1]), Integer.parseInt(ngayTra[2])
                            );
                            int giaTienMotNgay = 100000;
                            int tongTien = giaTienMotNgay * soNgayO;
    
                            System.out.println("Tong so ngay o: " + soNgayO);
                            System.out.println("Tong so tien thue: " + tongTien);
    
                            // Ghi hóa đơn vào file
                            bw.write("=== Reciept ===\n");
                            bw.write("Customer Name: " + clientName + "\n");
                            bw.write("District: " + removeDiacritics(bookingData[0]) + "\n");
                            bw.write("House Name: " + removeDiacritics(bookingData[1]) + "\n");
                            bw.write("Booking ID: " + bookingData[2] + "\n");
                            bw.write("Start Date: " + bookingData[3] + "\n");
                            bw.write("Check-in Date: " + bookingData[4] + "\n");
                            bw.write("Check-out Date: " + bookingData[5] + "\n");
                            bw.write("Tong so ngay o: " + soNgayO + "\n");
                            bw.write("Tong so tien thue: " + tongTien + "\n");
                            bw.write("================\n");
                        } catch (Exception e) {
                            System.out.println("Lỗi khi tính số ngày hoặc tiền thuê: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Khong tim thay ten khach hang cho booking ID: " + bookingID);
                    }
                    break;
                }
            }
    
            if (!found) {
                System.out.println("Khong tim thay thong tin voi ma dat nha: " + bookingID);
            }
    
            // Đóng BufferedReader của file client.txt sau khi sử dụng
            brClient.close();
    
        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý file: " + e.getMessage());
        }
    }
    

    public int TinhSoNgayGiuaHaiMocThoiGian(int ngay1, int thang1, int nam1, int ngay2, int thang2, int nam2) {
        LocalDate startDate = LocalDate.of(nam1, thang1, ngay1);
        LocalDate endDate = LocalDate.of(nam2, thang2, ngay2);
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }
}
