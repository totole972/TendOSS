package tendoss

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Answer)
class AnswerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	def "Test answerDate constraints"() {
		setup:
		mockForConstraintsTests(Answer)

		when:
		def answer = new Answer(answerDate: answerDate, content: "Answer text")
		answer.validate()

		then:
		answer.hasErrors() == !valid

		where:
		answerDate 	| valid
		null 		| false
		"" 			| false
	}

	def "Test content constraints"() {
		setup:
		mockForConstraintsTests(Answer)

		when:
		def calendar = new GregorianCalendar(2011, 1, 7)
		def answer = new Answer(answerDate: calendar.getTime(), content: content)
		answer.validate()

		then:
		answer.hasErrors() == !valid

		where:
		content | valid
		null 	| false
		"" 		| false
	}
}
