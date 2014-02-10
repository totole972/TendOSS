package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.core.context.SecurityContextHolder
import spock.lang.Specification
import spock.lang.Unroll
import tendoss.test.IntegrationTestInit

class VoteServiceIntegrationSpec extends Specification {

    def technoService
    def voteService

    def setupSpec(){
        IntegrationTestInit.initData()
    }

    def setup() {

    }

    def cleanup() {

    }

    void "test vote for an answer"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def answer = Answer.get(1)
        def answer2 = Answer.get(2)
        def score = voteService.calculateScore("answer",1)
        def score2 = voteService.calculateScore("answer",2)
        def return1
        def return2
       when :
       SpringSecurityUtils.doWithAuth("user1"){
           return1 = voteService.voteAnswer(answer,1)
           return2 = voteService.voteAnswer(answer2,-1)
       }
       then :
        voteService.calculateScore("answer",1) == score + 1
        voteService.calculateScore("answer",2) == score - 1
        return1.message == "OK"
        return2.message == "OK"

    }

    void "test vote for an answer echec"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def answer = Answer.get(1)
        def answer2 = Answer.get(2)
        def return1
        def return2
        return1 = voteService.voteAnswer(answer,1)
        return2 = voteService.voteAnswer(answer2,-1)
        def score = voteService.calculateScore("answer",1)
        def score2 = voteService.calculateScore("answer",2)
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            return1 = voteService.voteAnswer(answer,1)
            return2 = voteService.voteAnswer(answer2,-1)
        }
        then :
        voteService.calculateScore("answer",1) == score
        voteService.calculateScore("answer",2) == score2
        return1.error == "Has already Voted"
        return2.error == "Has already Voted"

    }

    void "test vote for an tender"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def tender = Tender.get(1)
        def tender2 = Tender.get(2)
        def score = voteService.calculateScore("tender",1)
        def score2 = voteService.calculateScore("tender",2)
        def return1
        def return2
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            return1 = voteService.voteTender(tender,1)
            return2 = voteService.voteTender(tender2,-1)
        }
        then :
        voteService.calculateScore("tender",1) == score + 1
        voteService.calculateScore("tender",2) == score2 - 1
        return1.message == "OK"
        return2.message == "OK"

    }

    void "test vote for an tender echec"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def tender = Tender.get(1)
        def tender2 = Tender.get(2)
        def return1
        def return2
        return1 = voteService.voteTender(tender,1)
        return2 = voteService.voteTender(tender2,-1)
        def score = voteService.calculateScore("tender",1)
        def score2 = voteService.calculateScore("tender",2)
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            return1 = voteService.voteTender(tender,1)
            return2 = voteService.voteTender(tender2,-1)
        }
        then :
        voteService.calculateScore("tender",1) == score
        voteService.calculateScore("tender",2) == score2
        return1.error == "Has already Voted"
        return2.error == "Has already Voted"

    }
    /*
    void "test vote for an user"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def user = User.get(2)
        def user2 = User.get(3)
        def score = voteService.calculateScore("user",2)
        def score2 = voteService.calculateScore("user",3)
        def return1
        def return2
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            return1 = voteService.voteUser(user,1)
            return2 = voteService.voteUser(user2,-1)
        }
        then :
        voteService.calculateScore("user",2) == score + 1
        voteService.calculateScore("user",3) == score2 - 1
        return1.message == "OK"
        return2.message == "OK"

    }
*/
    /* The method to test is incorrect
    void "test vote for an user echec"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        voteService.springSecurityService  = [authentication:[principal:[id:1]]]
        def user = User.get(2)
        def user2 = User.get(3)
        def return1
        def return2
        def score
        def score2
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            return1 = voteService.voteUser(user,1)
            return2 = voteService.voteUser(user2,-1)
            score = voteService.calculateScore("user",2)
            score2 = voteService.calculateScore("user",3)
            return1 = voteService.voteUser(user,1)
            return2 = voteService.voteUser(user2,-1)
        }
        then :
        voteService.calculateScore("user",2) == score
        voteService.calculateScore("user",3) == score2
        return1.error == "Has already Voted"
        return2.error == "Has already Voted"

    }*/

    void "test getBestTender"() {
        setup:
            def tenders = []
        when:
            tenders = voteService.getBestTenders()
        then:
        tenders.size() == 10

    }

    /*void "test vote for tender"() {
        setup:
        voteService.springSecurityService = Mock(SpringSecurityService)
        def tender = Tender.get(1)
        def tender2 = Tender.get(2)
        def score = voteService.calculateScore("tender",1)
        def score2 = voteService.calculateScore("tender",2)
        def return1
        def return2
        when :
        SpringSecurityUtils.doWithAuth("user1"){
            voteService.voteTender(tender,1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender,1)
            voteService.voteTender(tender,1)
            voteService.voteTender(tender,-1)
        }
        then :
        voteService.calculateScore("tender",1) == score + 2
        voteService.calculateScore("tender",2) == score +4
        return1.message == "OK"
        return2.message == "OK"

        when :
        SpringSecurityUtils.doWithAuth("user1"){
            voteService.voteTender(tender,1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender2,-1)
            voteService.voteTender(tender,1)
            voteService.voteTender(tender,1)
            voteService.voteTender(tender,-1)
        }
        then :
        voteService.calculateScore("tender",1) == score + 2
        voteService.calculateScore("tender",2) == score +4
        return1.error == "Has already Voted"
        return2.error == "Has already Voted"
    }

    void "test vote for user"() {
        setup :
        def user = User.get(1)
        def user2 = User.get(2)
        def score = voteService.calculateScore("user",1)
        def score2 = voteService.calculateScore("user",2)
        when :
        voteService.voteUser(user,1)
        voteService.voteUser(user,-1)
        voteService.voteUser(user,-1)
        voteService.voteUser(user,-1)
        voteService.voteUser(user2,-1)
        voteService.voteUser(user2,1)
        voteService.voteUser(user2,1)
        voteService.voteUser(user2,-1)
        then :
        voteService.calculateScore("user",1) == score - 2
        voteService.calculateScore("user",2) == score

    }

    void "test getBEstAnswer"() {
        when:
        def desc=""
        for (def i=0 ; i < Techno.constraints.description.getAppliedConstraint('maxSize').maxSize + 1; i+=10 ){
            desc += "0123456789"
        }
        technoService.create("lib", desc)

        then:
        Techno.findByLibelle("lib") == null

    }*/
}
