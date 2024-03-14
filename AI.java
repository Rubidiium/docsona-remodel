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
    //Number to space out certain cases a static amount
    public static int weightCounter;
    public static double random;
    public static int target;
    private static int intHolder;

    public static void act(Actor a, Actor[] actors){
        //Find out what phase Nyx is in
        AI.phaseCalculator(a);
        //Create a random double between 0 and 100
        random = Math.random() * 100;
        //Reset the intHolder in case of needed
        intHolder = 0;
        //Cancel the starting sequence for each phase, use special skill if necessary
        switch(AI.phase){
            //Unit 0 Logic (DONE)
            case 0:
                AI.unit0started = true;
                //Determine case for weighting
                AI.weightCalculator(a, actors);
                //Choose a skill based on weighting
                a.hasTurn = false;
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
                                    target = i;
                                    break; } } }
                        if((int)(random) <= 70){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 70 && (int)(random) <= 85){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 85 && (int)(random) <= 93){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 93 && (int)(random) <= 98){
                            Battle.useASkill(a, actors, a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 98){
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        break;
                    //Prioritize ailments
                    case 2:
                        a.hasTurn = false;
                        //Prioritize targets with no ailments
                        for(int i = 0; i < actors.length; i++){
                            if(actors[i].ailment == 0){
                                //70% chance to select a target
                                if(random >= 30){
                                    target = i;
                                    break; } } }
                        if((int)(random) <= 80){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 80 && (int)(random) <= 85){
                            Battle.useASkill(a, actors, a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 85 && (int)(random) <= 90){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 90 && (int)(random) <= 95){
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 95){
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        break; 
                }
                break;
            //Unit 1 Logic
            case 1:
                AI.unit1started = true;
                //Determine case for weighting
                AI.weightCalculator(a, actors);
                //Choose a skill based on weighting
                a.hasTurn = false;
                switch(weightCase){
                    //Purely random - No case defined
                    default:
                        a.hasTurn = false;
                        //Pick a random target
                        target = (int)(Math.random() * (4));
                        //Pick a random attack
                        if((int)(random) <= 13){
                            //t.attack()
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 13 && (int)(random) <= 33){
                            //t.stomp()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 33 && (int)(random) <= 50){
                            //t.smash()
                            Battle.useASkill(a, actors, a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 50 && (int)(random) <= 66){
                            //t.slow()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 66 && (int)(random) <= 85){
                            //t.speed(2)
                            Battle.useSSkill(a, a, a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 85){
                            //t.screech()
                            Battle.useASkill(a, actors, a.edocsona.skills[4], "0"); }
                        break;
                    //Prioritize physical
                    case 0:
                        //Pick the target with the most HP
                        for(int i = 0; i < actors.length; i++){
                            if(actors[i].cHP > intHolder){
                                //70% chance to select a target
                                if(random >= 30){
                                    intHolder = actors[i].cHP;
                                    target = i;
                                    break; } } }
                        //Favor physical attacks
                        if((int)(random) <= 35){
                           //t.stomp()
                           Battle.useSSkill(a, actors[target], a.edocsona.skills[0], "0"); } 
                        else if((int)(random) > 35 && (int)(random) <= 70){
                            //t.smash()
                            Battle.useASkill(a, actors, a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 70 && (int)(random) <= 80){
                            //t.attack()
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 80 && (int)(random) <= 85){
                            //t.slow()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); }
                        else if((int)(random) > 85 && (int)(random) <= 90){
                            //t.speed(2)
                            Battle.useSSkill(a, a, a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 90){
                            //t.screech()
                            Battle.useASkill(a, actors, a.edocsona.skills[4], "0"); }
                        break;
                    //Prioritize buffs and debuffs
                    case 1:
                        a.hasTurn = false;
                        //Prioritize target with buffs, else random
                        for(int i = 0; i < actors.length; i++){
                            if(actors[i].atk != 0 || actors[i].def != 0 || actors[i].acc != 0){
                                //70% chance to select a target
                                if(random >= 30){
                                    target = i;
                                    break; } } }
                        //Favor buffs/debuffs
                        if((int)(random) <= 35){
                           //t.slow()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); } 
                        else if((int)(random) > 35 && (int)(random) <= 70){
                            //t.speed(2)
                            Battle.useSSkill(a, a, a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 70 && (int)(random) <= 80){
                            //t.attack()
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 80 && (int)(random) <= 85){
                            //t.stomp()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 85 && (int)(random) <= 90){
                            //t.smash()
                            Battle.useASkill(a, actors, a.edocsona.skills[1], "0"); }
                        else if((int)(random) > 90){
                            //t.screech()
                            Battle.useASkill(a, actors, a.edocsona.skills[4], "0"); }
                        break;
                    //Priotiize ailments
                    case 2:
                        a.hasTurn = false;
                        //Prioritize targets with no ailments
                        for(int i = 0; i < actors.length; i++){
                            if(actors[i].ailment == 0){
                                //70% chance to select a target
                                if(random >= 30){
                                    target = i;
                                    break; } } }
                        //Favor buffs/debuffs
                        if((int)(random) <= 45){
                            //t.screech()
                            Battle.useASkill(a, actors, a.edocsona.skills[4], "0"); }
                        else if((int)(random) > 45 && (int)(random) <= 70){
                            //t.speed(2)
                            Battle.useSSkill(a, a, a.edocsona.skills[3], "0"); }
                        else if((int)(random) > 70 && (int)(random) <= 80){
                            //t.attack()
                            Battle.useSSkill(a, actors[target], a.edocsona.attack, "0"); }
                        else if((int)(random) > 80 && (int)(random) <= 85){
                            //t.slow()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[2], "0"); } 
                        else if((int)(random) > 85 && (int)(random) <= 90){
                            //t.stomp()
                            Battle.useSSkill(a, actors[target], a.edocsona.skills[0], "0"); }
                        else if((int)(random) > 90){
                            //t.smash()
                            Battle.useASkill(a, actors, a.edocsona.skills[1], "0"); }
                        break;
                }
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
    }

    //Determines the ideal weighting to use for skills depending on the current status of all actors
    //The same case cannot be used twice in a row
    public static void weightCalculator(Actor a, Actor[] actors){
        Battle.weightChanged = false;
        switch(phase){
            //Calculate the weighting for phase 0
            case 0:
                //Priotiize physical attacks if a player is above 50% HP
                if(AI.weightCase != 0){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.cHP >= player.mHP / 2){
                                AI.weightCase = 0;
                                Battle.weightChanged = true;
                                break; } } } 
                //Priotize buffs and debuffs if a player has an active buff
                } else if(AI.weightCase != 1){
                    for(Actor player : actors){
                        if(player.player){    
                            if(player.atk != 0 || player.def != 0 || player.acc != 0){
                                AI.weightCase = 1;
                                Battle.weightChanged = true;
                                break; } } }
                //Prioritize ailments if all players have none
                } else if(AI.weightCase != 2){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.ailment == 0){
                                AI.weightCase = 2; 
                                Battle.weightChanged = true;
                                break; } } } }
                //Reset if the same case was used twice
                if(!Battle.weightChanged){
                    weightCase = -1;
                    break; }
                break;
            //Calculate the weighting for phase 1
            case 1:
                //Priotiize physical attacks if a player is above 50% HP
                if(AI.weightCase != 0){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.cHP >= player.mHP / 2){
                                AI.weightCase = 0;
                                Battle.weightChanged = true;
                                break; } } } 
                //Priotize buffs and debuffs if a player has an active buff
                } else if(AI.weightCase != 1){
                    for(Actor player : actors){
                        if(player.player){    
                            if(player.atk != 0 || player.def != 0 || player.acc != 0){
                                AI.weightCase = 1;
                                Battle.weightChanged = true;
                                break; } } }
                //Prioritize ailments if all players have none
                } else if(AI.weightCase != 2){
                    for(Actor player : actors){
                        if(player.player){
                            if(player.ailment == 0){
                                AI.weightCase = 2; 
                                Battle.weightChanged = true;
                                break; } } } }
                //Reset if the same case was used twice
                if(!Battle.weightChanged){
                    weightCase = -1;
                    break; }
                break;
            //Calculate the weighting for phase 2
            case 2:
                //Prioritize magic skills
                if(AI.weightCounter == 0){
                    AI.weightCounter = 1;
                    AI.weightCase = 0; 
                //Random every other turn
                } else {
                    AI.weightCounter = 0;
                    AI.weightCase = 1; }
                break;
            //Calculate the weighting for phase 3
            case 3:
                //Prioritize magic skills
                if(AI.weightCounter < 5){
                    AI.weightCounter++;
                    AI.weightCase = 0; }
                //Concentrate every 5 turns
                if(AI.weightCounter >= 5){
                    AI.weightCounter = 0;
                    AI.weightCase = 1; }
                break;
            //Calculate the weighting for phase 4
            case 4:
                //Prioritize light/dark attack every other turn
                if(AI.weightCounter == 0){
                    AI.weightCounter = 1;
                    AI.weightCase = 0; 
                //Priotize charge/physical every other turn
                } else {
                    AI.weightCounter = 0;
                    AI.weightCase = 1; }
                break;
            //Calculate the weighting for phase 5
            case 5:
                //Move down the elemental list and loop back at end
                switch(AI.weightCounter){
                    //Fire
                    case 0:
                        AI.weightCase = 0;
                        AI.weightCounter++;
                        break;
                    //Ice
                    case 1:
                        AI.weightCase = 1;
                        AI.weightCounter++;
                        break;
                    //Wind
                    case 3:
                        AI.weightCase = 2;
                        AI.weightCounter++;
                        break;
                    //Elec
                    case 4:
                        AI.weightCase = 3;
                        AI.weightCounter++;
                        break;
                    //Light
                    case 5:
                        AI.weightCase = 4;
                        AI.weightCounter++;
                        break;
                    //Dark
                    case 6:
                        AI.weightCase = 5;
                        AI.weightCounter = 0;
                        break;
                    //Loop back, random skill
                    default:
                        AI.weightCase = 0;
                        AI.weightCounter = 0;
                        break; }
                break;
            //Calculate the weighting for phase 6
            case 6:
                switch(AI.weightCounter){
                    //One magic attack
                    case 0:
                        AI.weightCase = 0;
                        AI.weightCounter++;
                        break;
                    //One physical attack
                    case 1:
                        AI.weightCase = 1;
                        AI.weightCounter++;
                        break;
                    //One buff/ailment
                    case 2:
                        AI.weightCase = 2;
                        AI.weightCounter = 0;
                        break; }
                break;
            //Calculate the weighting for phase 7
            case 7:
                //Total automation every 5 turns
                if(AI.weightCounter >= 5){
                    AI.weightCase = 0;
                    AI.weightCounter = 0;
                //Random otherwise
                } else {
                    AI.weightCase = 1;
                    AI.weightCounter++; }
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
        if(a.cHP < 9000 && a.cHP >= 7500){
            phase = 5; }
        if(a.cHP < 7500 && a.cHP >= 5000){
            phase = 6; }
        if(a.cHP < 5000){
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
        AI.weightCounter = 0;
        System.out.println("AI.java compiled!");
    }
}