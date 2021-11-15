import java.util.Random;

public class Roulette implements CasinoGame{

    private final int slots = 100;

    @Override
    public double playGame(double money) {

        int mode = new Random().nextInt(2)+1;

        // On red
        if (mode == 1) {

            double boundry = slots/2-1;

            int chance = new Random().nextInt((int) boundry)+1;

            if (chance>boundry/2) {
                return money*2;
            }
        }
        // On value
        else {
            int chance = new Random().nextInt(slots)+1;

            if (chance == 1) {
                return money*100;
            }
        }

        return 0;
    }
}
