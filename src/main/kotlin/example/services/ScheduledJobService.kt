package example.services

import example.repositories.ModStoreStockZoneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
open class ScheduledJobService @Autowired constructor(private val modStoreStockZoneRepository: ModStoreStockZoneRepository) {

    @Scheduled(fixedDelay = 25000)
    fun runJob()  {
        //modStoreStockZoneRepository.callOverPackContainerSP()
    }
}