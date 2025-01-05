import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class DatePiker {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 500, 300);

        SqlDateModel model = new SqlDateModel();

        Properties properties = new Properties();
        properties.put("text.day", "Day");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl impl = new JDatePanelImpl(model, properties);

        JDatePickerImpl datePickerImpl = new JDatePickerImpl(impl, new AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'stringToValue'");
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String date = "";
                if (value != null) {
                    Calendar cal = (Calendar) value;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    date = dateFormat.format(cal.getTime());
                }
                return date;
            }

        });

        datePickerImpl.setBounds(200, 50, 200, 30);
        frame.add(datePickerImpl);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}