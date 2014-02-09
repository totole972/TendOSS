package tendoss

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class VoteService {

    def dataSource
    def springSecurityService

    def voteAnswer(Answer answer, int val){
        def currentUser = springSecurityService.currentUser as User
        def hasVoted =  answer.votes.count {
            it.voter.id == currentUser.id
        } > 0
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            answer.addToVotes(new Vote(vote: val, voter: currentUser))
            answer.save()
        }
    }

    def voteTender(Tender tender, int value){
        def currentUser = springSecurityService.currentUser as User
        def hasVoted =  tender.votes.count {
            it.voter.id == currentUser.id
        } > 0
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            tender.addToVotes(new Vote(vote: val, voter: currentUser))
            tender.save()
        }
    }

    def voteUser(User user, int value){
        def currentUser = springSecurityService.currentUser as User
        def hasVoted =  user.votes.count {
            it.voter.id == currentUser.id
        } > 0
        if(hasVoted){
            return [error : "Has already Voted"]
        }else{
            user.addToVotes(new Vote(vote: val, voter: currentUser))
            user.save()
        }
    }

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
        score += (int)entityInstance.votes.vote.sum()
        return score;
    }

    def getBestTenders(){
        def c = Tender.createCriteria()
        def sql = new Sql(dataSource)
        def results = sql.rows ('''
        select tender.id, tender.name, sum(vote.vote) as note ,count(vote.vote) nbVotes
        from tender,tender_vote,vote
        where tender.id = tender_vote.tender_votes_id
        and vote.id = tender_vote.vote_id
        group by tender.id
        order by 3 desc
         ''',0,10)
        return results
    }
}
