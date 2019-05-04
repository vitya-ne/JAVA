package com.epolsoft;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static java.lang.System.out;

public class Main {
    final static String XSD_FILE = "Country.xsd";
    final private static SchemaFactory FACTORY = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );

    private static InputStream getFile( String file_name ) throws FileNotFoundException {
        return new FileInputStream( file_name );
    }

    private static Schema getSchema( InputStream xsd ) throws SAXException {
        return FACTORY.newSchema( new StreamSource( xsd ) );
    }

    private static Validator createValidator( String file_name ) {
        InputStream xsd;
        Schema schema;
        Validator result;

        out.print( "\nCREATING VALIDATOR: [" + file_name + "]: " );

        try {
            xsd = getFile( file_name );
            schema = getSchema( xsd );
            result = schema.newValidator();
            out.println( "OK!" );
            return result;
        } catch ( Exception ex ) {
            out.println( "FALL!" +
                    "\n  REASON: " + ex.getMessage()
            );

            return null;
        }
    }

    private static void validate( String xml_name, Validator validator ) {
        InputStream xml;

        out.print( "\nVALIDATING [" + xml_name + "]: " );

        try {
            xml = getFile( xml_name );
            validator.validate( new StreamSource( xml ) );
            out.println( "OK!" );
        }
        catch( Exception ex ) {
            out.println( "FALL!" +
                    "\n  REASON: " + ex.getMessage()
            );
        }
    }

    private static void doWithXML() {
        Validator validator = createValidator( XSD_FILE );

        if ( validator != null ) {
            validate( "Example1.xml", validator );
            validate( "Example2.xml", validator );
            validate( "Example3.xml", validator );
            validate( "Example4.xml", validator );
            validate( "NOT_EXISTING_FILE.xml", validator );
        }
    }

    public static void main( String[] args ) {
        doWithXML();

    }
}
