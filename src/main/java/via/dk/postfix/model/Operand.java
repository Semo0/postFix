package via.dk.postfix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operand implements Token {

    private int value;

    @JsonCreator
    public Operand(@JsonProperty("value") int value) {

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
