package br.edu.ifsc.aquilombar.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

object Adapter {
    //Objeto para evitar armazenar NULL no Json
    object NULL_TO_EMPTY_STRING_ADAPTER {
        @FromJson
        fun fromJson(reader: JsonReader): String {
            if (reader.peek() != JsonReader.Token.NULL) {
                return reader.nextString()
            }
            reader.nextNull<Unit>()
            return ""
        }
    }
}