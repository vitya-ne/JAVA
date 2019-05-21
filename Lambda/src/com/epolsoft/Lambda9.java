package com.epolsoft;

import java.util.function.BinaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая возвращает сумму двух входных аргументов
 */

public class Lambda9 {

    static BinaryOperator<Float> getLambda() {
        return Float::sum;
    }

    private static void showSum( float num1, float num2, BinaryOperator<Float> lambda ) {

        out.println( "calc: " +
                num1 +
                " + " +
                num2 +
                " = " +
                lambda.apply( num1, num2 )
        );

    }

    private static void doTask() {

        BinaryOperator<Float> lambda = getLambda();

        showSum( 2, 5, lambda );
        showSum( (float)12.3, -9, lambda );
        showSum( -3, (float)3, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 9 );
        doTask();

    }
}