package tendoss

import grails.plugin.springsecurity.userdetails.GrailsUser

class TechnoController {
    def springSecurityService

    def index() {}

    def create(){
        def user = User.get((long)((GrailsUser)springSecurityService.authentication.getPrincipal()).getId())
        def libel = params.libelle
        def desc = params.description

        def tec = new Techno(libelle: libel, description: desc)

        tec.save()
        redirect(controller:"User",action:"_personnalform", params:[userInstance: user.id])
    }
}
