import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task_02 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        BufferedReader reader;
        StringBuilder new_string = new StringBuilder();
        System.out.println("Решение через обработку при чтении из файла:");
        try {
            reader = new BufferedReader(new FileReader("data_file.txt"));
            String line = reader.readLine();
            while (line != null) {
                int i = 0;
                new_string.append("Студент ");
                i = move_idx(i, line);
                i = write_string(i, line, new_string);

                new_string.append(" получил ");
                i = move_idx(i, line);
                i = write_string(i, line, new_string);

                new_string.append(" по предмету ");
                i = move_idx(i, line);
                write_string(i, line, new_string);

                System.out.println(new_string);
                new_string.setLength(0);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Время:" + elapsed);


        start = System.nanoTime();
        System.out.println("\nРешение через метод split() и массив:");

        try {
            reader = new BufferedReader(new FileReader("data_file.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] str_array = line.split("[\",:]");
                for (String s : str_array) {
                    switch (s) {
                        case "фамилия" -> new_string.append("Студент ");
                        case "оценка" -> new_string.append(" получил ");
                        case "предмет" -> new_string.append(" по предмету ");
                        default -> new_string.append(s);
                    }
                }
                System.out.println(new_string);
                new_string.setLength(0);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("Время:" + elapsed);

    }
    public static int move_idx(int i, String line){
        while (line.charAt(i) != ':') i ++;
        return i;
    }

    public static int write_string(int i, String line, StringBuilder new_string){
        i ++;
        while (line.charAt(i) != ',' && i != line.length() - 1){
            if (line.charAt(i) != '\"') new_string.append(line.charAt(i));
            i ++;
        }
        return i;
    }
}
