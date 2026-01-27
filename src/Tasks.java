import java.util.ArrayList;
import java.util.List;

public class Tasks {

    protected List<String> listTasks = new ArrayList<>();

    public boolean addTask(String task){
        if (!listTasks.contains(task)){
            return listTasks.add(task);
        }
        return false;
    }

    public boolean deleteTaskByIndex(String[] deleteArr){
        List<String> delCol = new ArrayList<>();
        for (String digit : deleteArr){
            int index = Integer.parseInt(digit) - 1;
            if (index >= 0 && index < listTasks.size()){
                delCol.add(listTasks.get(index));
            }
        }
        if (!delCol.isEmpty()){
            return listTasks.removeAll(delCol);
        }
        return false;
    }

    public boolean deleteTaskByName(String[] deleteArr){
        List<String> delCol = new ArrayList<>();
        for (String task : listTasks){
            for (String word : deleteArr){
                if (task.toLowerCase().contains(word.toLowerCase())){
                    delCol.add(task);
                    break;
                }
            }
        }
        if (!delCol.isEmpty()){
            return listTasks.removeAll(delCol);
        }
        return false;
    }

    public String getTasks(){
        int counter = 0;
        String taskList = "";
        for(String task : listTasks){
            counter++;
            taskList += counter + ". " + task + "\n";
        }
        if (!taskList.isEmpty()){
            return taskList;
        }
        return ("Список задач пуст!");
    }
}
