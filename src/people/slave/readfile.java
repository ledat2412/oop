package people.slave;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readfile {
    public void read() {
        String[] names = new String[100];
        String[] Job = new String[100];
        String[] ID = new String[100];
        String[] TEL = new String[100];
        String[] Email = new String[100];
        String[] Sal = new String[100];
        String[] Birth = new String[100];
        String[] infor = new String[100];
        int lineCount = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/input/worker.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 8) {
                    Job[lineCount] = parts[0].trim();
                    ID[lineCount] = parts[1].trim();
                    names[lineCount] = parts[2].trim();
                    TEL[lineCount] = parts[3].trim();
                    Email[lineCount] = parts[4].trim();
                    Sal[lineCount] = parts[5].trim();
                    Birth[lineCount] = parts[6].trim();
                    infor[lineCount] = parts[7].trim();
                    lineCount++;
                }
                line = input.readLine();
            }

            int indexWidth = 3;
            int indexWidthBlank = 3;
            int nameWidth = 18;
            int IDWidth = 27;
            int JobWidth = 18;
            int TELWidth = 20;
            int EmailWidth = 42;
            int SalWidth = 27;
            int BirthWidth = 12;
            int InforWidth = 76;

            // System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + districtWidth + "s|" + " %-" + conditionWidth + "s|", "No.", "Name", "District", "Condition"));

            // for (int i = 0; i < lineCount; i++) {
            //     System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + IDWidth + "s|" + " %-" + TELWidth + "s|" + " %-" + EmailWidth + "s|" + " %-" + BirthWidth + "s|" + "\n" + "|  %-" + indexWidthBlank + "s  | %-" + JobWidth + "s| %-" + SalWidth + "s|" + " %-" + InforWidth + "s|", (i + 1), names[i], "ID: " + ID[i], "TEL: " + TEL[i], "Email: " + Email[i], Birth[i], Job[i], "Salary: " + Sal[i], "Information: " + infor[i]));
            //     System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + IDWidth + "s|" + " %-" + TELWidth + "s|" + " %-" + EmailWidth + "s|" + " %-" + BirthWidth + "s|", (i + 1), names[i], "ID: " + ID[i], "TEL: " + TEL[i], "Email: " + Email[i], Birth[i]));
            //     System.out.println(String.format("| %-" + indexWidthBlank + "s| %-" + JobWidth + "s| %-" + SalWidth + "s|" + " %-" + InforWidth + "s|",  Job[i], "Salary: " + Sal[i], "Information: " + infor[i]));
            // }
            for (int i = 0; i < lineCount; i++) {
                System.out.println(String.format(
                    "| %-" + indexWidth + "s|%-" + nameWidth + "s|%-" + IDWidth + "s|%-" + TELWidth + "s|%-" + EmailWidth + "s|%-" + BirthWidth + "s|\n" +
                    "| %-" + indexWidthBlank + "s|%-" + JobWidth + "s|%-" + SalWidth + "s|%-" + InforWidth + "s|",
                    (i + 1), 
                    names[i], 
                    "ID: " + ID[i], 
                    "TEL: " + TEL[i], 
                    "Email: " + Email[i], 
                    Birth[i], 
                    "",
                    Job[i], 
                    "Salary: " + Sal[i], 
                    "Information: " + infor[i]
                ));
                System.out.println("|    |---------------------------------------------------------------------------------------------------------------------------|");
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            }
        }