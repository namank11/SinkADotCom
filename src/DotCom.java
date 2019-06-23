import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationcells;
    private String name;

    public void setLocationcells(ArrayList<String> locs) {
        locationcells = locs;
    }
    public void setName(String n){
        name=n;
    }
    public String checkYourself(String userInput){
        String result="miss";
        int index=locationcells.indexOf(userInput);
        if(index>=0){
            locationcells.remove(userInput);
            if(locationcells.isEmpty()){
                result ="kill";
                System.out.println("Oouch!  You sunk" +name+ " : (");
            }
            else
                result ="hit";
        }
        return result;
    }
}
