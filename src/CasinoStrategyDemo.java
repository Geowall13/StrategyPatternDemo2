

public class CasinoStrategyDemo {

    public static void main(String[] args){

        CasinoGamePlayer laust = new CasinoGamePlayer(new Slots());

        laust.play(100000);

    }
}

