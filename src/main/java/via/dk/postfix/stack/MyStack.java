package via.dk.postfix.stack;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

public class MyStack {

    private LinkedList<Integer> list;


    public MyStack(){
        this.list=new LinkedList<>();
    }

    public int getSize(){
        return list.size();
    }

    public int lookUp(){
        return list.peek();
    }

    public void push(int elm){
      list.push(elm);
    }

    public int pop() throws Exception {
        if (list.isEmpty()){
            throw new Exception("Stack is Empty"
            );
        }
        return list.pop();
    }


}
