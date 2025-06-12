import java.util.ArrayList;
import java.util.List;
public class Party{
  public Party tempParty;
  public static String[] topics = new String[] {
  "a Border Wall","Abortion","Animal Testing","Autonomous Zones","Censorship","Child Labor","Civil Rights","Corporation Taxes","Cruel and Unusual Punishment","Daylight Savings Time","Drunk Driving","Enviromental Protections","Foreign Intervention","Fracking","Freedom of Religion","Gambling","Gerrymandering","Government Surveillance","Gun Control","High Taxes for Children","Higher Taxes for the poor ","Homeland Security","Immigration","an Incel Tax","Indoor Hats","Inheritance Limits","Lobbying","LGBTQ+ Rights","Nuclear Weapons","Mandatory Minimums","Mandatory Primary School","Mandatory Vaccination","Minimum Wage","Monopolies","Net Neutrality","No Taxes for Single Men","Omar's Law","Police Funding","Private Property","Prohibition","Protesting","Public Healthcare","Public Attorneys","Public Schools","Public Transportation","Renewable Energy","Search Without Warrant","Serfdom","Segregation","Silver Nitrate Mining","Slavery","State Prisons","Tax Cuts for the Rich","the Death Penalty","the Draft","Legal Weed","the Sale of Tobacco","Trial by Jury","a Twelve Child Policy","Wealth Limits","Welfare","Willowbend Reservations","Women's Rights","Worker's Unions","Workplace Harassment","Workplace Protections"};
  private boolean[] topicOpinion = new boolean[topics.length];
  private String partyName;
  private double popularity;
  private int leaderId;
  private Char[] members = new Char[5];
  
private static String[] partyAdjArr = new String[]{ "Abolitionist","Agrarian","Anarchist","Aristocratic","Authoritarian","Capitalist","Central","Christian","Communist","Conservative","Constitutional","Cool","Democratic","Eastern","Facist","Federal","Federalist","Globalist","Holy","Industrial","Individualist","International","Islamist","Isolationist","Liberal","Loyalist","Marxist","Maternal","Moderate","Nationalist","Northern","Omarist","Pacifist","Particularist","Paternal","Patriotic","People's","Radical","Reformist","Republican","Revolutionary","Royalist","Slaver","Socialist","Southern","Traditionalist","Unionist","Universal","Western","Zionist"};
  public Party(int i){
    int ran1 = (int) (Math.random()*partyAdjArr.length);
    int ran2 = (int) (Math.random()*partyAdjArr.length);
    partyName = partyAdjArr[ran1] + " " + partyAdjArr[ran2] + " Party" ;
    for(int j = 0;j<topics.length;j++){
      if((int)(Math.random()*2)==0){
        topicOpinion[j]=true;
      }else{
        topicOpinion[j]=false;
      }
    }
    popularity = 50.0;
    for(int j = 0;j<5;j++){
      members[j] = new Char(i);
    }
  }



  public void setLeaderId(int i){
    leaderId = i;
  }
  


  public Char getChar(int i){
    return members[i];
  }
  public static String getTopicName(int i){
    return topics[i];
  }
  public double getPopularity(){
    return popularity;
  }
  public void setPopularity(double newPop){
    popularity = newPop;
  }
  public int getTopicLength(){
    return topicOpinion.length;
    
  }
  public void changePopularity(double addedPopularity){
    popularity = popularity + addedPopularity;
  }
  public String getName(){
    return partyName;
  }
  public void setName(String newPartyName){
    partyName = newPartyName;
    if (newPartyName==""){
      int ran = (int) (Math.random()*partyAdjArr.length);
      partyName = partyAdjArr[ran] + " Party" ;
    }
  }
  public boolean getOpinion(int i){
    return topicOpinion[i];
  }
  public void changeOpinion(int i){
    topicOpinion[i] = !(topicOpinion[i]);
  }
  public void speech(){
    //System.out.print(topics.length+" "+topicLaw.length);
    int i = (int)(Math.random()*topics.length);
    while(i >=0){
    if (Gov.getLaw(i) == !(topicOpinion[i])){
      System.out.print(getLeader().getName()+ " has given a speech about ");
    
    System.out.print(topics[i]);
    if(topicOpinion[i]){
      System.out.print(" and how the fact " + topics[i] +" doesn't exist undermines the very principles of Omaria.");
    }else{
      System.out.print(" and the abhorrance that "+  topics[i]+" exists.");
    }
    if((int)(Math.random()*2)==0){
      System.out.println(" This speech has not gone over well with the public.");
      changePopularity(-4.0);
      return;
    }else{
      System.out.println(" This speech has gone down very well with the public.");
      changePopularity(4.0);
      return;
    }
    }else{
      i = (int)(Math.random()*topics.length);
    }
    }
  }


  public Char getLeader(){
    return members[leaderId];
  }
}