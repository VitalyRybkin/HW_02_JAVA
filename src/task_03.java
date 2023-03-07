import java.util.Scanner;

public class task_03 {
    public static void main(String[] args) {
        Scanner scan_line = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String string_to_check = scan_line.next();

        System.out.print(is_polyndromic(string_to_check));
    }

    public static boolean is_polyndromic(String string_to_check){
        int forward_idx = 0;
        int backward_idx = string_to_check.length() - 1;
        while (forward_idx < backward_idx) {
            if (string_to_check.charAt(forward_idx) == string_to_check.charAt(backward_idx)){
            forward_idx ++;
            backward_idx --;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
