import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Gov{
  public static String[] topics = new String[] {
  "a Border Wall","Abortion","Animal Testing","Autonomous Zones","Censorship","Child Labor","Civil Rights","Corporation Taxes","Cruel and Unusual Punishment","Daylight Savings Time","Drunk Driving","Enviromental Protections","Foreign Intervention","Fracking","Freedom of Religion","Gambling","Gerrymandering","Government Surveillance","Gun Control","High Taxes for Children","Higher Taxes for the poor ","Homeland Security","Immigration","an Incel Tax","Indoor Hats","Inheritance Limits","Lobbying","LGBTQ+ Rights","Nuclear Weapons","Mandatory Minimums","Mandatory Primary School","Mandatory Vaccination","Minimum Wage","Monopolies","Net Neutrality","No Taxes for Single Men","Omar's Law","Police Funding","Private Property","Prohibition","Protesting","Public Healthcare","Public Attorneys","Public Schools","Public Transportation","Renewable Energy","Search Without Warrant","Serfdom","Segregation","Silver Nitrate Mining","Slavery","State Prisons","Tax Cuts for the Rich","the Death Penalty","the Draft","Legal Weed","the Sale of Tobacco","Trial by Jury","a Twelve Child Policy","Wealth Limits","Welfare","Willowbend Reservations","Women's Rights","Worker's Unions","Workplace Harassment","Workplace Protections"};
  public static String[] lawGroups = new String[] {"Government Type","Distribution of Power","Freedom of Speech"};
  public static int[] lawGroupsSize = new int[] {3,4,3};
  public static String[] laws = new String[] {"Tribe","Monarchy","Republic","Tribes","Noble Families","Political Parties","Stationed Armies","Free Speech","Censorship","Outlawed Dissent"};
  private static ArrayList<Party> parties = new ArrayList<Party>();
  private static Char president;
  private static boolean[] topicLaw = new boolean[topics.length];
  private static int leading;
  private static int month = 1;
  private static int electionMonth = 10;
  private static boolean electionSeason = false;
  private static String[] monthList = new String[] { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
  private static int year = 2001;
  private static int termLength = 4;
  private static int termLeft = 3;
  public Gov(){
    parties.add(new Party(parties.size()));
    parties.add(new Party(parties.size()));
    leading = 0;
    for(int i = 0;i<topics.length;i++){
      if((int)(Math.random()*2)==0){
        topicLaw[i]=true;
      }else{
        topicLaw[i]=false;
      }
    }
    parties.get(0).setName("Great Omar Party");
    parties.get(1).setName("Anti-Omar Party");
    parties.get(0).getChar(0).changeChar("Zaid", "Omar", 28);
    parties.get(0).getChar(1).changeChar("Tyler", "Kemp", 28);
    parties.get(0).getChar(2).changeChar("Oliver", "Smink", 28);
    parties.get(0).getChar(3).changeChar("Tyger", "Foster", 28);
    parties.get(0).getChar(4).changeChar("Stylianos", "Tasikas", 28);
    parties.get(1).getChar(0).changeChar("Eamonn", "Short", 28);
    parties.get(1).getChar(1).changeChar("Gilliam", "PK", 28);
    parties.get(1).getChar(2).changeChar("Nathan", "Ruchland", 28);
    parties.get(1).getChar(3).changeChar("Benjamin", "Remmel", 28);
    parties.get(1).getChar(4).changeChar("Suhrob", "Omar", 28);
    parties.get(0).getChar(0).addTermtoPres(3);
    president = parties.get(0).getLeader();
  }



  public static String getDate(){
    return monthList[month] +" "+year;
  }
  


  public static boolean getLaw(int i){
    return topicLaw[i];
  }


  
  public static int getMonth(){
    return month;
  }



  public static Party getParty(int i){
    return parties.get(i);
  }



  public static Char getPresident(){
    if(termLeft>1){
      return parties.get(leading).getLeader();
    }else{
      return president;
    }
    
  }


  public static void setPresident(Char pres){
    president = pres;
  }

  

  public static void passLaw(){
    for(int i = 0; i < 200;i++){
      int j = (int)(Math.random()*topics.length);
    if(parties.get(leading).getOpinion(j)!=topicLaw[j]){
      i=201;
      System.out.print("The "+parties.get(leading).getName()+" has passed a bill about "+topics[j]+ ". This bill will");
      if(parties.get(leading).getOpinion(j)){
        System.out.println(" guarantee " + topics[j] + " in Omaria");
        topicLaw[j] = true;
      }else{
        System.out.println(" completely get rid of " + topics[j] + " in Omaria");
        topicLaw[j] = false;
      }
      
  }
  }
  }





  public static void checkDeaths(){
    for(int i = 0;i<parties.size();i++){
      for(int j = 0;j<5;j++){
        parties.get(i).getChar(j).checkAge();
      }
    }
  }



  public static int findOpinionAgree(){
    int i = (int)(Math.random()*topics.length);
    int k = 0;
    while((parties.get(0).getOpinion(i)!=parties.get(1).getOpinion(i))&&(k<250)){
      i = (int)(Math.random()*topics.length);
      k++;
    }
    if(k==250){
      for(int m=0;m<topics.length;m++){
        if(parties.get(0).getOpinion(i)==parties.get(1).getOpinion(i)){
          return m;
        }
      }
      i = (int)(Math.random()*topics.length);
      opinionChangeCope(i);
      return i;
    }
    return i;
  }




  public static void nameChangeCope(int i){
    System.out.print(monthList[month] + " " + year + "\t" + "The " + parties.get(i).getName()
              + " has decided to change their name to the ");
    parties.get(i).setName("");
    System.out.println(parties.get(i).getName());
    parties.get(i).changePopularity(5);
  }

  
  
  public static void opinionChangeCope(int i){
    int j = findOpinionAgree();
    System.out.print(getDate() + "\t" + "The " + parties.get(i).getName() + " has decided to change their policy on " + topics[j]);
    if (parties.get(i).getOpinion(j)) {
      parties.get(i).changeOpinion(j);
      System.out.println(" They now believe it is bad.");
    } else {
      parties.get(i).changeOpinion(j);
      System.out.println(" They now believe it is good.");
    }
    parties.get(i).changePopularity(5);
  }


  
  public static void doEverything(){
    while (year <= 2200){
      System.out.println(monthList[month] + " " + year);
      int ranDouble = (int) ((Math.random() * 81) - 40);
      ranDouble = ranDouble / 100;
      parties.get(0).changePopularity(ranDouble);
      // Character Death
      checkDeaths();  
      // Party law Passing
      if ((int) (Math.random() * 20) == 0) {
        passLaw();
      }
      // Party Coping Mechanisms
      // Party will switch Opinion on topic
      if ((int) (Math.random() * 20) == 0) {
        if ((parties.get(0).getPopularity() < 45) && (leading==0)) {
          opinionChangeCope(0);
        } else{
          opinionChangeCope(1);
        }
      }
      // Party Will Change Names
      if ((int) (Math.random() * 40) == 0) {
        if ((parties.get(0).getPopularity() < 45) && (leading==0)) {
          nameChangeCope(0);
        }else{
          nameChangeCope(1);  
        }
      }
      if (electionSeason) {

      }
      if ((termLeft == 1) && (month == (electionMonth))) {
        electionSeason = true;
        if ((0==leading) && (parties.get(0).getPopularity() > 45) && (parties.get(0).getLeader().getTermsServed() < 3)) {
        } else {
          parties.get(0).setLeaderId((int) (Math.random() * 5));
        }
        if ((1==leading) && (parties.get(1).getPopularity() > 45)) {
        } else {
          parties.get(1).setLeaderId((int) (Math.random() * 5));
        }
        System.out.println(Gov.getDate() + "\t" + "The " + parties.get(0).getName() + " have chosen "
            + parties.get(0).getLeader().getName() + " as their canidate for president.");
        System.out.println(Gov.getDate() + "\t" + "The " + parties.get(1).getName() + " have chosen "
            + parties.get(1).getLeader().getName() + " as their canidate for president.");
      }
      if ((termLeft == 0) && (month == electionMonth)) {
        electionSeason = false;
        if (parties.get(0).getPopularity() > parties.get(1).getPopularity()) {
          leading = 0;
          parties.get(0).getLeader().addTermtoPres(1);
        } else {
          leading = 1;
          parties.get(1).getLeader().addTermtoPres(1);
        }
        president = parties.get(leading).getLeader();

        System.out.print(monthList[month] + " " + year + "\t" + Gov.getPresident().getName() + " of the ");
        System.out.print(parties.get(leading).getName() + " has won the " + year + " election by " + (double) ((int) (parties.get(leading).getPopularity() / (parties.get(leading).getPopularity() + parties.get(Math.abs(leading-1)).getPopularity()) * 1000))/ 10);
        System.out.println("% and will now be the president of Omaria for the next " + termLength + " years");
        termLeft = termLength;
      }

      if ((int) (Math.random() * 500) == 0) {
        int tempTermLength = termLength;
        termLength = termLength + ((int) ((Math.random() * 7) - 3));
        if (termLength < 2) {
          termLength = 2;
        }
        parties.get(leading).changePopularity((double) (2 * (tempTermLength - termLength)));
        if (termLength != tempTermLength) {
          System.out.println(monthList[month] + " " + year + "\t " + Gov.getPresident().getName() + " has decided to change term lengths to " + termLength + " years for future presidents.");
        }
      }
      if ((int) (Math.random() * 25) == 0) {
        parties.get((int) (Math.random() * 2)).speech();
      }
      // make popularity add to 100
      double change = 100.0/(parties.get(0).getPopularity() + parties.get(1).getPopularity());
      parties.get(0).setPopularity((parties.get(0).getPopularity()*change));
      parties.get(1).setPopularity((parties.get(1).getPopularity()*change));

      month++;
      if (month >= 12) {
        year++;
        termLeft--;
        month = 0;
      }
      System.out.println(parties.get(0).getPopularity());
      System.out.println(parties.get(1).getPopularity());
      try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
    }
     
    }
}
    

