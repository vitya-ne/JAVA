package com.epolsoft;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Lambda5 {
    final static private Pattern EMAIL_RE = Pattern.compile( "\\w+@\\w+\\.\\w+", Pattern.CASE_INSENSITIVE );

    @FunctionalInterface
    private interface HasEmail {
        Boolean check( String s );
    }

    private static HasEmail getLambda() {
        return str -> {
            Matcher m = EMAIL_RE.matcher( str );
            return m.find();
        };
    }

    private static void showChecking( String test_str, HasEmail hasEmail ) {
        out.println( "String: " +
                test_str +
                "\nhas E-mail: " +
                hasEmail.check( test_str ).toString().toUpperCase()
        );

    }

    private static void doTask() {
        String test_str1 = "rngj.rn bdbjcd3@ncjnj5e.cd @ ";
        String test_str2 = "ndnjdsjfdn d fj357frjnjndj@dnfjndj.gkg jdngjrngjrn bdbjcd @ncjnje.cd";
        String test_str3 = "ndnjds@jf4dn djdjs jf fjr frjnjndj.t";

        HasEmail hasEmail = getLambda();

        showChecking( test_str1, hasEmail );
        showChecking( test_str2, hasEmail );
        showChecking( test_str3, hasEmail );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 5 );
        doTask();

    }
}