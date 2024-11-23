package people.client;
import java.util.Arrays;
import java.util.Scanner;
interface INhapXuat{
    public void nhap();
    public void xuat();
}
class KhachHang implements INhapXuat{
    Scanner rd = new Scanner(System.in);
    private String makh;
    public KhachHang(){}
    public KhachHang(String makh){
        this.makh = makh;
    }
    public void nhap(){
        System.out.print("Nhap ma khach hang: ");
        makh = rd.nextLine();
    }
    public void xuat(){
        System.out.println("Ma khach hang: "+makh);
    }
    public String getMa(){
        return makh;
    }
    public void setMa(String makh){
        this.makh = makh;
    }
}
class DSKH implements INhapXuat{
    Scanner rd = new Scanner(System.in);
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
        dskh[n] = new KhachHang();
        dskh[n].nhap();
        n++;
        int choose;
        System.out.print("\nTiep tuc them khach hang? ");
        choose = rd.nextInt();
        while(choose != 1 && choose != 0){
            System.out.print("\nVui long nhap lai ");
            choose = rd.nextInt();
        }
        if(choose == 1){
            do{
                dskh = Arrays.copyOf(dskh, n+1);
                dskh[n] = new KhachHang();
                dskh[n].nhap();
                n++;
                System.out.print("\nTiep tuc them khach hang? ");
                choose = rd.nextInt();
                while(choose != 1 && choose != 0){
                    System.out.print("\nVui long nhap lai ");
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
            }
        }
        
    }
    public void timkiem(){
        System.out.print("Nhap ma khach hang muon tim kiem: ");
        String maKH = rd.nextLine();
        for(int i = 0; i < n; i++){
            if(dskh[i].getMa().equals(maKH)){
                dskh[i].xuat();
                break;
            }
            System.out.println("Khong tim thay khach hang");
        }
    }
    public void sua(){
        System.out.print("Nhap ma khach hang muon sua: ");
        String maKH = rd.nextLine();
        for(int i = 0; i < n; i++){
            if(dskh[i].getMa().equals(maKH)){
                System.out.println("------------------------");
                dskh[i].nhap();
            }
        }
    }
}
class QuanLyDSKH{
    Scanner rd = new Scanner(System.in);
    DSKH ds = new DSKH();
    public void menu(){
        while(true){
            System.out.println("\n======================DANH SACH KHACH HANG======================");
            System.out.println("1.Xem danh sach khach hang");
            System.out.println("2.Them khach hang");
            System.out.println("3.Sua thong tin khach hang");
            System.out.println("4.Tim kiem khach hang");
            System.out.println("5.Xoa");
            System.out.println("6.Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = rd.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
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
                    return;
                default:
                    System.out.println("Lua chon khong hop le");    
            }
        }
    } 
}
public class Project{
    public static void main(String[] args) {
        QuanLyDSKH ql = new QuanLyDSKH();
        ql.menu();
    }
}