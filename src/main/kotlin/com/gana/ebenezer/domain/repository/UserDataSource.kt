package com.gana.ebenezer.domain.repository

import com.gana.ebenezer.domain.model.User

interface UserDataSource {
    suspend fun getUserInfo(userId: String): User?
    suspend fun saveUserInfo(user: User): Boolean
    suspend fun deleteUser(userId: String): Boolean
    suspend fun updateUserInfo(
        userId:String,
        firstName:String,
        lastName:String
    ):Boolean


}