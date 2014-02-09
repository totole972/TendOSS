package tendoss

class Vote {

    int vote

    static constraints = {
        vote(nullable: false, inList: [-1,1], blank: false)
    }
}
