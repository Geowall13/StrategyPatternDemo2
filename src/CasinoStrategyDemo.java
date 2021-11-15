

public class CasinoStrategyDemo {

    public static void main(String[] args){

        CasinoGamePlayer laust = new CasinoGamePlayer(new Slots());
        CasinoGamePlayer patrick = new CasinoGamePlayer(new Blackjack());
        CasinoGamePlayer rasmus = new CasinoGamePlayer(new Roulette());

        for (int i = 0; i < 5; i++) {

            System.out.println("---------------------------------------------------------------------------------------------------\n" +
                                "Laust plays the slots, and has round " + i + " a win of " + (int) laust.play(100000) + " money." +
                                "\nPatrick plays blackjack, and has round " + i + " a win of " + (int) patrick.play(100000) + " money." +
                                "\nRasmus plays roulette, and has round " + i + " a win of " + (int) rasmus.play(100000) + " money." +
                                "\n---------------------------------------------------------------------------------------------------\n");
        }

    }
}

