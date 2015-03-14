package jena;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatementTest {

    @Test
    public void testStatements() {
        
    	StatementParserImpl spi= new StatementParserImpl();
    	String s= spi.getStatement(1);
    	assertEquals("onetwo", s);
    }
    
}