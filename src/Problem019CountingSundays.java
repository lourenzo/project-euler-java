public static boolean isLeap(int year) {
  return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

public static int getDaysInMonth(int month, int year) {
  return switch (month) {
    case 4, 6, 9, 11 -> 30;
    case 2 -> isLeap(year) ? 29 : 28;
    default -> 31;
  };
}

void main() {
  int sundays = 0;
  int dayOfWeek = 2;

  for (int year = 1901; year <= 2000; year++) {
    for (int month = 1; month <= 12; month++) {
      if (dayOfWeek == 7) sundays++;
      int days = getDaysInMonth(month, year);
      dayOfWeek = (dayOfWeek + days) % 7;
      if (dayOfWeek == 0) dayOfWeek = 7;
    }
  }

  IO.println(String.format("Sundays: %s", sundays));
}

