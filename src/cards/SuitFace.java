package cards;


public class SuitFace {

    private Suit suit;
    private Face face;

    public SuitFace(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuitFace)) return false;

        SuitFace suitFace = (SuitFace) o;

        if (getSuit() != suitFace.getSuit()) return false;
        return getFace() == suitFace.getFace();
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }
}
