package via.dk.postfix.MyTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import via.dk.postfix.stack.MyStack;

public class MyTest {

    private MyStack stack= new MyStack();


    @Test
    public void pushElementToTheStack(){
        stack.push(1);
        Assertions.assertTrue(stack.getSize()==1);
    }

    @Test
    public void pushTowElementToTheStack(){
        stack.push(1);
        stack.push(2);



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
        Assertions.assertTrue(stack.lookUp().equals(32));
    }


    @Test
    public void lookUpDontReturnFirstElement(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        Assertions.assertFalse(stack.lookUp().equals(23));
    }
    @Test
    public void popReturnLastElement(){
        stack.push(23);
        stack.push(32);
        stack.lookUp();
        try {


            Assertions.assertTrue(stack.pop().equals(32));
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
            Assertions.assertFalse(stack.lookUp().equals(32));



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

}
