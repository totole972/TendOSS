package tendoss

class File {

    String name
    Float size
    String type
    String path



    static mapping = {
        version(false)
    }
    static constraints = {
        name nullable: false, blank:false
        size nullable: false, blank: false
        type nullable: false, blank: false
        path nullable: false, blank: false
    }
}
