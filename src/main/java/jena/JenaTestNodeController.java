package jena;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

@RestController
@RequestMapping("/statement")
class JenaTestNodeController {

	@Autowired
	private StatementParserImpl statementParser;

	@RequestMapping(value= "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public JenaStatement getStatement(@PathVariable("id") int id) {
		return statementParser.getStatement(id);
	}
}


