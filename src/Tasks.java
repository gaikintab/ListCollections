import java.util.ArrayList;
import java.util.List;

public class Tasks {

    protected List<String> tasks = new ArrayList<>();

    public boolean addTask(String task) {
        if (!tasks.contains(task)) {
            return tasks.add(task);
        }
        return false;
    }

    public boolean deleteTaskByIndex(String[] deleteArr) {
        List<String> delCol = new ArrayList<>();
        for (String digit : deleteArr) {
            int index = Integer.parseInt(digit.trim()) - 1;
            if (index >= 0 && index < tasks.size()){
                delCol.add(tasks.get(index));
            }
        }
        if (!delCol.isEmpty()) {
            return tasks.removeAll(delCol);
        }
        return false;
    }

    public boolean deleteTaskByName(String[] deleteArr) {
        List<String> delCol = new ArrayList<>();
        for (String task : tasks) {
            for (String word : deleteArr) {
                if (task.toLowerCase().contains(word.toLowerCase().trim())) {
                    delCol.add(task);
                    break;
                }
            }
        }
        if (!delCol.isEmpty()) {
            return tasks.removeAll(delCol);
        }
        return false;
    }

    public String getTasks() {
        int counter = 0;
        StringBuilder taskListBuilder = new StringBuilder();
        for (String task : tasks) {
            taskListBuilder.append((counter++)).append(". ").append(task).append("\n");
        }
        String taskList = taskListBuilder.toString();
        if (!taskList.isEmpty()) {
            return taskList;
        }
        return ("Список задач пуст!");
    }
}
