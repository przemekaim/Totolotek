package pl.java.lotek;

import java.util.*;

public class Lotek {
    public static void main(String[] args) {
        lotto();
    }

    private static void lotto() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            lotto.add(i);
        }
        Collections.shuffle(lotto);
        List<Integer> winningNumbers = lotto.subList(0, 6);
        Collections.sort(winningNumbers);

        Scanner scanner = new Scanner(System.in);
        List<Integer> chosenNumbers = new ArrayList<>(6);

        int wybrane;
        System.out.println("Podaj numery: ");
        for (int i = 0; i < 6; i++) {
            wybrane = scanner.nextInt();

            while (chosenNumbers.contains(wybrane) || wybrane < 1 || wybrane > 49) {
                System.out.println("Podaj jeszcze raz.");
                wybrane = scanner.nextInt();
            }
                chosenNumbers.add(wybrane);
        }

        int trafione = 0;

        for (Integer chosenNumber : chosenNumbers) {
            if (winningNumbers.contains(chosenNumber))
                trafione++;
        }
        //chosenNumbers.sort(Integer::compareTo);
        Collections.sort(chosenNumbers);
        System.out.println("Trafiles " + trafione);
        System.out.println("Twoje liczby: " + chosenNumbers);
        System.out.println("Wylosowane liczby: " + winningNumbers);
    }
}
