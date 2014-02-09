package tendoss

import grails.plugin.springsecurity.SpringSecurityService
import spock.lang.Specification
import tendoss.Role.RoleEnum

class UserServiceIntegrationSpec extends Specification {

	BootStrapService bootStrapService
	UserService userService
	SpringSecurityService springSecurityService
	
	def passwordEncoder
	
	def "add user"() {
		given:
			bootStrapService.initializeRoles()
		when:
			User randomUser = userService.addUser(new User(username: "RandomUser",
														   emailAddress: "random.user@domain.com",
													       password: "RandomPassword"),
										          RoleEnum.USER_ROLE.role)
		then:
			User user = User.findByUsername("RandomUser")
			user != null
			user.enabled
			user.emailAddress == "random.user@domain.com"
			!user.authorities.empty
			user.authorities.first().authority == RoleEnum.USER_ROLE.name()
			passwordEncoder.isPasswordValid(user.password, "RandomPassword", null)
			//user.password == springSecurityService.encodePassword("password")
	}
}
