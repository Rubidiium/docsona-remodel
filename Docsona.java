public class Docsona{
    public String name;
    public int[] affinities;
    public int st;
    public int ma;
    public int en;
    public int ag;
    public int lu;
    //Normal attack, default every Docsona
    public Skill attack;
    public Skill[] skills;

    //Constructor with name and stats
    public Docsona(String n, int Strength, int Magic, int Endurance, int Agility, int Luck){
        name = n;
        st = Strength;
        ma = Magic;
        en = Endurance;
        ag = Agility;
        lu = Luck;
    }

    //Method to create an array of affinities
    public void setAffinities(int Phys, int Fire, int Ice, int Wind, int Elec, int Light, int Dark){
        affinities = new int[]{Phys, Fire, Ice, Wind, Elec, Light, Dark};
    }

    //Method to create an array of skills
    public void setSkills(Skill skill1, Skill skill2, Skill skill3, Skill skill4, Skill skill5, Skill skill6, Skill skill7, Skill skill8){
        skills = new Skill[]{skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8};
    }

    //Hardcoded assignment of default physical attack for every Docsona
    public void setAttack(Skill attackS){
        this.attack = attackS;
    }

    //Method to print out Docsona with stats and availible skills
    public String statusString(){
        //Create a string to store the final result
        String status = "";
        status += name;
        status += "\n";

        //Print affinities
        for(int i = 0; i < this.affinities.length; i++){
            switch(i){
                case 0:
                    status += "Phys: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 1:
                    status += "Fire: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 2:
                    status += "Ice: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 3:
                    status += "Wind: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 4:
                    status += "Elec: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 5:
                    status += "Light: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
                case 6:
                    status += "Dark: ";
                    switch(this.affinities[i]){
                        case 1:
                            status += "WK | ";
                            break;
                        case 2:
                            status += "RS | ";
                            break;
                        case 3:
                            status += "NL | ";
                            break;
                        case 4:
                            status += "DR | ";
                            break;
                        case 5:
                            status += "RP | ";
                            break;
                        default:
                            status += "-- | ";
                            break; }
                    break;
            }
        }

        return status;
    }

    public void statList(){
        //Print out the stats
        System.out.println("ST: " + this.st + " | MA: " + this.ma + " | EN: " + this.en + " | AG: " + this.ag + " | LU: " + this.lu);
    }

    public void skillList(){
        //Print out the skills
        System.out.println("\n\nSkills: \n");
        for(int i = 0; i < this.skills.length; i++){
            System.out.println(this.skills[i].name);
            if(!(i == this.skills.length - 1)){
                System.out.println(" | ");
            }
        }
    }

    public static void init(){
        System.out.println("Docsona.java compiled!\n");
    }
}