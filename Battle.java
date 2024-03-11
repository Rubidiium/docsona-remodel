public class Battle{
    //Global flags
    public static boolean missed;
    public static boolean wasCritical;
    public static boolean wasWeak;
    public static boolean wasResisted;
    public static boolean wasNulled;
    public static boolean wasDrained;
    public static boolean wasRepeled;
    public static boolean docsonaChanged;
    public static boolean is1more;
    public static boolean battleActive;
    public static boolean battleWon;
    public static boolean ailmentPrint;
    //Counter for when all actors have had a turn
    public static int cycleCounter;
    //Misc. counter when needed
    public static int arrCounter;
    //Keep track of which phase the boss is in
    public static int codioPhase;
    //Cache variable for damage printing
    public static int damage;
    //Check if an ailment was already applied, avoid printing otherwise
    public static int preAilment;

    //Check to see if the battle can be ended
    public static boolean battleChecker(Actor[] actors){
        //Check if Vee has died
        if(actors[0].cHP <= 0 || actors[0].uc){
            Battle.battleActive = false;
            return false; }
        //Check if Nyx is defeated
        if(actors[4].cHP <= 0 || actors[4].uc){
            Battle.battleActive = false;
            Battle.battleWon = true;
            return true; }
        return false;
    }

    //Method to use skill that affects one target
    public static void useSSkill(Actor a, Actor t, Skill s, String choice){
        damage = 0;
        preAilment = t.ailment;
        Clear.clear();
        //Reset battle trackers
        Battle.wasCritical = false;
        Battle.missed = false;
        //90% chance to lose turn if fearful
        if(a.ailment == 5){
            if(Math.random() >= 0.10){
                a.hasTurn = false;
                System.out.println(a.name + " is too afraid to move!"); } }
        //Perform a basic attack
        if(s.name.equals("Attack")){
            System.out.println(a.name + " attacks " + t.name + "\n"); } else {
            System.out.println(a.name + " uses " + s.name + " on " + t.name + "\n"); }
        //Subtract HP/SP cost
        if(s.type == 0){
            a.cHP -= s.cost;
        } else {
            a.cSP -= s.cost; }
        //Handle unfriendly attacks
        if(!s.friendly){
            //Hack almighty damage
            if(s.type == 8){
                a.hasTurn = false;
                damage = s.castDamage(a, t);
                if(!Battle.missed){
                    if(Battle.wasCritical){
                        System.out.println("CRITICAL");
                        t.down = true;
                        System.out.println(damage + " damage to " + t.name);
                        t.cHP -= damage;
                        t.down = true;
                        System.out.println(t.name + "'s HP is " + t.cHP);
                        if(!Battle.is1more){
                            System.out.println("\n1 MORE\n"); 
                            Battle.is1more = true;
                            a.hasTurn = true; } 
                        } else {
                            System.out.println(damage + " damage to " + t.name);
                            t.cHP -= damage;
                            System.out.println(t.name + "'s HP is " + t.cHP);
                        }
                        t.unconscious(); } }
            //Handle damage skills
            if((s.type >= 0 && s.type <= 6)){
            switch(t.edocsona.affinities[s.type]){
                //No affinities
                default:
                    a.hasTurn = false;
                    damage = s.castDamage(a, t);
                    if(!Battle.missed){
                        if(Battle.wasCritical){
                            System.out.println("CRITICAL");
                            t.down = true;
                            System.out.println(damage + " damage to " + t.name);
                            t.cHP -= damage;
                            t.down = true;
                            System.out.println("\n1 MORE\n"); 
                            System.out.println(t.name + "'s HP is " + t.cHP);
                            if(!Battle.is1more){
                                Battle.is1more = true;
                                a.hasTurn = true; } 
                            } else {
                                System.out.println(damage + " damage to " + t.name);
                                t.cHP -= damage;
                                System.out.println(t.name + "'s HP is " + t.cHP);
                            }
                            t.unconscious();
                    }
                    break;
                //Enemy is weak
                case 1:
                    a.hasTurn = false;
                    damage = s.castDamage(a, t);
                    if(!Battle.missed){
                    if(!Battle.is1more){
                        a.hasTurn = true; }
                        System.out.println("WEAK");
                        t.cHP -= damage;
                        t.down = true;
                        System.out.println(damage + " damage to " + t.name);
                    if(!Battle.is1more){
                        System.out.println("1 MORE"); }
                        System.out.println(t.name + "'s HP is " + t.cHP); }
                    t.unconscious();
                    break;
                //Enemy resists
                case 2:
                    a.hasTurn = false;
                    damage = s.castDamage(a, t);
                    System.out.println("RESIST");
                    t.cHP -= damage;
                    System.out.println(damage + " damage to " + t.name);
                    System.out.println(t.name + "'s HP is " + t.cHP);
                    t.unconscious();
                    break;
                //Enemy blocks
                case 3:
                    a.hasTurn = false;
                    System.out.println("BLOCK");
                    break;
                //Enemy absorbs
                case 4:
                    a.hasTurn = false;
                    System.out.println("DRAIN");
                    damage = s.castDamage(a, t);
                    t.cHP += damage;
                    if(t.cHP >= t.mHP){
                        t.cHP = t.mHP;
                        System.out.println(t.name + "'s HP is maxed out!");
                    } else {
                    System.out.println(damage + " healed to " + t.name); }
                    System.out.println(t.name + "'s HP is " + t.cHP + "\n");
                    break;
                //Enemy repels
                case 5:
                    a.hasTurn = false;
                    System.out.println("REPEL");
                    damage = s.castDamage(a, t);
                    a.cHP -= damage;
                    System.out.println(damage + " to " + a.name);
                    System.out.println(a.name + "'s HP is " + a.cHP);
                    a.unconscious();
                    break;
                }
            }
            //Handle debuff skills
            if(s.type >= 10 && s.type <= 15){
                //All debuff
                if(s.type == 10){
                    a.hasTurn = false;
                    t.atk = 2;
                    t.atkT += 4;
                    t.def = 2;
                    t.defT += 4;
                    t.acc = 2;
                    t.accT += 4;
                    System.out.println(t.name + "'s ATK/DEF/ACC fell");
                //Singular debuffs
                } else {
                    switch(s.type){
                        case 11:
                            a.hasTurn = false;
                            t.atk = 2;
                            t.atkT += 4;
                            System.out.println(t.name + "'s ATK fell");
                            break;
                        case 12:
                            a.hasTurn = false;
                            t.def = 2;
                            t.defT += 4;
                            System.out.println(t.name + "'s DEF fell");
                            break;
                        case 13:
                            a.hasTurn = false;
                            t.acc = 2;
                            t.accT += 4;
                            System.out.println(t.name + "'s ACC fell");
                            break; } } }
            //Handle ailment skills
            if(s.type >= 16 && s.type <= 18){
                //Inflict Fear - 50% Chance
                if(s.type == 16){
                    damage = (int)(Math.random() * (100 - 0) + 0);
                    if(damage >= 50){
                        a.hasTurn = false;
                        t.ailment = 5;
                        t.ailmentT = 4;
                        System.out.println(t.name + " became fearful!"); } }
                //Inflict Poison - 75% Chance
                if(s.type == 17){
                    damage = (int)(Math.random() * (100 - 0) + 0);
                    if(damage >= 25){
                        a.hasTurn = false;
                        t.ailment = 6;
                        t.ailmentT = 4;
                        System.out.println(t.name + " was poisoned!"); } }
                //Inflict Despair - 50% Chance
                if(s.type == 16){
                    damage = (int)(Math.random() * (100 - 0) + 0);
                    if(damage >= 50){
                        a.hasTurn = false;
                        t.ailment = 7;
                        t.ailmentT = 4;
                        System.out.println(t.name + " is despairing!"); } } }
        }
        //Handle friendly skills
        if(s.friendly){
            //Handle healing skills
            if(s.type == 7){
                if(!t.unconscious() || t.cHP == t.mHP){
                    a.hasTurn = false;
                    damage = s.castHealing(a, t);
                    if(a.name.equals(t.name)){
                        System.out.println(damage + " healing to themself");
                    } else {
                    System.out.println(damage + " healing to " + t.name); }
                    t.cHP += damage;
                    if(t.cHP >= t.mHP || t.cHP == t.mHP){
                        t.cHP = t.mHP;
                        System.out.println(t.name + "'s HP is maxed out!"); }
                    System.out.println(t.name + "'s HP is " + t.cHP); 
                } else {
                    a.cSP += s.cost;
                    if(t.unconscious()){
                        System.out.println("Target cannot be healed! They must be revived!"); }
                    if(t.cHP == t.mHP){
                        System.out.println("Target does not need healing!"); }
                } }
            //Handle buff skils
            if(s.type >= 10 && s.type <= 15){
                //All buff
                if(s.type == 10){
                    a.hasTurn = false;
                    t.atk = 1;
                    t.atkT += 4;
                    t.def = 1;
                    t.defT += 4;
                    t.acc = 1;
                    t.accT += 4;
                    System.out.println(t.name + "'s ATK/DEF/ACC rose");
                //Singular buffs
                } else {
                    switch(s.type){
                        case 11:
                            a.hasTurn = false;
                            t.atk = 1;
                            t.atkT += 4;
                            System.out.println(t.name + "'s ATK rose");
                            break;
                        case 12:
                            a.hasTurn = false;
                            t.def = 1;
                            t.defT += 4;
                            System.out.println(t.name + "'s DEF rose");
                            break;
                        case 13:
                            a.hasTurn = false;
                            t.acc = 1;
                            t.accT += 4;
                            System.out.println(t.name + "'s ACC rose");
                            break;
                        case 14:
                            a.hasTurn = false;
                            if(t.charge == 1){
                                t.charge = 3;
                                System.out.println(t.name + " is charged and concentrated");
                            } else {
                                t.charge = 2; }
                            System.out.println(t.name + " is concentrated");
                            break;
                        case 15:
                            a.hasTurn = false;
                            if(t.charge == 2){
                               t.charge = 3;
                                System.out.println(t.name + " is charged and concentrated");
                            } else {
                                t.charge = 1; }
                            System.out.println(t.name + " is charged up");
                            break; } } }
            //Handle ailment heal skills
            if(s.type >= 19 && s.type <= 20){
                //Heal magic ailments
                if(s.type == 19){
                    switch(t.ailment){
                        default:
                            System.out.println("Target inapplicable!");
                            a.hasTurn = true;
                            a.cSP += s.cost;
                            break;
                        case 1:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " was cured of their burns!");
                            break;
                        case 2:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " is no longer frozen!");
                            break;
                        case 3:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " is no longer dizzy!");
                            break;
                        case 4:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " is no longer shocked!");
                            break; } }
                if(s.type == 20){
                    switch(t.ailment){
                        default:
                            System.out.println("Target inapplicable!");
                            a.hasTurn = true;
                            a.cSP += s.cost;
                            break;
                        case 5:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " is no longer afraid!");
                            break;
                        case 6:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " was cured of their poison!");
                            break;
                        case 7:
                            a.hasTurn = false;
                            t.ailment = 0;
                            t.ailmentT = 0;
                            System.out.println(t.name + " is no longer despairing!");
                            break;
                    }
                }
            }
        }

        //Print if any ailments were applied
        if(t.ailment != Battle.preAilment){
            t.ailmentCheck(); }
    }

    //Method to use skills that affect multiple actors (ONLY WORKS FOR PARTY)
    public static void useASkill(Actor a, Actor[] targets, Skill s, String choice){
        //Clear the console
        Clear.clear();
        //Reset battle trackers
        Battle.wasCritical = false;
        Battle.missed = false;
        //90% chance to lose turn if fearful
        if(a.ailment == 5){
            if(Math.random() >= 0.10){
                a.hasTurn = false;
                System.out.println(a.name + " is too afraid to move!"); } }
        //Print out the attack name
        System.out.println(a.name + " uses " + s.name + " on all allies!" +  "\n");
        //Subtract HP/SP cost
        if(s.type == 0){
            a.cHP -= s.cost;
        } else {
            a.cSP -= s.cost; }
        //Handle unfriendly attacks
        if(!s.friendly){
            //Cycle through each party actor
            for(Actor t : targets){
                if(t.player){
                    //Handle damage skills
                    if((s.type >= 0 && s.type <= 6) || s.type == 8){
                        switch(t.edocsona.affinities[s.type]){
                            //No affinities
                            default:
                                a.hasTurn = false;
                                damage = s.castDamage(a, t);
                                if(!Battle.missed){
                                    if(Battle.wasCritical){
                                        System.out.println("CRITICAL");
                                        t.down = true;
                                        System.out.println(damage + " damage to " + t.name);
                                        t.cHP -= damage;
                                        t.down = true;
                                        System.out.println(t.name + "'s HP is " + t.cHP + "\n");
                                        t.unconscious(); } }
                                break;
                            //Enemy is weak
                            case 1:
                                a.hasTurn = false;
                                damage = s.castDamage(a, t);
                                if(!Battle.missed){
                                if(!Battle.is1more){
                                    a.hasTurn = true; }
                                    System.out.println("WEAK");
                                    t.cHP -= damage;
                                    t.down = true;
                                    System.out.println(damage + " damage to " + t.name  + "\n");
                                if(!Battle.is1more){
                                    Battle.is1more = true;
                                    System.out.println("1 MORE"); }
                                    System.out.println(t.name + "'s HP is " + t.cHP  + "\n"); }
                                t.unconscious();
                                break;
                            //Enemy resists
                            case 2:
                                a.hasTurn = false;
                                damage = s.castDamage(a, t);
                                System.out.println("RESIST");
                                t.cHP -= damage;
                                System.out.println(damage + " damage to " + t.name);
                                System.out.println(t.name + "'s HP is " + t.cHP  + "\n");
                                t.unconscious();
                                break;
                            //Enemy blocks
                            case 3:
                                a.hasTurn = false;
                                System.out.println("BLOCK");
                                break;
                            //Enemy absorbs
                            case 4:
                                a.hasTurn = false;
                                System.out.println("DRAIN");
                                damage = s.castDamage(a, t);
                                t.cHP += damage;
                                if(t.cHP >= t.mHP){
                                    t.cHP = t.mHP;
                                    System.out.println(t.name + "'s HP is maxed out!");
                                } else {
                                System.out.println(damage + " healed to " + t.name); }
                                System.out.println(t.name + "'s HP is " + t.cHP + "\n");
                                break;
                            //Enemy repels
                            case 5:
                                a.hasTurn = false;
                                System.out.println("REPEL");
                                damage = s.castDamage(a, t);
                                a.cHP -= damage;
                                System.out.println(damage + " to " + a.name);
                                System.out.println(a.name + "'s HP is " + a.cHP + "\n");
                                a.unconscious();
                                break;
                            }
                        }
                        //Handle debuff skills
                        if(s.type >= 10 && s.type <= 13){
                            //All debuff
                            if(s.type == 10){
                                a.hasTurn = false;
                                t.atk = 2;
                                t.atkT = 4;
                                t.def = 2;
                                t.defT = 4;
                                t.acc = 2;
                                t.accT = 4;
                                System.out.println(t.name + "'s ATK/DEF/ACC fell");
                            //Singular debuffs
                            } else {
                                switch(s.type){
                                    case 11:
                                        a.hasTurn = false;
                                        t.atk = 2;
                                        t.atkT = 4;
                                        System.out.println(t.name + "'s ATK fell");
                                        break;
                                    case 12:
                                        a.hasTurn = false;
                                        t.def = 2;
                                        t.defT = 4;
                                        System.out.println(t.name + "'s DEF fell");
                                        break;
                                    case 13:
                                        a.hasTurn = false;
                                        t.acc = 2;
                                        t.accT = 4;
                                        System.out.println(t.name + "'s ACC fell");
                                        break;
                            }
                        }
                    }
                }
            }
            //Restore 1 nore for one critical
            if(Battle.wasCritical && !Battle.is1more){
                a.hasTurn = true;
                Battle.is1more = true;
            }
        }
        //Handle friendly attacks
        if(s.friendly){
            //Cycle through each friendly actor
            for(Actor t : targets){
                if(t.player){
                    if(s.type == 7){
                        if(!t.unconscious()){
                            a.hasTurn = false;
                            damage = s.castHealing(a, t);
                            if(a.name.equals(t.name)){
                                System.out.println(damage + " healing to themself");
                            } else {
                            System.out.println(damage + " healing to " + t.name); }
                            t.cHP += damage;
                            if(t.cHP >= t.mHP || t.cHP == t.mHP){
                                t.cHP = t.mHP;
                                System.out.println(t.name + "'s HP is maxed out!");
                            }
                            System.out.println(t.name + "'s HP is " + t.cHP); } else {
                                System.out.println(t.name + " is unconscious and must be revived first");
                            } 
                        System.out.println("\n"); }
                    //Handle buff skils
                    if(s.type >= 10 && s.type <= 13){
                        //All buff
                        if(s.type == 10){
                            a.hasTurn = false;
                            t.atk = 1;
                            t.atkT = 4;
                            t.def = 1;
                            t.defT = 4;
                            t.acc = 1;
                            t.accT = 4;
                            System.out.println(t.name + "'s ATK/DEF/ACC rose");
                        //Singular debuffs
                        } else {
                            switch(s.type){
                                case 11:
                                    a.hasTurn = false;
                                    t.atk = 1;
                                    t.atkT = 4;
                                    System.out.println(t.name + "'s ATK rose");
                                    break;
                                case 12:
                                    a.hasTurn = false;
                                    t.def = 1;
                                    t.defT = 4;
                                    System.out.println(t.name + "'s DEF rose");
                                    break;
                                case 13:
                                    a.hasTurn = false;
                                    t.acc = 1;
                                    t.accT = 4;
                                    System.out.println(t.name + "'s ACC rose");
                                    break; } } } 
                    //Handle ailment heal skills
                    if(s.type >= 19 && s.type <= 20){
                        //Heal magic ailments
                        if(s.type == 19){
                            switch(t.ailment){
                                default:
                                    System.out.println("Target inapplicable!\n");
                                    a.hasTurn = true;
                                    a.cSP += s.cost;
                                    break;
                                case 1:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " was cured of their burns!\n");
                                    break;
                                case 2:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " is no longer frozen!\n");
                                    break;
                                case 3:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " is no longer dizzy!\n");
                                    break;
                                case 4:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " is no longer shocked!\n");
                                    break; } }
                        if(s.type == 20){
                            switch(t.ailment){
                                default:
                                    System.out.println("Target inapplicable!\n");
                                    a.hasTurn = true;
                                    a.cSP += s.cost;
                                    break;
                                case 5:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " is no longer afraid!\n");
                                    break;
                                case 6:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " was cured of their poison!\n");
                                    break;
                                case 7:
                                    a.hasTurn = false;
                                    t.ailment = 0;
                                    t.ailmentT = 0;
                                    System.out.println(t.name + " is no longer despairing!\n");
                                    break;
                            }
                        }
                    }
                } 
            } 
        } 
    }
                        
    public static void useItem(Actor a, Actor t, Actor[] targets, Item i, String choice){
        //Clear the console
        Clear.clear();
        a.hasTurn = false;
        i.quantity--;
        //Use the item
        if(i.all && i.type != 7){
            Battle.useASkill(a, targets, i, choice);
        } else if (i.all && i.type == 7){
            for(Actor act : targets){
                if(act.player){
                    act.cHP += i.basePower;
                    System.out.println(act.name + " restored " + i.basePower + " HP");
                    if(act.cHP >= act.mHP){
                        act.cHP = act.mHP;
                        System.out.println(act.name + "'s HP is maxed out!\n"); }
                if(i.spRestore){
                    act.cSP += i.basePower;
                    System.out.println(act.name + " restored " + i.basePower + " SP");
                    if(act.cSP >= act.mSP){
                        act.cSP = act.mSP;
                        System.out.println(act.name + "'s HP is maxed out!\n"); } } }
                } } 
        if(!i.all && i.type != 7){
            Battle.useSSkill(a, t, i, choice);
        } else if(!i.all && i.type == 7){
            if(targets[Integer.parseInt(choice) - 1].player){
                    targets[Integer.parseInt(choice) - 1].cHP += i.basePower;
                    System.out.println(targets[Integer.parseInt(choice) - 1].name + " restored " + i.basePower + " HP");
                    if(targets[Integer.parseInt(choice) - 1].cHP >= targets[Integer.parseInt(choice) - 1].mHP){
                        targets[Integer.parseInt(choice) - 1].cHP = targets[Integer.parseInt(choice) - 1].mHP;
                        System.out.println(targets[Integer.parseInt(choice) - 1].name + "'s HP is maxed out!\n"); } }
                if(i.spRestore){
                    targets[Integer.parseInt(choice) - 1].cSP += i.basePower;
                    System.out.println(a.name + " restored " + i.basePower + " HP");
                    if(targets[Integer.parseInt(choice) - 1].cSP >= i.basePower){
                        targets[Integer.parseInt(choice) - 1].cSP = targets[Integer.parseInt(choice) - 1].cSP;
                        System.out.println(targets[Integer.parseInt(choice) - 1].name + "'s HP is maxed out!\n"); } }
        }
    }

    //Method to print out the availble skills of a Docsona
    public static void skillSelector(Actor a){
        Battle.arrCounter = 1;
        for(Skill s : a.edocsona.skills){
            if(s.useable){
                System.out.print(Battle.arrCounter + ". ");
                System.out.println(s.statusString() + "\n");
                Battle.arrCounter++; } }
        System.out.println("9. Cancel");
    }

    //Method to print out the availble items of a Docsona
    public static void itemSelector(Item[] items){
        Battle.arrCounter = 1;
        for(Item s : items){
            if(s.useable){
                System.out.print(Battle.arrCounter + ". ");
                System.out.println(s.quantityCounter() + "\n" + s.desc + "\n");
                Battle.arrCounter++; } }
        System.out.println("9. Cancel");
    }

    //Method that prints a readout of availible targets depending on skill
    public static void targetSelector(Actor a, Actor[] actors, Skill s, String choice){
        Clear.clear();
        if(s.name.equals("Attack")){
            System.out.println("ATTACK\n");
            System.out.println("Attack whom?");
        } else {
            System.out.println("Use " + s.name + " on whom?"); }

        //Single target friendly skills
        if(s.friendly && !s.all){
            Battle.arrCounter = 1;
            for(Actor actor : actors){
                if(actor.player){
                    System.out.print(Battle.arrCounter + ". ");
                    System.out.print(actor.HPString() + "     ");
                    System.out.println(actor.SPString());
                    Battle.arrCounter++; } }
            System.out.println(Battle.arrCounter + ". Cancel");
            
        //Whole party target skills
        } else if(s.friendly && s.all){
            //Skill applies to whole party member, ask for confirmation
            System.out.println("1. All Allies\n2. Cancel");
        }

        //Single target enemy skills
        if(!s.friendly && !s.all){
            //Print out all enemies
            Battle.arrCounter = 1;
            for(Actor actor : actors){
                if(!actor.player){
                    System.out.print(Battle.arrCounter + ". ");
                    System.out.println(actor.HPString());
                    Battle.arrCounter++; } }
                System.out.println(Battle.arrCounter + ". Cancel");
        }
    }

    public static void analysis(Actor[] actors){
        Clear.clear();
        for(Actor a : actors){
            System.out.println(a.HPString() + a.SPString());
            System.out.println("DOCSONA: " + a.edocsona.statusString());
            System.out.println(""); }
    }

    public static void init(){
        Battle.wasRepeled = false;
        Battle.docsonaChanged = false;
        Battle.is1more = false;
        Battle.battleActive = true;
        Battle.battleWon = false;
        System.out.println("Battle.java compiled!\n");
    }
}