package tendoss

import groovy.sql.Sql
import tendoss.Role.RoleEnum

class BootStrapService {

	def dataSource
	UserService userService
	
	Role userRole
	Role adminRole
	
	User julien
	User admin
	
	Techno cpp
	Techno java
	Techno uml
	
	Level beginner
	Level intermediate
	Level advanced
	
	Tender tender
	
    def initializeRoles() {
		Sql sql = new Sql(dataSource)
		
        adminRole = Role.findByAuthority(RoleEnum.ADMIN_ROLE.name())
        if (!adminRole) {
            sql.executeInsert("insert into role(id, authority) values (1,${RoleEnum.ADMIN_ROLE.name()})")
        }
		
        userRole = Role.findByAuthority(RoleEnum.USER_ROLE.name())
        if (!userRole) {
            sql.executeInsert("insert into role(id, authority) values (2,${RoleEnum.USER_ROLE.name()})")
        }
    }
	
	def initializeDevTechnos() {
		cpp == Techno.findByLibelle('C++')
		if (!cpp) {
			cpp = new Techno(libelle: 'C++', description: 'Free-form programming language')
			cpp.save()
		}
		
		java == Techno.findByLibelle('Java')
		if (!java) {
			java = new Techno(libelle: 'Java', description: 'Object-oriented programming language')
			java.save()
		}
		
		uml == Techno.findByLibelle('UML')
		if (!uml) {
			uml = new Techno(libelle: 'UML', description: 'General-purpose modeling language')
			uml.save()
		}
	}
	
	def initializeDevLevels() {
		beginner = Level.findByName('Beginner')
		if (!beginner) {
			beginner = new Level(name: 'Beginner', description: 'For those who are juste starting to learn programming')
			beginner.save()
		}

		intermediate = Level.findByName('Intermediate')
		if (!intermediate) {
			intermediate = new Level(name: 'Intermediate', description: 'Quite good experience in programming skills')
			intermediate.save()
		}
		
		advanced = Level.findByName('Advanced')
		if (!advanced) {
			advanced = new Level(name: 'Advanced', description: 'Very confident	about analytical and programming skills')
			advanced.save()
		}
	}
	
	def initializeDevUsers() {
		admin = User.findByUsername("admin")
		if (!admin) {
			def user = new User(username: "admin", password: "adminPassword", emailAddress: 'kevinanatole@yahoo.fr')
			admin = userService.addUser(user, adminRole, true)
		}
		
		julien = User.findByUsername("julien")
		if (!julien) {
			def user = new User(username: "julien", password: "julien", emailAddress: 'julien@yahoo.fr')
			julien = userService.addUser(user, userRole, true)
			new UserTechno(level: intermediate, techno: cpp, user: julien)
		}
	}
	
	def initializeDevTenders() {
		tender = new Tender(name: 'Test tender', description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', answerDeadline: new Date() + 31, closed: false, postOwner: julien)
		tender.save()
		new TenderTechno(minimalLevel: intermediate, techno: java, tender: tender).save()
		//new TenderTechno(minimalLevel: beginner, techno: uml, tender: tender).save()
	}
}
