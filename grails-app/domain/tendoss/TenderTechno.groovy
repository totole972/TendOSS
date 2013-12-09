package tendoss

class TenderTechno {

    Level minimalLevel


    static belongsTo = [tender : Tender, techno: Techno]

    static mapping = {
        version(false)
    }

    static constraints = {
        minimalLevel nullable: false, blank: false
    }
}
