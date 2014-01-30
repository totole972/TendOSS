import tendoss.*

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
            julienUser = User.findByUsername("julien")
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
        def technoCPP = new Techno(libelle: 'C++ ',description: 'c++')
        def technoJava = new Techno(libelle: 'Java',description: 'java')
		def technoUml = new Techno(libelle: 'UML',description: 'Langage de modélisation')
	
        technoCPP.save()
        technoJava.save()
		technoUml.save()

        //niveau
        def deb = new Level(name: 'Debutant',description: 'je debute')
        def intermedaire = new Level(name: 'Intermediaire',description: 'inter')
        def avance = new Level(name: 'Avance',description: 'avance')
        deb.save()
        intermedaire.save()
        avance.save()

        //user techno
        def julTechno  = new UserTechno(level: intermedaire,techno: technoCPP, user: julienUser)
        julTechno.save()
		
		// tender
		def storedTender = new Tender(name: 'Test tender', description:'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', answerDeadline:new Date() + 31, closed: false)		
		def tenderTechnoJava = new TenderTechno(minimalLevel: intermedaire, techno:technoJava, tender:storedTender)
		def tenderTechnoUml = new TenderTechno(minimalLevel: deb, techno:technoUml, tender:storedTender)
		storedTender.save()
		tenderTechnoJava.save()
		tenderTechnoUml.save()
		
    }
    def destroy = {
    }
}
