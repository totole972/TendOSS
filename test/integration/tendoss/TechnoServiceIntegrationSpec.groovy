package tendoss

import spock.lang.Specification

class TechnoServiceIntegrationSpec extends Specification {

    def technoService


    def setup() {
    }

    def cleanup() {
    }

    void "test create all good"() {
        when:
        technoService.create("libelle", "description")

        then:
        Techno.findByLibelle("libelle") != null

    }

    void "test create bad libelle"() {
        when:
        technoService.create("", "descriptionsssssssssssss")

        then:
        Techno.findByLibelle("") == null

    }

    void "test create bad description"() {
        when:
        def desc=""
        for (def i=0 ; i < Techno.constraints.description.getAppliedConstraint('maxSize').maxSize + 1; i+=10 ){
            desc += "0123456789"
        }
        technoService.create("lib", desc)

        then:
        Techno.findByLibelle("lib") == null

    }
}
