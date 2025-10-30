import java.util.List;

public class TableTermin extends Table{
    public static void printTableTermin(List<ZadaniaTerminowe> tasks_ter) {
        String line = "---------------------------------------------";
        System.out.println(line);
        System.out.printf("| %-3s |%-25s | %-12s | %-12s |\n",
                "ID","TITLE", "STATUS", "DEADLINE");
        System.out.println(line);

        for (ZadaniaTerminowe t : tasks_ter) {
            String statusColored;

            if (t.getStatus().isCompleted()) {
                statusColored = ConsoleColors.BG_GREEN + t.getStatus() + ConsoleColors.RESET;
            } else if (t.getStatus().isInProgres()) {
                statusColored = ConsoleColors.BG_YELLOW + t.getStatus() + ConsoleColors.RESET;
            } else if (t.getStatus().isOverdue()) {
                statusColored = ConsoleColors.BG_RED + t.getStatus() + ConsoleColors.RESET;
            } else {
                statusColored = t.getStatus().toString();
            }

            System.out.printf("| %-3d | %-25s | %-20s | %-12s |\n",
                    t.getId(),
                    t.getTitle(),
                    statusColored,
                    t.getDeadline());
        }

        System.out.println(line);
    }
}