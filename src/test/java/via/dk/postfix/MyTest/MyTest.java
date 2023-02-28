package via.dk.postfix.MyTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import via.dk.postfix.controller.Controller;
import via.dk.postfix.logic.PostFix;
import via.dk.postfix.model.Operand;
import via.dk.postfix.model.Operator;
import via.dk.postfix.model.Token;
import via.dk.postfix.stack.MyStack;

import java.util.ArrayList;

public class MyTest {

    private MyStack stack= new MyStack();

    private PostFix postFix = new PostFix(stack);
    private Controller controller= new Controller(postFix);



    @Test
    public void pushElementToTheStack(){
        stack.push(1);
        Assertions.assertTrue(stack.getSize()==1);
    }

    @Test
    public void pushTowElementToTheStack(){
        stack.push(1);
        stack.push(2);
        //Sghsdghsd

        Assertions.assertTrue(stack.getSize()==2);
    }
    @Test
    public void pushMuchElementToTheStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1234);
        Assertions.assertTrue(stack.getSize()==5);
    }
    @Test
    public void pushElementToTheStackAndLook(){
        stack.push(23);
        stack.lookUp();
        Assertions.assertTrue(stack.getSize()==1);
    }

    @Test
    public void pushTowElementToTheStackAndLook(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        Assertions.assertTrue(stack.getSize()==2);
    }

    @Test
    public void pushMuchElementToTheStackLook(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1234);
        stack.lookUp();
        stack.lookUp();
        stack.lookUp();
        Assertions.assertTrue(stack.getSize()==5);
    }

    @Test
    public void lookUpReturnLastElement(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        Assertions.assertTrue(stack.lookUp()==32);
    }


    @Test
    public void lookUpDontReturnFirstElement(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        Assertions.assertFalse(stack.lookUp()==23);
    }
    @Test
    public void popReturnLastElement(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        try {


            Assertions.assertTrue(stack.pop()==32);
        }
        catch (Exception e){
            return;
        }
    }
    @Test
    public void popReturnLastElementAndPopIt(){
        stack.push(23);
        stack.push(32);

        try {
            stack.pop();
            Assertions.assertFalse(stack.lookUp()==32);



        }
        catch (Exception e){
            return;
        }
    }
    @Test
    public void popReturnLastElementAndPopItCheckSize(){
        stack.push(23);
        stack.push(32);

        try {
            stack.pop();
            Assertions.assertTrue(stack.getSize()==1);



        }
        catch (Exception e){
            return;
        }
    }

    @Test
    public void popMoreThanTheSizeThrowsException(){
        stack.push(23);
        stack.push(32);
        boolean thrown= false;

        try {
            stack.pop();
            stack.pop();
            stack.pop();



        }
        catch (Exception e){
            thrown=true;

        }
        Assertions.assertTrue(thrown);
    }



    //Test the calculator

    @Test
    public void EmptyExpressionReturnException(){
        ArrayList<Token> tokens= new ArrayList<>();


    Exception exception=   Assertions.assertThrows(Exception.class,() -> controller.evaluateExpression(tokens));
        String ExpectedMessage="Empty input";
        String ActualMessage=exception.getMessage();


        Assertions.assertTrue(ActualMessage.equalsIgnoreCase(ExpectedMessage));
    }

    @Test
    public void InvalidExpressionReturnException(){
        ArrayList<Token> tokens= new ArrayList<>();
        Operand operand1= new Operand(2);
        Operand operand2= new Operand(3);
        Operand operand3= new Operand(3);
        Operator operator= new Operator("+");
        tokens.add(operand1);
        tokens.add(operand2);
        tokens.add(operand3);
        tokens.add(operator);


        Exception exception=   Assertions.assertThrows(Exception.class,() -> controller.evaluateExpression(tokens));
        String ExpectedMessage="Invalid input Expression";
        String ActualMessage=exception.getMessage();


        Assertions.assertTrue(ActualMessage.equalsIgnoreCase(ExpectedMessage));
    }
    @Test
    public void DividingByZeroExpressionReturnException(){
        ArrayList<Token> tokens= new ArrayList<>();
        Operand operand1= new Operand(2);
        Operand operand2= new Operand(0);
        Operator operator= new Operator("/");
        tokens.add(operand1);
        tokens.add(operand2);
        tokens.add(operator);


        Exception exception=   Assertions.assertThrows(Exception.class,() -> controller.evaluateExpression(tokens));
        String ExpectedMessage="Cannot divide by zero";
        String ActualMessage=exception.getMessage();


        Assertions.assertTrue(ActualMessage.equalsIgnoreCase(ExpectedMessage));
    }

    @Test
    public void returnRight(){
        ArrayList<Token> tokens= new ArrayList<>();
        Operand operand1= new Operand(2);
        Operand operand2= new Operand(4);
        Operator operator= new Operator("+");
        tokens.add(operand1);
        tokens.add(operand2);
        tokens.add(operator);



        Assertions.assertTrue(controller.evaluateExpression(tokens)==6);
    }


}
