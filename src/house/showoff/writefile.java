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
            while(true){
                System.out.print("Nhap ten nha: ");
                String name = sc.nextLine();
                System.out.print("Nhap dia chi: ");  
                String address = sc.nextLine();
                bw.write( address + ", " + name + "\n");
                System.out.print("Ban co muon nhap tiep khong? (Y/N): ");
                String choice = sc.nextLine();
                if(choice.equals("N") || choice.equals("n")){
                    break;
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}