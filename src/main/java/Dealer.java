public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    public boolean canDealerPlay(){
        return (!this.isPlayerBust() && this.isDealerScoreUnderOrEqualTo16());
    }

    private boolean isDealerScoreUnderOrEqualTo16() {
        return Scorer.scoreHand(this) <= 16;
    }

    public Card showFirstCardInHand(){
        return this.getHand().get(0);
    }

}
