class Food {
    String name;
    int basePrice;

    public Food(String name, int basePrice) {
        if (basePrice >= 1000000) {
            System.out.println("Invalid price!");
            basePrice = 0;
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    public int calcPrice() {
        return basePrice + 5000; // labour cost
    }

    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
        System.out.println();
    }
}

// Subclass Regular
class RegularMenu extends Food {

    public RegularMenu(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 10000;
    }
}

// Subclass Special
class SpecialMenu extends Food {

    public SpecialMenu(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 20000;
    }
}

// Main
public class Nomor3 {
    public static void main(String[] args) {

        Food f1 = new Food("Beef Rendang", 15000);
        Food f2 = new RegularMenu("Chicken Ramen", 20000);
        Food f3 = new SpecialMenu("Fiery Fried Rice", 80000);

        f1.getInfo();
        f2.getInfo();
        f3.getInfo();
    }
}