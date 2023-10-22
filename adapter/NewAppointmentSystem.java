package adapter;

import scheduler.Appointment;
import java.util.List;
import java.util.Map;

public interface NewAppointmentSystem {
    List<Appointment> searchAppointments(String date, String time, String description);
    Map<String, Integer> getStatistics();
}
