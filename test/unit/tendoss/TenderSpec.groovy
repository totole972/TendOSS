package tendoss

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tender)
class TenderSpec extends Specification {

	@Unroll
	def "test tender name"() {
		when:
			Tender tender = new Tender(name: name, description: "A description", answerDeadline: new Date() + 7)
		then:
			tender.validate() == nameIsOK
		where:
			name            | nameIsOK
			null			| false
			""				| false
			"A name"		| true
	}
	
	@Unroll
	def "test tender description"() {
		when:
			Tender tender = new Tender(name: "A name", description: description, answerDeadline: new Date() + 7)
		then:
			tender.validate() == descriptionIsOK
		where:
			description     | descriptionIsOK
			null			| false
			""				| false
			"A description" | true
	}
	
	@Unroll
	def "test tender deadline"() {
		when:
			Tender tender = new Tender(name: "A name", description: "A description", answerDeadline: deadline)
		then:
			tender.validate() == deadlineIsOK
		where:
			deadline         | deadlineIsOK
			null			 | false
			new Date() - 365 | false
			new Date() + 6   | false
			new Date() + 7   | true
			new Date() + 365 | true
	}
	
	@Unroll
	def "test tender light description"() {
		when:
			Tender tender = new Tender(name: "A name", description: description, answerDeadline: new Date() + 7)
		then:
			tender.getLightDescription() == lightDescription
		where:
			description = "Je suis une très très très très longue description. J’aimerais que la petite description soit beaucoup plus légère. Ce String servira pour le test unitaire de la fonction getLightDescription() !"
			lightDescription = "Je suis une très très très très longue description. J’aimerais que la petite description soit beaucoup plus légère. Ce String s..."
	}	
	
}


