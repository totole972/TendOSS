package tendoss

import spock.lang.Specification
import tendoss.Role.RoleEnum

class BootstrapIntegrationSpec extends Specification {

	BootStrapService bootStrapService

	def "role initialization"() {
		when:
			bootStrapService.initializeRoles()
		then:
		    bootStrapService.userRole != null
		    bootStrapService.userRole == RoleEnum.USER_ROLE.role
		    bootStrapService.adminRole != null
		    bootStrapService.adminRole == RoleEnum.ADMIN_ROLE.role
		    bootStrapService.adminRole.id == 1
  	}
}
