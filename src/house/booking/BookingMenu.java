package house.booking;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
// ------------phần của Quyền ---------------- //
public class BookingMenu {
    public void main() {
        QuanLyBooking QB = new QuanLyBooking();
        QB.menu();
    }
}

class Booking {
    KhachHangDat[] DatNha;
    int n;

    public Booking() {
        n = 0;
        DatNha = new KhachHangDat[0];
    }

    // ------------phần của Đạt ---------------- //
    public void DocThongTinTuFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                KhachHangDat kh = new KhachHangDat();
                kh.setQuanDatNha(data[0]);
                kh.setTenHomeStay(data[1]);
                kh.setMaDatNha(data[2]);
                kh.setNgayDatNha(data[3]);
                kh.setNgayNhanNha(data[4]);
                kh.setNgayTraNha(data[5]);

                // Thêm khách hàng vào mảng
                ThemKhachHangVaoMang(kh);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    private void ThemKhachHangVaoMang(KhachHangDat kh) {
        DatNha = Arrays.copyOf(DatNha, n + 1);
        DatNha[n] = kh;
        n++;
    }
    
    // ------------phần của Quyền ---------------- //
    public void NhapThongTinDatNha(Scanner sc) {
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng thừa
        DatNha = new KhachHangDat[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho khach hang thu " + (i + 1) + ":");
            DatNha[i] = new KhachHangDat();
            DatNha[i].NhapThongTinDatNha(sc);
        }
    }

    public void XuatThongTinDatNha() {
        for (int i = 0; i < n; i++) {
            DatNha[i].xuat();
        }
    }

    public void ThemThongTinDatNha(Scanner sc) {
        System.out.println("Nhap thong tin dat nha moi:");
        DatNha = Arrays.copyOf(DatNha, n + 1);
        DatNha[n] = new KhachHangDat();
        DatNha[n].NhapThongTinDatNha(sc);
        n++;
    }

    // public void XoaThongTinDatNha(String MaDatNha) {
    //     for (int i = 0; i < n; i++) {
    //         if (DatNha[i].getMaDatNha().equals(MaDatNha)) {
    //             for (int j = i; j < n - 1; j++) {
    //                 DatNha[j] = DatNha[j + 1];
    //             }
    //             DatNha = Arrays.copyOf(DatNha, n - 1);
    //             n--;
    //             System.out.println("Da xoa thanh cong thong tin dat nha " + MaDatNha);
    //             return;
    //         }
    //     }
    //     System.out.println("Khong tim thay ma dat nha " + MaDatNha);
    // }

    // ------------phần của Đạt ---------------- //
    // public void XoaThongTinDatNha(String maDatNha) {
    //     DocThongTinTuFile("src/input/booking.txt");
    
    //     boolean found = false;
    //     for (int i = 0; i < n; i++) {
    //         if (DatNha[i].getMaDatNha().equals(maDatNha)) {
    //             found = true;
    
    //             // Dịch các phần tử phía sau lên một vị trí
    //             for (int j = i; j < n - 1; j++) {
    //                 DatNha[j] = DatNha[j + 1];
    //             }
    //             DatNha[n - 1] = null; // Xóa phần tử cuối
    //             n--; // Giảm số lượng phần tử
    //             break;
    //         }
    //     }
    
    //     if (!found) {
    //         System.out.println("Khong tim thay ma dat nha: " + maDatNha);
    //     } else {
    //         GhiThongTinVaoFile("src/input/booking.txt");
    //         System.out.println("Xoa thong tin thanh cong!");
    //     }
    // }

    // ------------phần của Đạt ---------------- //
    public void XoaThongTinDatNha(String maDatNha) {
        // Định nghĩa đường dẫn file
        File bookingFile = new File("src/input/booking.txt");
        File clientFile = new File("src/input/client.txt");
    
        try {
            // Xóa thông tin đặt phòng trong booking.txt
            XoaThongTinTrongFile(bookingFile, maDatNha);
    
            // Xóa thông tin khách hàng trong client.txt
            XoaThongTinTrongFile(clientFile, maDatNha);
    
            System.out.println("Đã xóa thông tin đặt phòng và khách hàng liên quan đến mã đặt phòng: " + maDatNha);
    
        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý file: " + e.getMessage());
        }
    }
    
    private void XoaThongTinTrongFile(File file, String maDatNha) throws IOException {
        // Đọc file vào bộ nhớ
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder updatedData = new StringBuilder();
        String line;
        
        // Đọc từng dòng và kiểm tra nếu dòng không chứa maDatNha thì giữ lại
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (!line.contains(maDatNha)) {
                updatedData.append(line).append("\n");
            } else {
                found = true; // Đánh dấu là đã tìm thấy mã cần xóa
            }
        }
        reader.close();
    
        // Nếu tìm thấy mã đặt phòng trong file, ghi lại dữ liệu đã chỉnh sửa
        if (found) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(updatedData.toString());
            writer.close();
        }
        // Nếu không tìm thấy mã đặt phòng trong file, không làm gì cả
        else {
            System.out.println("Không tìm thấy mã đặt phòng trong file: " + file.getName());
        }
    }

    // ------------phần của Quyền ---------------- //
    public void SuaThongTinDatNha(String MaDatNha, Scanner sc) {
        // ------------phần của Đạt ---------------- //
        DocThongTinTuFile("src/input/booking.txt");
        // ------------phần của Quyền ---------------- //
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (DatNha[i].getMaDatNha().equals(MaDatNha)) {
                found = true;
                int luachon;
                do {
                    System.out.println("==== Chon thong tin muon sua ====");
                    System.out.println("1. Sua quan");
                    System.out.println("2. Sua ten homestay");
                    System.out.println("3. Sua thoi gian dat phong");
                    System.out.println("4. Sua thoi gian nhan phong");
                    System.out.println("5. Sua thoi gian tra phong");
                    System.out.println("6. Thoat sua thong tin");
                    System.out.print("Lua chon: ");
                    luachon = sc.nextInt();
                    sc.nextLine(); // Xóa ký tự thừa
    
                    switch (luachon) {
                        case 1:
                            System.out.print("Nhap lai quan ban muon o: ");
                            DatNha[i].setQuanDatNha(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap lai ten homestay ban muon o: ");
                            DatNha[i].setTenHomeStay(sc.nextLine());
                            break;
                        case 3:
                            while (true) {
                                System.out.println("---------------------------------");
                                System.out.println("Vui long nhap lai thoi gian dat phong");
                                System.out.print("Nhap ngay: ");
                                int ngay = sc.nextInt();
                                System.out.print("Nhap thang: ");
                                int thang = sc.nextInt();
                                System.out.print("Nhap nam: ");
                                int nam = sc.nextInt();
                    
                                if (KhachHangDat.KiemTraNgayThang(ngay, thang, nam)) {
                                    String ngayDatPhongMoi = ngay + "/" + thang + "/" + nam;
                                    DatNha[i].setNgayDatNha(ngayDatPhongMoi);
                                    System.out.println("Ngay dat nha da cap nhat thanh cong: " + ngayDatPhongMoi);
                                    sc.nextLine(); 
                                    break;
                                } 
                                else {
                                    System.out.println("Ngay thang nam khong hop le, vui long nhap lai.");
                                }
                            }
                            break;
                        case 4: 
                            while(true) {
                                System.out.println("-----------------------------------");
                                System.out.println("Vui long nhap lai thoi gian nhan phong");
                                System.out.print("Nhap ngay: ");
                                int ngay = sc.nextInt();
                                System.out.print("Nhap thang: ");
                                int thang = sc.nextInt();
                                System.out.print("Nhap nam: ");
                                int nam = sc.nextInt();
                                if (KhachHangDat.KiemTraNgayThang(ngay, thang, nam)) {
                                    String ngayNhanNhaMoi = ngay + "/" + thang + "/" + nam;
                                    DatNha[i].setNgayNhanNha(ngayNhanNhaMoi);
                                    System.out.println("Ngay nhan nha da cap nhat thanh cong: " + ngayNhanNhaMoi);
                                    sc.nextLine();
                                    break;
                                }
                                else {
                                    System.out.println("Ngay thang nam khong hop le, vui long nhap lai.");
                                }
                            }
                        case 5: 
                            while(true) {
                                System.out.println("----------------------------------");
                                System.out.println("Vui long nhap lai thoi gian tra nha");
                                System.out.print("Nhap ngay: ");
                                int ngay = sc.nextInt();
                                System.out.print("Nhap thang: ");
                                int thang = sc.nextInt();
                                System.out.print("Nhap nam: ");
                                int nam = sc.nextInt();
                                if (KhachHangDat.KiemTraNgayThang(ngay, thang, nam)) {
                                    String ngayTraNhaMoi = ngay + "/" + thang + "/" + nam;
                                    DatNha[i].setNgayTraNha(ngayTraNhaMoi);
                                    System.out.println("Ngay tra nha da cap nhat thanh cong: " + ngayTraNhaMoi); 
                                    sc.nextLine();
                                    break;
                                }
                                else {
                                    System.out.println("Ngay thang nam khong hop le, vui long nhap lai.");
                                }
                            }
                        case 6:
                            System.out.println("Thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long thu lai.");
                    }
                } while (luachon != 6);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma nha " + MaDatNha);
        }else {
            // ------------phần của Đạt ---------------- //
            GhiThongTinVaoFile("src/input/booking.txt");
            System.out.println("Cap nhat thong tin thanh cong!");
        }
    }
    // ------------phần của Đạt ---------------- //
    public void GhiThongTinVaoFile(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < n; i++) {
                bw.write(DatNha[i].getQuanDatNha() + ", " +
                         DatNha[i].getTenHomeStay() + ", " +
                         DatNha[i].getMaDatNha() + ", " +
                         DatNha[i].getNgayDatNha() + ", " +
                         DatNha[i].getNgayNhanNha() + ", " +
                         DatNha[i].getNgayTraNha() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
    // ------------phần của Quyền ---------------- //
    // public void TimKiemThongTinDatNha(String MaDatNha){
    //     for(int i = 0; i < n; i++){
    //         if(DatNha[i].getMaDatNha().equals(MaDatNha)){
    //             DatNha[i].xuat();
    //             break;
    //         }
    //         else {
    //             System.out.println("Khong co ma nha ban kiem");
    //         }
    //     }
    // }
    // ------------phần của Đạt ---------------- //
    public void TimKiemThongTinDatNha(String MaDatNha){
        DocThongTinTuFile("src/input/booking.txt");

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (DatNha[i].getMaDatNha().equals(MaDatNha)) {
                found = true;
                System.out.println("Thong tin dat nha tim thay:");
                DatNha[i].xuat();
                break;
            }
        }
    
        if (!found) {
            System.out.println("Khong tim thay thong tin voi ma dat nha: " + MaDatNha);
        }
    }
    
    public class KhachHangDat {
    private String quanDatNha;
    private String tenHomeStay;
    private String maDatNha;
    private String ngayDatNha;
    private String ngayNhanNha;
    private String ngayTraNha;
    private int ngay;
    private int thang;
    private int nam;
    
    public String getQuanDatNha() {
        return quanDatNha;
    }

    public void setQuanDatNha(String quanDatNha) {
        this.quanDatNha = quanDatNha;
    }

    public String getTenHomeStay() {
        return tenHomeStay;
    }

    public void setTenHomeStay(String tenHomeStay) {
        this.tenHomeStay = tenHomeStay;
    }

    public String getMaDatNha() {
        return maDatNha;
    }

    public void setMaDatNha(String maDatNha) {
        this.maDatNha = maDatNha;
    }

    public String getNgayDatNha() {
        return ngayDatNha;
    }

    public void setNgayDatNha(String ngayDatNha) {
        this.ngayDatNha = ngayDatNha;
    }

    public String getNgayNhanNha () {
        return ngayNhanNha;
    }

    public void setNgayNhanNha (String ngayNhanNha) {
        this.ngayNhanNha = ngayNhanNha;
    }

    public String getNgayTraNha() {
        return ngayTraNha;
    }

    public void setNgayTraNha(String ngayTraNha) {
        this.ngayTraNha = ngayTraNha;
    }

    public void NhapThongTinDatNha(Scanner sc) {
        // ------------phần của Đạt ---------------- //
        try{
            FileWriter fw = new FileWriter("src/input/booking.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            // ------------phần của Quyền ---------------- //
            System.out.print("Nhap quan ban muon dat: ");
            quanDatNha = sc.nextLine();
            System.out.print("Ten homestay ban muon dat: ");
            tenHomeStay = sc.nextLine();
            System.out.print("Nhap ma dat nha: ");
            maDatNha = sc.nextLine();

            while(true){
                System.out.println("---------------------------------");
                System.out.println("Vui long nhap thoi gian dat phong");
                System.out.print("Nhap ngay: ");
                ngay = sc.nextInt();
                System.out.print("Nhap thang: ");
                thang = sc.nextInt();
                System.out.print("Nhap nam: ");
                nam = sc.nextInt();
                if (KiemTraNgayThang(ngay, thang, nam)) {
                    this.ngayDatNha = ngay+"/"+thang+"/"+nam;
                    System.out.println("Ngay dat nha: " + ngayDatNha);
                    break;
                }
                else {
                    System.out.println("Ngay thang nam khong hop le, vui long nhap lai: ");
                }
            }
            
            while(true){
                System.out.println("---------------------------------");
                System.out.println("Vui long nhap thoi gian nhan phong");
                System.out.print("Nhap ngay: ");
                ngay = sc.nextInt();
                System.out.print("Nhap thang: ");
                thang = sc.nextInt();
                System.out.print("Nhap nam: ");
                nam = sc.nextInt();
                if (KiemTraNgayThang(ngay, thang, nam)) {
                    this.ngayNhanNha = ngay+"/"+thang+"/"+nam;
                    System.out.println("Ngay nhan nha: " + ngayNhanNha);
                    break;
                }
                else {
                    System.out.println("Ngay thang nam khong hop le, vui long nhap lai: ");
                }
            }
            
            while(true){
            System.out.println("---------------------------------");
            System.out.println("Vui long nhap thoi gian tra phong");
            System.out.print("Nhap ngay: ");
            ngay = sc.nextInt();
            System.out.print("Nhap thang: ");
            thang = sc.nextInt();
            System.out.print("Nhap nam: ");
            nam = sc.nextInt();
            if (KiemTraNgayThang(ngay, thang, nam)) {
                this.ngayTraNha = ngay+"/"+thang+"/"+nam;
                System.out.println("Ngay tra nha: " + ngayTraNha);
                sc.nextLine();
                break;
            }else {
                System.out.println("Ngay thang nam khong hop le, vui long nhap lai: ");
            }
            }
        // ------------phần của Đạt ---------------- //
        bw.write(this.quanDatNha + ", " + this.tenHomeStay + ", " + this.maDatNha + ", " + this.ngayDatNha + ", " + this.ngayNhanNha + ", " + this.ngayTraNha + "\n");
        bw.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
    }
    
    public static boolean KiemTraNgayThang(int ngay, int thang, int nam) {
        if (thang < 1 || thang > 12) {
            return false; // Tháng không hợp lệ
        }

        int soNgayTrongThang;

        switch (thang) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                soNgayTrongThang = 31;
                break;
            case 4: case 6: case 9: case 11:
                soNgayTrongThang = 30;
                break;
            case 2:
                if (NamNhuan(nam)) {
                    soNgayTrongThang = 29;
                } else {
                    soNgayTrongThang = 28;
                }
                break;
            default:
                return false; 
        }
        return ngay >= 1 && ngay <= soNgayTrongThang;
    }

    public static boolean NamNhuan(int nam) {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }


    public void xuat() {
        System.out.println("Quan ban muon o: " + quanDatNha);
        System.out.println("Ten homestay ban muon o: " + tenHomeStay);
        System.out.println("Ma dat nha: " + maDatNha);
        System.out.println("Ngay dat nha: " + ngayDatNha);
        System.out.println("Ngay nhan nha: " + ngayNhanNha);
        System.out.println("Ngay tra nha: " + ngayTraNha); 
        }
    }
}

class QuanLyBooking {
    Booking booking = new Booking();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==============================================================booking=============================================================");
            ReadFile r = new ReadFile();
            r.read();
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|1. Dat nha                                                                                                                      |");
            System.out.println("|2. Sua thong tin dat nha                                                                                                        |");
            System.out.println("|3. Xoa thong tin dat nha                                                                                                        |");
            System.out.println("|4. Tim kiem ma dat nha                                                                                                          |");
            System.out.println("|0. Thoat                                                                                                                        |");
            System.out.println("==================================================================================================================================");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ các ký tự thừa
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (choice) {
                case 1:
                System.out.println("Ban da chon muc dat nha");
                booking.NhapThongTinDatNha(sc); // Đảm bảo rằng phương thức này có logic nhập thông tin cho đặt nhà
                break;
            
                    
                case 2:
                    System.out.println("Ban da chon muc sua thong tin dat nha");
                    System.out.print("Nhap ma nha can sua: ");
                    String maSua = sc.nextLine();
                    booking.SuaThongTinDatNha(maSua,sc);
                    break;
                    
                case 3:
                    System.out.println("Ban da chon muc xoa thong tin dat nha");
                    System.out.print("Nhap ma nha can xoa: ");
                    String MaNhaCanXoa = sc.nextLine();
                    booking.XoaThongTinDatNha(MaNhaCanXoa);
                    break;
                    
                case 4:
                    System.out.println("Ban da chon muc tim kiem thong tin dat nha");
                    System.out.print("Nhap ma dat nha muon tim kiem: ");
                    String maTim = sc.nextLine();
                    booking.TimKiemThongTinDatNha(maTim);
                    break;
                    
                case 0:
                    System.out.println("Ban da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai");
            }
        } while (choice != 0);
    }
}