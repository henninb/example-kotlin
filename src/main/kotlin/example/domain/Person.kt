package example.domain

import com.fasterxml.jackson.annotation.JsonProperty




//data class Person()

class Person {
    @JsonProperty(value = "first_name")
    var firstName: String? = null

    @JsonProperty(value = "middle_name", access = JsonProperty.Access.WRITE_ONLY)
    var middleName: //@JsonProperty(value = "middle_name")
            String? = null

    @JsonProperty(value = "last_name")
    var lastName: String? = null
}