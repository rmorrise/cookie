package com.gorkwobble.cookie.services

import com.gorkwobble.cookie.NotFoundException
import com.gorkwobble.cookie.domain.Fortune
import grails.transaction.Transactional

@Transactional
class FortuneService {

    def getRandomFortune() {
        def numberOfFortunes = Fortune.count()
        if (!numberOfFortunes) {
            throw new NotFoundException('The fortune database is empty!')
        }

        Fortune.list([max: 1, offset: generateRandomInt(numberOfFortunes), sort: 'id']).get(0)
    }

    /**
     * @param maxValue
     * @return A random int on 0-(maxValue - 1)
     */
    def generateRandomInt(int maxValue) {
        (int) (Math.random() * maxValue)
    }
}
