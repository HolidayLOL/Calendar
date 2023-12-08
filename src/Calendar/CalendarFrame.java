package Calendar;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
class CalendarFrame extends JFrame {
    private final CalendarPanel calendarPanel;

    public CalendarFrame() {
        setTitle("Простой календарь");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        calendarPanel = new CalendarPanel();
        add(calendarPanel, BorderLayout.CENTER);

        ClockPanel clockPanel = new ClockPanel();
        add(clockPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
