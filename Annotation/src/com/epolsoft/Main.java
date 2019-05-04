package com.epolsoft;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

@ClassData(
        author = "VNEZ",
        lastModified = "03.05.2019"
)
public class Main {
    private static Field getSuperField( Class refl_class, String field_name ) {
        try {
            return refl_class.getSuperclass().getDeclaredField( field_name );
        } catch ( SecurityException | NoSuchFieldException x ) {
            //x.printStackTrace();
            return null;
        }
    }

    private static Field getField( Class refl_class, String field_name ) {
        try {
            return refl_class.getDeclaredField( field_name );
        } catch ( SecurityException | NoSuchFieldException x ) {
            //x.printStackTrace();
            return null;
        }
    }

    private static void showFieldNameAnnotations( Field f, String title ) {
        Annotation[] all_annotations;

        out.print("\n  " + title + " [" + FieldName.name + "] ANNOTATION:" );

        if ( f == null ) {
            out.println( " --" );
            return;
        }
        out.println("\n    FIELD: " + f.getName() );
        out.println( "    CLASS: " + f.getDeclaringClass().getName() );

        all_annotations = f.getAnnotations();

        for ( Annotation a : all_annotations ) {
            if ( a instanceof FieldName ) {
                out.println( "    TYPE: " + ( ( FieldName ) a ).type() );
            }
        }
    }

    private static void showClassDataAnnotation( Annotation a ) {
        ClassData cdata;

        if ( a instanceof ClassData ) {
            cdata = ( ClassData ) a;
            out.println("  [" + cdata.name + "] ANNOTATION:" );
            out.println("    AUTHOR:       " + cdata.author());
            out.println("    COMPANY:      " + cdata.company());
            out.println("    LastModified: " + cdata.lastModified());
            out.println("    Revision:     " + cdata.currentRevision());
        }
    }

    private static void showAnnotations( Class an_class ) {
        Annotation[] annotations;

        out.println("\nANNOTATIONS IN CLASS: [" + an_class.getName() + "]" );

        try {
            annotations = an_class.getAnnotations();

            for ( Annotation a : annotations ) {
                showClassDataAnnotation( a );
                showFieldNameAnnotations( getField( an_class, "name" ), "SELF" );
                showFieldNameAnnotations( getSuperField(an_class, "name"), "SUPER" );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void doWithAnnotations() {
        out.println( "\nclass Person:" +
                "\nhas Class Annotation (self), Field Annotation (self):" );
        showAnnotations( Person.class );

        out.println( "\nclass Developer:" +
                "\nhas Class Annotation (some default):" );
        showAnnotations( Developer.class );

        out.println( "\nclass Company:" +
                "\nhas Class Annotation (some default), Field Annotation (self):" );
        showAnnotations( Company.class );

        out.println( "\nclass Language:" +
                "\nhas Class Annotation (self), Field Annotation (default):" );
        showAnnotations( Language.class );

        out.println( "\nclass Tester" +
                "\nhas not any self Annotations:" );
        showAnnotations( Tester.class );
    }

    public static void main(String[] args) {
        doWithAnnotations();
    }
}
