package people.client;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
interface INhapXuat{
    public void nhap();
    public void xuat();
}

class ThoiGian implements INhapXuat{
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

class KhachHang implements INhapXuat{
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

class DSKH implements INhapXuat{
    Scanner rd = new Scanner(System.in);
    ThoiGian tg = new ThoiGian();
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
        }
    }

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
            }
            while(choose == 1);
        }
    }

    public void xoa(){
        System.out.print("Nhap ma khach hang muon xoa: ");
        String maKH = rd.nextLine();
        for (int i = 0; i < n; i++){
            if(dskh[i].getMa().equals(maKH)){
                for(int j = i; j < n-1; j++){
                    dskh[j] = dskh[j+1];
                }
                dskh = Arrays.copyOf(dskh, n-1);
                n--;
                break;
            }
        }
    }

    public void timkiem(){
        System.out.print("Nhap ma khach hang muon tim kiem: ");
        String maKH = rd.nextLine();
        boolean find = false;
        for(int i = 0; i < n; i++){
            if(dskh[i].getMa().equals(maKH)){
                find = true;
                dskh[i].xuat();
                break;
            }
        }
        if (!find){
            System.out.println("Khong tim thay khach hang");
        }
    }

    public void sua(){
        System.out.print("Nhap ma khach hang muon sua: ");
        String maKH = rd.nextLine();
        for(int i = 0; i < n; i++){
            if(dskh[i].getMa().equals(maKH)){
                int luachon;
                do{
                    System.out.println("------------------------");
                    dskh[i].xuat();
                    System.out.println("------------------------");
                    System.out.println("1.Sua ten khach hang: ");
                    System.out.println("2.Sua so dien thoai: ");
                    System.out.println("3.Sua email: ");
                    System.out.println("4.Nhap ngay sinh: ");
                    System.out.println("5.Sua dia chi: ");
                    System.out.println("0.Quay lai. ");
                    System.out.print("Chon thong tin muon sua: ");
                    luachon = rd.nextInt();
                    rd.nextLine();
                    switch(luachon){
                        case 1:
                            System.out.print("Nhap ten moi: ");
                            dskh[i].setHoTen(rd.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap so dien thoai moi: ");
                            dskh[i].setSDT(rd.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap email moi: ");
                            dskh[i].setMail(rd.nextLine());
                            break;
                        case 4:
                            System.out.println("Nhap ngay sinh moi: ");
                            dskh[i].tg.nhap();
                            break;
                        case 5:
                            System.out.print("Nhap dia chi moi: ");
                            dskh[i].setDC(rd.nextLine());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                    }
                }
                while(luachon != 0);
            }
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
            Readfile raf = new Readfile();
            raf.read();
            System.out.println("\n======================DANH SACH KHACH HANG======================");
            System.out.println("1.Xem danh sach khach hang");
            System.out.println("2.Them khach hang");
            System.out.println("3.Sua thong tin khach hang");
            System.out.println("4.Tim kiem khach hang");
            System.out.println("5.Xoa");
            System.out.println("0.Thoat");
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