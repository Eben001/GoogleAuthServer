package com.gana.ebenezer.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String, val name: String, val emailAddress: String,
    val profilePhoto: String
)
