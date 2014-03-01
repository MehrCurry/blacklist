package blacklist

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Email)
class EmailSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test invalid"() {
        given:
        def blacklist = new Blacklist(memo:"Test",mid:24)
        def invalid = new Email(address:"sdfsdf", blacklist:blacklist)

        when:
        def response = invalid.validate()

        then:
        response == false
        println(response)
    }

    void "test valid"() {
        given:
        def blacklist = new Blacklist(memo:"Test",mid:24)
        def valid = new Email(address:"sdfsdf@ddd.de", blacklist:blacklist)

        when:
        def response = valid.validate()

        then:
        response == true
        println(response)
    }

    void "test normalize without match"() {
        given:
        def email="test@test.de"

        when:
        def result=Email.normalize(email)

        then:
        result == email

    }

    void "test normalize with match"() {
        given:
        def email="test+unit@test.de"

        when:
        def result=Email.normalize(email)

        then:
        result == "test@test.de"

    }
}
