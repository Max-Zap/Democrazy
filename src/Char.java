import java.util.ArrayList;
import java.util.List;
public class Char {
  private String firstName;
  private String lastName;
  private int birthMonth;
  private int age;
  private int termsServed;
  private int partyId;
  final String[] monthList = new String[] { "January", "Febuary", "March", "April", "May", "June", "July", "August",
      "September", "October", "November", "December" };

  // Sort alphabetically
   static ArrayList<String> specFirstNameArr = new ArrayList<String> (List.of("Barack", "Elon", "Isaac", "John", "Keanu", "Luke", "Michael", "Nelson", "Oscar", "Quentin", "Robert", "Steve", "Thomas", "Ulysses", "Ray", "Carl", "Franklin", "Michael", "Trevor", "Arthur", "Dutch", "John", "Lenny", "Micah", "Albert", "Bruce", "Darth", "Frodo", "Gandalf", "Hannibal", "Tony", "James", "Neo", "Obi-Wan", "Peter", "Quasimodo", "Rocky", "Sherlock", "Uncle", "Vito", "Xander", "Yoda", "Zorro","Walter","Jesse","Gustavo"));
  static ArrayList<String> specLastNameArr = new ArrayList<String> (List.of("Obama", "Musk", "Newton", "Keaton", "Reeves", "Skywalker", "Myers", "Mandela", "Wilde", "Tarantino", "Downey Jr.", "Jobs", "Edison", "Grant", "William Johnson", "Johnson", "Clinton", "De Santa", "Philips", "Morgan", "van der Linde", "Marston", "Summers", "Bell", "Einstein", "Wayne", "Vader", "Baggins", "the Grey", "Lecter", "Stark", "Bond", "Anderson", "Kenobi", "Parker", "Bellringer", "Balboa", "Holmes", "Sam", "Corleone", "Harris", "Starlight", "Zorro (Don Diego de la Vega)","White","Pinkman","Fringe"));
  private String[] firstNameArr = new String[] { "Adam", "Albert", "Alex", "Alexander", "Andrew", "Andy", "Bartholomew",
      "Ben", "Benjamin", "Bernie", "Bill", "Billy", "Cameron", "Carl", "Carter", "Charles", "Charlie", "Chris",
      "Christian", "Christopher", "Cleveland", "Colin", "Conner", "Cornelius", "Dan", "Daniel", "Darius", "Dave",
      "David", "Derek", "Devin", "Eamonn", "Edward", "Ethan", "Eugene", "Evan", "Frank", "Gavin", "George", "Glen",
      "Gus", "Gustavo", "Harry", "Harvey", "Henrik", "Isaac", "Jacob", "Jason", "Jay", "Jeff", "Jeffery", "Jeffy",
      "Jesse", "Jim", "Jimmy", "Joe", "Joey", "John", "Johnathan", "Jordan", "Justin", "Kendrick", "Larry", "Lewis",
      "Liam", "Louis", "Manuel", "Mark", "Matteo", "Matthias", "Matthew", "Max", "Maxwell", "Micheal", "Mike", "Nathan",
      "Nicholas", "Nick", "Noah", "Nolan", "Oliver", "Oswald", "Patrick", "Pedro", "Peter", "Quinn", "Randy", "Raymond",
      "Roy", "Rod", "Roman", "Ryan", "Sam", "Samuel", "Sean", "Slate", "Shaun", "Shawn", "Steve", "Stevie", "Taj",
      "Thomas", "Tom", "Trent", "Tyler", "Tyger", "Walter", "Whitman", "William", "Willy", "Will", "Woodrow", "Woody",
      "Zach", "Zachary", "Zaid" };
  // Sort alphabetically
  private String[] lastNameArr = new String[] { "Adams", "Anderson", "Baker", "Bateman", "Bradshaw", "Brown", "Biden",
      "Black", "Butler", "Carson", "Clemens", "Cook", "Dahmer", "Davis", "Dimartino", "Evans", "Edwards", "Ferguson",
      "Fields", "Fisher", "Foley", "Foster", "Franklin", "Freeman", "Fringe", "Garcia", "Gardner", "Geary", "Goldman",
      "Green", "Griffin", "Hamilton", "Hanson", "Haney", "Hayes", "Hoffman", "Hull", "Hunter", "Irving", "Jackson",
      "Jacobs", "Jacobson", "Jefferson", "Johnson", "Johnsonof", "Johnsovich", "Jones", "Kemp", "Kennedy", "King",
      "Lavonas", "Lee", "Lewis", "Madison", "Mason", "Mastoff", "Marshall", "Miller", "Moore", "Newman", "Omar",
      "Olson", "Opoku", "Owens", "O'Conner", "O'Riley", "Pinkman", "Poole", "Porter", "Qadir", "Remmel", "Rodriguez",
      "Rogers", "Ruckland", "Sanders", "Smink", "Smith", "Sternson", "Sullivan", "Tasikas", "Vecathca", "von Israel",
      "Washington", "Watson", "Welder", "West", "White", "Williams", "Williamson", "Willson", "Wilmot", "Wonka",
      "Woods", "Zoolander" };



  
  public Char(int id) {
    int ran1 = (int) (Math.random() * firstNameArr.length);
    int ran2 = (int) (Math.random() * lastNameArr.length);
    firstName = firstNameArr[ran1];
    lastName = lastNameArr[ran2];
    age = (int) (Math.random() * 35) + 35;
    birthMonth = (int) (Math.random() * 12);
    partyId = id;
  }

  

  public String getName() {
    return firstName + " " + lastName;
  }


  public int getTermsServed() {
    return termsServed;
  }

  public int getAge() {
    return age;
  }

  public void checkAge(){
    if (Gov.getMonth() == birthMonth) {
      age++;
    }
    if (age <= 60) {
      if (((int) (Math.random() * 500)) == 0) {
        charDeath();
      }
    } else if ((((int) (Math.random() * ((100 - age) * 6))) == 0) || (age == 100)) {
      charDeath();
    }
  }

  public void changeChar() {
    if(specFirstNameArr.size()>0){
     int ran1 = (int) (Math.random() * specFirstNameArr.size());
      firstName = specFirstNameArr.get(ran1);
      lastName = specLastNameArr.get(ran1);
      specLastNameArr.remove(ran1);
      specFirstNameArr.remove(ran1);
    }else{
      int ran1 = (int) (Math.random() * firstNameArr.length);
      int ran2 = (int) (Math.random() * lastNameArr.length);
      firstName = firstNameArr[ran1];
      lastName = lastNameArr[ran2];
    }
    age = (int) (Math.random() * 35) + 35;
    birthMonth = (int) (Math.random() * 12);
    termsServed = 0;
  }

  public void addTermtoPres(int terms) {
    termsServed += terms;
  }



  public void changeChar(String charFirstName, String charLastName, int charAge) {
    firstName = charFirstName;
    lastName = charLastName;
    age = charAge;
  }

  public void charDeath() {
    Party tempParty = Gov.getParty(partyId);
    boolean president = false;
    if ((getName().equals(Gov.getPresident().getName())) && (age == Gov.getPresident().getAge())) {
      System.out.print(Gov.getDate() + "\t President " + getName() + " of the "
          + tempParty.getName() + " has died at the age of " + age + " and left his position to vice president ");
    }else{
      System.out.print(Gov.getDate() + "\t" + getName() + " of the " + tempParty.getName()
          + " has died at the age of " + age + " and left his position to ");
    }
    int tempAge = age;
    String tempName = getName();
    int tempTerms = getTermsServed();
    changeChar();
    if(president){Gov.setPresident(this);}
    System.out.print(getName());
    if (tempAge <= 55) {
      System.out.print(", and he was so young!");
    }
    if (tempTerms > 0) {
      System.out.print(" " + tempName + " was a prominent member of the " + tempParty.getName()
          + " and his death has caused the party to lose popularity.");
    }
    System.out.println();
  }
}
