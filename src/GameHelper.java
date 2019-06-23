import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet="abcdefg";
    private int gridLength=7;
    private int gridSize=49;
    private int[] grid =new int[gridSize];
    private int comCount=0;
    public String getUserInput(String prompt) {
        String inputline = null;
        System.out.print(prompt + "");
        try {
            BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
            inputline=is.readLine();
            if(inputline.length()==0){
                return null;
            }
        }
        catch(IOException e){
            System.out.println("IO Exception"+e);
        }
        return inputline.toLowerCase();
    }
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphacells=new ArrayList<String>();
        String[] alphacoords=new String[comSize];
        int attempts=0;
        String temp=null;
        int[] coords=new int[comSize];
        boolean success=false;
        int location=0;
        comCount++;
        int incr=1;
        if((comCount%2)==1){
            incr=gridLength;
        }
        while(!success & attempts++<200){
            location=(int)(Math.random()*gridSize);
            int x=0;
            success=true;
            while(success && x<comSize){
                if (grid[location]==0) {
                    coords[x++]=location;
                    location+=incr;
                    if(location>=gridSize){
                        success=false;
                    }
                    if(x>0 &&(location%gridLength==0)){
                        success=false;
                    }
                }
                else{
                    success=false;
                }
            }
        }
        int x=0;
        int row=0;
        int column=0;
        while(x<comSize){
            grid[coords[x]]=1;
            row=(int) (coords[x]/gridLength);
            column=coords[x]%gridLength;
            temp=String.valueOf(alphabet.charAt(column));
            alphacells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphacells;
    }
}
