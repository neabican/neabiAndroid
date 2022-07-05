package br.edu.ifsc.neabiAndroid.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String
)