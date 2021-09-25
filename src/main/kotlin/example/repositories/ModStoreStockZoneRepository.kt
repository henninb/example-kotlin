package example.repositories

import org.morejdbc.*
import org.morejdbc.NamedJdbcCall.call
import org.morejdbc.SqlTypes.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.SqlParameter
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcCall
import org.springframework.stereotype.Service
import java.sql.SQLException
import java.sql.Types


@Service
open class ModStoreStockZoneRepository {

    private lateinit var simpleJdbcCall: SimpleJdbcCall

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    private val log: Logger = LoggerFactory.getLogger(ModStoreStockZoneRepository::class.java)

    fun run() {
        try {
            simpleJdbcCall = SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
//                .withCatalogName("catelog_name")
                .withProcedureName("proc_name")

            simpleJdbcCall.declareParameters(
                SqlParameter("parm1", Types.NUMERIC),
                SqlParameter("parm2", Types.NUMERIC),
                SqlParameter("parm3", Types.VARCHAR)
            )

        } catch (e: SQLException) {
            //LOGGER.error("Error initializing PtsLabelRepository", e)
            throw RuntimeException(e)
        }
    }


    fun callOverPackContainerSP() {


        val theOut = Out.of(INTEGER)

        jdbcTemplate.execute(call("proc_name")
            .inOut("parm1", 0, theOut)
            .`in`("parm2", 1000L)
            .`in`("parm3", "015")
            )

        log.info(theOut.get().toString())

       // String errString = (String) query.getOutputParameterValue("error_msg");
    }
}