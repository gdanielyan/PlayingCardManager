package cards;

/**
 *
 */
public enum Face {

    ACE("ace"),
    TWO("two"),
    THREE("three"),
    FOUR("four"),
    FIVE("five"),
    SIX("six"),
    SEVEN("seven"),
    EIGHT("eight"),
    NINE("nine"),
    TEN("ten"),
    JACK("jack"),
    QUEEN("queen"),
    KING("king");

    private String face;

    Face(String face) {
        this.face = face;
    }

    public String getFace() {
        return this.face;
    }

}
