package quotes;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class ReadAndWrite {
    private Formatter formatter;

    public StringBuilder readMyFile(String path, StringBuilder str) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            str.append(scanner.nextLine());
        }
        return str;
    }

    public void usingBufferedWritter(String path, String stuffToAppend) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.newLine();
        writer.write(stuffToAppend);
        writer.close();
    }

    public void writeToFile(String stuffToAddToFile, String path) throws FileNotFoundException {
        formatter = new Formatter(path);
        formatter.format(stuffToAddToFile);
    }

    public void closeFile() {
        formatter.close();
    }
}
