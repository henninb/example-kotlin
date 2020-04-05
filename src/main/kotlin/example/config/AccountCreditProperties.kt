package example.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "custom.project")
@Configuration
open class AccountCreditProperties(
        var creditAccounts: MutableList<String> = mutableListOf()
)