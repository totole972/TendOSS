package tendoss

class UserTechno implements Serializable{

    Level level
    Techno techno
    User user
    //static belongsTo = [user: User]

    static mapping = {
        version(false)
        id composite: ['user', 'techno']
    }

    static constraints = {
        level nullable: false, blank: false
    }

}
