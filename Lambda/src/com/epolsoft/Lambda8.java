package com.epolsoft;


import java.util.ArrayList;
import java.util.function.*;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая проверяет число на принадлежность к ряду
 *  Фибоначчи. Лямбда должна запоминать ранее вычисленные значения.
 */

public class Lambda8 {

    private static Supplier<IntPredicate> getLambda() {
        return () -> {
            ArrayList<Integer> fibMemo = new ArrayList<>();
            
            fibMemo.add( 0 );
            fibMemo.add( 1 );

            return ( IntPredicate ) number -> {

                if ( number < 0 ) {
                    return false;
                }

                int last = fibMemo.get( fibMemo.size() - 1 );

                if ( number > last ) {
                    int prev = fibMemo.get( fibMemo.size() - 2 );
                    int next;

                    while ( number > last ) {
                        next = last + prev;
                        fibMemo.add( next );
                        prev = last;
                        last = next;
                    }
                }

                return ( fibMemo.indexOf( number ) > 0 );

            };
        };
    }

    private static void showChecking( int test_num, IntPredicate fibCheck ) {
        boolean checkResult = fibCheck.test( test_num );

        out.println( "Number: " +
                test_num +
                "\nbelongs to Fibonacci: " +
                Boolean.toString( checkResult ).toUpperCase()
        );

    }

    private static void doTask() {
        int n1 = 2;
        int n2 = 10;
        int n3 = 24;
        int n4 = 8;
        int n5 = -3;

        Supplier<IntPredicate> fabric = getLambda();

        IntPredicate fibCheck = fabric.get();

        showChecking( n1, fibCheck );
        showChecking( n2, fibCheck );
        showChecking( n3, fibCheck );
        showChecking( n4, fibCheck );
        showChecking( n5, fibCheck );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 8 );
        doTask();

    }
}