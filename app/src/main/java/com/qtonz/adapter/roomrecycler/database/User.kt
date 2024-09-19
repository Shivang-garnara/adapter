package com.qtonz.adapter.roomrecycler.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey var number: String,
    var firstName: String,
    var email: String
)
