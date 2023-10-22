package scheduler;

public class Appointment {
    private static int idCounter = 1;

    private int id;
    private String date;
    private String time;
    private String description;

    public Appointment(String date, String time, String description) {
        this.id = idCounter++;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nDescription: " + description + "\n";
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}
