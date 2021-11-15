import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Blackjack implements CasinoGame{

    private final int boundary = 21, boundaryOfNewCard = 14;
    private Set<Integer> hearts=new HashSet<>(),spades=new HashSet<>(),clovers=new HashSet<>(),diamonds=new HashSet<>();
    private int playersAces = 0, housesAces = 0;

    @Override
    public double playGame(double money) {

        ArrayList<Integer> playersCards = new ArrayList<>();
        ArrayList<Integer> houseCards = new ArrayList<>();

        playersCards = hitMe(playersCards,2,false);
        houseCards = hitMe(houseCards,2,true);

        while (totalValueOf(playersCards,false)<boundaryOfNewCard) {
            playersCards = hitMe(playersCards,1,false);
            if (isAboveBoundary(playersCards,false)) {
                return 0;
            }
        }
        while (totalValueOf(houseCards,true)<boundaryOfNewCard) {
            houseCards = hitMe(houseCards,1,true);
            if (isAboveBoundary(houseCards,true)) {
                return money*2;
            }
        }

        playersAces = 0;

        if (totalValueOf(playersCards,false)>totalValueOf(houseCards,true)) {
            return money*2;
        }
        else if (totalValueOf(playersCards,false)==totalValueOf(houseCards,true)) {
            return money;
        }
        return 0;
    }

    private ArrayList<Integer> hitMe(ArrayList<Integer> cards, int amount,boolean isTheHouse) {
        for (int i = 0; i < amount;i++) {

            int cardValue = 0;

            while (true) {
                cardValue = new Random().nextInt(11)+1;
                if (!(hearts.contains(cardValue)&&spades.contains(cardValue)&&clovers.contains(cardValue)&&diamonds.contains(cardValue))) {
                    break;
                }
            }

            if (cardValue==11) {
                if(isTheHouse) {
                    housesAces++;
                }
                else {
                    playersAces++;
                }
            }

            if (!(hearts.contains(cardValue))) {
                hearts.add(cardValue);
            }
            else if (!(spades.contains(cardValue))) {
                spades.add(cardValue);
            }
            else if (!(clovers.contains(cardValue))) {
                clovers.add(cardValue);
            }
            else {
                diamonds.add(cardValue);
            }
            cards.add(cardValue);
        }
        return cards;
    }

    private int totalValueOf(ArrayList<Integer> cards,boolean isTheHouse) {
        return calculateValueWithAces(cards.stream().mapToInt(value -> value.intValue()).sum(),isTheHouse);
    }

    private boolean isAboveBoundary(ArrayList<Integer> cards, boolean isTheHouse) {
        return totalValueOf(cards,isTheHouse)>boundary;
    }

    private int calculateValueWithAces(int totalValue,boolean isTheHouse) {
        if (isTheHouse&&housesAces>0) {
            for (int i = 0; i < housesAces;i++) {
                if (totalValue>21) {
                    totalValue -= 10;
                }
                else {
                    break;
                }
            }
        }
        else if (!isTheHouse&&playersAces>0) {
            for (int i = 0; i < playersAces;i++) {
                if (totalValue>21) {
                    totalValue -= 10;
                }
                else {
                    break;
                }
            }
        }
        return totalValue;
    }
}
