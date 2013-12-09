package tendoss

class UserTechno {

    Level level

    static belongsTo = [user: User, techno: Techno]

    static mapping = {
        version(false)
    }

    static constraints = {
        level nullable: false, blank: false
    }
}
