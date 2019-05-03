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

    public static void showFieldNameAnnotations( Field f ) {
        Annotation[] all_annotations;

        if ( f == null ) {
            return;
        }

        out.println("\n  ANNOTATION ON FIELD: " + f.getName() );
        out.println( "    CLASS: " + f.getDeclaringClass().getName() );

        all_annotations = f.getAnnotations();

        for ( Annotation a : all_annotations ) {
            if ( a instanceof FieldName ) {
                out.println( "    TYPE: " + ( ( FieldName ) a ).type() );
            }
        }
    }

    private static void showAnnotations( Class an_class ) {
        Annotation[] all_annotations;
        ClassData cdata;
        Field f;

        out.println("\nANNOTATION ON CLASS: [" + an_class.getName() + "]" );

        try {
            all_annotations = an_class.getAnnotations();

            for ( Annotation a : all_annotations ) {
                if ( a instanceof ClassData ) {
                    cdata = ( ClassData ) a;
                    out.println("  AUTHOR: " + cdata.author());
                    out.println("  COMPANY: " + cdata.company());
                    out.println("  LastModified: " + cdata.lastModified());
                    out.println("  Revision: " + cdata.currentRevision());

                    f = getField( an_class, "name" );

                    if ( f == null ) {
                        f = getSuperField(an_class, "name");
                    }

                    showFieldNameAnnotations( f );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void doWithAnnotations() {
        Class class1 = Person.class;

        showAnnotations( class1 );
        showAnnotations( Developer.class );
        showAnnotations( Company.class );
        showAnnotations( Language.class );
    }

    public static void main(String[] args) {
        doWithAnnotations();
    }
}
