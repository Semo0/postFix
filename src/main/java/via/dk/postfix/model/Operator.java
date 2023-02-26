package via.dk.postfix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operator extends Token {

    private  String operator;
@JsonCreator
    public Operator(@JsonProperty("operator") String operator) {
        super(operator);
        this.operator=operator;

    }

    public String getOperator() {
        return operator;
    }
}
