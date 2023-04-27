import java.io.*;
import java.util.Scanner;

public class DataAccess {
    private static int[][] list;

    public static void readFile(String filePath) {
        File file = new File(filePath);
        int[][] numbers = new int[4][4]; // zakładamy, że plik zawiera maksymalnie 100 wierszy
        int row = 0;
        boolean skipFirstLine = true; // zmienna określająca, czy należy pominąć pierwszy wiersz

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue; // pomiń pierwszy wiersz
                }

                String[] values = line.split(" ");

                for (int i = 0; i < values.length; i++) {
                    numbers[row][i] = Integer.parseInt(values[i]);
                }

                row++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list = numbers;
    }

    public static void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(list[i][j]);
            }
        }
    }

    public static Node initialNode(String filePath) {
        int x = 0;
        int y = 0;
        readFile(filePath);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (list[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        return new Node(null, list, x, y, ' ', 0);
    }

    public static void write(String filePath, StringBuilder message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(message.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
