import grails.util.Environment
import tendoss.BootStrapService

class BootStrap {
	
	BootStrapService bootStrapService

	def init = { servletContext ->
		bootStrapService.initializeRoles()
		Environment.executeForCurrentEnvironment {
			development {
				bootStrapService.initializeDevTechnos()
				bootStrapService.initializeDevLevels()
				bootStrapService.initializeDevUsers()
				bootStrapService.initializeDevTenders()
			}
			demo {
				bootStrapService.initializeDevTechnos()
				bootStrapService.initializeDevLevels()
				bootStrapService.initializeDevUsers()
				bootStrapService.initializeDevTenders()
			}
		}
	}

	def destroy = { }
}