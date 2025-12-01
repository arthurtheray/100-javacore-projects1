package prg47;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * **Сортировка с `Comparator`.
 * * Требования: `thenComparing`; без `Comparable`.
 * * Теория: компараторы, метод-референсы, стабильность сортировки.
 */
public class Main {
    public static void main(String[] args) {
//        testSorting();
        coutryesSorting();
    }

    private static void coutryesSorting() {
        Country russia = new Country("Russia", 2540.6);
        Country china = new Country("China", 19398.5);
        Country usa = new Country("USA", 30615.7);
        Country japan = new Country("Japan", 4279.8);
        Country poland = new Country("Poland", 688.1);
        Country romania = new Country("Romania", 422.5);
        Country rwanda = new Country("Rwanda", 14.8);
        Country ukraine = new Country("Ukraine", 209.7);
        ArrayList<Country> countries = new ArrayList<>(
                List.of(japan, poland, romania, rwanda, ukraine, russia, china, usa));
        countries.sort(Comparator.comparing(Country::name).thenComparing(Country::imf));
        System.out.println(countries);
    }

    private static void testSorting() {
        SortedTextProcessor sortedTextProcessor = new SortedTextProcessor();
        sortedTextProcessor.add("Мама мыла раму");
        sortedTextProcessor.add("раму мыла мама");
        sortedTextProcessor.add("Мыло мыло маму");
        sortedTextProcessor.add("Папа раму ранил");
        System.out.println(sortedTextProcessor.report());
        System.out.println("Самые популярные слова: " + sortedTextProcessor.getPopularWords(3));
    }
}
