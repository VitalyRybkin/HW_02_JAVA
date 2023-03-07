import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class task_01 {
    public static void main(String[] args) {

        int[] my_arr = new int[]{6,4,5,3,8,9,0,1};
        int temp;
        String to_log;
        for (int j = 0; j < my_arr.length; j ++) {
            for (int i = 0; i < my_arr.length - 1 - j; i ++){
                if (my_arr[i] > my_arr[i + 1]){
                    temp = my_arr[i];
                    my_arr[i] = my_arr[i + 1];
                    my_arr[i + 1] = temp;
                }
            try(FileWriter writer = new FileWriter("log_file.txt", true))
            {
                Date date = new Date();
                String date_to_write = date + ": " + "i-" + i + " ";
                writer.write(date_to_write);
                to_log = Arrays.toString(my_arr);
                writer.write(to_log);
                writer.append('\n');
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            }
        }
        System.out.print(Arrays.toString(my_arr));
    }
}