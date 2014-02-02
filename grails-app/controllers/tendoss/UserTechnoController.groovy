package tendoss

class UserTechnoController {

    def springSecurityService
    def index() {}

    def create(UserTechno userTechnoInstance){
        //def user = User.get((long)((GrailsUser)springSecurityService.authentication.getPrincipal()).getId())
        //def user = User.get((long)(springSecurityService.authentication.getPrincipal()).getId())
        def user = springSecurityService.currentUser
        def techno = params.skills
        def level = params.level

        def usrTch = new UserTechno(user: user, techno: techno, level: level)
        usrTch.save()

        redirect(controller:"User",action:"_personnalform", params:[userInstance: user.id])//render(model: 'user', bean: user, template: '_personnalform')
    }

    def remove(UserTechno userTechnoInstance){
        def user = springSecurityService.currentUser
        if (userTechnoInstance != null)
            userTechnoInstance.delete()


        redirect(controller:"User",action:"_personnalform", params:[userInstance: user.id])//render(model: 'user', bean: user, template: '_personnalform')
    }
}
