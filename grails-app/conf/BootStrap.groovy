import tendoss.Level
import tendoss.Role
import tendoss.Techno
import tendoss.User
import tendoss.UserRole
import tendoss.UserTechno

class BootStrap {

    def init = { servletContext ->
        def roles = Role.list()
        def userRole
        def adminRole
        def julienUser
        if(roles.size() == 0){
            userRole = new Role(authority: 'ROLE_USER').save()
            adminRole = new Role(authority: 'ROLE_ADMIN').save()
        }else{
            userRole = Role.findByAuthority('ROLE_USER')
            adminRole = Role.findByAuthority('ROLE_ADMIN')
        }
        def users = User.list()
        def stdUser
        def adminUser
        if(users.size() == 0){
            stdUser = new User(username: 'stdUser', password: "stdPassword")
            stdUser.emailAddress = "test@yopmail.com"
            stdUser.save(failOnError: true)
            adminUser = new User(username: 'admin', password: "adminPassword")
            adminUser.emailAddress = "kevinanatole@yahoo.fr"
            adminUser.save(failOnError: true)

            julienUser = new User(username: 'julien', password: "julien")
            julienUser.emailAddress = "julien@yahoo.fr"
            julienUser.save(failOnError: true)
        }else{
            adminUser = User.findByUsername("admin")
            stdUser = User.findByUsername("stdUser")
        }
        def stdAuth = stdUser.getAuthorities()
        if(stdAuth.size() == 0){
            new UserRole(user: stdUser, role: userRole).save()
        }
        def adminAuth = adminUser.getAuthorities()
        if(adminAuth.size() == 0){
            new UserRole(user: adminUser, role: adminRole).save()
        }

        //techno
        def technoCPP = new Techno(libelle: 'c++ ',description: 'c++')
        def technoJava = new Techno(libelle: 'java',description: 'java')
        technoCPP.save()
        technoJava.save()

        //niveau
        def deb = new Level(name: 'debutant',description: 'je debute')
        def intermedaire = new Level(name: 'intermediare',description: 'inter')
        deb.save()
        intermedaire.save()

        //user techno
        def julTechno  = new UserTechno(level: intermedaire,techno: technoCPP, user: julienUser)
        julTechno.save()

    }
    def destroy = {
    }
}
