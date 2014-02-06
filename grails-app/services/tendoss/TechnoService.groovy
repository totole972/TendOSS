package tendoss

import grails.transaction.Transactional
import grails.validation.ValidationException

@Transactional
class TechnoService {

    def serviceMethod() {

    }

    def create(String libelle,String description){

        def tec = new Techno(libelle: libelle, description: description)
        try{
            tec.save(failOnError: true)
            return true
        }catch (ValidationException e){
            return false
        }
    }
}
