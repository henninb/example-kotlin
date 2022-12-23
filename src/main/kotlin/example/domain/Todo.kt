package example.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
data class Todo(@Id @GeneratedValue var id: Long = 0, var text: String = "")