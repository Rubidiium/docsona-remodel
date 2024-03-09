public class AI{
    //Tracker for which phase Codio is on
    public static int phase;
    public static boolean unit0started;
    public static boolean unit1started;
    public static boolean unit2started;
    public static boolean unit3started;
    public static boolean unit4started;
    public static boolean unit5started;
    public static boolean unit6started;
    public static boolean unit7started;
    //Number for which AI weighting case to use - Varies depending on phase
    public static int weightCase;
    public static double random;
    public static int target;

    public static void act(Actor a, Actor[] actors){
        //Find out what phase Nyx is in
        AI.phaseCalculator(a);
        //Create a random double between 0 and 100
        random = Math.random() * 100;
        //Cancel the starting sequence for each phase, use special skill if necessary
        switch(AI.phase){
            //Unit 0 Logic
            case 0:
                AI.unit0started = true;
                //Determine case for weighting
                AI.weightCalculator(a, actors);
                //Choose a skill based on weighting
                System.out.println(random);
                switch(weightCase){
                    //Purely random - No case defined
                    default:
                        a.hasTurn = false;
                        //Pick a random target
                        target = (int)(Math.random() * (4));
                        if((int)(random) <= 20){
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 20 && (int)(random) <= 40){
                            Battle.useASkill(a, actors, a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 40 && (int)(random) <= 60){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 60 && (int)(random) <= 80){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 80){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[3], "0"); }
                        break;
                    //Priotize physical attack skills
                    case 0:
                        a.hasTurn = false;
                        //Pick a random target
                        target = (int)(Math.random() * (4));
                        if((int)(random) <= 50){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 50 && (int)(random) <= 80){
                            Battle.useASkill(a, actors, a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 80 && (int)(random) <= 90){
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 90 && (int)(random) <= 95){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 95){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[3], "0"); }
                        break;
                    //Prioritize buffs/debuffs
                    case 1:
                        a.hasTurn = false;
                        //Prioritize target with buffs, else random
                        for(int i = 0; i < actors.length; i++){
                            if(actors[i].atk != 0 || actors[i].def != 0 || actors[i].acc != 0){
                                //70% chance to select a target
                                if(random >= 30){
                                    target = i;} } }
                        if((int)(random) <= 70){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 70 && (int)(random) <= 85){
                            
                        }
                        break;
                    //Prioritize ailments
                    case 2:
                        break;
                }
                break;
            //Unit 1 Logic
            case 1:
                AI.unit1started = true;
                break;
            //Unit 2 Logic
            case 2:
                AI.unit2started = true;
                break;
            //Unit 3 Logic
            case 3:
                AI.unit3started = true;
                break;
            //Unit 4 Logic
            case 4:
                AI.unit4started = true;
                break;
            //Unit 5 Logic
            case 5:
                AI.unit5started = true;
                break;
            //Unit 6 Logic
            case 6:
                AI.unit6started = true;
                break;
            //Unit 7 Logic
            case 7:
                AI.unit7started = true;
                break; 
        }
        a.hasTurn = false;
    }

    //Determines the ideal weighting to use for skills depending on the current status of all actors
    //A weight case cannot be used twice in a row, a different case must be used each turn
    public static void weightCalculator(Actor a, Actor[] actors){
        switch(phase){
            //Calculate the weighting for phase 0
            case 0:
                //Prioritize ailments if all players have none
                if(weightCase != 2){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.ailment == 0){
                                weightCase = 2;
                            } else {
                                weightCase = -1; } } } }
                //Priotize buffs and debuffs if a player has an active buff
                if(weightCase != 1){
                    for(Actor player : actors){
                        if(player.player){    
                            if(player.atk != 0 || player.def != 0 || player.acc != 0){
                                weightCase = 1;
                                break;
                            } else {
                                weightCase = -1; } } } }
                //Priotiize physical attacks if a player is above 50% HP
                if(weightCase != 0){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.cHP >= player.mHP / 2){
                                weightCase = 0;
                                break;
                            } else {
                                weightCase = -1; } } } }
                break;
        }
    }

    public static void phaseCalculator(Actor a){
        if(a.cHP >= 18000){
            phase = 0; }
        if(a.cHP < 18000 && a.cHP >= 16000){
            phase = 1; }
        if(a.cHP < 16000 && a.cHP >= 14000){
            phase = 2; }
        if(a.cHP < 12000 && a.cHP >= 10000){
            phase = 3; }
        if(a.cHP < 10000 && a.cHP >= 9000){
            phase = 4; }
        if(a.cHP < 9000 && a.cHP >= 8000){
            phase = 5; }
        if(a.cHP < 8000 && a.cHP >= 7000){
            phase = 6; }
        if(a.cHP < 7000 && a.cHP >= 6000){
            phase = 7; }
    }

    public static void init(){
        phase = 0;
        unit0started = false;
        unit1started = false;
        unit2started = false;
        unit3started = false;
        unit4started = false;
        unit5started = false;
        unit6started = false;
        unit7started = false;
        System.out.println("AI.java compiled!");
    }
}