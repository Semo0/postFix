package via.dk.postfix.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Operand.class,name = "operand"),
        @JsonSubTypes.Type(value = Operator.class,name = "operator")
})
public class Token {

    private String input;

    public Token(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
