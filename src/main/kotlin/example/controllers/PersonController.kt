package example.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @RequestMapping(value = ["/person"], method = [RequestMethod.GET])
    fun getPerson(): ResponseEntity<String>? {
        return ResponseEntity.ok("brian")
    }
}