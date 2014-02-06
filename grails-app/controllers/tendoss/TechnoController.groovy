package tendoss

import grails.plugin.springsecurity.userdetails.GrailsUser

class TechnoController {
    def springSecurityService
    def technoService

    def index() {}

    def create(){
        def lib = (String)params.libelle
        def desc = (String)params.description


        technoService.create(lib, desc)

        def user = User.get((long)((GrailsUser)springSecurityService.authentication.getPrincipal()).getId())
        redirect(controller:"User",action:"_personnalform", params:[userInstance: user.id])
    }
}
