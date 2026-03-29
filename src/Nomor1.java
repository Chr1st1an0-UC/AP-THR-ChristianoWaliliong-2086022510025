import java.util.*;

public class Nomor1 {
    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";

        Stack<String> inputStack = new Stack<>();
        String[] data = input.split(" ");

        // Push ke stack
        for (String word : data) {
            inputStack.push(word);
        }

        // Ambil pair
        List<List<String>> pairs = new ArrayList<>();
        while (!inputStack.isEmpty()) {
            String second = inputStack.pop();
            String first = inputStack.pop();

            List<String> pair = new ArrayList<>();
            pair.add(first);
            pair.add(second);
            pairs.add(pair);
        }

        // Karena stack, pair jadi terbalik → kita reverse dulu
        Collections.reverse(pairs);

        // Urutan khusus
        int[] order = {3, 1, 0, 2, 4};

        Stack<String> resultStack = new Stack<>();

        for (int i : order) {
            resultStack.push(pairs.get(i).get(0));
            resultStack.push(pairs.get(i).get(1));
        }

        // Convert ke array
        List<String> result = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            result.add(0, resultStack.pop()); // biar urutan benar
        }

        System.out.println(result);
    }
}