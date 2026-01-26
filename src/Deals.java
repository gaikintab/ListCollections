import java.util.ArrayList;

public class Deals {

    protected ArrayList<String> list = new ArrayList<>();
    protected ArrayList<String> delCol = new ArrayList<>();

    public boolean addDeal(String deal){
        if (!list.contains(deal)){
            return list.add(deal);
        }
        return false;
    }

    public boolean deleteDealByIndex(String[] delList){
        delCol.clear();
        for (String d : delList){
            int num = Integer.parseInt(d) - 1;
            if (num >= 0 && num < list.size()){
                delCol.add(list.get(num));
            }
        }
        if (!delCol.isEmpty()){
            return list.removeAll(delCol);
        }
        return false;
    }

    public boolean deleteDealByName(String[] delList){
        delCol.clear();
        for (String l : list){
            for (String d : delList){
                if (l.toLowerCase().contains(d.toLowerCase())){
                    delCol.add(l);
                    break;
                }
            }
        }
        if (!delCol.isEmpty()){
            return list.removeAll(delCol);
        }
        return false;
    }

    public String getDeals(){
        int counter = 0;
        String t = "";
        for(String D : list){
            counter++;
            t += counter + ". " + D + "\n";
        }
        if (!t.isEmpty()){
            return t;
        } else return ("Список задач пуст!");
    }
}
