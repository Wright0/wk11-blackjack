public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    public boolean canDealerPlay(){
        return Scorer.scoreHand(this.getHand()) < 16;
    }

}
