package people.slave;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

abstract class NhanVien {
    private String Ma;
    private int Luong;
    private String Hovaten;
    private String Sodienthoai;
    private String Ngaysinh;
    private String Email;

    public NhanVien() {
        Ma = "";
        Hovaten = "";
        Sodienthoai = "";
        Ngaysinh = "";
        Email = "";
        Luong = 0;
    }

    public NhanVien(String Ma, int Luong, String Hovaten, String Ngaysinh, String Sodienthoai, String Email) {
        this.Ma = Ma;
        this.Hovaten = Hovaten;
        this.Sodienthoai = Sodienthoai;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
        this.Luong = Luong;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHovaten() {
        return Hovaten;
    }

    public void setHovaten(String Hovaten) {
        this.Hovaten = Hovaten;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String Sodienthoai) {
        this.Sodienthoai = Sodienthoai;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    // Phương thức abstract yêu cầu lớp con phải ghi đè
    public abstract String getCongViec();

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Ma Nhan Vien: ");
        Ma = scanner.nextLine();
        System.out.print("Nhap Ho va Ten Nhan Vien: ");
        Hovaten = scanner.nextLine();
        System.out.print("Nhap So dien thoai cua Nhan Vien: ");
        Sodienthoai = scanner.nextLine();
        System.out.print("Nhap Ngay sinh cua Nhan Vien: ");
        Ngaysinh = scanner.nextLine();
        System.out.print("Nhap Email cua Nhan Vien: ");
        Email = scanner.nextLine();
        System.out.print("Nhap Luong cua Nhan Vien: ");
        Luong = scanner.nextInt();
        }

    public void xuat() {
        System.out.println("Ma Nhan Vien: " + Ma);
        System.out.println("Ho va ten Nhan Vien: " + Hovaten);
        System.out.println("So dien thoai: " + Sodienthoai);
        System.out.println("Ngay sinh: " + Ngaysinh);
        System.out.println("Email: " + Email);
        System.out.println("Luong: " + Luong + " VND");
    }
}

class TiepTan extends NhanVien {
    private String Tuvan;

    public TiepTan() {
        super();
        Tuvan = "";
    }

    public TiepTan(String Ma, int Luong, String Tuvan, String Hovaten, String Ngaysinh, String Sodienthoai, String Email) {
        super(Ma, Luong, Hovaten, Ngaysinh, Sodienthoai, Email);
        this.Tuvan = Tuvan;
    }

    public String getTuvan() {
        return Tuvan;
    }

    public void setTuvan(String Tuvan) {
        this.Tuvan = Tuvan;
    }

    @Override
    public String getCongViec() {
        return "Tu van: " + Tuvan;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec Tu Van: ");
        Tuvan = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Cong Viec: " + getCongViec());
    }
}

class LaoCong extends NhanVien {
    private String Dondep;

    public LaoCong() {
        super();
        Dondep = "";
    }

    public LaoCong(String Ma, int Luong, String Dondep, String Hovaten, String Ngaysinh, String Sodienthoai, String Email) {
        super(Ma, Luong, Hovaten, Ngaysinh, Sodienthoai, Email);
        this.Dondep = Dondep;
    }

    public String getDondep() {
        return Dondep;
    }

    public void setDondep(String Dondep) {
        this.Dondep = Dondep;
    }

    @Override
    public String getCongViec() {
        return "Don dep: " + Dondep;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec Don Dep: ");
        Dondep = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Cong Viec: " + getCongViec());
    }
}

class NVQuanLy extends NhanVien {
    private String Quanly;

    public NVQuanLy() {
        super();
        Quanly = "";
    }

    public NVQuanLy(String Ma, int Luong, String Quanly, String Hovaten, String Ngaysinh, String Sodienthoai, String Email) {
        super(Ma, Luong, Hovaten, Ngaysinh, Sodienthoai, Email);
        this.Quanly = Quanly;
    }

    public String getQuanly() {
        return Quanly;
    }

    public void setQuanly(String Quanly) {
        this.Quanly = Quanly;
    }

    @Override
    public String getCongViec() {
        return "Quan ly: " + Quanly;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Cong Viec Quan Ly: ");
        Quanly = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Cong Viec: " + getCongViec());
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
        String Loai = "";
        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai nhan vien: 1. Tiep Tan  2. Lao Cong  3. Quan Ly");
            int loai = scanner.nextInt();
            scanner.nextLine();  
            if (loai < 1 || loai > 3) {
                System.out.println("Lua chon khong hop le!");
                i--; 
                continue;
            }
            else if (loai == 1 ){
                Loai = "Tiep Tan";
            }
            else if (loai == 2 ){
                Loai = "Lao Cong";
            }
            else if (loai == 3 ){
                Loai = "Quan Ly";
            }
            else{
                System.out.println("Lua chon hop le!");
            }
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
            ghiFile("src/input/worker.txt", dsnv[i], Loai);
            return;
        }
    }

    // Hàm ghi file
    public void ghiFile(String fileName, NhanVien nv, String Loai) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write( Loai + ", " + nv.getMa() + ", " + nv.getHovaten() + ", " + nv.getSodienthoai() + ", " + nv.getEmail() + ", " + nv.getLuong() + ", " + nv.getNgaysinh() + ", " + nv.getCongViec() + "\n");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // Hàm xuất danh sách nhân viên
    public void xuat() {
        System.out.println("-------------------------");
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
    System.out.println("-------------------------");
    System.out.print("Nhap so luong nhan vien can them: ");
    int soLuongThem = scanner.nextInt();
    scanner.nextLine(); 
    dsnv = Arrays.copyOf(dsnv, n + soLuongThem);
   // Nhập thông tin từng nhân viên
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
    System.out.println("-------------------------");
}


    // Hàm xóa nhân viên
    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        try {
            File file = new File("src/input/worker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (!parts[1].equals(Ma)) {
                    sb.append(line).append("\n");
                } else {
                    found = true;
                }
            }

            if (found) {
                FileWriter fw = new FileWriter(file);
                fw.write(sb.toString());
                fw.close();
                System.out.println("Nhan vien ma " + Ma + " da duoc xoa.");
            } else {
                System.out.println("Khong tim thay nhan vien can xoa.");
            }

        } catch (IOException e) {
            System.out.println("Loi khi xu ly file: " + e.getMessage());
        }
    }

   // Hàm sửa thông tin nhân viên
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can sua: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        try {
            File file = new File("src/input/worker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (!parts[1].equals(Ma)) {
                    sb.append(line).append("\n");
                } else {
                    found = true;
                    System.out.println("Thong tin nhan vien can sua:");
                    System.out.println(line);

                    System.out.println("Chon thong tin can sua:");
                    System.out.println("1. Loai nhan vien");
                    System.out.println("2. Ho va ten nhan vien");
                    System.out.println("3. so dien thoai nhan vien");
                    System.out.println("4. email nhan vien");
                    System.out.println("5. luong nhan vien");
                    System.out.println("6. ngay sinh nhan vien");
                    System.out.println("7. thong tin cong viec nhan vien");
                    System.out.print("Lua chon: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng mới còn lại

                    String newInfo = "";
                    switch (choice) {
                        case 1:
                            int type;
                            do {
                                System.out.println("Chon loai nhan vien moi: ");
                                System.out.println("1. Tiep Tan");
                                System.out.println("2. Don Dep");
                                System.out.println("3. Quan Ly");
                                System.out.print("Lua chon: ");
                                type = scanner.nextInt();
                                scanner.nextLine();
                                if (type < 1 || type > 3) {
                                    System.out.println("Lua chon khong hop le, nhap lai!");
                                }
                            } while (type < 1 || type > 3);

                            switch (type) {
                                case 1:
                                    newInfo = "Tiep Tan";
                                    break;
                                case 2:
                                    newInfo = "Don Dep";
                                    break;
                                case 3:
                                    newInfo = "Quan Ly";
                                    break;
                            }
                            break;
                        case 2:
                            System.out.print("Nhap ho va ten nhan vien moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Nhap so dien thoai nhan vien moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        case 4:
                            System.out.print("Nhap email nhan vien moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        case 5:
                            System.out.print("Nhap luong nhan vien moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        case 6:
                            System.out.print("Nhap ngay sinh nhân viên moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        case 7:
                            System.out.print("Nhap thong tin cong viec moi: ");
                            newInfo = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, nhap lai!");
                            break;
                    }

                    String[] newParts = line.split(", ");
                    if (choice == 1) {
                        newParts[0] = newInfo; // Loại nhân viên
                    } else {
                        newParts[choice] = newInfo;
                    }
                    sb.append(String.join(", ", newParts)).append("\n");
                }
            }

            if (found) {
                FileWriter fw = new FileWriter(file);
                fw.write(sb.toString());
                fw.close();
                System.out.println("thong tin nhan vien da duoc sua.");
            } else {
                System.out.println("khong tim thay nhan vien co ma " + Ma);
            }

        } catch (IOException e) {
            System.out.println("loi khi xu ly file: " + e.getMessage());
        }
    }





    // Hàm tìm kiếm nhân viên
    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.print("Nhap ma nhan vien can tim: ");
        String Ma = scanner.nextLine();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/input/worker.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(", ");
                if (details.length > 1 && details[1].equals(Ma)) {
                    System.out.println("THONG TIN NHAN VIEN CAN TIM:");
                    System.out.println("Loai: " + details[0]);
                    System.out.println("Ma Nhan Vien: " + details[1]);
                    System.out.println("Ho va ten Nhan Vien: " + details[2]);
                    System.out.println("So dien thoai: " + details[3]);
                    System.out.println("Email: " + details[4]);
                    System.out.println("Luong: " + details[5]);
                    System.out.println("Ngay sinh: " + details[6]);
                    System.out.println("Cong Viec: " + details[7]);
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co ma " + Ma);
        }
    }

    // Hàm đếm số lượng nhân viên
    public void dem() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/input/worker.txt"))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Loi khi xu ly file: " + e.getMessage());
        }
        System.out.println("So luong nhan vien hien tai la  " + count);
    }
}
public class Worker {
    public static void main() {
        
        Scanner scanner = new Scanner(System.in);
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        int luachon;

        do {
            System.out.println ("==============================================================worker==============================================================");
            readfile r = new readfile();
            r.read();
            System.out.println ("----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("|1. Nhap danh sach nhan vien                                                                                                     |");
            System.out.println ("|2. Hien thi danh sach nhan vien                                                                                                 |");
            System.out.println ("|3. Them nhan vien                                                                                                               |");
            System.out.println ("|4. Tim kiem nhan vien                                                                                                           |");
            System.out.println ("|5. Xoa nhan vien                                                                                                                |");
            System.out.println ("|6. Sua thong tin nhan vien                                                                                                      |");
            System.out.println ("|7. Dem so luong nhan vien                                                                                                       |");
            System.out.println ("|0. Thoat                                                                                                                        |");
            System.out.println ("==================================================================================================================================");
            System.out.print("Lua chon: ");

            // Kiểm tra nhập sai
            while (!scanner.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long nhap lai!");
                scanner.next();
            }
            luachon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống
            System.out.print("\033[H\033[2J");
            System.out.flush();
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

    }
}