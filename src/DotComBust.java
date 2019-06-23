import java.util.ArrayList;

public class DotComBust {
    GameHelper gameHelper=new GameHelper();
    ArrayList<DotCom> al=new ArrayList<DotCom>();
    int numofguesses=0;
    public void setUpGame(){
        DotCom one=new DotCom();
        DotCom two=new DotCom();
        DotCom three=new DotCom();
        one.setName("Yahoo.com");
        two.setName("Google.com");
        three.setName("Bing.com");
        al.add(one);
        al.add(two);
        al.add(three);
        System.out.println("Welcome to Sink A DotCom Game");
        System.out.println("Type Your Guess in Format Particular to 7x7 Grid");
        for(DotCom dotCom:al){
            ArrayList<String> newlocation=gameHelper.placeDotCom(3);
            dotCom.setLocationcells(newlocation);
        }
    }
    public void startPlaying(){
        while (!al.isEmpty()){
            String userGuess=gameHelper.getUserInput("Enter Your Guess");
            checkUserGuess(userGuess);
        }
        finshGame();
    }
    public void checkUserGuess(String userGuess){
        numofguesses++;
        String result="miss";
        for(DotCom dotCom:al){
            result=dotCom.checkYourself(userGuess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                al.remove(dotCom);
                break;
            }
        }
        System.out.println(result);
    }
    public void finshGame(){
        System.out.println("All Dot Coms Are Dead");
        if(numofguesses<=18){
            System.out.println("you took "+numofguesses+" guesses");
            System.out.println("good");
        }
        else{
            System.out.println("You Took "+numofguesses+" guesses");
            System.out.println("Bad");
        }
    }

    public static void main(String[] args) {
        DotComBust game=new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
