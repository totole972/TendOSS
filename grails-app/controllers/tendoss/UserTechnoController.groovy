package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.userdetails.GrailsUser
import org.codehaus.groovy.grails.test.io.SystemOutAndErrSwapper

class UserTechnoController {

    def springSecurityService
    def index() {}

    def create(){
        //def ret='';
        def user = User.get(((GrailsUser)springSecurityService.authentication.getPrincipal()).getId())
        def techno = params.skills
        def level = params.level

        def usrTch = new UserTechno(user: user, techno: techno, level: level)
        usrTch.save()

        /*for (u in user.skills){
            ret += '<li>'+u.techno.getLibelle()+'&nbsp;'+u.level.getName()+'<p style="align:right"><'+'</li>\n'
        }*/
        //render(text: ret,contentType:'text/plain')
        println redirect(controller:"User",action:"_personnalform", params:[userInstance: user.id])//render(model: 'user', bean: user, template: '_personnalform')
    }

    def remove(){
        def ret='';
        def usr_techno = params.usr_techno
        println(usr_techno)
        UserTechno.get(usr_techno).delete()


        for (u in user.skills){
            ret += '<li>'+u.techno.getLibelle()+'&nbsp;'+u.level.getName()+'</li>\n'
        }
        render(text: ret,contentType:'text/plain')
    }
}
