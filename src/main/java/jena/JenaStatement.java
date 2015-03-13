package jena;

public class JenaStatement {

	private final long id;
	private final String label;

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
}