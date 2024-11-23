package house.showoff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readfile {
    public void read() {
        String[] names = new String[100];
        String[] districts = new String[100];
        String[] condition = new String[100];
        int lineCount = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/input/house.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    districts[lineCount] = parts[0].trim();
                    names[lineCount] = parts[1].trim();
                    condition[lineCount] = parts[2].trim();
                    lineCount++;
                }
                line = input.readLine();
            }

            int indexWidth = 3;
            int nameWidth = 70;
            int districtWidth = 38;
            int conditionWidth = 10;

            System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + districtWidth + "s|" + " %-" + conditionWidth + "s|", "No.", "Name", "District", "Condition"));

            for (int i = 0; i < lineCount; i++) {
                System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + districtWidth + "s|" + " %-" + conditionWidth + "s|", (i + 1), names[i], districts[i], condition[i]));
            }
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}