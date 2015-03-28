package com.gorkwobble.cookie.controllers

class FortuneCookieController {
    def fortuneCookieService

    def random() {
        def cookie = fortuneCookieService.generateRandom()

        withFormat {
            json {
                respond cookie
            }
        }
    }
}
