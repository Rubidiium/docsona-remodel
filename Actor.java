public class Actor{
    //Create instance variables for each character
    public String name;
    public int cHP;
    public int cSP;
    public int mHP;
    public int mSP;
    //States (Buffs): 0 = None, 1 = 25% Buff, 2 = 25% Debuff
    //States (Timers): 4 Upon Infliction, -- at the end of every turn, cannot go below zero.
    public int atk;
    public int atkT;
    public int def;
    public int defT;
    public int acc;
    public int accT;
    //States (Charge): 0 = None, 1 = 100% Boost to Next Physical, 2 = 100% Boost to Next Magic, 3 = Both
    public int charge;
    //States (Ailement): 0 = None, 1 = Burning (-10% HP), 2 = Frozen (No Turn, 100% Crit), 3 = Dizzy (10% Hit 90% Crit), 4 = Shocked (No Turn, 100% Crit), 5 = Fear (90% Lose Turn), 6 = Poison (-10% HP), 7 = Despair (-5% SP), 10 = Immune to Ailments
    public int ailment;
    public int ailmentT;
    public boolean player;
    public boolean hasTurn;
    public boolean guard;
    public boolean uc;
    public boolean down;
    public Docsona edocsona;

    //Constructor to create each actor
    public Actor(String n, int maxHP, int maxSP, Docsona equippedDocsona){
        name = n;
        cHP = maxHP;
        cSP = maxSP;
        mHP = maxHP;
        mSP = maxSP;
        edocsona = equippedDocsona;
    }

    public void resetState(){
        atk = 0;
        atkT = 0;
        def = 0;
        defT = 0;
        acc = 0;
        accT = 0;
        charge = 0;
        ailment = 0;
        ailmentT = 0;
        hasTurn = true;
        uc = false;
        guard = false;
        down = false;
    }

    //Return the actor as a string in a format compatibile with the battle interface
    public String HPString(){
        return(name + " | HP: " + cHP + " / " + mHP);
    }

    public String SPString(){
        return(" | SP: " + cSP + " / " + mSP);
    }

    //Set the given actor as downed
    public void down(){
        down = true;
    }

    //Change actor's Docsona to parameter
    public void changeDocsona(Docsona newD){
        this.edocsona = newD;
    }

    public void beginTurn(Actor[] actors){
        //Clear the console
        Clear.clear();
        //Handle knockout
        if(this.cHP <= 0 || this.uc){
            this.resetState();
            this.cHP = 0;
            this.hasTurn = false;
            this.uc = true;
            System.out.println(this.name + " is unconscious! They need to be revived before they can go again!");
        } else {
            if(this.down){
                this.down = false;
                System.out.println(this.name + " got back up!\n"); }
            //Only run ailment/buff checks if beginning turn
            if(!Battle.is1more){
                //Reset Battle flags
                Battle.is1more = false;
                Battle.docsonaChanged = false;
                //Print any status regarding buffs/debuffs ending
                this.buffCheck();
                //Lower the ailment timer
                this.ailmentT--;
                //Check for ailment recovery
                if(this.ailment != 0 && this.ailmentT <= 0){
                    this.ailment = 0;
                    System.out.println("Status ailment recovered!\n"); }
                //Print out any active ailments
                
                if(Battle.ailmentPrint == false){
                    this.ailmentCheck(); } }
            //End the turn if frozen or shocked
            switch(this.ailment){
                case 2:
                    this.hasTurn = false;
                    System.out.println(this.name + " is frozen!");
                    break;
                case 4:
                    this.hasTurn = false;
                    System.out.println(this.name + " is shocked!");
                    break; }
        }
    }

    public void headerUI(Actor[] actors){
        //Print the battle UI
        if(this.player){
        this.battleUI(); 
        this.statusUI(actors); } else {
            System.out.println("Codio Avatar's turn!"); }
    }

    public void battleUI(){
        System.out.println("It's " + name + "'s turn!\n\nWhat will you do?\n\n1. Attack\n2. Guard\n3. Docsona\n4. Item\n5. Analysis");
        if(this.name.equals("Vee") && (!Battle.is1more || !Battle.docsonaChanged)){
            System.out.println("6. Change Docsona");
        }
    }

    public void statusUI(Actor[] actors){
        //Reformat each variable to three digits
        String actor1cHP = Integer.toString(actors[0].cHP);
        String actor2cHP = Integer.toString(actors[1].cHP);
        String actor3cHP = Integer.toString(actors[2].cHP);
        String actor4cHP = Integer.toString(actors[3].cHP);

        for(Actor a : actors){
            if(a.player){
                if(a.cHP < 100 && a.cHP >= 10){
                    switch(a.name){
                        case "Vee":
                            actor1cHP = "0" + Integer.toString(a.cHP);
                            break;
                        case "Hinni":
                            actor2cHP = "0" + Integer.toString(a.cHP);
                            break;
                        case "Ed":
                            actor3cHP = "0" + Integer.toString(a.cHP);
                            break;
                        case "Antonio":
                            actor4cHP = "0" + Integer.toString(a.cHP);
                            break; } }
                if(a.cHP < 10){
                    switch(a.name){
                        case "Vee":
                            actor1cHP = "00" + Integer.toString(a.cHP);
                            break;
                        case "Hinni":
                            actor2cHP = "00" + Integer.toString(a.cHP);
                            break;
                        case "Ed":
                            actor3cHP = "00" + Integer.toString(a.cHP);
                            break;
                        case "Antonio":
                            actor4cHP = "00" + Integer.toString(a.cHP);
                            break; } } } }
        
        String actor1cSP = Integer.toString(actors[0].cSP);
        String actor2cSP = Integer.toString(actors[1].cSP);
        String actor3cSP = Integer.toString(actors[2].cSP);
        String actor4cSP = Integer.toString(actors[3].cSP);

        for(Actor a : actors){
            if(a.player){
                if(a.cSP < 100 && a.cSP >= 10){
                    switch(a.name){
                        case "Vee":
                            actor1cSP = "0" + Integer.toString(a.cSP);
                            break;
                        case "Hinni":
                            actor2cSP = "0" + Integer.toString(a.cSP);
                            break;
                        case "Ed":
                            actor3cSP = "0" + Integer.toString(a.cSP);
                            break;
                        case "Antonio":
                            actor4cSP = "0" + Integer.toString(a.cSP);
                            break; } }
                if(a.cSP < 10){
                    switch(a.name){
                        case "Vee":
                            actor1cSP = "00" + Integer.toString(a.cSP);
                            break;
                        case "Hinni":
                            actor2cSP = "00" + Integer.toString(a.cSP);
                            break;
                        case "Ed":
                            actor3cSP = "00" + Integer.toString(a.cSP);
                            break;
                        case "Antonio":
                            actor4cSP = "00" + Integer.toString(a.cSP);
                            break; } } } }
        
        //Print out player status
        System.out.println("\n\n    " + actors[0].name + "        " + actors[1].name + "       " + actors[2].name + "          " + actors[3].name);
        System.out.println("HP: " + actor1cHP + "/" + actors[0].mHP + "    "  + actor2cHP + "/" + actors[1].mHP + "     "  + actor3cHP + "/" + actors[2].mHP + "     "  + actor4cHP + "/" + actors[3].mHP);
        System.out.println("SP: " + actor1cSP + "/" + actors[0].mSP + "    "  + actor2cSP + "/" + actors[1].mSP + "     "  + actor3cSP + "/" + actors[2].mSP + "     "  + actor4cSP + "/" + actors[3].mSP);
        //Print out status buffs
        System.out.print("ATK: ");
        for(Actor a : actors){    
            if(a.player)
                switch(a.atk){
                    default:
                        System.out.print(" -          ");
                        break;
                    case 1:
                        System.out.print(" Ʌ " + a.atkT + "        ");
                        break;
                    case 2:
                        System.out.print(" V " + a.atkT + "        ");
                        break; } }
        System.out.print("\nDEF: ");
        for(Actor a : actors){    
            if(a.player)
                switch(a.def){
                    default:
                        System.out.print(" -          ");
                        break;
                    case 1:
                        System.out.print(" Ʌ " + a.defT + "        ");
                        break;
                    case 2:
                        System.out.print(" V " + a.defT + "        ");
                        break; } }
        System.out.print("\nACC: ");
        for(Actor a : actors){    
            if(a.player)
                switch(a.acc){
                    default:
                        System.out.print(" -          ");
                        break;
                    case 1:
                        System.out.print(" Ʌ " + a.accT + "        ");
                        break;
                    case 2:
                        System.out.print(" V " + a.accT + "        ");
                        break; } }
        System.out.print("\nCHG: ");
        for(Actor a : actors){    
            if(a.player)
                switch(a.charge){
                    default:
                        System.out.print(" -          ");
                        break;
                    case 1:
                        System.out.print(" P " + "         ");
                        break;
                    case 2:
                        System.out.print(" M " + "         ");
                        break;
                    case 3:
                        System.out.print("P+M" + "         "); } }
        System.out.print("\nAIL: ");
        for(Actor a : actors){    
            if(a.player)
                switch(a.ailment){
                    default:
                        System.out.print(" -          ");
                        break;
                    case 1:
                        System.out.print("BUR " + a.ailmentT + "       ");
                        break;
                    case 2:
                        System.out.print("FRZ " + a.ailmentT + "       ");
                        break; 
                    case 3:
                        System.out.print("DIZ " + a.ailmentT + "       ");
                        break;
                    case 4:
                        System.out.print("SHK " + a.ailmentT + "       ");
                        break;     
                    case 5:
                        System.out.print("FEA " + a.ailmentT + "       ");
                        break;
                    case 6:
                        System.out.print("POI " + a.ailmentT + "       ");
                        break;   
                    case 7:
                        System.out.print("DES " + a.ailmentT + "       ");
                        break; } }
        System.out.println("\n-----------------------------\n" + actors[4].HPString());
        System.out.print("ATK: ");
        switch(actors[4].atk){
            default:
                System.out.print(" - |");
                break;
            case 1:
                System.out.print(" Ʌ " + actors[4].atkT + " |");
                break;
            case 2:
                System.out.print(" V " + actors[4].atkT + " |");
                break; }
        System.out.print("DEF: ");
        switch(actors[4].def){
            default:
                System.out.print(" - |");
                break;
            case 1:
                System.out.print(" Ʌ " + actors[4].defT + " |");
                break;
            case 2:
                System.out.print(" V " + actors[4].defT + " |");
                break; }
        System.out.print(" ACC: ");
        switch(actors[4].acc){
            default:
                System.out.print(" - |");
                break;
            case 1:
                System.out.print(" Ʌ " + actors[4].accT + " |");
                break;
            case 2:
                System.out.print(" V " + actors[4].accT + " |");
                break; }
        System.out.print(" CHG: ");
        switch(actors[4].charge){
            default:
                System.out.print(" - ");
                break;
            case 1:
                System.out.print(" P \n");
                break;
            case 2:
                System.out.print(" M \n");
                break;
            case 3:
                System.out.print("P+M\n");
                break; }
        System.out.println("");
    }

    //Check for buffs and debuffs at the beginning of an actor's turn
    public void buffCheck(){
        //String to be built to return feedback
        String expiredBuffs = "";

        //Reset buff timers if a buff was canceled out
        if(this.atk == 0 && this.atkT != 0){
            this.atkT = 0; }
        if(this.def == 0 && this.defT != 0){
            this.defT = 0; }
        if(this.acc == 0 && this.accT != 0){
            this.accT = 0; }

        //Lower all buff timers by 1
        this.atkT--;
        this.defT--;
        this.accT--;
        
        //Raise buff timers to 0
        if(this.atkT < 0) this.atkT = 0;
        if(this.defT < 0) this.defT = 0;
        if(this.accT < 0) this.accT = 0;

        //Reset attack buff/debuff
        if(this.atkT == 0 && this.atk == 1){
            expiredBuffs += "Attack increase ended!\n";
            atk = 0;
        } else if (this.atkT == 0 && this.atk == 2){
            expiredBuffs += "Attack decrease ended!\n";
            atk = 0;
        }

        //Reset defense buff/debuff
        if(this.defT == 0 && this.def == 1){
            expiredBuffs += "Defense increase ended!\n";
            def = 0;
        } else if (this.defT == 0 && this.def == 2){
            expiredBuffs += "Defense decrease ended!\n";
            def = 0;
        }

        //Reset attack buff/debuff
        if(this.accT == 0 && this.acc == 1){
            expiredBuffs += "Accuracy increase ended!\n";
            acc = 0;
        } else if (this.accT == 0 && this.acc == 2){
            expiredBuffs += "Accuracy decrease ended!\n";
            acc = 0;
        }

        if(expiredBuffs.length() > 1){
            System.out.println(expiredBuffs); }
    }

    //Check to run if an actor is unconscious or not
    public boolean unconscious(){
        if(this.cHP == 0){
            this.uc = true;
            this.cHP = 0;
            System.out.println(name + " was knocked unconscious! They need to be revived before they can move again!");
            return true;
        } else {
            return false;
        }
    }

    public void endTurn(){
        int damage = (int)(this.mHP * 0.10);
        //Apply negative effects from ailments
        switch(this.ailment){
            case 1:
                System.out.println(this.name + " took " + damage + " damage from burns");
                this.cHP -= damage;
            case 6:
                System.out.println(this.name + " took " + damage + " damage from poison");
                this.cHP -= damage;
            case 7:
                damage = (int)(this.mSP * 0.05);
                System.out.println(this.name + " lost " + damage + " SP from despair");
                this.cHP -= damage;
        }
    }

    //Method to apply ailment effects at the end of a turn
    public void ailmentCheck(){
        switch(this.ailment){
            //None
            default:
                break;
            //Burn damage
            case 1:
                System.out.println(this.name + " is burning!\nThey'll take damage after their turn!");
                break;
            //Frozen 
            case 2:
                System.out.println(this.name + " is frozen!\nThey won't be able to move!");
                break;
            //Dizzy
            case 3:
                System.out.println(this.name + " is dizzy!\nTheir attacks may not hit!");
                break;
            //Shocked
            case 4:
                System.out.println(this.name + " is shocked!\nThey won't be able to move!");
                break;
            //Fear
            case 5:
                System.out.println(this.name + " is afraid!\nThey may be paralyzed with fear!");
                break;
            //Poison
            case 6:
                System.out.println(this.name + " is poisoned!\nThey'll take damage after their turn!");
                break;
            //Despair
            case 7:
                System.out.println(this.name + " is despairing!\nThey'll lose some spirit after their turn!");
                break;
        }
    }

    public static void init(){
        System.out.println("Actor.java compiled!\n");
    }
}