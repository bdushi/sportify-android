package al.bruno.sportify.interceptor

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class OffsetDateTimeSerializer : KSerializer<OffsetDateTime> {
    private val primaryPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    private val secondaryPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    override fun deserialize(decoder: Decoder): OffsetDateTime = try {
        OffsetDateTime.parse(
            decoder.decodeString(),
            DateTimeFormatter.ISO_OFFSET_DATE_TIME
        )
    } catch (ex: Exception) {
        OffsetDateTime.parse(
            decoder.decodeString(),
            secondaryPattern
        )
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("OffsetDateTimeSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: OffsetDateTime) {
        encoder.encodeString(value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))

    }
}