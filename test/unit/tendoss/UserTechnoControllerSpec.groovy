package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserTechnoController)
@Mock([SpringSecurityService, User, Techno, UserTechno, Level])
class UserTechnoControllerSpec extends Specification {


    Level level
    Techno skill
    User user
    SpringSecurityService sprSecSrv = Mock(SpringSecurityService)
    def setup() {
        controller.springSecurityService = sprSecSrv
        user = new User(username: 'julien', password: "julien")
        user.emailAddress = "julien@yahoo.fr"
        user.springSecurityService = sprSecSrv
        user.save()

        level = new Level(name: 'débutant',description: 'débutant')
        level.save()
        skill = new Techno(libelle: 'ruby',description: 'ruby')
        skill.save()
    }

    def cleanup() {
    }

    void "create action all be good"() {
        when:"used create actions  normally"
        controller.params.level = level.id
        controller.params.skills = skill.id

        sprSecSrv.currentUser >> user
        controller.create()

        then: "all must be good"
        response.redirectedUrl == '/user/_personnalform?userInstance='+user.id
        def usrTechno = UserTechno.findByTechnoAndLevel(skill, level)
        usrTechno != null
        usrTechno.user == user
    }

    void "create with bad parameters"(){
        when:"used create actions with bad params"
        controller.params.level = "az"
        controller.params.skills = "ae"

        sprSecSrv.currentUser >> user
        controller.create()

        then: "redirect is same, no instance is created"
        response.redirectedUrl == '/user/_personnalform?userInstance='+user.id
        def usrTechno = UserTechno.findAll()
        usrTechno.size() == 0
    }

    void "test remove"(){
        when:"used remove actions with good params"
        def userTechnoInstance = new UserTechno(user: user,level: level, techno: skill)
        userTechnoInstance.save()
        sprSecSrv.currentUser >> user
        controller.params.technoId = skill.id
        controller.remove( userTechnoInstance)

        then: "it is removed"
        response.redirectedUrl == '/user/_personnalform?userInstance='+user.id
        def usrTechno = UserTechno.findAll()
        usrTechno.size() == 0
    }

    void "test remove bad params"(){
        when:"used remove actions with bad params"
        def userTechnoInstance = new UserTechno(user: user,level: level, techno: skill)
        userTechnoInstance.save()
        sprSecSrv.currentUser >> user
        controller.remove()

        then: "it is removed"
        response.redirectedUrl == '/user/_personnalform?userInstance='+user.id
        def usrTechno = UserTechno.findAll()
        usrTechno.size() == 1
    }
}
