package via.dk.postfix.logic;

import org.springframework.stereotype.Component;
import via.dk.postfix.model.Operand;
import via.dk.postfix.model.Operator;
import via.dk.postfix.model.Token;
import via.dk.postfix.stack.MyStack;

import java.util.ArrayList;

@Component
public class PostFix {

    private MyStack stack;



    public PostFix(MyStack stack) {
        this.stack = stack;
    }

    public int getResult(ArrayList<Token> list) throws Exception {

        for (int i = 0; i < list.size(); i++) {
            var x = list.get(i);

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
                        if (y==0){
                            throw new Exception("Cannot divide by zero");
                        }
                        stack.push(z / y);

                        break;
                }
            }


        }
        if (stack.getSize()>1){
            throw new Exception("Invalid input Expression");
        }

        return stack.pop();

    }

}
