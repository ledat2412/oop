package house.booking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class bookingclient {
    private String district;
    private String houseName;
    private String bookingID;
    private String ngayDatPhong;
    private String ngayTraPhong;
    private String ngayNhanPhong;
    //------------------//
    private String name;
    private String clientID;

    public bookingclient(String district, String houseName, String bookingID, String ngayDatPhong, String ngayTraPhong, String ngayNhanPhong,
                         String name, String clientID, String tel, String birthDate, String email, String locate) {
        this.district = district;
        this.houseName = houseName;
        this.bookingID = bookingID;
        this.ngayDatPhong = ngayDatPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.name = name;
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        int indexWidthBlank = 3;
        int nameWidth = 26;
        int houseWidth = 20;
        int districtWidth = 20;
        int IDWidth = 27;
        int IDbookingWidth = 26;
        int ngaydpWidth = 26;
        int ngaytrapWidth = 68;
        int ngaynhanpWidth = 27;
        return String.format(
            "|%-" + nameWidth + "s|%-" + IDWidth + "s|%-" + IDbookingWidth + "s|%-" + houseWidth + "s|%-" + districtWidth + "s|\n" +
            "| %-" + indexWidthBlank + "s|%-" + ngaydpWidth + "s|%-" + ngaynhanpWidth + "s|%-" + ngaytrapWidth + "s|",
            name, 
            "CCCD: " + clientID, 
            "IDBooking: " + bookingID, 
            houseName, 
            district,
            "",
            "ngay dat phong: " + ngayDatPhong, 
            "ngay nhan phong: " + ngayNhanPhong,
            "ngay tra phong: " + ngayTraPhong
            );
    }
}

public class ReadFile {
    public void read() {
        int bookingCount = countLines("src/input/booking.txt");
        int clientCount = countLines("src/input/client.txt");
        bookingclient[] combinedData = new bookingclient[Math.max(bookingCount, clientCount)];

        try {
            BufferedReader brBooking = new BufferedReader(new FileReader("src/input/booking.txt"));
            String lineBooking;
            String[][] bookingData = new String[bookingCount][6];
            int indexBooking = 0;

            while ((lineBooking = brBooking.readLine()) != null) {
                bookingData[indexBooking++] = lineBooking.split(", ");
            }
            brBooking.close();

            BufferedReader brClient = new BufferedReader(new FileReader("src/input/client.txt"));
            String lineClient;
            String[][] clientData = new String[clientCount][6];
            int indexClient = 0;

            while ((lineClient = brClient.readLine()) != null) {
                clientData[indexClient++] = lineClient.split(", ");
            }
            brClient.close();

            // Kết hợp dữ liệu từ hai file vào mảng
            for (int i = 0; i < combinedData.length; i++) {
                String district = i < bookingCount ? bookingData[i][0].trim() : "";
                String houseName = i < bookingCount ? bookingData[i][1].trim() : "";
                String bookingID = i < bookingCount ? bookingData[i][2].trim() : "";
                String ngayDatPhong = i < bookingCount ? bookingData[i][3].trim() : "";
                String ngayTraPhong = i < bookingCount ? bookingData[i][4].trim() : "";
                String ngayNhanPhong = i < bookingCount ? bookingData[i][5].trim() : "";
                // ------------------ //
                String name = i < clientCount ? clientData[i][0].trim() : "";
                String clientID = i < clientCount ? clientData[i][1].trim() : "";
                String tel = i < clientCount ? clientData[i][2].trim() : "";
                String birthDate = i < clientCount ? clientData[i][3].trim() : "";
                String email = i < clientCount ? clientData[i][4].trim() : "";
                String locate = i < clientCount ? clientData[i][5].trim() : "";

                // Lưu dữ liệu vào mảng
                combinedData[i] = new bookingclient(district, houseName, bookingID, ngayDatPhong, ngayTraPhong, ngayNhanPhong,name, clientID, tel, birthDate, email, locate);
            }
            int indexWidth = 3;
            int index=1;
            // In dữ liệu từ mảng
            for (bookingclient data : combinedData) {
                if (data != null) {
                    // System.out.println(data);
                    System.out.print(String.format("| %-" + indexWidth + "d%s", 
                    (index++),
                    data
                    ));
                    System.out.println("");
                    System.out.println("|    |---------------------------------------------------------------------------------------------------------------------------|");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm đếm số dòng trong file
    private int countLines(String filePath) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

