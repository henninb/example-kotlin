package example.services

import example.repositories.ModStoreStockZoneRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@Slf4j
open class ScheduledJobService @Autowired constructor(private val modStoreStockZoneRepository: ModStoreStockZoneRepository) {

    @Scheduled(fixedDelay = 25000)
    fun runJob()  {
        println("scheduled")
    }
}