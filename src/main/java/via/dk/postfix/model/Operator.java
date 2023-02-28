package via.dk.postfix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operator implements Token {

    private  String operator;
@JsonCreator
    public Operator(@JsonProperty("operator") String operator) {
        this.operator=operator;

    }

    public String getOperator() {
        return operator;
    }
}
