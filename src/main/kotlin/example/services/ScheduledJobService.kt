package example.services

import com.fasterxml.jackson.databind.ObjectMapper
import example.domain.Person
import example.repositories.ModStoreStockZoneRepository
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@Slf4j
open class ScheduledJobService (private val modStoreStockZoneRepository: ModStoreStockZoneRepository) {

    var objectMapper: ObjectMapper = ObjectMapper()

    @Scheduled(fixedDelay = 5000)
    open fun runMe() {
        val payload = "{\"first_name\": \"brian\"," +
                "    \"middle_name\": \"z\"," +
                "    \"last_name\": \"henning\"" +
                "}"
        val person: Person = objectMapper.readValue(payload, Person::class.java)
        System.out.println("middleName: " + person.middleName)
        System.out.println(objectMapper.writeValueAsString(person))
    }
}