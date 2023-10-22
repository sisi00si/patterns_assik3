package singleton;

import scheduler.Appointment;
import strategy.AppointmentStrategy;
import strategy.BasicAppointmentStrategy;

import java.util.ArrayList;

import java.util.List;

public class AppointmentScheduler {
    private static AppointmentScheduler instance;
    private AppointmentStrategy appointmentStrategy;

    private AppointmentScheduler() {
        appointmentStrategy = new BasicAppointmentStrategy((ArrayList<Object>) new ArrayList<>());
    }

    public static synchronized AppointmentScheduler getInstance() {
        if (instance == null) {
            instance = new AppointmentScheduler();
        }
        return instance;
    }

    public void setAppointmentStrategy(AppointmentStrategy strategy) {
        this.appointmentStrategy = strategy;
    }

    public void scheduleAppointment(Appointment appointment) {
        appointmentStrategy.schedule(appointment);
    }

    public void viewAppointments() {
        appointmentStrategy.view();
    }

    public void cancelAppointment(int appointmentId) {
        appointmentStrategy.cancel(appointmentId);
    }


    public AppointmentStrategy getAppointmentStrategy() {
        return appointmentStrategy;
    }
}
