package people.client;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import Inhapxuat.Inhapxuat;

class ThoiGian implements Inhapxuat{
    Scanner rd = new Scanner(System.in);
    private int ngay, thang, nam;

    public ThoiGian(){}

    public ThoiGian(int n, ThoiGian[] tg, int ngay, int thang, int nam){
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    
    public void nhap(){
        System.out.print("Nhap thang: ");
        thang = rd.nextInt();
        while(thang < 1 || thang > 12){
            System.out.println("Nhap lai ");
            thang = rd.nextInt();
        }
        System.out.print("Nhap ngay: ");
        ngay = rd.nextInt();
        while(ngay < 1 || ngay > 31){
            System.out.println("Nhap lai ");
            ngay = rd.nextInt();
        }
        System.out.print("Nhap nam: ");
        nam = rd.nextInt();
        rd.nextLine();
    }

    public void xuat(){
        System.out.print("Ngay sinh: ");
        System.out.print(ngay+"/"+thang+"/"+nam);
    }

    public int getNgay(){
        return ngay;
    }
    public void setNgay(int ngay){
        this.ngay = ngay;
    }

    public int getThang(){
        return thang;
    }
    public void setThang(int thang){
        this.thang = thang;
    }

    public int getNam(){
        return nam;
    }
    public void setNam(int nam){
        this.nam = nam;
    }
}

class KhachHang implements Inhapxuat{
    Scanner rd = new Scanner(System.in);
    ThoiGian tg = new ThoiGian();

    private String makh;
    private String hoten;
    private String sdt;
    private String email;
    private String diachi;

    public KhachHang(){}

    public KhachHang(String makh, String hoten, String sdt, String email, String diachi,ThoiGian tg){
        this.makh = makh;
        this.hoten = hoten;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.tg = tg;
    }

    public void nhap(){
        // ------------phần của Đạt ---------------- //
        try{
            FileWriter fw = new FileWriter("src/input/client.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            // ------------phần của Huy ---------------- //
            System.out.print("\nNhap ten khach hang: ");
            hoten = rd.nextLine();
            System.out.print("Nhap ma khach hang: ");
            makh = rd.nextLine();
            System.out.print("Nhap so dien thoai: ");
            sdt = rd.nextLine();
            System.out.println("Nhap sinh nhat: ");
                tg.nhap();
            System.out.print("\nNhap email: ");
            email = rd.nextLine();
            System.out.print("Nhap dia chi: ");
            diachi = rd.nextLine();
            // ------------phần của Đạt ---------------- //
            bw.write(hoten+", "+makh+", "+sdt+", "+tg.getNgay()+"/"+tg.getThang()+"/"+tg.getNam()+", "+email+", "+diachi);
            bw.close();
        }catch(IOException e){
            System.out.println(e);
        } 
    }

    public void xuat(){
        System.out.println("\nTen khach hang: "+hoten);
        System.out.println("Ma khach hang: "+makh);
        System.out.println("So dien thoai: "+sdt);
            tg.xuat();
        System.out.println("\nEmail: "+email);
        System.out.println("Dia chi: "+diachi);
    }

    public String getMa(){
        return makh;
    }
    public void setMa(String makh){
        this.makh = makh;
    }

    public String getHoTen(){
        return hoten;
    }
    public void setHoTen(String hoten){
        this.hoten = hoten;
    }

    public String getSDT(){
        return sdt;
    }
    public void setSDT(String sdt){
        this.sdt = sdt;
    }

    public String getMail(){
        return email;
    }
    public void setMail(String email){
        this.email = email;
    }

    public String getDC(){
        return diachi;
    }
    public void setDC(String diachi){
        this.diachi = diachi;
    }
}

class DSKH implements Inhapxuat{
    Scanner rd = new Scanner(System.in);
    ThoiGian tg = new ThoiGian();
    private static int dem = 0;
    KhachHang[] dskh;
    private int n;

    public DSKH(){
        dskh = new KhachHang[0];
        n = 0;
    }

    public DSKH(KhachHang[] dskh, int n){
        this.n = n;
        this.dskh = dskh;
    }

    public void nhap(){
        System.out.print("Nhap so luong khach hang: ");
        n = rd.nextInt();
        rd.nextLine();
        dskh = new KhachHang[n];
        for (int i = 0; i < n; i++){
            System.out.println("------------------------");
            System.out.println("Nhap thong tin khach hang thu "+(i+1));
            dskh[i] = new KhachHang();
            dskh[i].nhap();
            dem++;
        }
    }

    @Override
    public void xuat(){
        for(int i = 0; i < n; i++){
            System.out.println("------------------------");
            System.out.println("Khach hang thu "+(i+1));
            dskh[i].xuat();
        }
    }

    public void them(){
        dskh = Arrays.copyOf(dskh, n+1);
        System.out.println("----------------------------------");
        System.out.println("Nhap thong tin khach hang thu "+(n+1));
        dskh[n] = new KhachHang();
        dskh[n].nhap();
        n++;
        int choose;
        System.out.print("\nTiep tuc them khach hang? ");
        choose = rd.nextInt();
        rd.nextLine();
        while(choose != 1 && choose != 0){
            System.out.print("Vui long nhap lai ");
            choose = rd.nextInt();
        }
        dem++;
        if(choose == 1){
            do{
                dskh = Arrays.copyOf(dskh, n+1);
                System.out.println("----------------------------------");
                System.out.println("Nhap thong tin khach hang thu "+(n+1));
                dskh[n] = new KhachHang();
                dskh[n].nhap();
                n++;
                System.out.print("\nTiep tuc them khach hang? ");
                choose = rd.nextInt();
                rd.nextLine();
                while(choose != 1 && choose != 0){
                    System.out.print("Vui long nhap lai ");
                    choose = rd.nextInt();
                }
                dem++;
            }
            while(choose == 1);
        }
    }

    public void xoa(){
        System.out.print("Nhap ma khach hang muon xoa: ");
        String maKH = rd.nextLine();
        try {
            File file = new File("src/input/client.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (!parts[1].equals(maKH)) {
                    sb.append(line).append("\n");
                }
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1); // Xoa ky tu newline cuoi cung
            }

            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.close();
            System.out.println("Da xoa khach hang ma " + maKH);
            dem--;

        } catch (IOException e) {
            System.out.println("Loi khi xu ly file: " + e.getMessage());
        }
    }

    // public void xoa(){
    //     System.out.print("Nhap ma khach hang muon xoa: ");
    //     String maKH = rd.nextLine();
    //     for (int i = 0; i < n; i++){
    //         if(dskh[i].getMa().equals(maKH)){
    //             for(int j = i; j < n-1; j++){
    //                 dskh[j] = dskh[j+1];
    //             }
    //             dskh = Arrays.copyOf(dskh, n-1);
    //             n--;
    //             break;
    //         }
    //     }
    // }

    public void timkiem(){
        System.out.print("Nhap ma khach hang muon tim kiem: ");
        String maKH = rd.nextLine();
        try {
            File file = new File("src/input/client.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts[1].equals(maKH)) {
                    found = true;
                    System.out.println(line);
                    break;
                }
            }
            if (!found) {
                System.out.println("Khong tim thay khach hang");
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void sua() {
        System.out.print("Nhap ma khach hang muon sua: ");
        String maKH = rd.nextLine();
        File file = new File("src/input/client.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            boolean found = false;
    
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (!parts[1].equals(maKH)) {
                    sb.append(line).append("\n");
                } else {
                    found = true;
                    int luachon;
                    do {
                        System.out.println("------------------------");
                        System.out.println("1. Sua ten");
                        System.out.println("2. Sua sdt");
                        System.out.println("3. Sua email");
                        System.out.println("4. Sua ngay sinh");
                        System.out.println("5. Sua dia chi");
                        System.out.println("0. Quay lai");
                        System.out.print("Chon: ");
                        luachon = rd.nextInt();
                        rd.nextLine(); // Đọc bỏ dòng trống
    
                        switch (luachon) {
                            case 1:
                                System.out.print("Nhap ten moi: ");
                                parts[0] = rd.nextLine(); // Tên ở vị trí đầu tiên
                                break;
                            case 2:
                                System.out.print("Nhap sdt moi: ");
                                parts[2] = rd.nextLine(); // Số điện thoại ở vị trí thứ 3
                                break;
                            case 3:
                                System.out.print("Nhap email moi: ");
                                parts[4] = rd.nextLine(); // Email ở vị trí thứ 5
                                break;
                            case 4:
                                System.out.print("Nhap ngay sinh moi: ");
                                parts[3] = rd.nextLine(); // Ngày sinh ở vị trí thứ 4
                                break;
                            case 5:
                                System.out.print("Nhap dia chi moi: ");
                                parts[5] = rd.nextLine(); // Địa chỉ ở vị trí thứ 6
                                break;
                            case 0:
                                System.out.println("Quay lai.");
                                break;
                            default:
                                System.out.println("lua chon khong hop le.");
                        }
                    } while (luachon != 0);
    
                    // Ghi lại dòng đã sửa
                    line = String.join(", ", parts);
                    sb.append(line).append("\n");
                }
            }
            br.close();
    
            // Nếu tìm thấy, ghi lại file; nếu không, thông báo lỗi
            if (found) {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString());
                bw.close();
                System.out.println("Thong tin khach hang da duoc sua.");
            } else {
                System.out.println("Khong tim thay khach hang: " + maKH);
            }
        } catch (IOException e) {
            System.out.println("loai file khong hop le: " + e.getMessage());
        }
    }
    public void Dem(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/input/client.txt"))) {
            int count = 0;
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("So luong khach hang trong file: "+count);
        } catch (IOException e) {
            System.out.println("Loi khi xu ly file: " + e.getMessage());
        }
    }
}    

class QuanLyDSKH{
    Scanner rd = new Scanner(System.in);
    DSKH ds = new DSKH();
    public void menu(){
        int choice;
        ds.nhap();
        do{
            System.out.println ("==============================================================client==============================================================");
            Readfile raf = new Readfile();
            raf.read();
            System.out.println ("----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("|1.Xem danh sach khach hang                                                                                                      |");
            System.out.println ("|2.Them khach hang                                                                                                               |");
            System.out.println ("|3.Sua thong tin khach hang                                                                                                      |");
            System.out.println ("|4.Tim kiem khach hang                                                                                                           |");
            System.out.println ("|5.Xoa                                                                                                                           |");
            System.out.println ("|6.So luong khach hang                                                                                                           |");
            System.out.println ("|0.Thoat                                                                                                                         |");
            System.out.println ("==================================================================================================================================");

            System.out.print("Nhap lua chon cua ban: ");
            choice = rd.nextInt();
            switch(choice){
                case 1:
                    ds.xuat();
                    break;
                case 2:
                    ds.them();
                    break;
                case 3:
                    ds.sua();
                    break;  
                case 4:
                    ds.timkiem();
                    break;
                case 5:
                    ds.xoa();
                    break;
                case 6:
                    ds.Dem();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");    
            }
        }
        while(choice != 0);
    } 
}

public class Project{
    public static void main() {
        QuanLyDSKH ql = new QuanLyDSKH();
        ql.menu();
    }
}