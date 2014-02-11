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

    void "test getBestTender"() {
        setup:

        def tenders = []
        when:
        tenders = voteService.getBestTenders()
        then:
        tenders.size() == 10

    }

    void "test getBestTender < 10"() {
        setup:
        for (int i=10 ; i<14; i++){
            Tender.get(i).delete()
        }
        def tenders = []
        when:
        tenders = voteService.getBestTenders()
        then:
        tenders.size() < 10

    }

    void "tender index"(){
        setup:
        def tc = new TenderController()
        def retour
        tc.voteService = Mock(VoteService)
        when :
        retour = tc.index()
        then :
         assert tc.response.status == 200
    }
}
