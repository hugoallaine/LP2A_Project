/**
 * GameModeEnum.java
 */
public enum GameModeEnum {
    QUICK(120), //Constant for the quick game mode
    NORMAL(180), //Constant for the normal game mode
    LONG(300); //Constant for the long game mode
    private final int value;
    //Needed to create the enum
    private GameModeEnum(int value) {
        this.value = value;
    }
    //Getter for the value
    public int getValue() {
        return value;
    }
}