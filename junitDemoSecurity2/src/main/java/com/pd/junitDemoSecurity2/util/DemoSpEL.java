package com.pd.junitDemoSecurity2.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.GregorianCalendar;

public class DemoSpEL {

    public static void main(String[] args) {

        //genral purpose expression language
        // can be used in parsiong and in methodlevel security also follow this
        //   helloSpEL();
        // concatDemo();
        //getBytes();

        //length();
        //upperLower();

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(1991,02,25);
        
        record Person(int id, String name, String address, Date dob){}
        
        Person p = new Person(1,"Purushottam","pune", gc.getTime());
        
        ExpressionParser ep = new SpelExpressionParser();

        Expression expression = ep.parseExpression("dob");
        EvaluationContext ec = new StandardEvaluationContext(p);

        System.out.println("expression.getValue(ec) = " + expression.getValue(ec));
        


    }

    private static void upperLower() {
        ExpressionParser ep = new SpelExpressionParser();

        Expression expression = ep.parseExpression("'Hello worldss '.toLowerCase()");

        System.out.println("upper = " + expression.getValue());
    }

    private static void length() {
        ExpressionParser ep = new SpelExpressionParser();
        Expression expression = ep.parseExpression("'purushottam'.bytes.length");
        System.out.println("expression.getValue() = " + expression.getValue());
    }

    private static void getBytes() {
        ExpressionParser ep = new SpelExpressionParser();
        Expression expression = ep.parseExpression("'Hello world'.bytes");
        Expression expression1 = ep.parseExpression("'hello '.concat(' worldss')");
        System.out.println("expression1 = " + expression1.getValue());

        System.out.println("expression = " + expression.getValue());
    }

    private static void concatDemo() {
        ExpressionParser ep = new SpelExpressionParser();
        Expression exp = ep.parseExpression("'Hello world '.concat('!')");
        System.out.println("exp.getValue() = " + exp.getValue());
    }


    private static void helloSpEL() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = exp.getValue(String.class);
        System.out.println("message = " + message);
    }
}
