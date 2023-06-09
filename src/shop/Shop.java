package shop;

import shop.clothes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    public int k = 0;
    ArrayList<Cloth> clothes = new ArrayList<>();

    public Shop() {
        addArray();

    }


    public Cloth getCloth(int selectedCloth) {
        return clothes.get(selectedCloth);


    }

    public void showColorCloth(Cloth cloth) {
        for (int i = 0; i < cloth.color.size(); i++) {
            System.out.println("Номер цвета " + i + " - " + cloth.color.get(i));
        }
    }

    public void buyCloth() {
        System.out.println(Cash.cash);
        System.out.println("Введите одежду, которую хотите купить");
        if (this.clothes.isEmpty()) {
            addArray();
        }
        Scanner scanner = new Scanner(System.in);
        int selectedCloth = scanner.nextInt();
        Cloth clothe = getCloth(selectedCloth);
        if (Cash.cash >= clothe.price) {
            System.out.println("Вы выбрали одежду " + clothe.name);
            System.out.println("Выберите цвет одежды");
            showColorCloth(clothe);
            int selectedColorCloth = scanner.nextInt();
            System.out.println("Вы выбрали цвет " + clothe.color.get(selectedColorCloth));
            System.out.println("Товар в корзине");
            k += 1;
            if (k % 3 == 0) {
                Cash.cash -= (clothe.price * 0.5);
                System.out.println("Вы использовали скидку в размере 50%");
                System.out.println("Остаток на балансе: " + Cash.cash);
            } else {
                Cash.cash = Cash.cash - clothe.price;
                System.out.println("Остаток на балансе: " + Cash.cash);
            }
            this.clothes.remove(selectedCloth);
            printArray();
        } else {
            System.out.println("Денег недостаточно");
        }
    }

    public void test() {
        buyCloth();

        System.out.println("Хотите купить ещё одежду?: ");
        Scanner scanner_prov = new Scanner(System.in);
        if (scanner_prov.nextLine().equals("Да")) {
            test();
        }
    }

    public void printArray() {
        for (int i = 0; i < clothes.size(); i++) {
            System.out.println(i + " " + clothes.get(i).name);
        }
    }

    public void addArray() {
        clothes.add(new Cap("Balenciaga", Arrays.asList("Бордовый", "Красноватый", "Бархатный"), 1999));
        clothes.add(new Jeans("Gucci", Arrays.asList("Бордовый", "Красноватый", "Бархатный"), 1999));
        clothes.add(new Cap("LoroPiana", Arrays.asList("Бордовый", "Красноватый", "Бархатный"), 1000));
        clothes.add(new Sneakers("Djakam", Arrays.asList("Бордовый", "Красноватый", "Бархатный"), 1000));
        for (int i = 0; i < clothes.size(); i++) {
            System.out.println(i + " " + clothes.get(i).name);
        }
    }

}
