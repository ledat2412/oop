package house.booking;
import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        QuanLyBooking QB = new QuanLyBooking();
        QB.menu();
    }
}

class Booking {
    KhachHang[] DatNha;
    int n;

    public Booking() {
        n = 0;
        DatNha = new KhachHang[0];
    }

    public void NhapThongTinDatNha(Scanner sc) {
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng thừa
        DatNha = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho khach hang thu " + (i + 1) + ":");
            DatNha[i] = new KhachHang();
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
        DatNha[n] = new KhachHang();
        DatNha[n].NhapThongTinDatNha(sc);
        n++;
    }

    public void XoaThongTinDatNha(String MaDatNha) {
        for (int i = 0; i < n; i++) {
            if (DatNha[i].getMaDatNha().equals(MaDatNha)) {
                for (int j = i; j < n - 1; j++) {
                    DatNha[j] = DatNha[j + 1];
                }
                DatNha = Arrays.copyOf(DatNha, n - 1);
                n--;
                System.out.println("Da xoa thanh cong thong tin dat nha " + MaDatNha);
                return;
            }
        }
        System.out.println("Khong tim thay ma dat nha " + MaDatNha);
    }
    
    public void SuaThongTinDatNha(String MaDatNha, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if(DatNha[i].getMaDatNha().equals(MaDatNha)) {
                DatNha[i].NhapThongTinDatNha(sc);
                return;
            }
            else {
                System.out.println("Khong tim thay ma nha " + MaDatNha);
            }
        }
    }
    
    public void TimKiemThongTinDatNha(String MaDatNha){
        for(int i = 0; i < n; i++){
            if(DatNha[i].getMaDatNha().equals(MaDatNha)){
                DatNha[i].xuat();
                break;
            }
            else {
                System.out.println("Khong co ma nha ban kiem");
            }
        }
    }

    public class KhachHang {
        private String quanDatNha;
        private String tenHomeStay;
        private String maDatNha;
        private String tenKhachHang;
        private String ngayDatNha;
        private String ngayNhanNha;
        private String ngayTraNha;

        public void NhapThongTinDatNha(Scanner sc) {
            System.out.print("Nhap quan ban muon dat: ");
            quanDatNha = sc.nextLine();
            System.out.print("Ten homestay ban muon dat: ");
            tenHomeStay = sc.nextLine();
            System.out.print("Nhap ma dat nha: ");
            maDatNha = sc.nextLine();
            System.out.print("Nhap ten khach hang: ");
            tenKhachHang = sc.nextLine();
            System.out.print("Ngay dat nha: ");
            ngayDatNha = sc.nextLine();
            System.out.print("Ngay nhan nha: ");
            ngayNhanNha = sc.nextLine();
            System.out.print("Ngay tra nha: ");
            ngayTraNha = sc.nextLine();
        }

        public void xuat() {
            System.out.println("Quan ban muon o: " + quanDatNha);
            System.out.println("Ten homestay ban muon o: " + tenHomeStay);
            System.out.println("Ma dat nha: " + maDatNha);
            System.out.println("Ten khach hang: " + tenKhachHang);
            System.out.println("Ngay dat nha: " + ngayDatNha);
            System.out.println("Ngay nhan nha: " + ngayNhanNha);
            System.out.println("Ngay tra nha: " + ngayTraNha);
            
            
        }

        public String getMaDatNha() {
            return maDatNha;
        }
    }
}

class QuanLyBooking {
    Booking booking = new Booking();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==========Menu==========");
            System.out.println("1. Dat nha");
            System.out.println("2. Sua thong tin dat nha");
            System.out.println("3. Xoa thong tin dat nha");
            System.out.println("4. Xuat danh sach ra console");
            System.out.println("5. Tim kiem ma dat nha");
            System.out.println("6. Thoat");
            System.out.println("=========================");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ các ký tự thừa
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (choice) {
                case 1:
                    System.out.println("Ban da chon muc dat nha");
                    booking.NhapThongTinDatNha(sc);
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
                    System.out.println("Ban da chon muc xuat danh sach ra console");
                    booking.XuatThongTinDatNha();
                    break;
                    
                case 5:
                    System.out.println("Ban da chon muc tim kiem thong tin dat nha");
                    System.out.print("Nhap ma dat nha muon tim kiem: ");
                    String maTim = sc.nextLine();
                    booking.TimKiemThongTinDatNha(maTim);
                    break;
                    
                case 6:
                    System.out.println("Ban da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai");
            }
        } while (choice != 6);
    }
}