package com.gorkwobble.cookie.service

import com.gorkwobble.cookie.domain.Fortune
import com.gorkwobble.cookie.services.FortuneCookieService
import com.gorkwobble.cookie.services.FortuneService
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FortuneCookieService)
class FortuneCookieServiceSpec extends Specification {
    FortuneService fortuneService = Mock()

    void "generate random fortune cookie"() {
        given:
        def fortune = new Fortune(message: 'foo')
        service.fortuneService = fortuneService

        when:
        def result = service.generateRandom()

        then:
        1 * fortuneService.getRandomFortune() >> fortune
        6 * fortuneService.generateRandomInt(100) >>> [1, 2, 3, 4, 5, 42]
        result != null
        result.message == 'foo'
        result.luckyNumbers.size() == 6
        result.luckyNumbers[0] == 2
        result.luckyNumbers[1] == 3
        result.luckyNumbers[2] == 4
        result.luckyNumbers[3] == 5
        result.luckyNumbers[4] == 6
        result.luckyNumbers[5] == 43
    }
}
