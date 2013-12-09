import tendoss.Role
import tendoss.User
import tendoss.UserRole

class BootStrap {

    def init = { servletContext ->
        def roles = Role.list()
        def userRole
        def adminRole
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
    }
    def destroy = {
    }
}
