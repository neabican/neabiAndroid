package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseEntity (
    @PrimaryKey
    val pk: Int,
    val name: String,
    val description: String,
)