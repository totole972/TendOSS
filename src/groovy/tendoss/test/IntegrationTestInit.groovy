package tendoss.test

import tendoss.Answer
import tendoss.Role
import tendoss.Tender

/**
 * Created by totole on 09/02/14.
 */
import tendoss.User
import tendoss.UserRole
import tendoss.Vote

class IntegrationTestInit {

    static initData(){

        //create users
        if(User.list().size() == 0){

            def user = new User(username: "user1", password: "user1", emailAddress:"user@yopmail.com" ).save(flush:true,failOnError: true)
            def userRole = new UserRole(user: user, role: Role.findByAuthority("ROLE_USER")).save(flush: true)
            def user2 = new User(username: "user2", password: "user2", emailAddress: "user@yopmail.com").save(flush:true)
            def userRole2 = new UserRole(user: user2, role: Role.findByAuthority("ROLE_USER")).save(flush: true)
            def user3 = new User(username: "user3", password: "user3", emailAddress: "user@yopmail.com").save(flush:true)
            def userRole3 = new UserRole(user: user3, role: Role.findByAuthority("ROLE_USER")).save(flush: true)
            def user4 = new User(username: "user4", password: "user4", emailAddress: "user@yopmail.com").save(flush:true)
            def userRole4 = new UserRole(user: user4, role: Role.findByAuthority("ROLE_USER")).save(flush: true)
            def user5 = new User(username: "user5", password: "user5", emailAddress: "user@yopmail.com").save(flush:true)
            def userRole5 = new UserRole(user: user5, role: Role.findByAuthority("ROLE_USER")).save(flush: true)

            if(Tender.list().size() == 0){
                //create tenders

                def tender = new Tender(name: "tender1", description: "a",answerDeadline: new Date()+365, postOwner: user).save(flush: true, failOnError: true)
                def tender2 = new Tender(name: "tender2", description: "a",answerDeadline: new Date()+365, postOwner: user).save(flush: true)
                def tender3 = new Tender(name: "tender3", description: "a",answerDeadline: new Date()+365, postOwner: user2).save(flush: true)
                def tender4 = new Tender(name: "tender4", description: "a",answerDeadline: new Date()+365, postOwner: user2).save(flush: true)
                def tender5 = new Tender(name: "tender5", description: "a",answerDeadline: new Date()+365, postOwner: user3).save(flush: true)
                def tender6 = new Tender(name: "tender6", description: "a",answerDeadline: new Date()+365, postOwner: user3).save(flush: true)
                def tender7 = new Tender(name: "tender7", description: "a",answerDeadline: new Date()+365, postOwner: user4).save(flush: true)
                def tender8 = new Tender(name: "tender8", description: "a",answerDeadline: new Date()+365, postOwner: user4).save(flush: true)
                def tender9 = new Tender(name: "tender9", description: "a",answerDeadline: new Date()+365, postOwner: user5).save(flush: true)
                def tender10 = new Tender(name: "tender10", description: "a",answerDeadline: new Date()+365, postOwner: user5).save(flush: true)
                def tender11 = new Tender(name: "tender11", description: "a",answerDeadline: new Date()+365, postOwner: user5).save(flush: true)
                def tender12 = new Tender(name: "tender12", description: "a",answerDeadline: new Date()+365, postOwner: user4).save(flush: true)
                def tender13 = new Tender(name: "tender13", description: "a",answerDeadline: new Date()+365, postOwner: user3).save(flush: true)


                   //Create answers

                   def answer = new Answer(content: "sdfdsfsdf", author: user).save(flush:true,failOnError: true)
                   def answer2 = new Answer(content: "sdfdsfsdf", author: user).save(flush:true)
                   def answer3 = new Answer(content: "sdfdsfsdf", author: user2).save(flush:true)
                   def answer4 = new Answer(content: "sdfdsfsdf", author: user2).save(flush:true)
                   def answer5 = new Answer(content: "sdfdsfsdf", author: user3).save(flush:true)
                   def answer6 = new Answer(content: "sdfdsfsdf", author: user3).save(flush:true)
                   def answer7 = new Answer(content: "sdfdsfsdf", author: user4).save(flush:true)
                   def answer8 = new Answer(content: "sdfdsfsdf", author: user4).save(flush:true)
                   def answer9 = new Answer(content: "sdfdsfsdf", author: user5).save(flush:true)
                   def answer10 = new Answer(content: "sdfdsfsdf", author: user5).save(flush:true)
                   def answer11 = new Answer(content: "sdfdsfsdf", author: user5).save(flush:true)
                   def answer12 = new Answer(content: "sdfdsfsdf", author: user4).save(flush:true)

                   //Set answers to tenders
                   tender.addToAnswers(answer)
                   tender2.addToAnswers(answer2)
                   tender3.addToAnswers(answer3)
                   tender4.addToAnswers(answer4)
                   tender5.addToAnswers(answer5)
                   tender6.addToAnswers(answer6)
                   tender7.addToAnswers(answer7)
                   tender8.addToAnswers(answer8)
                   tender9.addToAnswers(answer9)
                   tender10.addToAnswers(answer10)
                   tender11.addToAnswers(answer11)
                   tender12.addToAnswers(answer12)


                   def random = 0
                   Tender.list().each {
                       def val = 0
                       random++
                       if(random % 2 == 0){
                           val =1
                       }else{
                           val =-1
                       }
                       random++
                       def vote = new Vote(vote: val, voter: user3).save(flush:true)
                       it.addToVotes(vote)
                       if(random % 2 == 0){
                           val =1
                       }else{
                           val =-1
                       }
                       random++
                       vote = new Vote(vote: val, voter: user4).save(flush:true)
                       it.addToVotes(vote)
                       if(random % 2 == 0){
                           val =1
                       }else{
                           val =-1
                       }
                       vote = new Vote(vote: val, voter: user5).save(flush:true)
                       it.addToVotes(vote)
                       it.save(flush: true)

                   }
            }
        }
    }

}
