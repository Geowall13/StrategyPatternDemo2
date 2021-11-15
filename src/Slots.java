import java.util.Random;

public class Slots implements CasinoGame{

    private double balance = 0;

    @Override
    public double playGame(double money) {

        balance += money;
        int luck = new Random().nextInt(100)+1;

        if (luck == 1) {
            return balance/87*100;
        }
        return 0;
    }
}
