package example.service

import example.config.AccountCreditProperties
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
open class ScheduledJobService @Autowired constructor(
        private var accountCreditProperties: AccountCreditProperties
) {

    @Scheduled(fixedDelay = 3000)
    fun runJob()  {
        println(accountCreditProperties.creditAccounts)
    }
}