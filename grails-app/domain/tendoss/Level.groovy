package tendoss

class Level {

    String name
    String description


    static mapping = {
        version(false)
    }

    static constraints = {
        name nullable: false, blank: false
    }
}
