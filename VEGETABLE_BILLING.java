import java.util.*;
class Vegetable {
    int id;
    String name;
    double pricePerKg;
    double quantity;
    Vegetable(int id, String name, double pricePerKg, double quantity) {
        this.id = id;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.quantity = quantity;
    }
    double getTotalPrice() {
        return pricePerKg * quantity;
    }
    void display() {
        System.out.printf("%-4d %-10s %-10.2f %-8.2f %-10.2f\n", 
                          id, name, pricePerKg, quantity, getTotalPrice());
    }
}
class VegetableShop {
    Vegetable[] vegetables;
    int count;
    VegetableShop(int size) {
        vegetables = new Vegetable[size];
        count = 0;
    }
    void addVegetable(Vegetable v) {
        if (count < vegetables.length) {
            vegetables[count++] = v;
        }
    }
    void showBill() {
        double grandTotal = 0;
        System.out.println("\nID   Name       Price/Kg   Qty(kg)  Total");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < count; i++) {
            vegetables[i].display();
            grandTotal += vegetables[i].getTotalPrice();
        }
        System.out.println("----------------------------------------------");
        System.out.println("Grand Total = Rs. " + grandTotal);
    }
}
public class VegetableBilling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vegetables: ");
        int n = s.nextInt();
        VegetableShop shop = new VegetableShop(n);
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter Vegetable " + (i + 1) + " details");
            System.out.print("Vegetable ID: ");
            int id = s.nextInt();
            s.nextLine(); 
            System.out.print("Vegetable Name: ");
            String name = s.nextLine();
            System.out.print("Price per Kg: ");
            double price = s.nextDouble();
            System.out.print("Quantity (Kg): ");
            double qty = s.nextDouble();
            Vegetable v = new Vegetable(id, name, price, qty);
            shop.addVegetable(v);
        }
        shop.showBill();
    }
}