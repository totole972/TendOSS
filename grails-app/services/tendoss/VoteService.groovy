package tendoss

import grails.transaction.Transactional
import groovy.sql.Sql
import org.hibernate.criterion.CriteriaSpecification

import javax.sql.DataSource

@Transactional
class VoteService {

    def dataSource
    def springSecurityService

    def voteAnswer(Answer answer, int val){
        def currentUser = User.get(springSecurityService.authentication.principal.id)
        Boolean hasVoted = false
        for(Vote v: answer?.votes ?:[]){
            if(v.voter.id == currentUser.id){
                hasVoted = true
                break
            }
        }
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            def vote = new Vote(vote: val, voter: currentUser).save(flush:true)
            answer.addToVotes(vote)
            answer.save(flush: true)
            return [message : "OK"]
        }
    }

    def voteTender(Tender tender, int val){
        def currentUser = User.get(springSecurityService.authentication.principal.id)
        Boolean hasVoted = false
        for(Vote v: tender?.votes ?:[]){
            if(v.voter.id == currentUser.id){
                hasVoted = true
                break
            }
        }
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            def vote = new Vote(vote: val, voter: currentUser).save(flush:true,failOnError: true)
            tender.addToVotes(vote)
            tender.save(flush:true)
            return [message : "OK"]
        }
    }

    //TODO Review the database schema before using this method
    /*def voteUser(User user, int val){
        def currentUser = User.get(springSecurityService.authentication.principal.id)
        Boolean hasVoted = false
        for(Vote v: user?.votes ?:[]){
            if(v.voter.id == currentUser.id){
                hasVoted = true
                break
            }
        }
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            def vote = new Vote(vote: val, voter: currentUser).save(flush:true)
            user.ad
            user.save(flush:true)
            return [message : "OK"]
        }
    }*/

    def calculateScore(String entity, Long id){
        def score =0
        def entityInstance
        switch(entity){
            case "answer" : entityInstance = Answer.get(id)
                break
            case "tender" : entityInstance = Tender.get(id)
                break
            case "user" : entityInstance = User.get(id)
                break
        }
        score += (int)entityInstance?.votes?.vote?.sum()?:0
        return score;
    }

    def getBestTenders(){

        def firstList = []
        Tender.withSession {
            Tender.list(fetch: [votes :'eager']).each {
                def res =   [
                        id : it.id,
                        name: it.name,
                        note : calculateScore("tender",it.id),
                        nbvotes : it.votes.size()
                ]
                firstList << res
            }
        }
       firstList.sort{a,b-> b.note<=>a.note}
        def secondList
        if(firstList.size() >= 10){
            secondList = firstList.subList(0,10)
        }else{
            secondList = firstList.subList(0,firstList.size())
        }
        /*firstList = null
        def finalList = []
        println(finalList)

        def sql = new Sql(dataSource)
        def results = sql.rows ('''
        select tender.id, tender.name, sum(vote.vote) as note ,count(vote.vote) nbVotes
        from tender,tender_vote,vote
        where tender.id = tender_vote.tender_votes_id
        and vote.id = tender_vote.vote_id
        group by tender.id
        order by 3 desc
         ''',0,10)


        return results*/
        return secondList
    }
}
