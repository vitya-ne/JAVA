package com.epolsoft;


import java.util.function.Predicate;
import static java.lang.System.out;

public class Lambda7 {

    private static Predicate<String> getLambda() {
        Predicate<String> isEmailLength = Lambda6.getLambda();

        return str -> isEmailLength.negate().test( str );
    }

    private static void showChecking( String test_str, Predicate<String> isEmailLengthNeg ) {
        boolean checkResult = isEmailLengthNeg.test( test_str );

        out.println( "String: " +
                test_str +
                "\nhasn't E-mail with right length (> 10): " +
                Boolean.toString( checkResult ).toUpperCase()
        );

    }

    private static void doTask() {
        String test_str1 = "rngj.rn bd@ne.c @ ";
        String test_str2 = "ndnjdsjfdn d lambda@jshello.org jdngjrngjrn bdbjcd @ncjnje.cd";
        String test_str3 = "nd@jf4.n";


        Predicate<String> isEmailLengthNeg = getLambda();

        showChecking( test_str1, isEmailLengthNeg );
        showChecking( test_str2, isEmailLengthNeg );
        showChecking( test_str3, isEmailLengthNeg );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 7 );
        doTask();

    }
}