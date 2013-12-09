package tendoss

class Techno {

    String libelle
    String description

    static constraints = {
        libelle nullable: false, blank: false
        description nullable: true, blank: true , maxSize: 100000
    }

    static mapping ={
        version(false)
    }
}
