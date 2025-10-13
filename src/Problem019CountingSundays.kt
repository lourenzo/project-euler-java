import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

fun isLeap(year: Int): Boolean {
  return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

fun getDaysInMonth(month: Int, year: Int): Int {
  return when (month) {
    4, 6, 9, 11 -> 30
    2 -> if (isLeap(year)) 29 else 28
    else -> 31
  }
}

fun main() {
  var sundays = 0
  var dayOfWeek = 2

  for (year in 1901..2000) {
    for (month in 1..12) {
      if (dayOfWeek == 7) sundays++
      val days = getDaysInMonth(month, year)
      dayOfWeek = (dayOfWeek + days) % 7
      if (dayOfWeek == 0) dayOfWeek = 7
    }
  }

  println("Sundays: %s".format(sundays))

}
