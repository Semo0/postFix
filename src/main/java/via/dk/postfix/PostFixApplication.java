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



	}

}