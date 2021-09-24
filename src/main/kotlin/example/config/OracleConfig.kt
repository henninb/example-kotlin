//package example.config
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Primary
//import org.springframework.core.env.Environment
//import org.springframework.jdbc.datasource.DataSourceTransactionManager
//import org.springframework.jdbc.datasource.DriverManagerDataSource
//import java.util.*
//import javax.sql.DataSource
//
//@Configuration
//open class OracleConfig @Autowired constructor(private val environment: Environment) {
//
//
//    @Bean
//    @Primary
//    val dBDataSource: DataSource
//        get() {
//            val props = Properties()
//            props.setProperty("v\$session.program", "modern.pps")
//            val dataSource = DriverManagerDataSource()
//            dataSource.url = environment.getProperty("spring.datasource.url")
//            dataSource.username = environment.getProperty("spring.datasource.username")
//            dataSource.password = environment.getProperty("spring.datasource.password")
//            dataSource.connectionProperties = props
//            val dataSourcePool = DataSource()
//            dataSourcePool.setDataSource(dataSource)
//            dataSourcePool.setInitialSize(5)
//            dataSourcePool.setMaxIdle(20)
//            return dataSourcePool
//        }
//
//    //@Bean(name = "dbTransactionManager")
//    @Bean
//    open fun dbTransactionManager(): DataSourceTransactionManager {
//        return DataSourceTransactionManager(dBDataSource)
//    }
//}