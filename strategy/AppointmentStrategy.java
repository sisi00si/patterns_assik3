package strategy;

import scheduler.Appointment;
import java.util.List;
import java.util.Map;

public interface AppointmentStrategy {
    void schedule(Appointment appointment);
    void view();
    void cancel(int appointmentId);
    List<Appointment> getAppointments();
    List<Appointment> searchAppointments(String date, String time, String description);


}
