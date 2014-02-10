package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tender)
@Mock([User])
class TenderSpec extends Specification {



    def springSecurityService = Mock(SpringSecurityService)
    def user

    def setup() {
        user = Mock(User)
        //user = new User(username: "julien", password: "julien")
        user.emailAddress = "julien@yahoo.fr"
        user.save()
        springSecurityService.currentUser >> user

        user.springSecurityService = springSecurityService
    }

    def cleanup() {
    }

    @Unroll
    def "test tender without user"() {
        when:
        Tender tender = new Tender(name: "A name", description: "A description", answerDeadline: deadline, postOwner: user)
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
	def "test tender name"() {
		when:
			Tender tender = new Tender(name: "A name", description: "A description", answerDeadline: new Date() + 7)
		then:
			tender.validate() == false
	}
	
	@Unroll
	def "test tender description"() {
		when:
			Tender tender = new Tender(name: "A name", description: description, answerDeadline: new Date() + 7, postOwner: user)
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
			Tender tender = new Tender(name: "A name", description: "A description", answerDeadline: deadline, postOwner: user)
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
			Tender tender = new Tender(name: "A name", description: description, answerDeadline: new Date() + 7, postOwner: user)
		then:
			tender.getLightDescription() == lightDescription
		where:
			description = "Je suis une tr�s tr�s tr�s tr�s longue description. J�aimerais que la petite description soit beaucoup plus l�g�re. Ce String servira pour le test unitaire de la fonction getLightDescription() !"
			lightDescription = "Je suis une tr�s tr�s tr�s tr�s longue description. J�aimerais que la petite description soit beaucoup plus l�g�re. Ce String s..."
	}	
	
}


