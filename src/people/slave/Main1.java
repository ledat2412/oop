package people.slave;
import java.util.Scanner;
import java.util.Arrays;

// lop truu tuong nhan vien
abstract class NhanVien {
    private String Ma;
    private int Luong;

    public NhanVien() {
        Ma = "";
        Luong = 0;
        
    }

    public NhanVien(String Ma, int Luong ) {
        this.Ma = Ma;
        this.Luong = Luong;
       
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

   
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Luong Nhan Vien: ");
        Luong = scanner.nextInt();
        scanner.nextLine();  
        
        System.out.print("Nhap Ma Nhan Vien: ");
        Ma = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Ma Nhan Vien: " + Ma);
        System.out.println("Luong Nhan Vien: " + Luong+"đ");
        
    }
}

// Lớp(Nhân viên tiếp tân)
class TiepTan extends NhanVien {
    private String Tuvan;

    public TiepTan() {
        super();
        Tuvan = "";
    }

    public TiepTan(String Ma, int Luong, String Tuvan) {
        super(Ma, Luong);
        this.Tuvan = Tuvan;
    }

    public String getTuvan() {
        return Tuvan;
    }

    public void setTuvan(String Tuvan) {
        this.Tuvan = Tuvan;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec Nhan Vien Tiep tan: ");
        Tuvan = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Hien thi Cong viec Nhan Vien Tu Van: " + Tuvan);
    }
}

//  (Nhân viên lao công)
class LaoCong extends NhanVien {
    private String Dondep;

    public LaoCong() {
        super();
        Dondep = "";
    }

    public LaoCong(String Ma, int Luong, String Dondep) {
        super(Ma, Luong);
        this.Dondep = Dondep;
    }

    public String getDondep() {
        return Dondep;
    }

    public void setDondep(String Dondep) {
        this.Dondep = Dondep;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec cua Lao cong: ");
        Dondep = scanner.nextLine();
    }

    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Hien thi cong viec cua Nhan Vien lao cong: " + Dondep);
    }
}

// Lớp NVQuanLy (Nhân viên quản lý)
class NVQuanLy extends NhanVien
{
    private String Quanly;

    public NVQuanLy() {
        super();
        Quanly = "";
    }

    public NVQuanLy(String Ma, int Luong, String Quanly) {
        super(Ma, Luong);
        this.Quanly = Quanly;
    }

    public String getQuanly() {
        return Quanly;
    }

    public void setQuanly(String Quanly) {
        this.Quanly = Quanly;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec cua Quan Ly: ");
        Quanly = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Cong Viec Quan Ly: " + Quanly);
    }
}
class DanhSachNhanVien {
    private int n;
    private NhanVien[] dsnv;

    public DanhSachNhanVien() {
        n = 0;
        dsnv = new NhanVien[0];
    }

    // Hàm nhập danh sách nhân viên
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        n = scanner.nextInt();
        dsnv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai nhan vien: 1. Tiep Tan  2. Lao Cong  3. Quan Ly");
            int loai = scanner.nextInt();
            scanner.nextLine();  

            switch (loai) {
                case 1:
                    dsnv[i] = new TiepTan();
                    break;
                case 2:
                    dsnv[i] = new LaoCong();
                    break;
                case 3:
                    dsnv[i] = new NVQuanLy();
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    i--; 
                    continue;
            }
            dsnv[i].nhap();
        }
    }

    // Hàm xuất danh sách nhân viên
    public void xuat() {
        System.out.println("Danh Sach Nhan Vien:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhan Vien " + (i + 1) + ":");
            dsnv[i].xuat();
            System.out.println("-------------------------");
        }
    }

    
   // Hàm thêm nhân viên
public void them() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so luong nhan vien can them: ");
    int soLuongThem = scanner.nextInt();
    scanner.nextLine(); 

    
    dsnv = Arrays.copyOf(dsnv, n + soLuongThem);

    // Nhập thông tin từng nhân viê
    for (int i = 0; i < soLuongThem; i++) {
        System.out.println("Chon loai nhan vien: 1. Tiep Tan  2. Lao Cong  3. Quan Ly");
        int loai = scanner.nextInt();
        scanner.nextLine();

        switch (loai) {
            case 1:
                dsnv[n + i] = new TiepTan();
                break;
            case 2:
                dsnv[n + i] = new LaoCong();
                break;
            case 3:
                dsnv[n + i] = new NVQuanLy();
                break;
            default:
                System.out.println("Lua chon khong hop le, nhap lai!");
                i--; 
                continue;
        }
    
        dsnv[n + i].nhap();
    }

    // Cập nhật số lượng nhân viên
    n += soLuongThem;
    System.out.println("Da them " + soLuongThem + " nhan vien thanh cong.");
}


    // Hàm xóa nhân viên
    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMa().equals(Ma)) {
                for (int j = i; j < n - 1; j++) {
                    dsnv[j] = dsnv[j + 1];
                }
                dsnv = Arrays.copyOf(dsnv, n - 1);
                n--;
                found = true;
                System.out.println("Nhan vien ma " + Ma + " da duoc xoa.");
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien can xoa.");
        }
    }

    // Hàm sửa thông tin nhân viên
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can sua: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMa().equals(Ma)) {
                System.out.println("Nhap lai thong tin cho nhan vien co ma " + Ma + ":");
                dsnv[i].nhap();
                found = true;
                System.out.println("Thong tin nhan vien da duoc cap nhat.");
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien can sua.");
        }
    }

    // Hàm tìm kiếm nhân viên
    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMa().equals(Ma)) {
                System.out.println("THONG TIN NHAN VIEN CAN TIM:");
                dsnv[i].xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co ma " + Ma);
        }
    }

    // Hàm đếm số lượng nhân viên
    public void dem() {
        System.out.println("So luong nhan vien hien tai: " + n);
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        int luachon;

        do {
            System.out.println("_____MENU_____");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Hien thi danh sach nhan vien");
            System.out.println("3. Them nhan vien");
            System.out.println("4. Tim kiem nhan vien");
            System.out.println("5. Xoa nhan vien");
            System.out.println("6. Sua thong tin nhan vien");
            System.out.println("7. Dem so luong nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            luachon = scanner.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (luachon == 1) {
                dsnv.nhap();
            } else if (luachon == 2) {
                dsnv.xuat();
            } else if (luachon == 3) {
                dsnv.them();
            } else if (luachon == 4) {
                dsnv.timKiem();
            } else if (luachon == 5) {
                dsnv.xoa();
            } else if (luachon == 6) {
                dsnv.sua();
            } else if (luachon == 7) {
                dsnv.dem();
            } else if (luachon == 0) {
                System.out.println("Ket thuc chuong trinh.");
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        } while (luachon != 0);
    }
}

