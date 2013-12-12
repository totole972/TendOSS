package tendoss

class User {

    transient springSecurityService

    String username
    String password
    String emailAddress
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static hasMany = [answers : Answer, proposals: Tender, assignedTenders: Tender,  votes: Vote, skills: UserTechno]

    static constraints = {
        username blank: false, unique: true
        password blank: false, nullable : false
        emailAddress nullable: false, blank: false, email: true
    }

    static mapping = {
        password column: '`password`'
        version(false)
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
