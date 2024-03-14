public class Skill{
    //Instance variables for each skill
    public String name;
    //States (Type): 0 = Physical, 1 = Fire, 2 = Ice, 3 = Wind, 4 = Electric, 5 = Light, 6 = Dark, 7 = Healing, 8 = Almighty, 10 = Enemy AllDebuff, 11 = Attack Buff/Debuff, 12 = Defense Buff/Debuff, 13 = Accuracy Buff/Debuff, 14 = Concetrate, 15 = Charge, 16 = Fear, 17 = Poison, 18 = Despair, 19 = Skill Ailment Heal, 20 = Other Ailment Heal, 21 = Revive Heal
    public int type;
    //Determines whether an attack targets enemy or allies
    public boolean friendly;
    //Determines whether a skill targets all enemies or just one; important for boss to use
    public boolean all;
    public int cost;
    public String desc;
    public int basePower;
    public boolean useable;

    //Constructor for each skill
    public Skill(String n, int t, boolean f, boolean a, int c, int bP, boolean u){
        name = n;
        type = t;
        friendly = f;
        all = a;
        cost = c;
        basePower = bP;
        useable = u;
    }

    //Assign a description for player-side skills, not necessary for skills that won't be printed
    public void newDescription(String n){
        desc = n;
    }

    //Print the skill and information in a format compatible with the battle interface
    public String statusString(){
        if(this.useable == false){
            return(""); }
        if(this.type == 0){
            return(name + "\n" + cost + " HP" + "\n" + desc);
        } else {
            return(name + "\n" + cost + " SP" + "\n" + desc); }
    }


    //Cast a damage skill on a target
    public int castDamage(Actor player, Actor target){
        //Reset critical tracker
        Battle.wasCritical = false;
        Battle.wasWeak = false;
        
        //Temporary value for calculations
        double temp = 0;
        double fin = 0;

        //Create cache variables for the player and target's stats
        int pST = player.edocsona.st;
        int pMA = player.edocsona.ma;
        int pEN = player.edocsona.en;
        int pAG = player.edocsona.ag;
        int pLU = player.edocsona.lu;

        int tST = target.edocsona.st;
        int tMA = target.edocsona.ma;
        int tEN = target.edocsona.en;
        int tAG = target.edocsona.ag;
        int tLU = target.edocsona.lu;

        //Apply buffs and debuffs for player
        switch(player.atk){
            default:
                break;
            case 1:
                pST *= 1.25;
                pMA *= 1.25;
                break;
            case 2: 
                pST *= 0.75;
                pMA *= 0.75;
                break; }
        switch(player.def){
            default:
                break;
            case 1:
                pEN *= 1.25;
                break;
            case 2:
                pEN *= 0.75;
                break; }
        switch(player.acc){
            default:
                break;
            case 1:
                pAG *= 1.25;
                pLU *= 1.25;
                break;
            case 2:
                pAG *= 0.75;
                pLU *= 0.75;
                break; }
        
        //Apply buffs and debuffs for target
        switch(target.atk){
            default:
                break;
            case 1:
                tST *= 1.25;
                tMA *= 1.25;
                break;
            case 2: 
                tST *= 0.75;
                tMA *= 0.75;
                break; }
        switch(target.def){
            default:
                break;
            case 1:
                tEN *= 1.25;
                break;
            case 2:
                tEN *= 0.75;
                break; }
        switch(target.acc){
            default:
                break;
            case 1:
                tAG *= 1.25;
                tLU *= 1.25;
                break;
            case 2:
                tAG *= 0.75;
                tLU *= 0.75;
                break; }


        //Formula to check for hit, if the enemy is down, skip this check
        //Only run this check if the attack affinity is neutral or weak
        if(this.type == 8 || target.edocsona.affinities[this.type] == 0 || target.edocsona.affinities[this.type] == 1){
            if(player.ailment == 3){
                //Dizzy penalty
                if(((Math.random() * (100 - 0) + 0) - (int)(tAG/10) + (int)(pAG/10)) > 5 && !target.down){
                    //Return 0 if missed
                    System.out.println("MISS\n");
                    Battle.missed = true;
                    return 0; } 
            } else {  
                if(((Math.random() * (100 - 0) + 0) - (int)(tAG/10) + (int)(pAG/10)) > 95 && !target.down){
                    //Return 0 if missed
                    System.out.println("MISS\n");
                    Battle.missed = true;
                    return 0; } } }

        // Physical damage calculator //
        if(this.type == 0){
            //Formula to calculate damage
            temp = ((Math.random() * (1 - 0.8) + 0.8) * Math.sqrt(this.basePower) * pST) - (tEN * 0.2);    
        
        } else { // Magic damage calculator //
            //Formula to calculate damage
            temp = ((Math.random() * (1 - 0.8) + 0.8) * Math.sqrt(this.basePower) * pMA) - (tEN * 0.2);

            //Check for ailment immunity or pre-existing ailment
            if(target.ailment != 10 && target.ailment == 0 && target.edocsona.affinities[this.type] < 3){
                //Calculate chance for ailments
                switch(this.type){
                    //Burning
                    case 1:
                        if(Math.random() >= 0.8){
                            target.ailment = 1; 
                            target.ailmentT = 3;
                            System.out.println(target.name + " was inflicted with burns\n"); }
                        break;
                    //Frozen
                    case 2:
                        if(Math.random() >= 0.9){
                            target.ailment = 2; 
                            target.ailmentT = 3;
                            System.out.println(target.name + " was frozen\n"); }
                        break;
                    //Dizzy
                    case 3:
                        if(Math.random() >= 0.8){
                            target.ailment = 3;
                            target.ailmentT = 3;
                            System.out.println(target.name + " is dizzy\n"); }
                        break;
                    //Shocked
                    case 4:
                        if(Math.random() >= 0.9){
                            target.ailment = 4; 
                            target.ailmentT = 3;
                            System.out.println(target.name + " was shocked\n"); }
                        break;
                }
            }
        }

        //If the enemy was down, reward a bonus turn and 10% more damage
        if(target.down == true){
            fin *= 1.10;
        }

        // Calculate affinity bonuses //
        if(this.type != 8){
        switch(target.edocsona.affinities[this.type]){
            //No affinities
            default:
                break;
            //Weak = 25% bonus
            case 1:
                //Negate weakness if guarding
                if(target.guard){
                    Battle.wasWeak = false;
                    break; 
                } else {
                temp *= 1.25;
                Battle.wasWeak = true;
                target.down = true; }
                break;
            //Resist = 50% penalty
            case 2:
                temp *= 0.5;
                break;
            //Null = No damage
            case 3:
                temp = 0;
                break;
            //Asborb = 50% change
            case 4:
                temp *= 0.5;
                break; 
            //Repel = 50% change
            case 5:
                temp *= 0.5;
                break; } }

        //Calculate critical for physical attacks; Down target if critical
        fin = this.criticalCalc(player, target, temp);

        //Apply charge/concentrate bonuses
        if((player.charge == 1 || player.charge == 3) && this.type == 0){
            fin *= 2;
            if(player.charge == 3){
                player.charge = 2;
            } else {
                player.charge = 0;
            }
        } else if ((player.charge == 2 || player.charge == 3) && (this.type > 0 && this.type < 9)){
            fin *= 2;
            if(player.charge == 3){
                player.charge = 2;
            } else {
                player.charge = 0;
            }
        }

        //Apply final guard penalty
        if(target.guard == true){
            fin *= 0.5;
        }

        //Return the final number
        return (int)(fin);
    }

    //Cast a healing skill on a target
    public int castHealing(Actor player, Actor target){
        return((int)((Math.random() * (1 - 0.8) + 0.8) * this.basePower));
    }

    public int criticalCalc(Actor player, Actor target, double damage){
        //Do nothing if it isn't a physical skill
        if(this.type != 0){
            return (int)(damage); }
        //Create a random value
        int rando = (int)(Math.random() * (100 - 0) + 0);
        //Add 90 if the target is dizzy
        if(target.ailment == 3){
            rando += 90;
        }
        //Formula to check for critical
        if(rando + (int)(player.edocsona.lu/10) > 95){
            //75% damage boost if critical
            Battle.wasCritical = true;
            return (int)(damage * 1.75); 
        } else {
            Battle.wasCritical = false;
            return (int)(damage); }
    }



    public static void init(){
        System.out.println("Skill.java compiled!\n");
    }
}
