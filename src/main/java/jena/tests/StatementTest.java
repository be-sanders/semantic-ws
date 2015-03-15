package jena.tests;

import jena.StatementParserImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StatementTest {

    @Test
    public void testStatements() {
        
    	StatementParserImpl spi= new StatementParserImpl();
    	String s= spi.getStatement(1).toString();
    	assertEquals ("literal", s);
    }
    
}