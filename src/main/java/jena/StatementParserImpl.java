package jena;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

import org.springframework.stereotype.Component;

@Component
public class StatementParserImpl {
	
	private final AtomicLong counter= new AtomicLong();
	private ArrayList<JenaStatement> statementArrayList= null;

	private void init() {
		FileManager.get().addLocatorClassLoader(JenaTestNodeController.class.getClassLoader());
		Model model = FileManager.get().loadModel("data/data.ttl", null, "TURTLE");

		StmtIterator iter= model.listStatements();

		try {
		 	while (iter.hasNext()) {
		 		Statement stmt = iter.next();

		 		Resource s= stmt.getSubject();
		 		Resource p = stmt.getPredicate();
		 		RDFNode o = stmt.getObject();

		 		JenaStatement jena_stmt= new JenaStatement(counter.incrementAndGet(), s, p, o);
	 			statementArrayList.add(jena_stmt);
		 	}
		 } finally {
		 	if (iter != null) iter.close();
		 }
	}
	
	public JenaStatement getStatement(int index) {
		if (statementArrayList == null) 
			init();
			
		return statementArrayList.get(index);
	}
}