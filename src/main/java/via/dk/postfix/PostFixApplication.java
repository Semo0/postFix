package via.dk.postfix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.dk.postfix.logic.PostFix;
import via.dk.postfix.model.Operand;
import via.dk.postfix.model.Operator;
import via.dk.postfix.model.Token;
import via.dk.postfix.stack.MyStack;

import java.util.ArrayList;

@SpringBootApplication
public class PostFixApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PostFixApplication.class, args);

		ArrayList<Token> list = new ArrayList<>();

		Operand operand1= new Operand(2);
		Operand operand2= new Operand(3);
		Operator operator= new Operator("+");
		list.add(operand1);
		list.add(operator);




		MyStack stack= new MyStack();

		PostFix postFix= new PostFix(stack);

		System.out.println(postFix.getResult(list));


	}

}