package Calendar;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class CalendarPanel extends JPanel {
    private final JLabel monthLabel;
    private final JPanel daysPanel;
    private final CalendarModel calendarModel;

    public CalendarPanel() {
        calendarModel = new CalendarModel(this); // Инициализация переменной calendarModel
        setLayout(new BorderLayout());

        monthLabel = new JLabel("", JLabel.CENTER);
        monthLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton previousButton = new JButton("<<");
        JButton nextButton = new JButton(">>");

        previousButton.addActionListener(e -> calendarModel.previousMonth());
        nextButton.addActionListener(e -> calendarModel.nextMonth());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(previousButton, BorderLayout.WEST);
        controlPanel.add(monthLabel, BorderLayout.CENTER);
        controlPanel.add(nextButton, BorderLayout.EAST);

        daysPanel = new JPanel(new GridLayout(0, 7));
        add(controlPanel, BorderLayout.NORTH);
        add(daysPanel, BorderLayout.CENTER);

        updateCalendar(); // Вызываем метод обновления календаря
    }

    public void updateCalendar() {
        monthLabel.setText(calendarModel.getCurrentMonthYear());
        daysPanel.removeAll();

        String[] daysOfWeek = calendarModel.getDaysOfWeek();
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day, JLabel.CENTER);
            daysPanel.add(label);
        }

        int[] currentMonthDays = calendarModel.getCurrentMonthDays();
        int currentDay = calendarModel.getCurrentDay();
        int startDayOfWeek = calendarModel.getStartDayOfWeek();

        int dayIndex = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < startDayOfWeek) {
                    JLabel emptyLabel = new JLabel("");
                    daysPanel.add(emptyLabel);
                } else if (dayIndex < currentMonthDays.length) {
                    int day = currentMonthDays[dayIndex];
                    JLabel label = new JLabel(String.valueOf(day), JLabel.CENTER);
                    if (day == currentDay) {
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                    daysPanel.add(label);
                    dayIndex++;
                }
            }
        }

        revalidate();
        repaint();
    }
}