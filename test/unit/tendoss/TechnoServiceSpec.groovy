package tendoss

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TechnoService)
@Mock(Techno)
class TechnoServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test insertion"() {
        when:"adding a techno"
        def ret = service.create(libelle,description)

        then:"assert techno is in base"
        def t = Techno.findByLibelle(libelle)
        t.libelle == libelle
        t.description == description

        where:
        libelle     |description
        "libelle"   |"description"
    }

    void "test constraint unique"() {
        when:"adding 2 same techno"
        def libelle = "libelle"
        def description = "description"
        def ret = service.create(libelle,description)
        print ret

        ret = service.create(libelle,description)
        print ret

        then:"assert techno is in base one time"
        def t = Techno.findAllByLibelle(libelle)
        t.size() == 1
    }

    void "test constraint max size description"() {
        when:"adding too big description"
        String libelle = "Max-size"
        String description = ""
        def maxSize = Techno.constraints.description.getAppliedConstraint('maxSize').maxSize
        for (def i =0 ; i < maxSize ; i++){
            description+= "e"
        }
        def ret = service.create(libelle,description)
        print ret

        ret = service.create(libelle+'_',description+'_')
        print ret

        then:"assert techno is not in base"
        def t1 = Techno.findAllByLibelle(libelle)
        t1.size() == 1

        def t2 = Techno.findAllByLibelle(libelle+'_')
        t2.size() == 0
    }
}
