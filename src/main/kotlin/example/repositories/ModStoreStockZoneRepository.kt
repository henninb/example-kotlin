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
//            val typeMap = jdbcTemplate.dataSource.connection.typeMap
//            typeMap[PtsItem._SQL_RECORD_NAME] = PtsItem::class.java
//            jdbcTemplate.dataSource.connection.typeMap = typeMap
           // log.info("status of jdbc template: ${jdbcTemplate == null}")

            simpleJdbcCall = SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("DIST")
//                .withCatalogName("dps_pack_prcs_ng_pkg")
                .withProcedureName("dpp_get_mod_ssz")

            //log.info("status of simpleJdbcCall: ${simpleJdbcCall == null}")
            //log.info("${simpleJdbcCall == null} v0")
            simpleJdbcCall.declareParameters(
                SqlParameter("o_sql_error_code", Types.NUMERIC),
                SqlParameter("o_brkpk_module_i", Types.NUMERIC),
                SqlParameter("o_store_stk_zone_c", Types.VARCHAR)
            )

        } catch (e: SQLException) {
            //LOGGER.error("Error initializing PtsLabelRepository", e)
            throw RuntimeException(e)
        }
    }


    fun callOverPackContainerSP() {
//        run()
//        val resultMap: Map<String, Any>
////        log.info("${simpleJdbcCall == null} v1")
//        val paramMap = MapSqlParameterSource()
//            .addValue("o_sql_error_code", 1)
//            .addValue("o_brkpk_module_i", 100)
//            .addValue("o_store_stk_zone_c", "015")
//        //log.info("${simpleJdbcCall == null} v2")
//        resultMap =simpleJdbcCall.execute(paramMap)
//        log.info("result ${resultMap.size}")


        val theOut = Out.of(INTEGER)

        jdbcTemplate.execute(call("dpp_get_mod_ssz")
            .inOut("o_sql_error_code", 0, theOut)
            .`in`("o_brkpk_module_i", 1000L)
            .`in`("o_store_stk_zone_c", "015")
            )

        log.info(theOut.get().toString())


       // String errString = (String) query.getOutputParameterValue("error_msg");

       //return callOverPackContainer(message.getLpnId(), paramMap)
    }


//    @NotNull
//    private fun callOverPackContainer(lpnId: String, paramMap: MapSqlParameterSource): OverpackContainerResponse? {
//        val resultMap: Map<String, Any>
//        LOGGER.info("populated the values")
//        resultMap = simpleJdbcCall.execute(paramMap)
//        LOGGER.info("sql called.")
//        val responseMessage = OverpackContainerResponse()
//        responseMessage.setLpnId(lpnId)
//        responseMessage.setOpdNumber((resultMap["ovrpk_ctnr_i_out"] as String?)!!.trim { it <= ' ' })
//        responseMessage.setLabelData(readLabel(resultMap["ovrpk_lbl_data_out"]))
//        responseMessage.setBypassFlag((resultMap["prnt_byp_f_out"] as String?)!!.trim { it <= ' ' })
//        LOGGER.info("Response Message: " + responseMessage.toString())
//        return responseMessage
//    }

}