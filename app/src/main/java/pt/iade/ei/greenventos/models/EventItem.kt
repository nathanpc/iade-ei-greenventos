package pt.iade.ei.greenventos.models

import java.util.Calendar

data class EventItem(
    var id: Int,
    var title: String,
    var date: Calendar,
    var room: String,
    var durationMinutes: Int,
    var rsvp: Int,
    var description: String = ""
)

fun hoursToMinutes(hours: Int): Int {
    return hours * 60
}
