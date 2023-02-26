package via.dk.postfix.logic;

import org.springframework.stereotype.Component;
import via.dk.postfix.model.Operand;
import via.dk.postfix.model.Operator;
import via.dk.postfix.model.Token;
import via.dk.postfix.stack.MyStack;

import java.util.ArrayList;

public class PostFix {

    private MyStack stack = new MyStack();

//    private ArrayList<Object> list;
//
//    public PostFix(ArrayList<Object> list) {
//        this.list = list;
//    }


    public PostFix(MyStack stack) {
        this.stack = stack;
    }

    public int getResult(ArrayList<Token> list) throws Exception {

        for (int i = 0; i < list.size(); i++) {
            var x = list.get(i);
            System.out.println(x.getInput());

            if (x instanceof Operand) {


                stack.push(((Operand) x).getValue());

            } else if (x instanceof Operator){

                int y = stack.pop();
                int z = stack.pop();
                switch (((Operator) x).getOperator()) {
                    case "+":
                        stack.push(y + z);
                        break;
                    case "-":
                        stack.push(z - y);
                        break;
                    case "*":
                        stack.push(z * y);
                        break;
                    case "/":
                        stack.push(z / y);
                        break;
                }
            }


        }

        return stack.pop();

    }


    public boolean isInt(String input) {
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
