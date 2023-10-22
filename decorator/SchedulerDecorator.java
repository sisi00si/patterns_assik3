package decorator;

import scheduler.Appointment;
import strategy.AppointmentStrategy;

public interface SchedulerDecorator extends AppointmentStrategy {
    void setScheduler(AppointmentStrategy scheduler);
    void sendReminder(Appointment appointment);
}