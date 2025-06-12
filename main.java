class Main {
  public static void main(String[] args){
    Gov gov = new Gov();
    int topicListLength = 50;
    boolean electionSeason = false;
    double newPopular = 0.0;
    double ranDouble;
    int i = 0;
    


    System.out.println("January 2001" + "\t"
        + "It has been 12 years since Omaria has freed themselves from their oppresive overlords. Zaid omar has decided not to run again after winning 3 terms and the Omar Party has split into the "
        + Gov.getParty(0).getName() + " led by " + Gov.getParty(0).getLeader().getName() + " and the " + Gov.getParty(1).getName() + " led by " + Gov.getParty(1).getLeader().getName());


        
    Gov.doEverything();
  }
}