// bỏ code này vì chưa tối ưu dùng để tham khảo là chính


package house.booking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readfile1 {
    public void read() {
        String[] districts = new String[100];
        String[] house = new String[100];
        String[] IDbooking = new String[100];
        String[] ngaydp = new String[100];
        String[] ngaytrap = new String[100];
        String[] ngaynhanp = new String[100];
        // ----------------------//
        String[] names = new String[100];
        String[] ID = new String[100];
        String[] TEL = new String[100];
        String[] Birth = new String[100];
        String[] Email = new String[100];
        String[] Locate = new String[100];
        int countbooking = 0;
        int countclient = 0;
        try {
            BufferedReader brbooking = new BufferedReader(new FileReader("src/input/booking.txt"));
            String lineb = brbooking.readLine();
            while (lineb != null) {
                String[] parts = lineb.split(", ");
                if (parts.length == 6) {
                    districts[countbooking] = parts[0].trim();
                    house[countbooking] = parts[1].trim();
                    IDbooking[countbooking] = parts[2].trim();
                    ngaydp[countbooking] = parts[3].trim();
                    ngaynhanp[countbooking] = parts[4].trim();
                    ngaytrap[countbooking] = parts[5].trim();
                    countbooking++;
                }
                lineb = brbooking.readLine();
            }
            
            BufferedReader brclient = new BufferedReader(new FileReader("src/input/client.txt"));
            String linec = brclient.readLine();
            while (linec != null) {
                String[] parts = linec.split(", ");
                if (parts.length == 6) {
                    names[countclient] = parts[1].trim();
                    ID[countclient] = parts[2].trim();
                    TEL[countclient] = parts[0].trim();
                    Birth[countclient] = parts[3].trim();
                    Email[countclient] = parts[4].trim();
                    Locate[countclient] = parts[5].trim();
                    countclient++;
                }
                linec = brclient.readLine();
            }

            int indexWidth = 3;
            int indexWidthBlank = 3;
            int nameWidth = 22;
            int houseWidth = 22;
            int districtWidth = 33;
            int IDbookingWidth = 20;
            int IDWidth = 22;
            int ngaydpWidth = 22;
            int ngaytrapWidth = 77;
            int ngaynhanpWidth = 22;
            for (int i = 0; i < countbooking; i++) {
                System.out.println(String.format(
                    "| %-" + indexWidth + "s|%-" + nameWidth + "s|%-" + IDWidth + "s|%-" + IDbookingWidth + "s|%-" + houseWidth + "s|%-" + districtWidth + "s|\n" +
                    "| %-" + indexWidthBlank + "s|%-" + ngaydpWidth + "s|%-" + ngaynhanpWidth + "s|%-" + ngaytrapWidth + "s|",
                    (i + 1),
                    names[i], 
                    ID[i], 
                    IDbooking[i], 
                    house[i], 
                    districts[i],
                    "",
                    ngaydp[i], 
                    ngaynhanp[i],
                    ngaytrap[i]
                    ));
                System.out.println("|    |---------------------------------------------------------------------------------------------------------------------------|");

            }

            // for (int i = 0; i < countbooking; i++) {
            //     // Kiểm tra IDbooking có khớp ID của client không
            //     String name = "", tel = "", birth = "", email = "", locate = "";
            //     for (int j = 0; j < countclient; j++) {
            //         if (IDbooking[i].equals(ID[j])) { // Ghép IDbooking với ID từ client
            //             name = names[j];
            //             tel = TEL[j];
            //             birth = Birth[j];
            //             email = Email[j];
            //             locate = Locate[j];
            //             break; // Thông tin client đã tìm thấy
            //         }
            //     }
            
            //     // Định dạng và in bảng
            //     System.out.println(String.format(
            //         "| %-" + indexWidth + "s | %-" + nameWidth + "s | %-" + IDWidth + "s | %-" + IDbookingWidth + "s | %-" + houseWidth + "s | %-" + districtWidth + "s |",
            //         (i + 1),
            //         (name.isEmpty() ? "N/A" : name),
            //         (tel.isEmpty() ? "N/A" : tel),
            //         IDbooking[i],
            //         (house[i] == null ? "N/A" : house[i]),
            //         (districts[i] == null ? "N/A" : districts[i])
            //     ));
            //     System.out.println(String.format(
            //         "| %-" + indexWidthBlank + "s | %-" + ngaydpWidth + "s | %-" + ngaytrapWidth + "s | %-" + ngaynhanpWidth + "s |",
            //         "",
            //         (ngaydp[i] == null ? "N/A" : ngaydp[i]),
            //         (ngaytrap[i] == null ? "N/A" : ngaytrap[i]),
            //         (ngaynhanp[i] == null ? "N/A" : ngaynhanp[i])
            //     ));
            //     System.out.println("|    |---------------------------------------------------------------------------------------------------------------------------|");
            // }
            

            for (int i = 0; i < countbooking; i++) {
                System.out.println("=== Booking Information ===");
                System.out.println("District: " + districts[i]);
                System.out.println("House Name: " + house[i]);
                System.out.println("Booking ID: " + IDbooking[i]);
                System.out.println("Ngay dat phong: " + ngaydp[i]);
                System.out.println("Ngay tra phong: " + ngaytrap[i]);
                System.out.println("Ngay nhan phong: " + ngaynhanp[i]);
            
                boolean found = false; 
                
            
                for (int j = 0; j < countclient && !found; j++) {
                        System.out.println("--- Client Information ---");
                        System.out.println("Name: " + names[j]);
                        System.out.println("TEL: " + TEL[j]);
                        System.out.println("Birth: " + Birth[j]);
                        System.out.println("Email: " + Email[j]);
                        System.out.println("Locate: " + Locate[j]);
                        found = true;
                }
            
                // if (!found) {
                //     System.out.println("No client information found for Booking ID: " + IDbooking[i]);
                // }
            
                System.out.println("---------------------------");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

