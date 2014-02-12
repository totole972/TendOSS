package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(AnswerController)
@Mock([Answer, User, SpringSecurityService,Tender])
class AnswerControllerSpec extends Specification {

    def springSecurityService = Mock(SpringSecurityService)
    def user
    def tender

    def setup() {
        user = new User()
        user.username = "julien"
        user.password ="julien"
        user.emailAddress = "julien@yahoo.fr"
        user.springSecurityService = springSecurityService
        user.save(flush: true)
        //user.save(failOnError: true)
        tender = new Tender(name: "tender1", description: "a",answerDeadline: new Date()+365, postOwner: user).save(flush: true, failOnError: true)
        springSecurityService.currentUser >> user
        controller.springSecurityService = springSecurityService
    }

    def cleanup() {
    }

    void "test adding answer to tender"() {
        when:"test with good params"
        def answer = new Answer(content: "content", answerDate: new Date())
        controller.params.tender = tender.id
        controller.save(answer)

        then:"all good"
        response.redirectedUrl == "/tender/show/${tender.id}"


        when:"test with bad params"
        response.reset()
        controller.params.tender = null
        answer = new Answer(content: "content", answerDate: new Date())
        controller.save(answer)
        then:"no good"
        response.redirectedUrl == "/answer/index"

        when:"test with errors"
        response.reset()
        answer = null
        controller.params.tender = tender.id
        answer = new Answer(content: "", answerDate: new Date())
        controller.save(answer)


        then:"not Found"
        answer.id == null


    }

    @Unroll
    void "test edit"() {
        when:"test no answerId"
        controller.params.answerId = null
        controller.edit()
        then:"all good"
        response.redirectedUrl == "/tender/index"

        when:"test no tenderId"
        response.reset()
        controller.params.answerId = 1
        controller.params.tenderId = null
        controller.edit()
        then:"all good"
        response.redirectedUrl == "/tender/index"

        when:"test current user different de auteur"
        response.reset()
        def newuser = new User()
        newuser.username = "juju"
        newuser.password ="juju"
        newuser.emailAddress = "jules@yahoo.fr"
        newuser.springSecurityService = springSecurityService
        newuser.save(flush: true)
        def answer = new Answer(content: "content", answerDate: new Date(), author: newuser).save(flush: true)
        controller.params.answerId = answer.id
        controller.params.tenderId = 1
        controller.edit()
        then:"all good"
        response.redirectedUrl == "/tender/index"
        when:"test content null"
        response.reset()
        answer = null
        answer = new Answer(content: "content", answerDate: new Date(), author: user).save(flush: true)
        controller.params.answerId = answer.id
        controller.params.tenderId = 1
        controller.edit()
        then:"all good"
        response.redirectedUrl == "/tender/index"

        when:"test when content empty"
        response.reset()
        answer = null
        answer = new Answer(content: "content", answerDate: new Date(), author: user).save(flush: true)
        controller.params.answerId = answer.id
        controller.params.tenderId = 1
        controller.params.content = ""
        controller.edit()
        then:"all good"
        response.redirectedUrl == "/tender/index"

        when:"test OK"
        response.reset()
        answer = null
        answer = new Answer(content: "content", answerDate: new Date(), author: user).save(flush: true)
        controller.params.answerId = answer.id
        controller.params.tenderId = 1
        controller.params.content = "lol"
        controller.edit()
        then:"all good"
        answer.content == "lol"
        response.redirectedUrl == "/tender/show/1"
    }
}
