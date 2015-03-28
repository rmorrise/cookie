package com.gorkwobble.cookie.services

import com.gorkwobble.cookie.FortuneCookie
import grails.transaction.Transactional

@Transactional
class FortuneCookieService {
    def fortuneService

    def generateRandom() {
        def result = new FortuneCookie(message: fortuneService.getRandomFortune().message)
        for( i in 0..5 ) {
            result.luckyNumbers.add(fortuneService.generateRandomInt(100) + 1)
        }
        result
    }
}
