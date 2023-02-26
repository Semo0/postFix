package via.dk.postfix.model;

public class Operand extends Token {

    private int value;

    public Operand(int value) {
        super(String.valueOf(value));
        this.value=value;

    }

    public int getValue() {
        return value;
    }

    public boolean isInt(String input){

        boolean isInt = false;
        try {
            Integer.parseInt(input);
            isInt = true;
        } catch (Exception e) {
            return isInt = false;
        }
        return isInt;
    }
}
