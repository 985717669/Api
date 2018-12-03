package com.example.demo.SpEL;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author fengjf
 * @Desc 春季表达
 **/

public class SPel {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");

        System.out.println(exp.getValue());
    }
}
