package tendoss

class Vote {

    Boolean up = false

    static belongsTo = [Voter: User]

    static constraints = {
        up(nullable: false, blank: false)
    }
}
