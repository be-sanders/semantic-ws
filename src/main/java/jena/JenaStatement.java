package jena;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

public class JenaStatement {

	private final long id;
	private String label;

	public JenaStatement(long id, Resource s, Resource p, RDFNode o) {
		this.id= id;
		
		if (s.isURIResource()) {
			label= "URI";
		} else if ( s.isAnon()) {
			label= "blank";
		}

		if (p.isURIResource()) 
			label= " URI ";

		if (o.isURIResource() ) {
			label= "URI";
		} else if (o.isAnon()) {
			label= "blank";
		}
		else if (o.isLiteral()) {
			label= "literal";
		}
	}

	public String getLabel() {
		return label;
	}

    @Override
    public String toString() { return label; }
}