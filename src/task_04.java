import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_04 {
    public static void main(String[] args) {
        Scanner scan_line = new Scanner(System.in);

        System.out.print("Enter first num: ");
        int num_1 = scan_line.nextInt();
        System.out.print("Enter operation: ");
        String oper = scan_line.next();
        System.out.print("Enter second num: ");
        int num_2 = scan_line.nextInt();
        try {
            calc(num_1, oper, num_2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void calc(int num_1, String oper, int num_2) throws IOException {
        int res = switch (oper) {
            case "-" -> num_1 - num_2;
            case "+" -> num_1 + num_2;
            case "/" -> num_1 / num_2;
            case "*" -> num_1 * num_2;
            default -> 0;
        };

        String to_log = "";
        try(FileWriter writer = new FileWriter("calc_log.txt", true))
        {
            Date date = new Date();
            String date_to_write = date + ": ";
            writer.write(date_to_write);
            to_log = num_1 + " " + oper + " " + num_2 + " = " + res;
            writer.write(to_log);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Result is " + res);

        Logger log = java.util.logging.Logger.getLogger(task_04.class.getName());
        try {
            FileHandler file = new FileHandler("calc_log.log", true);
            log.addHandler(file);
            SimpleFormatter form = new SimpleFormatter();
            file.setFormatter(form);
            log.info(to_log);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
