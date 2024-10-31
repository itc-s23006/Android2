package jp.ac.it_college.std.s23006.cherryblossoms.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiQuery(
    val search: List<ApiSearch>
)
