import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println(transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList()));
        System.out.println(transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList()));
        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().filter(t -> t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()));
        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getName).sorted().collect(Collectors.joining(" ")));
        System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
        System.out.println(transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce((Integer::sum)).get());
        System.out.println(transactions.stream().map(Transaction::getValue).max(Comparator.comparingInt(v -> v)).get());
        System.out.println(transactions.stream().min(Comparator.comparingInt(Transaction::getValue)).get());
    }
}