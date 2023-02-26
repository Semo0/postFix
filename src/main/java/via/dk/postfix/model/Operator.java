package via.dk.postfix.model;

public class Operator extends Token {

    private  String operator;

    public Operator(String operator) {
        super(operator);
        this.operator=operator;

    }

    public String getOperator() {
        return operator;
    }
}
