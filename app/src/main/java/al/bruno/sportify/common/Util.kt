package al.bruno.sportify.common

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun format(offsetDateTime: OffsetDateTime): String {
    return offsetDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss"))
}