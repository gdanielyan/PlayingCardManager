package cards;


public class SuitFace {

    private Suit suit;
    private Face face;

    public SuitFace(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public String toString() {
        return "Suit " + suit.getSuit() + " Face: " + face.getFace();
    }

    @Override
    public boolean equals(Object other) {
        String otherSuit = ((SuitFace)other).getSuit().toString();
        String otherFace = ((SuitFace)other).getFace().toString();
        return this.suit.toString().equals(otherSuit) && this.face.toString().equals(otherFace);
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
