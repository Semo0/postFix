package via.dk.postfix.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import via.dk.postfix.logic.PostFix;
import via.dk.postfix.model.Operand;
import via.dk.postfix.model.Operator;
import via.dk.postfix.model.Token;

import java.util.ArrayList;

@RestController
@RequestMapping("/PostFix")
public class Controller {
    private PostFix postFix;



    public Controller(PostFix postFix) {
        this.postFix = postFix;
    }

    @RequestMapping(value = (""),method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int evaluateExpression(@RequestBody String inpute) throws Exception {
        ArrayList<Token> tokens = new ArrayList<>();

        for (int i = 0; i < inpute.length(); i++) {

            char x = inpute.charAt(i);
            if (Character.isDigit(x)) {

                int operand = Integer.parseInt(String.valueOf(x));
                Operand operand1 = new Operand(operand);
                System.out.println(operand1.getValue());
                tokens.add(operand1);
            }


             else if (!Character.isDigit(x)){
                Operator operator = new Operator(String.valueOf(x));
                System.out.println(operator.getOperator());
                tokens.add(operator);

            }

        }
        return postFix.getResult(tokens);
    }
}
