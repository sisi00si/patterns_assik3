package adapter;

import scheduler.Appointment;
import singleton.AppointmentScheduler;
import strategy.AppointmentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentSystemAdapter implements NewAppointmentSystem {
    private AppointmentStrategy appointmentStrategy;

    public AppointmentSystemAdapter(AppointmentScheduler scheduler) {
        this.appointmentStrategy = scheduler.getAppointmentStrategy();
    }

    @Override
    public Map<String, Integer> getStatistics() {
        if (appointmentStrategy != null) {
            List<Appointment> appointments = appointmentStrategy.getAppointments();
            Map<String, Integer> statistics = new HashMap<>();

            for (Appointment appointment : appointments) {
                String date = appointment.getDate();
                statistics.put(date, statistics.getOrDefault(date, 0) + 1);
            }

            return statistics;
        } else {
            System.out.println("Appointment strategy is not set.");
            return null;
        }
    }
    @Override
    public List<Appointment> searchAppointments(String date, String time, String description) {
        if (appointmentStrategy != null) {
            return appointmentStrategy.searchAppointments(date, time, description);
        } else {
            System.out.println("Appointment strategy is not set.");
            return null;
        }
    }
}
