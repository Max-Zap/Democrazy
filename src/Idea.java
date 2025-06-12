import java.util.ArrayList;
public class Idea {
  String name;
  public static int[][] ideologyOpinions = new int[][] {{2,-1,-2,0,0,0,0,0,0},{2,-1,-2,0,0,0}};
  String[] adjectives = new String[16]; //16 is max number of adjectives
  // Ideology Opinions
  //From -2 to 2, 0 is neutral, -2 is hated, 2 is loved, 1 is liked, -1 is disliked
  private int[] lawOpinion = new int[9];
  public Idea(int id){
    if(id==0){
      name = "Tribalism";
    }else if (id==1){
      name = "Warlord Tribalism";
    }
  }
}
