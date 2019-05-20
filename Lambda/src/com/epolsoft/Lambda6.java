package com.epolsoft;

import com.epolsoft.Lambda5.HasEmail;

import java.util.function.Predicate;
import static java.lang.System.out;

public class Lambda6 {

    static Predicate<String> getLambda() {
        HasEmail hasEmail = Lambda5.getLambda();

        return str -> hasEmail.check( str ) && ( str.length() > 10 );
    }

    private static void showChecking( String test_str, Predicate<String> isEmailLength ) {
        boolean checkResult = isEmailLength.test( test_str );

        out.println( "String: " +
                test_str +
                "\nhas E-mail with right length (> 10): " +
                Boolean.toString( checkResult ).toUpperCase()
        );

    }

    private static void doTask() {
        String test_str1 = "rngj.rn bd@ne.c @ ";
        String test_str2 = "ndnjdsjfdn d lambda@jshello.org jdngjrngjrn bdbjcd @ncjnje.cd";
        String test_str3 = "nd@jf4.n";


        Predicate<String> isEmailLength = getLambda();

        showChecking( test_str1, isEmailLength );
        showChecking( test_str2, isEmailLength );
        showChecking( test_str3, isEmailLength );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 6 );
        doTask();

    }
}