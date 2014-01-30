package tendoss

class Techno {

    String libelle
    String description

    static constraints = {
        libelle nullable: false, blank: false, unique: true
        description nullable: true, blank: true , maxSize: 100000
    }

    static mapping ={
        version(false)
    }

    @Override
    String toString(){
        return libelle + ' : ' + description
    }
}
