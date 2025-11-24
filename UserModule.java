import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserModule {
    static class Schedule {
        String subject;
        String day;
        String time;

        Schedule(String subject, String day, String time) {
            this.subject = subject;
            this.day = day;
            this.time = time;
        }

        public String toString() {
            return subject + " - " + day + " - " + time;
        }
    }

    static class Reminder {
        String content;
        LocalDate dueDate;

        Reminder(String content, LocalDate dueDate) {
            this.content = content;
            this.dueDate = dueDate;
        }

        boolean isUpcoming() {
            return dueDate.isBefore(LocalDate.now().plusDays(3));
        }

        public String toString() {
            return content + " (Han: " + dueDate + ")";
        }
    }

    static class ScheduleManager {
        List<Schedule> schedules = new ArrayList<>();
        List<Reminder> reminders = new ArrayList<>();

        void addSchedule(Schedule s) {
            schedules.add(s);
        }

        void addReminder(Reminder r) {
            reminders.add(r);
        }

        void showAll() {
            System.out.println(" Lich hoc:");
            for (Schedule s : schedules) System.out.println(" - " + s);

            System.out.println("\n Nhac nho:");
            for (Reminder r : reminders) System.out.println(" - " + r);
        }
    }
}
