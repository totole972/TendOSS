package tendoss

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Techno)
class TechnoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
        when:
        def t = new Techno(libelle: libelle,description: description)
        t.save(validate: true, flush: true, failOnError: false)

        then:
        t.validate() == resultat

        where:
        libelle        |   description     | resultat
        'python'       | 'python'          | true
        'java'         | ''                | true
        'oracle'       | 'oracle'          | true
        ''             | 'grails'          | false
        null           | 'grails'          | false
    }

    void "test unique constraints"() {
        when:
        def t1 = new Techno(libelle: 'python',description: 'python')
        t1.save(validate: true, flush: true, failOnError: false)

        def t2 = new Techno(libelle: 'python',description: '')
        t2.save(validate: true, flush: true, failOnError: false)

        then:
        t1.validate() == true
        t2.validate() == false

    }

    void "test max size constraints"() {
        when:
        def desc =''
        def maxSize = Techno.constraints.description.getAppliedConstraint('maxSize').maxSize

        for (def i = 1 ; i< maxSize; i++ ){
            desc = desc + "a"
        }

        def t1 = new Techno(libelle: 'python',description:desc)
        t1.save(validate: true, flush: true, failOnError: false)

        desc = desc + "aa"

        def t2 = new Techno(libelle: 'python',description:desc)
        t2.save(validate: true, flush: true, failOnError: false)

        then:
        t1.validate() == true
        t2.validate() == false

    }
}
