package Calendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        return new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
    }

    public int[] getCurrentMonthDays() {
        int startDay = getStartDayOfWeek(); //Получаем первый день недели текущего месяца
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[] days = new int[numberOfDays + startDay]; //Добавляем пробелы для дней предыдущей недели

        Calendar tempCalendar = (Calendar) calendar.clone();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 1); //Устанавливаем текущий месяц
        tempCalendar.add(Calendar.DAY_OF_MONTH, -startDay); //Смещаемся к первому дню предыдущей недели

        for (int i = 0; i < days.length; i++) {
            days[i] = tempCalendar.get(Calendar.DAY_OF_MONTH); //Заполняем числами дни предыдущей и текущей недели
            tempCalendar.add(Calendar.DAY_OF_MONTH, 1); //Переходим к следующему дню
        }

        return days;
    }

    public String getCurrentMonthYear() {
        return new SimpleDateFormat("MMMM yyyy").format(calendar.getTime());
    }

    public int getCurrentDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    int getStartDayOfWeek() {
        Calendar tempCalendar = (Calendar) calendar.clone();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = tempCalendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY; //Устанавливаем понедельник как первый день недели
        if (startDay < 0) {
            startDay += 7; //Если первый день недели - воскресенье, сдвигаем на 7 дней назад
        }
        return startDay;
    }
}
