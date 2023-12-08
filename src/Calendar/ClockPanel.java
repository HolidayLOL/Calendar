package Calendar;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
class ClockPanel extends JPanel {
    private final JLabel timeLabel;

    public ClockPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        updateTime();
        add(timeLabel);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        Date now = new Date();
        String time = new SimpleDateFormat("HH:mm:ss").format(now);
        timeLabel.setText("Текущее время: " + time);
    }
}