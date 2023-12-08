package Calendar;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
class CalendarModel {
    private final CalendarPanel calendarPanel;
    private final Calendar calendar;

    public CalendarModel(CalendarPanel calendarPanel) {
        this.calendarPanel = calendarPanel;
        calendar = Calendar.getInstance();
    }

    public void previousMonth() {
        calendar.add(Calendar.MONTH, -1);
        calendarPanel.updateCalendar();
    }

    public void nextMonth() {
        calendar.add(Calendar.MONTH, 1);
        calendarPanel.updateCalendar();
    }

    public String[] getDaysOfWeek() {
        return new String[]{"Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"};
    }

    public int[] getCurrentMonthDays() {
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[] days = new int[numberOfDays];

        for (int i = 0; i < numberOfDays; i++) {
            days[i] = i + 1;
        }
        return days;
    }

    public String getCurrentMonthYear() {
        return new SimpleDateFormat("MMMM yyyy").format(calendar.getTime());
    }

    public int getCurrentDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
