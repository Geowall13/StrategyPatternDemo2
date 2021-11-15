

public class CasinoStrategyDemo {

    public static void main(String[] args){

        CasinoGamePlayer laust = new CasinoGamePlayer(new Slots());
        CasinoGamePlayer patrick = new CasinoGamePlayer(new Blackjack());
        CasinoGamePlayer rasmus = new CasinoGamePlayer(new Roulette());

        for (int i = 0; i < 100; i++) {
            System.out.println("\n---------------------------------------------------------------------------------------------------\n" +
                                "Laust plays the slots, and has round " + Math.addExact(i,1) + " a win of " + laust.play(5.5) + " money." +
                                "\nPatrick plays blackjack, and has round " + Math.addExact(i,1) + " a win of " + patrick.play(5.5) + " money." +
                                "\nRasmus plays roulette, and has round " + Math.addExact(i,1) + " a win of " + rasmus.play(5.5) + " money." +
                                "\n---------------------------------------------------------------------------------------------------\n\n");
        }
    }
}

