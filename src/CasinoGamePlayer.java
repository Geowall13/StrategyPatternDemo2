


public class CasinoGamePlayer {

    CasinoGame game;

    public CasinoGamePlayer(CasinoGame game){
        this.game = game;
    }

    public double play(double money){
        return game.playGame(money);
    }
}
