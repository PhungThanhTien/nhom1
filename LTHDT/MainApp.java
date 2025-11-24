import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    // Quản lý nhóm học
    static class StudyGroup {
        String name;
        String admin;
        List<String> members = new ArrayList<>();

        StudyGroup(String name, String admin) {
            this.name = name;
            this.admin = admin;
            members.add(admin);
        }

        void addMember(String m) {
            members.add(m);
        }

        void showGroup() {
            System.out.println(" Nhom hoc: " + name);
            System.out.println("Quan tri vien: " + admin);
            System.out.println("Thanh vien:");
            for (String m : members) System.out.println(" - " + m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserModule.ScheduleManager sm = new UserModule.ScheduleManager();
        GoalModule.GoalManager gm = new GoalModule.GoalManager();
        StudyGroup group = new StudyGroup("Nhom OOP", "Phung Thanh Tien");

        while (true) {
            System.out.println("\n===== DNU Study Planner =====");
            System.out.println("1. Quan ly lich hoc & nhac nho");
            System.out.println("2. Quan ly muc tieu hoc tap");
            System.out.println("3. Quan ly nhom hoc");
            System.out.println("4. Thoat");
            System.out.print("Chon: ");
            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1:
                    sm.addSchedule(new UserModule.Schedule("OOP", "Thu 2", "7h-9h"));
                    sm.addReminder(new UserModule.Reminder("Nop bai OOP", LocalDate.now().plusDays(2)));
                    sm.showAll();
                    break;
                case 2:
                    GoalModule.Goal g1 = new GoalModule.Goal("OOP", "Hoan thanh 5 chuong", 5);
                    g1.completeTask();
                    g1.completeTask();
                    gm.addGoal(g1);
                    gm.showProgress();
                    break;
                case 3:
                    group.addMember("Minh Khoi");
                    group.addMember("Kieu Duc Anh");
                    group.showGroup();
                    break;
                case 4:
                    System.out.println("Tam biet ");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
