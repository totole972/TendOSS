package tendoss

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Level)
class LevelSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraint name"() {
        when:"adding Level"
        def lev = new Level(name:name, description:descr)

        then:
        lev.validate() == result

        where:
        name        |descr      | result
        "level"     |"bla"      | true
        null        |"bla"      | false
        ""          |"bla"      | false
    }
}
