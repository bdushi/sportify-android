package al.bruno.sportify.interceptor

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class DateTimeSerializer : JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {
    val primaryPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    val secondaryPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    override fun serialize(
        src: OffsetDateTime,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement = JsonPrimitive(src.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): OffsetDateTime? = try {
        OffsetDateTime.parse(
            json?.asString,
            DateTimeFormatter.ISO_OFFSET_DATE_TIME
        )
    } catch (ex: Exception) {
        OffsetDateTime.parse(
            json?.asString,
            secondaryPattern
        )
    }
}