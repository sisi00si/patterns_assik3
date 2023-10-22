import adapter.AppointmentSystemAdapter;
import adapter.NewAppointmentSystem;
import decorator.ReminderDecorator;
import scheduler.Appointment;
import singleton.AppointmentScheduler;
import strategy.BasicAppointmentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = AppointmentScheduler.getInstance();

        BasicAppointmentStrategy basicStrategy = new BasicAppointmentStrategy(new ArrayList<>());
        ReminderDecorator reminderDecorator = new ReminderDecorator();
        reminderDecorator.setScheduler(basicStrategy);

        scheduler.setAppointmentStrategy(reminderDecorator);

        NewAppointmentSystem adapter = new AppointmentSystemAdapter(scheduler);

        Appointment appointment1 = new Appointment("2023-10-10", "10:00 AM", "General Checkup");
        Appointment appointment2 = new Appointment("2023-10-12", "02:30 PM", "Dental Cleaning");

        scheduler.scheduleAppointment(appointment1);
        scheduler.scheduleAppointment(appointment2);

        System.out.println("Scheduled Appointments:");
        scheduler.viewAppointments();

        int appointmentIdToCancel = 1;
        scheduler.cancelAppointment(appointmentIdToCancel);

        System.out.println("\nAppointments after Cancellation:");
        scheduler.viewAppointments();

        String searchDate = "2023-10-12";
        String searchTime = "02:30 PM";
        String searchDescription = "Dental Cleaning";
        List<Appointment> searchResults = adapter.searchAppointments(searchDate, searchTime, searchDescription);
        System.out.println("\nSearch Results:");
        for (Appointment appointment : searchResults) {
            System.out.println(appointment);
        }

        Map<String, Integer> statistics = adapter.getStatistics();
        System.out.println("\nStatistics:");
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
