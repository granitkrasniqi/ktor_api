package granitkrasniqi.dev.domain

import kotlinx.serialization.Serializable

@Serializable
data class PostRandomRequest(val names: List<String>)
