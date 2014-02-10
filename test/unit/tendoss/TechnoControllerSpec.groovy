package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TechnoController)
@Mock([Techno, User, TechnoService, SpringSecurityService])
class TechnoControllerSpec extends Specification {

    def springSecurityService = Mock(SpringSecurityService)
    def user
    def tecServ = Mock(TechnoService)

    def setup() {
        user = new User(username: "julien", password: "julien")
        user.emailAddress = "julien@yahoo.fr"
        user.save()
        springSecurityService.currentUser >> user

        user.springSecurityService = springSecurityService
        controller.springSecurityService = springSecurityService
        controller.technoService = tecServ
    }

    def cleanup() {
    }

    void "create"() {
        when:"test with good params"
        controller.params.libelle = "libelle"
        controller.params.description = "description"
        controller.create()

        then:"all good"
        response.redirectedUrl == "/user/_personnalform?userInstance="+user.id
        response.redirectUrl == "/user/_personnalform?userInstance="+user.id

        when:"test with bad params"
        response.reset()
        controller.params.libelle = null
        controller.params.description = null
        controller.technoService = tecServ
        controller.create()

        then:"no good"
        //good redirection
        response.redirectedUrl == "/user/_personnalform?userInstance="+user.id
        response.redirectUrl == "/user/_personnalform?userInstance="+user.id

    }

}
