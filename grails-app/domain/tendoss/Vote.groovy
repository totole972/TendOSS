package tendoss

class Vote {
    int vote
    User voter
    static constraints = {
        vote(nullable: false, inList: [-1,1], blank: false)
    }
}
