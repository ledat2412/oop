package people.slave;
import java.util.Scanner;
import java.util.Arrays;
// tao bien tao switch sai set de lay
// tao lop nhan vien la lop da hinh
class NhanVien
{
    private String Ma;
    private int Luong;
    private String Hovaten;
    private String Sodienthoai;
    private String Ngaysinh;
    private String Email;
    public NhanVien() {
        Ma = "";
        Hovaten="";
        Sodienthoai="";
        Ngaysinh="";
        Email="";
        Luong = 0;
        
    }

    public NhanVien(String Ma, int Luong ,String Hovaten,String Ngaysinh,String Sodienthoai,String Email) {
        this.Ma = Ma;
        this.Hovaten=Hovaten;
        this.Sodienthoai=Sodienthoai;
        this.Ngaysinh=Ngaysinh;
        this.Email=Email;
        this.Luong = Luong;
       
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHovaten()
    {
        return Hovaten;
    }
    public void sethovaten(String Hovaten)
    {
        this.Hovaten=Hovaten;
    }
    public String getSodienthoai()
    {
        return Sodienthoai;
    }
    public void setsodienthoai(String Sodienthoai)
    {
        this.Sodienthoai=Sodienthoai;
    }
    public String getNgaysinh()
    {
        return Ngaysinh;
    }
    public void setngaysinh(String Ngaysinh)
    {
        this.Ngaysinh=Ngaysinh;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setemail(String Email)
    {
        this.Email=Email;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

   
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Ma Nhan Vien: ");
        Ma = scanner.nextLine();
        System.out.println("Nhap Ho va Ten Nhan Vien:");
        Hovaten=scanner.nextLine();
        System.out.println("Nhap So dien thoai cua Nhan Vien:");
        Sodienthoai=scanner.nextLine();
        System.out.println("Nhap Ngay sinh cua Nhan Vien:");
        Ngaysinh=scanner.nextLine();
        System.out.println("Nhap Email cua Nhan Vien:");
        Email=scanner.nextLine();
        System.out.println("Nhap Luong cua Nhan Vien:");
        Luong=scanner.nextInt();
    }

    public void xuat() {
        System.out.println("Ma Nhan Vien: " + Ma);
        System.out.println("Ho va ten Nhan Vien:"+Hovaten);
        System.out.println("So dien thoai cua Nhan Vien:"+Sodienthoai);
        System.out.println("Ngay sinh cua Nhan Vien:"+Ngaysinh);
        System.out.println("Email cua Nhan Vien:"+Email);
        System.out.println("Luong Nhan Vien: " + Luong+"VND");
        
    }
}

// Lớp(Nhân viên tiếp tân)
class TiepTan extends NhanVien {
    private String Tuvan;

    public TiepTan() {
        super();
        Tuvan = "";
    }

    public TiepTan(String Ma, int Luong, String Tuvan,String Hovaten,String Sodienthoai,String Ngaysinh,String Email) {
        super(Ma, Luong,Hovaten,Ngaysinh,Sodienthoai,Email);
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

    public LaoCong(String Ma, int Luong, String Dondep,String Hovaten,String Ngaysinh,String Sodienthoai,String Email) {
        super(Ma, Luong,Hovaten,Ngaysinh,Sodienthoai,Email);
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

    public NVQuanLy(String Ma, int Luong, String Quanly,String Hovaten,String Ngaysinh,String Sodienthoai,String Email) {
        super(Ma, Luong,Hovaten,Ngaysinh,Sodienthoai,Email);
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
    System.out.println("Nhap ma nhan vien can sua: ");
    String Ma = scanner.nextLine();
    boolean found = false;

    for (int i = 0; i < n; i++) {
        if (dsnv[i].getMa().equals(Ma)) {
            found = true;
            System.out.println("Thong tin hien tai cua nhan vien:");
            dsnv[i].xuat();
            
            System.out.println("Chon muc can sua:");
           // System.out.println("1. Ma nhan vien");
            System.out.println("1. Ho va ten");
            System.out.println("2. So dien thoai");
            System.out.println("3. Ngay sinh");
            System.out.println("4. Email");
            System.out.println("5. Luong");
            if (dsnv[i] instanceof TiepTan) {
                System.out.println("6. Cong viec tu van");
            } else if (dsnv[i] instanceof LaoCong) {
                System.out.println("6. Cong viec don dep");
            } else if (dsnv[i] instanceof NVQuanLy) {
                System.out.println("6. Cong viec quan ly");
            }
            System.out.print("Lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới còn lại

            switch (choice) {
               // case 1:
                 //   System.out.print("Nhap ma moi: ");
                   // dsnv[i].setMa(scanner.nextLine());
                    //break;
                case 1:
                    System.out.print("Nhap ho va ten moi: ");
                    dsnv[i].sethovaten(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap so dien thoai moi: ");
                    dsnv[i].setsodienthoai(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay sinh moi: ");
                    dsnv[i].setngaysinh(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap email moi: ");
                    dsnv[i].setemail(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap luong moi: ");
                    dsnv[i].setLuong(scanner.nextInt());
                    scanner.nextLine(); // Đọc dòng mới còn lại
                    break;
                case 6:
                    if (dsnv[i] instanceof TiepTan) {
                        System.out.print("Nhap cong viec tu van moi: "); //instanceof ktra xem bien i co trung voi cac lop con neu trung thi in ra lop con do
                        ((TiepTan) dsnv[i]).setTuvan(scanner.nextLine());
                    } else if (dsnv[i] instanceof LaoCong) {
                        System.out.print("Nhap cong viec don dep moi: ");
                        ((LaoCong) dsnv[i]).setDondep(scanner.nextLine());
                    } else if (dsnv[i] instanceof NVQuanLy) {
                        System.out.print("Nhap cong viec quan ly moi: ");
                        ((NVQuanLy) dsnv[i]).setQuanly(scanner.nextLine());
                    }
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
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
            
            // Kiểm tra nhập sai
            while (!scanner.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long nhap lai!");
                scanner.next();
            }
            luachon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luachon) {
                case 1:
                    dsnv.nhap();
                    break;
                case 2:
                    dsnv.xuat();
                    break;
                case 3:
                    dsnv.them();
                    break;
                case 4:
                    dsnv.timKiem();
                    break;
                case 5:
                    dsnv.xoa();
                    break;
                case 6:
                    dsnv.sua();
                    break;
                case 7:
                    dsnv.dem();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

        } while (luachon != 0);

        scanner.close();
    }
}


