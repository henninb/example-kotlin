package example.services


import com.fasterxml.jackson.databind.ObjectMapper
import example.domain.Person
import groovy.util.logging.Slf4j

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
@Service
@Slf4j
open class ScheduledJobService () {
    @Scheduled(fixedDelay = 5000)
    open fun runMe() {
        val payload = "{\"first_name\": \"brian\"," +
                "    \"middle_name\": \"z\"," +
                "    \"last_name\": \"henning\"" +
                "}"
        val person: Person = objectMapper.readValue(payload, Person::class.java)
        logger.info("middleName: " + person.middleName)
        logger.info(objectMapper.writeValueAsString(person))
    }

    companion object {
        val objectMapper = ObjectMapper()
        val logger: Logger = LogManager.getLogger()
    }
}