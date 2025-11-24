import java.util.ArrayList;
import java.util.List;

public class GoalModule {
    static class Goal {
        String subject;
        String description;
        int totalTasks;
        int completed;

        Goal(String subject, String description, int totalTasks) {
            this.subject = subject;
            this.description = description;
            this.totalTasks = totalTasks;
            this.completed = 0;
        }

        void completeTask() {
            if (completed < totalTasks) completed++;
        }

        double getProgress() {
            return (completed * 100.0) / totalTasks;
        }

        public String toString() {
            return subject + ": " + description + " (" + completed + "/" + totalTasks + " - " 
                   + String.format("%.1f", getProgress()) + "%)";
        }
    }

    static class GoalManager {
        List<Goal> goals = new ArrayList<>();

        void addGoal(Goal g) {
            goals.add(g);
        }

        void showProgress() {
            System.out.println(" Muc tieu hoc tap:");
            for (Goal g : goals) System.out.println(" - " + g);
        }
    }
}
