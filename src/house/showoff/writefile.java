package house.showoff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class writefile {
    public void write() {
        try{
            FileWriter writer = new FileWriter("src/input/house.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);
            Scanner sc = new Scanner(System.in);  
            System.out.println("Nhap ten nha: ");
            System.out.println("Nhap dia chi:");
            System.out.println(" 1. quan 1");
            System.out.println(" 2. quan 3");
            System.out.println(" 3. quan 4");
            System.out.println(" 4. quan 5");
            System.out.println(" 5. quan 6");
            System.out.println(" 6. quan 7");
            System.out.println(" 7. quan 8");
            System.out.println(" 8. quan 10");
            System.out.println(" 9. quan 11");
            System.out.println("10. quan 12");
            System.out.println("11. quan Binh Thanh");
            System.out.println("12. quan Go Vap");
            System.out.println("13. quan Phu Nhuan");
            System.out.println("14. quan Tan Binh");
            System.out.println("15. quan Tan Phu");
            System.out.println("16. quan Binh Tan");
            System.out.println("17. Thanh pho Thu Duc");
            System.out.println("18. Huyen Nha Be");
            System.out.println("19. Huyen Hoc mon");
            System.out.println("20. Huyen Binh Chanh");
            System.out.println("21. Huyen Cu Chi");
            System.out.println("22. Huyen Can Gio");
            System.out.println("23. Huyen Ngu Hanh Son");
            System.out.print("\033[25A"); 
            System.out.print("\033[14C"); 
            String name = sc.nextLine();
            System.out.print("\033[14C"); 
            int DistrictChoice = sc.nextInt();
            String district = "";
            while (true) {
                sc.nextLine(); 
                if (DistrictChoice < 1 || DistrictChoice > 23) {
                    System.out.print("\033[1A");
                    System.out.print("Vui long nhap lai quan huyen: ");
                    DistrictChoice = sc.nextInt();
                    continue;
                }
                switch (DistrictChoice) {
                    case 1:
                    district = "Quan 1";
                        break;
                    case 2:
                    district = "Quan 3";
                        break;
                    case 3:
                    district = "Quan 4";
                        break;
                    case 4:
                    district = "Quan 5";
                        break;
                    case 5:
                    district = "Quan 6";
                        break;
                    case 6:
                    district = "Quan 7";
                        break;
                    case 7:
                    district = "Quan 8";
                        break;
                    case 8:
                    district = "Quan 10";
                        break;
                    case 9:
                    district = "Quan 11";
                        break;
                    case 10:
                    district = "Quan 12";
                        break;
                    case 11:
                    district = "Quan Binh Thanh";
                        break;
                    case 12:
                    district = "Quan Go Vap";
                        break;
                    case 13:
                    district = "Quan Phu Nhuan";
                        break;
                    case 14:
                    district = "Quan Tan Binh";
                        break;
                    case 15:
                    district = "Quan Tan Phu";
                        break;
                    case 16:
                    district = "Quan Binh Tan";
                        break;
                    case 17:
                    district = "Thanh pho Thu Duc";
                        break;
                    case 18:
                    district = "Huyen Nha Be";
                        break;
                    case 19:
                    district = "Huyen Hoc mon";
                        break;
                    case 20:
                    district = "Huyen Binh Chanh";
                        break;
                    case 21:
                    district = "Huyen Cu Chi";
                        break;
                    case 22:
                    district = "Huyen Can Gio";
                        break;
                    case 23:
                    district = "Huyen Ngu Hanh Son";
                        break;
                    default:
                    System.out.println("Khong co quan huyen nay.");
                        break;
                }
                String condition = "clear"; // Mặc định điều kiện là "clear"
                bw.write(district + ", " + name + ", " + condition + "\n");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Ban co muon nhap tiep khong? (Y/N): ");
                String choice = sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}