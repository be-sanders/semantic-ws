package jena;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenaTestNodeController {

	private ArrayList<Statement> statementArrayList;
	private final AtomicLong counter= new AtomicLong();
	
	public JenaTestNodeController() {
		init();
	}

	public void init() {
		FileManager.get().addLocatorClassLoader(JenaTestNodeController.class.getClassLoader());
		Model model = FileManager.get().loadModel("data/test.ttl", null, "TURTLE");

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

	@RequestMapping("/statements") 
	public JenaStatement statement(@RequestParam(value="statement", defaultValue="blank")) {
		return new Statement();
	}
}