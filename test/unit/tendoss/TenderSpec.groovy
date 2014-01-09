package tendoss

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tender)
class TenderSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
	
	def "Test constraints"() {
		setup:
		mockForConstraintsTests(Tender)

		when:
		def tender = new Tender(name: name, submissionDate: submissionDate, closed: closed)
		tender.validate()

		then:
		tender.hasErrors() == !valid

		where:
		name 		| 	submissionDate	|	closed	|	valid
		null		|	null			|	null	|	false
		"A name" 	| 	null			|	null	|	false
		null		| 	new Date()		|	null	|	false
		null		| 	null			|	false	|	false
		"A name"	| 	new Date()		|	null	|	false
		"A name"	| 	null			|	false	|	false
		null		| 	new Date()		|	false	|	false
		""			|	""				|	""		|	false
		"A name" 	| 	""				|	""		|	false
		""			| 	new Date()		|	""		|	false
		""			| 	""				|	false	|	false
		"A name"	| 	new Date()		|	""		|	false
		"A name"	| 	""				|	false	|	false
		""			| 	new Date()		|	false	|	false
	}
}


