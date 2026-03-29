import java.util.*;

public class Nomor1 {
    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";
        String[] arr = input.split(" ");

        // 1. Ambil pair
        List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            pairs.add(new String[]{arr[i], arr[i+1]});
        }

        // 2. Urutan sesuai soal
        int[] order = {3, 1, 0, 2, 4};

        // 3. Stack hasil
        Stack<String> stack = new Stack<>();
        for (int i : order) {
            stack.push(pairs.get(i)[0]);
            stack.push(pairs.get(i)[1]);
        }

        // 4. Output
        System.out.println(stack);
    }
}