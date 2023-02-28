package via.dk.postfix.controller;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import via.dk.postfix.logic.PostFix;
import via.dk.postfix.model.Token;

import java.util.ArrayList;

@RestController
@RequestMapping("/PostFix")
public class Controller {
    private PostFix postFix;


    public Controller(PostFix postFix) {
        this.postFix = postFix;
    }

    @SneakyThrows
    @RequestMapping(value = (""), method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int evaluateExpression(@RequestBody ArrayList<Token> tokens)  {
             int s;
        if (tokens==null || tokens.isEmpty()){
            throw new Exception("Empty input");
        }
        try {
            return postFix.getResult(tokens);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());

        }

    }
}
