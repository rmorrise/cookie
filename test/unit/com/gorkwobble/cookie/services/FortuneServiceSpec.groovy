package com.gorkwobble.cookie.services

import com.gorkwobble.cookie.NotFoundException
import com.gorkwobble.cookie.domain.Fortune
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FortuneService)
@Mock(Fortune)
class FortuneServiceSpec extends Specification {

    void "getRandomFortune returns a fortune"() {
        given:
        def fortune = new Fortune(message: 'foo')
        fortune.save()

        when:
        def result = service.getRandomFortune()

        then:
        result != null
        result.message == 'foo'
    }

    void "getRandomFortune throws an error when the database is empty"() {
        when:
        def result = service.getRandomFortune()

        then:
        thrown NotFoundException
    }

    void "getRandomInteger returns numbers in the correct range"() {
        expect:
        def result = service.generateRandomInt(n)
        result >= 0
        result < n

        where:
        n | _
        1 | _
        2 | _
        3 | _
        50 | _
        100 | _
    }
}
