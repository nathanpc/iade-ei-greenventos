package pt.iade.ei.greenventos.models

import java.util.Calendar

data class EventItem(
    var id: Int = -1,
    var title: String = "",
    var date: Calendar = Calendar.getInstance(),
    var room: String = "",
    var durationMinutes: Int = 0,
    var rsvp: Int = 0,
    var description: String = ""
)

fun hoursToMinutes(hours: Int): Int {
    return hours * 60
}
