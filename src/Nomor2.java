import java.util.*;

abstract class Stand {
    abstract boolean expose(String name);
}

class Jotaro extends Stand {
    @Override
    boolean expose(String name) {
        return name.length() <= 3;
    }
}

class Okuyasu extends Stand {
    @Override
    boolean expose(String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == name.charAt(i + 1)) return true;
        }
        return false;
    }
}

class Koichi extends Stand {
    @Override
    boolean expose(String name) {
        int count = 0;
        for (char c : name.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count >= 3;
    }
}

class Rohan extends Stand {
    @Override
    boolean expose(String name) {
        String rev = new StringBuilder(name).reverse().toString();
        return name.equalsIgnoreCase(rev);
    }
}

public class Nomor2 {
    public static void main(String[] args) {

        String input = "Okuyasu john paul mary ian leo samuel Ian roy aaron";
        String[] data = input.split(" ");

        String standName = data[0];

        // pilih stand
        Stand stand = null;
        if (standName.equals("Jotaro")) stand = new Jotaro();
        if (standName.equals("Okuyasu")) stand = new Okuyasu();
        if (standName.equals("Koichi")) stand = new Koichi();
        if (standName.equals("Rohan")) stand = new Rohan();

        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i < data.length; i++) {
            queue.add(data[i]);
        }

        Stack<String> arrested = new Stack<>();

        while (!queue.isEmpty()) {
            String name = queue.poll();
            if (stand != null && stand.expose(name)) {
                arrested.push(name.toLowerCase());
            }       
        }

        if (arrested.isEmpty()) {
            System.out.println(standName + " exposed no one.");
        } else {
            System.out.println(standName + " exposed someone!");
        }

        System.out.println("Arrested: " + arrested);
    }
}