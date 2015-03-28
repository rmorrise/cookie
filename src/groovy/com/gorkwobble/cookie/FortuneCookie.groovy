package com.gorkwobble.cookie

import grails.validation.Validateable

/**
 * @author: rmorrise
 */
@Validateable
class FortuneCookie {
    String message
    List<Integer> luckyNumbers = []
}
