package people.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readfile {

    public void read() {
        String[] names = new String[100];
        String[] customerIds = new String[100];
        String[] phones = new String[100];
        String[] birthDates = new String[100];
        String[] emails = new String[100];
        String[] addresses = new String[100];
        int lineCount = 0;

        try {
            BufferedReader input = new BufferedReader(new FileReader("src/input/client.txt"));
            String line = input.readLine();

            while (line != null) {
                String[] parts = line.split(", ");
                if (parts.length == 6) {
                    names[lineCount] = parts[0].trim();
                    customerIds[lineCount] = parts[1].trim();
                    phones[lineCount] = parts[2].trim();
                    birthDates[lineCount] = parts[3].trim();
                    emails[lineCount] = parts[4].trim();
                    addresses[lineCount] = parts[5].trim();
                    lineCount++;
                }
                line = input.readLine();
            }

            int indexWidth = 3;
            int nameWidth = 30;
            int customerIdWidth = 10;
            int phoneWidth = 15;
            int birthDateWidth = 15;
            int emailWidth = 35;
            int addressWidth = 25;

            // In header
            System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + customerIdWidth + "s| %-" + phoneWidth + "s| %-" + birthDateWidth + "s| %-" + emailWidth + "s| %-" + addressWidth + "s|",
                    "No.", "Name", "Customer ID", "Phone", "Birth Date", "Email", "Address"));

            // In dữ liệu từng khách hàng
            for (int i = 0; i < lineCount; i++) {
                System.out.println(String.format("| %-" + indexWidth + "s| %-" + nameWidth + "s| %-" + customerIdWidth + "s| %-" + phoneWidth + "s| %-" + birthDateWidth + "s| %-" + emailWidth + "s| %-" + addressWidth + "s|",
                        (i + 1), names[i], customerIds[i], phones[i], birthDates[i], emails[i], addresses[i]));
            }
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
