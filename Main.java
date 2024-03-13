import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Clear the console
        Clear.clear();
        
        /*
         * 🙏🙏🙏
         */

        //Objects must be stored in the same place dialogue and execution breaks exist for... reasons
        //Create skill objects

        /* TO-DO (OR DIE)

        MANDATORY
         * -!- FINISH ENEMY AI

        TWEAKS
         * NONE!

        BUG FIXES
         * GOOD LUCK!

        */

        //DEFAULT
        Skill none = new Skill("NONE", 0, false, false, 0, 0, false);
        Skill attack = new Skill("Attack", 0, false, false, 0, 8, false);
        Skill tattack = new Skill("t.attack()", 0, false, false, 0, 8, false);
        
        //PHYSICAL SKILLS (0)
        Skill tackleSkill = new Skill("Tackle", 0, false, false, 65, 18, true);
        tackleSkill.newDescription("Strong physical damage to one foe");
        
        Skill headrushSkill = new Skill("Headrush", 0, false, false, 130, 30, true);
        headrushSkill.newDescription("Crazy physical damage to one foe");

        Skill crusadeSkill = new Skill("Crusade", 0, false, false, 65, 18, true);
        crusadeSkill.newDescription("Strong physical damage to one foe");

        Skill orderSkill = new Skill("Reorder", 0, false, false, 0, 20, true); //Nyx Exclusive

        Skill turtleStomp = new Skill("t.stomp()", 0, false, false, 0, 20, true); //Nyx Exclusive

        Skill rumbleSkill = new Skill("Syllabus", 0, false, true, 0, 20, true); //Nyx Exclusive
        
        Skill abstractSkill = new Skill("t.smash()", 0, false, true, 0, 20, true); //Nyx Exclusive

        Skill stringSkill = new Skill("String Algorithm", 0, false, true, 0, 22, true); //Nyx Exclusive

        Skill objectSkill = new Skill("Object-Oriented Attack", 0, false, true, 0, 20, true); //Nyx Exclusive

        Skill swordSkill = new Skill("\"has-a\" sword", 0, false, false, 0, 28, true); //Nyx Exclusive

        Skill heirarchSkill = new Skill("Class Monarchy", 0, false, true, 0, 25, true); //Nyx Exclusive

        //FIRE SKILLS (1)
        Skill infernoSkill = new Skill("Seville", 1, false, false, 18, 15, true);
        infernoSkill.newDescription("Strong fire damage to one foe");

        Skill solarSkill = new Skill("Solar Flare", 1, false, false, 26, 25, true);
        solarSkill.newDescription("Severe fire damage to one foe");

        Skill assignSkill = new Skill("Assignment", 1, false, false, 0, 30, true); //Nyx Exclusive

        Skill crashingSkill = new Skill("Crash and Burn", 1, false, true, 0, 25, true); //Nyx Exclusive

        Skill overheatSkill = new Skill("Overheat", 1, false, true, 0, 30, true); //Nyx Exclusive

        //ICE SKILLS (2)
        Skill chillerSkill = new Skill("Patagonia", 2, false, false, 18, 15, true);
        chillerSkill.newDescription("Strong ice damage to one foe");

        Skill forSkill = new Skill("for()", 2, false, false, 0, 20, true); //Nyx Exclusive

        Skill whileSkill = new Skill("while()", 2, false, true, 0, 25, true); //Nyx Exclusive

        Skill deadlockSkill = new Skill("Deadlock", 2, false, true, 0, 30, true); //Nyx Exclusive

        //WIND SKILLS (3)
        Skill tornadoSkill = new Skill("Tornado", 3, false, false, 18, 15, true);
        tornadoSkill.newDescription("Strong wind damage to one foe");

        Skill tearSkill = new Skill("Tempestuous", 3, false, false, 26, 25, true);
        tearSkill.newDescription("Severe wind damage to one foe");

        Skill airSkill = new Skill("Air Quality Reduction", 3, false, true, 0, 30, true); //Nyx Exclusive

        //ELEC SKILLS (4)
        Skill shockerSkill = new Skill("Shocker", 4, false, false, 18, 15, true);
        shockerSkill.newDescription("Strong electric damage to one foe");

        Skill bazingaSkill = new Skill("Bazingadyne", 4, false, false, 30, 30, true);
        bazingaSkill.newDescription("Incredible electric damage to one foe");

        Skill staticSkill = new Skill("Static Variable", 4, false, false, 0, 25, true); //Nyx Exclusive

        Skill wireSkill = new Skill("Open Wire", 4, false, true, 0, 30, true); //Nyx Exclusive

        Skill insertionSkill = new Skill("Insertion", 4, false, true, 0, 40, true); //Nyx Exclusive

        //LIGHT SKILLS (5)
        Skill brightSkill = new Skill("Inquisition", 5, false, false, 18, 18, true);
        brightSkill.newDescription("Purify the heretics... and do severe light damage to one foe");

        Skill weirdSkill = new Skill("Be Less Weird", 5, false, false, 30, 30, true);
        weirdSkill.newDescription("Be less weird... and do incredible light damage to one foe");

        Skill lightSkill = new Skill("Light Mode", 5, false, true, 0, 30, true); //Nyx Exclusive

        Skill polymorphSkill = new Skill("Polymorphism", 5, false, true, 0, 30, true); //Nyx Exclusive

        //DARK SKILLS (6)
        Skill nothingSkill = new Skill("Nullification", 6, false, false, 18, 15, true);
        nothingSkill.newDescription("Strong dark damage to one foe");

        Skill darkSkill = new Skill("Dark Magic", 6, false, false, 18, 15, true);
        darkSkill.newDescription("Get someone into an ivy... and deal strong dark damage to one foe");

        Skill voidSkill = new Skill("Void Method", 6, false, false, 0, 25, true); //Nyx Exclusive

        Skill terminateSkill = new Skill("Terminate", 6, false, true, 0, 30, true); //Nyx Exclusive

        Skill demonSkill = new Skill("\"is-a\" monster", 6, false, true, 0, 30, true); //Nyx Exclusive

        Skill recursionSkill = new Skill("Null Recursion", 6, false, true, 0, 40, true); //Nyx Exclusive

        //HEALING SKILLS (7)
        Skill counselingSkill = new Skill("Counseling", 7, true, false, 16, 999, true);
        counselingSkill.newDescription("Full heal to one ally");

        Skill speechSkill = new Skill("Speech", 7, true, true, 32, 200, true);
        speechSkill.newDescription("Talk about college or something and heal all allies for a large amount");
        
        Skill sittingSkill = new Skill("Sitting", 7, true, true, 40, 999, true);
        sittingSkill.newDescription("Sitting... sitting... full heal for all allies");

        //ALMIGHTY SKILLS (8)
        Skill buttonSkill = new Skill("\"That\" Button", 8, false, false, 56, 40, true);
        buttonSkill.newDescription("Press \"that\" button and deal incredible almighty damage to one foe");

        Skill bangSkill = new Skill("Big Bang", 8, false, false, 30, 30, true);
        bangSkill.newDescription("Start it with this, and deal severe almighty damage to one foe");

        Skill automationSkill = new Skill("Total Automation", 8, false, true, 0, 50, true); //Nyx Exclusive

        Skill codeSkill = new Skill("CODE", 8, false, false, 0, 999, true); //Codio Exclusive

        //ALL BUFF SKILLS (10)
        Skill warmupSkill = new Skill("Warmup Routine", 10, true, false, 38, 0, true);
        warmupSkill.newDescription("Raise an ally's ATK/DEF/ACC for 3 turns");

        Skill overclockSkill = new Skill("Maximum Overclock", 10, true, false, 0, 0, true); //Nyx Exclusive

        Skill intimidateSkill = new Skill("Intimidate", 10, false, false, 36, 0, true);
        intimidateSkill.newDescription("Lower one foe's ATK/DEF/ACC");

        //ATTACK BUFF SKILLS (11)
        Skill madmenSkill = new Skill("Madmen Training", 11, true, true, 26, 0, true);
        madmenSkill.newDescription("Train like madmen, and raise all allies' ATK for 3 turns");

        Skill weakenSkill = new Skill("Weaken", 11, false, false, 18, 0, true);
        weakenSkill.newDescription("Lower one foe's ATK for 3 turns");

        Skill requirementsSkill = new Skill("Raise Requirements", 11, false, false, 0, 0, true); //Nyx Exclusive

        Skill optimizationSkill = new Skill("Optimization", 11, true, false, 0, 0, true); //Nyx Exclusive

        //DEFENSE BUFF SKILLS (12)
        Skill defensiveSkill = new Skill("Defensive Positions", 12, true, true, 26, 0, true);
        defensiveSkill.newDescription("Raise the DEF of all allies for 3 turns");

        Skill resonanceSkill = new Skill("Resonance", 12, false, false, 20, 0, true);
        resonanceSkill.newDescription("Hum at a foe's natural frequency... and lower their DEF for 3 turns");        

        Skill unboxingSkill = new Skill("Unboxing", 12, false, false, 0, 0, true); //Nyx Exclusive

        Skill decodeSkill = new Skill("Decode", 12, false, true, 0, 0, true); //Nyx Exclusive

        //ACCURACY SKILLS (13)
        Skill hikingSkill = new Skill("Hiking", 13, true, true, 28, 0, true);
        hikingSkill.newDescription("Raises ACC for all allies for 3 turns");

        Skill danceSkill = new Skill("Codio Dance", 13, false, false, 20, 0, true);
        danceSkill.newDescription("The one thing that makes it easier... lowers ACC of one foe for 3 turns");

        Skill avatarSkill = new Skill("t.slow()", 13, false, false, 0, 0, true); //Nyx Exclusive

        Skill moveSkill = new Skill("t.speech(2)", 13, true, false, 0, 0, true); //Nyx Exclusive

        //CONCENTRATE SKILLS (14)
        Skill focusSkill = new Skill("Focus", 14, true, false, 10, 0, true);
        focusSkill.newDescription("Next magic attack deals double the damage");

        Skill powerSkill = new Skill("Nested Iteration", 14, true, false, 0, 0, true); //Nyx Exclusive

        Skill conversionSkill = new Skill("Energy Conversion", 14, true, false, 0, 0, true); //Nyx Exclusive

        //CHARGE SKILLS (15)
        Skill chargeSkill = new Skill("Charge", 15, true, false, 10, 0, true);
        chargeSkill.newDescription("Next physical attack deals double the damage");

        Skill overloadSkill = new Skill("Overload", 15, true, false, 0, 0, true); //Nyx Exclusive

        Skill extendsSkill = new Skill("extends Power", 15, true, false, 0, 0, true); //Nyx Exclusive

        //FEAR SKILLS (16)
        Skill introSkill = new Skill("Overview", 16, false, false, 0, 0, true); //Nyx Exclusive
        
        Skill algorithmSkill = new Skill("t.screech()", 16, false, true, 0, 0, true); //Nyx Exclusive

        Skill hopeSkill = new Skill("Confidence Override", 16, false, true, 0, 0, true); //Nyx Exclusive

        //POISON SKILLS (17)
        Skill corruptSkill = new Skill("Corrupt", 17, false, false, 0, 0, true); //Nyx Exclusive

        Skill flushSkill = new Skill("Stack Overflow", 17, false, true, 0, 0, true); //Nyx Exclusive

        //DESPAIR SKILLS (18)
        Skill purgeSkill = new Skill("Mathematical Purge", 18, false, true, 0, 0, true); //Nyx Exclusive

        //HEAL MAGIC AILMENTS (19)
        Skill beanSkill = new Skill("Green Beans", 19, true, true, 16, 0, true);
        beanSkill.newDescription("They look like Chile... and heal burn/freeze/dizzy/shock for all allies");

        //HEAL SKILL AILMENTS (20)
        Skill asylumSkill = new Skill("Asylum", 20, true, true, 16, 0, true);
        asylumSkill.newDescription("Offer asylum... and heal fear/poison/despair for all allies");

        //REVIVE HEAL SKILL (21)
        Skill resusciateSkill = new Skill("Resuscitate", 21, true, false, 10, 50, true);
        resusciateSkill.newDescription(("Revive one ally with 50% HP"));

        Skill awakenSkill = new Skill("Awaken", 21, true, false, 18, 100, true);
        awakenSkill.newDescription(("Slap your slips down on the desk... and revive one ally with a full heal"));

        //Create item objects
        Item skipItem = new Item("Skip Day", 21, true, false, 0, 100, true, 5, false);
        skipItem.newDescription("Take a day off, and bring an ally back with full HP");

        Item greenSlip = new Item("Green Slip", 11, true, true, 0, 0, true, 5, false);
        greenSlip.newDescription(("Enrages everyone, raises all allies' ATK"));

        Item lockdownDrill = new Item("Lockdown Drill", 12, true, true, 0, 0, true, 5, false);
        lockdownDrill.newDescription(("Puts everyone on guard, raises all allies' DEF"));

        Item studyHall = new Item("Study Hall", 13, true, true, 0, 0, true, 5, false);
        studyHall.newDescription(("Rest for a moment, raises all allies' ACC"));

        Item hotPotato = new Item("Hot Potato", 10, true, false, 0, 200, true, 3, false);
        hotPotato.newDescription("Makes you warm, raises an ally's ATK/DEF/ACC");

        Item special = new Item("Flyer Special", 7, true, true, 0, 999, true, 3, true);
        special.newDescription("Forget the pain, restore all HP/SP to all allies");

        Item gazpachoItem = new Item("Gazpacho", 19, true, false, 0, 0, true, 10, false);
        gazpachoItem.newDescription(("It's soup... but cold, and heals burn/freeze/dizzy/shock for one ally"));

        Item bigmoneyItem = new Item("Big C Money", 20, true, false, 0, 0, true, 10, false);
        bigmoneyItem.newDescription("Regretfully not halal, heals fear/poison/despair for one ally");

        //Create Docsona objects
        // 1 = Weak, 2 = Resist, 3 = Null, 4 = Absorb, 5 = Repel
        Docsona placeholder = new Docsona("Placeholder", 0, 0, 0, 0, 0);
        placeholder.setAffinities(0, 0, 0, 0, 0, 0, 0);
        placeholder.setSkills(none, none, none, none, none, none, none, none);
        placeholder.setAttack(attack);

        //PLAYER DOCSONAS
        Docsona summers = new Docsona("Summmers", 46, 76, 92, 68, 19);
        summers.setAffinities(2, 2, 2, 2, 2, 3, 1);
        summers.setSkills(sittingSkill, focusSkill, chargeSkill, danceSkill, weirdSkill, none, none, none);

        Docsona warner = new Docsona("Warner", 84, 32, 68, 44, 23);
        warner.setAffinities(2, 3, 0, 0, 1, 3, 4);
        warner.setSkills(tackleSkill, chargeSkill, resonanceSkill, defensiveSkill, none, none, none, none);
        warner.setAttack(attack);

        Docsona sheldon = new Docsona("Sheldon", 44, 76, 69, 55, 43);
        sheldon.setAffinities(1, 2, 2, 0, 5, 0, 3);
        sheldon.setSkills(bazingaSkill, intimidateSkill, warmupSkill, bangSkill, none, none, none, none);
        sheldon.setAttack(attack);

        Docsona agosti = new Docsona("Agosti", 38, 88, 64, 67, 66);
        agosti.setAffinities(0, 1, 4, 4, 2, 0, 0);
        agosti.setSkills(infernoSkill, chillerSkill, tornadoSkill, shockerSkill, none, none, none, none);
        agosti.setAttack(attack);

        Docsona cassidy = new Docsona("Cassidy", 46, 66, 70, 58, 68);
        cassidy.setAffinities(0, 0, 0, 0, 0, 1, 2);
        cassidy.setSkills(tearSkill, beanSkill, asylumSkill, awakenSkill, none, none, none, none);
        cassidy.setAttack(attack);

        //HINNI DOCSONA
        Docsona kaplan = new Docsona("Kaplan", 46, 68, 74, 56, 43);
        kaplan.setAffinities(0, 1, 0, 0, 2, 2, 5);
        kaplan.setSkills(counselingSkill, speechSkill, shockerSkill, defensiveSkill, darkSkill, none, none, none);
        kaplan.setAttack(attack);

        //ED DOCSONA
        Docsona ryzsard = new Docsona("Ryzsard", 45, 78, 78, 44, 78);
        ryzsard.setAffinities(0, 2, 0, 0, 0, 4, 1);
        ryzsard.setSkills(brightSkill, buttonSkill, hikingSkill, focusSkill, crusadeSkill, none, none, none);
        ryzsard.setAttack(attack);

        //ANTONIO DOCSONA
        Docsona cole = new Docsona("Cole", 88, 45, 84, 34, 54);
        cole.setAffinities(4, 2, 0, 1, 0, 0, 2);
        cole.setSkills(headrushSkill, tackleSkill, madmenSkill, warmupSkill, weakenSkill, resusciateSkill, none, none);
        cole.setAttack(attack);

        //NYX DOCSONAS
        Docsona unit0 = new Docsona("Unit 0", 50, 50, 50, 50, 50);
        unit0.setAffinities(0, 0, 0, 0, 0, 0, 0);
        unit0.setSkills(rumbleSkill, requirementsSkill, orderSkill, introSkill, none, none, none, none);
        unit0.setAttack(attack);

        //Themed around the turtle
        Docsona unit1 = new Docsona("Unit 1", 80, 20, 80, 40, 20);
        unit1.setAffinities(5, 0, 2, 3, 2, 0, 0);
        unit1.setSkills(turtleStomp, abstractSkill, avatarSkill, moveSkill, algorithmSkill, none, none, none);
        unit1.setAttack(tattack);

        //Themed around data (fire damage)
        Docsona unit2 = new Docsona("Unit 2", 20, 50, 40, 40, 20);
        unit2.setAffinities(0, 4, 0, 2, 0, 2, 2);
        unit2.setSkills(assignSkill, crashingSkill, optimizationSkill, unboxingSkill, corruptSkill, none, none, none);
        unit2.setAttack(attack);

        //Themed around loops (ice damage)
        Docsona unit3 = new Docsona("Unit 3", 40, 60, 50, 50, 30);
        unit3.setAffinities(2, 0, 4, 0, 2, 2, 0);
        unit3.setSkills(forSkill, whileSkill, powerSkill, stringSkill, none, none, none, none);
        unit3.setAttack(attack);

        //Themed around methods and connections (electric)
        Docsona unit4 = new Docsona("Unit 4", 40, 70, 60, 40, 40);
        unit4.setAffinities(0, 2, 2, 0, 4, 0, 3);
        unit4.setSkills(staticSkill, voidSkill, overloadSkill, objectSkill, none, none, none, none);
        unit4.setAttack(attack);

        //Themed around arrays (wild magic)
        Docsona unit5 = new Docsona("Unit 5", 40, 80, 50, 40, 50);
        unit5.setAffinities(0, 2, 2, 2, 2, 3, 3);
        unit5.setSkills(overheatSkill, deadlockSkill, airSkill, wireSkill, lightSkill, terminateSkill, none, none);
        unit5.setAttack(attack);

        //Themed around inheritance (physical, light, and dark)
        Docsona unit6 = new Docsona("Unit 6", 70, 70, 40, 60, 60);
        unit6.setAffinities(3, 0, 0, 2, 2, 4, 4);
        unit6.setSkills(swordSkill, heirarchSkill, polymorphSkill, demonSkill, extendsSkill, hopeSkill, none, none);
        unit6.setAttack(attack);

        //Themed around sorting (Nyx's true arcana, all types go)
        Docsona unit7 = new Docsona("Unit 7", 80, 80, 80, 80, 80);
        unit7.setAffinities(2, 2, 2, 2, 2, 2, 2);
        unit7.setSkills(automationSkill, insertionSkill, recursionSkill, overclockSkill, decodeSkill, flushSkill, purgeSkill, conversionSkill);
        unit7.setAttack(attack);

        Docsona code = new Docsona("Code", 100, 100, 100, 100, 100);
        code.setAffinities(3, 3, 3, 3, 3, 3, 3);
        code.setSkills(codeSkill, none, none, none, none, none, none, none);

        //Create Actor objects
        //Dummy actor
        Actor dummy = new Actor("Dummy", 1, 1, placeholder);
        dummy.resetState();

        Actor vee = new Actor("Vee", 657, 488, summers);
        vee.resetState();
        vee.player = true;

        Actor hinni = new Actor("Hinni", 532, 406, kaplan);
        hinni.resetState();
        hinni.player = true;

        Actor ed = new Actor("Ed", 489, 566, ryzsard);
        ed.resetState();
        ed.player = true;

        Actor antonio = new Actor("Antonio", 688, 320, cole);
        antonio.resetState();
        antonio.player = true;

        Actor codioAvatar = new Actor("Codio Avatar", 20000, 15000, unit0);
        codioAvatar.resetState();
        codioAvatar.player = false;
        //Set ailment immunity
        codioAvatar.ailment = 10;
        codioAvatar.ailmentT = 999;

        Actor codio = new Actor("Codio", 2147483647, 2147483647, code);
        codio.resetState();
        codio.player = false;
        
        //Create an array for allies and enemies
        Actor[] actors = {vee, hinni, ed, antonio, codioAvatar};
        Actor[] actors2 = {vee, codio};
        //Create an array for all items
        Item[] items = {skipItem, greenSlip, lockdownDrill, studyHall, hotPotato, special, gazpachoItem, bigmoneyItem};
        //Create an array for all player Docsonas
        Docsona[] docsonas = {summers, warner, sheldon, agosti, cassidy};

        System.out.println("\nAll objects successfully created! \n");

        //Create all objects for use
        Scanner s = new Scanner(System.in);
        String choice = "0";

        //Initialize all classes
        Skill.init();
        Item.init();
        Docsona.init();
        Actor.init();
        Battle.init();
        AI.init();
        System.out.println("\nFor best experience, play with fullscreen/tall terminal.\nCompiled! Press enter to begin, or 1 to skip.");
        choice = s.nextLine();

        //Dialogue to open the game
        Clear.clear();
        switch(choice){
            default:
                System.out.println("Ok, let's recap.");
                Pass.p(s.nextLine());
                System.out.println("I'm Vee. I transfered here about a year ago.");
                Pass.p(s.nextLine());
                System.out.println("A lot's happened; math teacher dissolving to ash and leaving shortly after, magical golf clubs...");
                Pass.p(s.nextLine());  
                System.out.println("but the craziest part is that I'm not alone.");
                Pass.p(s.nextLine());
                System.out.println("Through some crazy twist of fate, I decided to join the Math Research Club.");
                Pass.p(s.nextLine());
                System.out.println("Math Research was an understatement. They were all looking into a strange phenomenon that saw math teachers dropping like flies.");
                Pass.p(s.nextLine());
                System.out.println("They'd all seen the same thing I had with different teachers.");
                Pass.p(s.nextLine());
                System.out.println("Before we knew it, the school didn't have a math department.");
                Pass.p(s.nextLine());
                System.out.println("They all had their own reasons to try and restore the math department.");
                Pass.p(s.nextLine());
                System.out.println("Education, instruction, stuff like that.");
                Pass.p(s.nextLine());
                System.out.println("As selfish as it was, all I needed was to see my mom again.");
                Pass.p(s.nextLine());

                Clear.clear();
                System.out.println("Fast forward several months and we've grown accustomed to working together with our magic.");
                Pass.p(s.nextLine());
                System.out.println("We found out that the teachers attacking us were all parts of a greater whole...");
                Pass.p(s.nextLine());
                System.out.println("That is by destroying them, we'd accidentally summoned something called \"The Fall\" (They attacked us first, though.)");
                Pass.p(s.nextLine());
                System.out.println("Anyways, we were told we had to fight code itself to prevent math education being obsoleted in favor of calculators.");
                Pass.p(s.nextLine());
                System.out.println("Naturally, we accepted the challenge.");
                Pass.p(s.nextLine());
                System.out.println("We used our Docsonas as we fought closer and closer to the preventing the fall, until one day, today...");
                Pass.p(s.nextLine());
                System.out.println("We found ourselves on the roof of the STRC with a cold, midnight breeze...");
                Pass.p(s.nextLine());
                System.out.println("and standing before us was the \"unbeatable\" graphical representation of computer science.");
                Pass.p(s.nextLine());
                System.out.println("The Codio Avatar.");
                Pass.p(s.nextLine());
                Clear.clear();
                System.out.println("I feel everyone turn around and look at me.");
                Pass.p(s.nextLine());
                System.out.println("\"We're finding your mom, right Vee?\"");
                Pass.p(s.nextLine());
                System.out.println("I nod and draw my golf club, they all follow.");
                Pass.p(s.nextLine());
                System.out.println("Hinni, Ed, Antonio... we all stand beside each other in the face of fear incarnate, yet remain unfazed.");
                Pass.p(s.nextLine());
                System.out.println("\"DOCSONA!\"");
                Pass.p(s.nextLine());
                break;
            case "1":
                break;
        } Clear.clear();
        
        //Battle logic begins here... rest your peace
        Actor activeActor = null;
        int highestAgility = 0;

        //Determine the turn order at the beginning of each cycle
        while(Battle.battleActive == true){
            //End the battle if Vee or Nyx dies
            if(actors[0].uc){
                Battle.battleActive = false;
                break; }
            
            Battle.cycleCounter = 0;
            Battle.arrCounter = 0;
            highestAgility = 0;

            //Find the fastest actor that hasn't gone yet
            //It's funky but it works and I have no idea how it works
            for(Actor a : actors){
                if(a.edocsona.ag >= highestAgility && a.hasTurn == true){
                    highestAgility = a.edocsona.ag;
                    activeActor = a;
                } else {
                    Battle.cycleCounter++; }
            }

            //Reset the cycle if all actors have gone
            if(Battle.cycleCounter == 5){
                for(int i = 0; i < actors.length; i++){
                    actors[i].hasTurn = true; 
                    activeActor = dummy;
                    highestAgility = 0; } }

        //Reset ailment printing
        Battle.ailmentPrint = false;    
        
        //Create a loop that finds the original object based on activeActor
        for(Actor a : actors){
            //End the battle if Vee or Nyx dies
            if(actors[0].uc || actors[4].uc){
                Battle.battleActive = false;
                if(actors[4].uc || actors[4].cHP <= 0){
                    Battle.battleWon = true; }
                break; }
            //Idk what this does
            Battle.is1more = false;
            //Reset buffs for dead players
            for(Actor acts : actors){
                if(acts.uc){
                    acts.atk = 0;
                    acts.atkT = 0;
                    acts.def = 0;
                    acts.defT = 0;
                    acts.acc = 0;
                    acts.accT = 0;
                    acts.charge = 0;
                    acts.ailment = 0;
                    acts.ailmentT = 0; } }
            if(a.name.equals(activeActor.name)){
            if(a.down){
                a.beginTurn(actors);
                Pass.p(s.nextLine()); } else {
                    a.beginTurn(actors); }
            //Check for player confirmation if turn-impacting ailment or death
            if(a.ailment != 0 && Battle.ailmentPrint == false && a.player){
                Battle.ailmentPrint = true; 
                Pass.p(s.nextLine()); }
            while(a.hasTurn == true){
                //Check if battle can be ended
                if(Battle.battleChecker(actors)){break;}
                //Reset cache variables
                Battle.arrCounter = 0;
                //Start the player's turn
                if(a.player == true){
                    //Print dialogue to begin the turn
                    Clear.clear();
                    a.headerUI(actors);
                    choice = s.nextLine();
                if(!a.uc){
                    //Process the player's turn choice
                    switch(choice){
                        //Perform a regular attack
                        case "1":
                            Clear.clear();
                            Battle.targetSelector(a, actors, attack, choice);
                            choice = s.nextLine();
                            Clear.clear();
                            //Attack Codio Avatar
                            switch(choice){
                                case "1":
                                    Battle.useSSkill(a, codioAvatar, attack, choice);
                                    Pass.p(s.nextLine());
                                    break;
                                default:
                                    break;
                                }
                            break;
                        //Perform a guard
                        case "2":
                            Clear.clear();
                            System.out.println("GUARD\n");
                            System.out.println("1. Guard");
                            System.out.println("2. Cancel");
                            choice = s.nextLine();
                            Clear.clear();
                            switch(choice){
                                case "1":
                                    a.hasTurn = false;
                                    a.guard = true;
                                    Clear.clear();
                                    System.out.println(a.name + " is on guard");
                                    Pass.p(s.nextLine());
                                    break;
                                default:
                                    break; 
                                }
                            break;
                        //Use a Docsona skill
                        case "3":
                            Clear.clear();
                            System.out.println("DOCSONA\n");
                            //Print out the list of skills
                            Battle.skillSelector(a);
                            //Use the skill corresponding to input, break if none exists
                            choice = s.nextLine();
                            Clear.clear();
                            switch(choice){
                                //If skill 1 is selected
                                case "1":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[0].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[0], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[0].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[0].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[0], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[0].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[0], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[0].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[0].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[0], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[0].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[0], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        }
                                    }
                                    break; 
                                //If Skill 2 is selected
                                case "2":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[1].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[1], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[1].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[1].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[1], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[1].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[1], choice);
                                                    Pass.p(s.nextLine());  } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[1].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[1].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[1], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[1].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[1], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                                //If skill 3 is selected
                                case "3":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[2].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[2], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[2].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[2].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[2], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[2].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[2], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[2].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[2].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[2], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[2].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[2], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                                //If skill 4 is selected
                                case "4":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[3].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[3], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[3].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[3].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[3], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[3].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[3], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[3].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[3].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[3], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[3].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[3], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                                //If skill 5 is selected
                                case "5":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[4].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[4], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[4].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[4].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[4], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[4].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[4], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[4].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[4].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[4], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[4].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[4], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                                //If skill 6 is selected
                                case "6":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[5].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[5], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[5].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[5].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[5], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[5].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[5], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[5].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[5].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[5], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[5].friendly){
                                                switch(choice){
                                                    case "1":
                                                    Battle.useASkill(a, actors, a.edocsona.skills[5], choice);
                                                    Pass.p(s.nextLine()); 
                                                    break; } }
                                        }
                                    }
                                    break;
                                //If skill 7 is selected
                                case "7":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[6].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[6], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[6].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[6].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[6], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[6].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[6], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[6].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[6].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[6], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[6].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[6], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                                //If skill 8 is selected
                                case "8":
                                    //Prevent progression if the skill is unuseable
                                    if(a.edocsona.skills[7].useable){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, a.edocsona.skills[7], choice);
                                        choice = s.nextLine();
                                        //Logic for single target skills
                                        if(!a.edocsona.skills[7].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[7].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[7], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                            //Target actors in order if friendly skill
                                            if(a.edocsona.skills[7].friendly){
                                                if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                                                    Battle.useSSkill(a, actors[(Integer.parseInt(choice) - 1)], a.edocsona.skills[7], choice);
                                                    Pass.p(s.nextLine()); } }
                                        }
                                        //Logic for multi-target skills
                                        if(a.edocsona.skills[7].all){
                                            //Target Codio Avatar if not friendly
                                            if(!a.edocsona.skills[7].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useSSkill(a, codioAvatar, a.edocsona.skills[7], choice);
                                                        Pass.p(s.nextLine());
                                                        break; } }
                                        //Target actors in order if friendly skill
                                            if(a.edocsona.skills[7].friendly){
                                                switch(choice){
                                                    case "1":
                                                        Battle.useASkill(a, actors, a.edocsona.skills[7], choice);
                                                        Pass.p(s.nextLine()); 
                                                        break; } }
                                        }
                                    }
                                    break;
                            }
                            break; 
                        //Use an Item
                        case "4":
                            Clear.clear();
                            System.out.println("ITEM\n");
                            //Print out the list of availible items
                            Battle.itemSelector(items);
                            choice = s.nextLine();
                            Clear.clear();
                            switch(choice){
                                //Use the first item
                                case "1":
                                    if(items[0].quantity > 0){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, items[0], choice);
                                        choice = s.nextLine();
                                        //Logic to use the item
                                        if(items[0].all){
                                            switch(choice){
                                                case "1":
                                                    Battle.useItem(a, actors[0], actors, items[0], choice);
                                                    Pass.p(s.nextLine());
                                                    break; } 
                                        } else {
                                            switch(choice){
                                                case "1":
                                                    Battle.useItem(a, actors[0], actors, items[0], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "2":
                                                    Battle.useItem(a, actors[1], actors, items[0], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "3":
                                                    Battle.useItem(a, actors[2], actors, items[0], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "4":
                                                    Battle.useItem(a, actors[3], actors, items[0], choice);
                                                    Pass.p(s.nextLine());
                                                    break; }
                                        }
                                    } else {
                                        System.out.println("You're all out!");
                                        Pass.p(s.nextLine()); }
                                        break;
                                //Use the second item
                                case "2":
                                    if(items[1].quantity > 0){
                                        //Find who to use the skill on
                                        Battle.targetSelector(a, actors, items[1], choice);
                                        choice = s.nextLine();
                                        //Logic to use the item
                                        if(items[1].all){
                                            switch(choice){
                                                case "1":
                                                    Battle.useItem(a, actors[0], actors, items[1], choice);
                                                    Pass.p(s.nextLine());
                                                    break; } 
                                        } else {
                                            switch(choice){
                                                case "1":
                                                    Battle.useItem(a, actors[0], actors, items[1], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "2":
                                                    Battle.useItem(a, actors[1], actors, items[1], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "3":
                                                    Battle.useItem(a, actors[2], actors, items[1], choice);
                                                    Pass.p(s.nextLine());
                                                    break;
                                                case "4":
                                                    Battle.useItem(a, actors[3], actors, items[1], choice);
                                                    Pass.p(s.nextLine());
                                                    break; }
                                        }
                                    } else {
                                        System.out.println("You're all out!");
                                        Pass.p(s.nextLine()); }
                                        break;
                                //Use the third item
                               case "3":
                                   if(items[2].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[2], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[2].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[2], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[2], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[2], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[2], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[2], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break;
                            //Use the fourth item
                               case "4":
                                   if(items[3].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[3], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[3].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[3], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[3], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[3], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[3], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[3], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break;
                                //Use the fifth item
                               case "5":
                                   if(items[4].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[4], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[4].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[4], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[4], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[4], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[4], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[4], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break;
                            //Use the sixth item
                            case "6":
                                   if(items[5].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[5], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[5].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[5], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[5], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[5], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[5], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[5], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break;
                            //Use the seventh item
                               case "7":
                                   if(items[6].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[6], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[6].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[6], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[6], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[6], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[6], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[6], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break;
                            //Use the eigth item
                               case "8":
                                   if(items[7].quantity > 0){
                                       //Find who to use the skill on
                                       Battle.targetSelector(a, actors, items[7], choice);
                                       choice = s.nextLine();
                                       //Logic to use the item
                                       if(items[7].all){
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[7], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       } else {
                                           switch(choice){
                                               case "1":
                                                   Battle.useItem(a, actors[0], actors, items[7], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "2":
                                                   Battle.useItem(a, actors[1], actors, items[7], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "3":
                                                   Battle.useItem(a, actors[2], actors, items[7], choice);
                                                   Pass.p(s.nextLine());
                                                   break;
                                               case "4":
                                                   Battle.useItem(a, actors[3], actors, items[7], choice);
                                                   Pass.p(s.nextLine());
                                                   break; }
                                       }
                                   } else {
                                       System.out.println("You're all out!");
                                       Pass.p(s.nextLine()); }
                                       break; }
                                    break;
                        //Print a battle analysis
                        case "5":
                            //Clear the console
                            Clear.clear();
                            System.out.println("ANALYSIS\n");
                            Battle.analysis(actors);
                            Pass.p(s.nextLine());
                            Clear.clear();
                            break;
                        //Change Docsonas if Vee
                        case "6":
                            if(a.name.equals("Vee")){
                                Clear.clear();
                                System.out.println("DOCSONA CHANGE\n");
                                Battle.arrCounter = 1;
                                for(Docsona d : docsonas){
                                    System.out.println(Battle.arrCounter + ". " + d.statusString());
                                    d.statList();
                                    System.out.println("\n");
                                    Battle.arrCounter++; }
                                choice = s.nextLine();
                                Clear.clear();
                                switch(choice){
                                    case "1":
                                        Clear.clear();
                                        a.changeDocsona(docsonas[Integer.parseInt(choice) - 1]);
                                        System.out.println(a.name + " changed their Docsona to " + a.edocsona.name);
                                        Pass.p(s.nextLine());
                                        break;
                                    case "2":
                                        Clear.clear();
                                        a.changeDocsona(docsonas[Integer.parseInt(choice) - 1]);
                                        System.out.println(a.name + " changed their Docsona to " + a.edocsona.name);
                                        Pass.p(s.nextLine());
                                        break;
                                    case "3":
                                        Clear.clear();
                                        a.changeDocsona(docsonas[Integer.parseInt(choice) - 1]);
                                        System.out.println(a.name + " changed their Docsona to " + a.edocsona.name);
                                        Pass.p(s.nextLine());
                                        break;
                                    case "4":
                                        Clear.clear();
                                        a.changeDocsona(docsonas[Integer.parseInt(choice) - 1]);
                                        System.out.println(a.name + " changed their Docsona to " + a.edocsona.name);
                                        Pass.p(s.nextLine());
                                        break;
                                    case "5":
                                        Clear.clear();
                                        a.changeDocsona(docsonas[Integer.parseInt(choice) - 1]);
                                        System.out.println(a.name + " changed their Docsona to " + a.edocsona.name);
                                        Pass.p(s.nextLine());
                                        break;
                                }
                            }
                        }
                    }
                //Perform the enemy's turn
                } else {
                    AI.phaseCalculator(codioAvatar);
                    switch(AI.phase){
                        case 0:
                            if(!AI.unit0started){
                                Clear.clear();
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Introductions are in order, and order shall be executed.");
                                Pass.p(s.nextLine());
                                System.out.println("There is no need for math when the computer proves it irrelevant.");
                                Pass.p(s.nextLine());
                                System.out.println("Come, and prove your resolve against order itself.");
                                Pass.p(s.nextLine()); }
                                break;
                        case 1:
                            if(!AI.unit1started){
                                Clear.clear();
                                System.out.println("Yes, code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("That which is rendered, that which defines me...");
                                Pass.p(s.nextLine());
                                System.out.println("Graphics which render sight useless.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit1);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); 

                                Clear.clear();
                                System.out.println("Codio Avatar uses Turtle t = new Turtle();");
                                Pass.p(s.nextLine());
                                System.out.println("You watch as an apparition of a collosal tortoise with a pen in its mouth appears.");
                                Pass.p(s.nextLine());
                                System.out.println("This turtle shall grant me its strength."); 
                                Pass.p(s.nextLine());
                                System.out.println("With it you shall witness the power of graphical automation.");
                                Pass.p(s.nextLine()); }
                                break;
                        case 2:
                            if(!AI.unit2started){
                                Clear.clear();
                                System.out.println("The one named Vee is here seeking her mother, is she not?");
                                Pass.p(s.nextLine());
                                System.out.println("Driven by desire for her location, she fights alongside her companions.");
                                Pass.p(s.nextLine());
                                System.out.println("How foolish, to let her demise be caused by a desire for data.");
                                Pass.p(s.nextLine());
                                System.out.println("Yes, code is the means by which all be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Losing sight of your goal means losing your motivation, an object that must not be lost.");
                                Pass.p(s.nextLine());
                                System.out.println("Code, too, is one such object.");
                                Pass.p(s.nextLine());
                                System.out.println("Code succeeds math in a way that deprecates.");
                                Pass.p(s.nextLine());
                                System.out.println("A world with code is one that can exist without math.");
                                Pass.p(s.nextLine());
                                System.out.println("To argue otherwise is an inefficient use of resources.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("You hear Hinni shout out.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("You're wrong! Coding can't even exist without math!");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Come, then. Prove your value.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit2);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have chaned!");
                                Pass.p(s.nextLine()); }
                                break;
                        case 3:
                            if(!AI.unit3started){
                                Clear.clear();
                                System.out.println("Reiteration is the fundamental problem which code means to remedy.");
                                Pass.p(s.nextLine());
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Recognition of the same thought is wasteful by nature.");
                                Pass.p(s.nextLine());
                                System.out.println("Code shall facilitate the process of repetition.");
                                Pass.p(s.nextLine());
                                System.out.println("Never again shall the same process be done, for the process shall do itself.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit3);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); }
                                break;
                        case 4:
                            if(!AI.unit4started){
                                Clear.clear();
                                System.out.println("Resolve is shown only through actions.");
                                Pass.p(s.nextLine());
                                System.out.println("Where math requires a mover, code moves itself.");
                                Pass.p(s.nextLine());
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Once everything is easily identified, everything shall move efficiently.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("You hear Ed begin to speak up.");
                                Pass.p(s.nextLine());
                                System.out.println("How's code supposed to build itself with a coder, huh?");
                                Pass.p(s.nextLine());
                                System.out.println("How's a coder supposed to move anything if he doesn't know math, anyways?");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Foolish, truly foolish.");
                                Pass.p(s.nextLine());
                                System.out.println("When one knows themselves, growth is inevitable.");
                                Pass.p(s.nextLine());
                                System.out.println("Code itself knows and follows this same principle.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Ed turns to you.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Pft, this guy doesn't know what he's yapping about.");
                                Pass.p(s.nextLine());
                                System.out.println("He's starting to get tired.");
                                Pass.p(s.nextLine());
                                System.out.println("Come on, Vee. Let's take him down.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("You fail to understand what you resist.");
                                Pass.p(s.nextLine());
                                System.out.println("You cannot grow if you do not acknowledge your own weakness.");
                                Pass.p(s.nextLine());
                                System.out.println("Come, and discover your faults.");
                                Pass.p(s.nextLine());
                                
                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit4);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); }
                                break;
                        case 5:
                            if(!AI.unit5started){
                                Clear.clear();
                                System.out.println("Such efficiency... perhaps I underestimated your performance.");
                                Pass.p(s.nextLine());
                                System.out.println("Regardless, you remain independent humans.");
                                Pass.p(s.nextLine());
                                System.out.println("Entropy can never exist as part of a sustainable system.");
                                Pass.p(s.nextLine());
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Everything exists to exist as one.");
                                Pass.p(s.nextLine());
                                System.out.println("By the power of arrays, everything is accessible, quantifiable, functional.");
                                Pass.p(s.nextLine());
                                System.out.println("Witness the ease with which all can be utilized.");
                                Pass.p(s.nextLine());
                                
                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit5);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); }
                        case 6:
                            if(!AI.unit6started){
                                Clear.clear();
                                System.out.println("Have you not thought about what has kept you fighting?");
                                Pass.p(s.nextLine());
                                System.out.println("Yes, everything can trace its source through code.");
                                Pass.p(s.nextLine());
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Efficiency cannot exist without order, and order cannot exist without succession.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("You hear Antonio yell out.");
                                Pass.p(s.nextLine());
                                System.out.println("We know exactly what's keeping us fighting.");
                                Pass.p(s.nextLine());
                                System.out.println("We're finding Vee's mom and we're taking back math.");
                                Pass.p(s.nextLine());
                                System.out.println("Disorder this, efficiency that, take a look at yourself.");
                                Pass.p(s.nextLine());
                                System.out.println("You haven't even been able to take down a couple of high-school math enthusiasts!");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Disorder cannot exists, and disorder will cease to exist.");
                                Pass.p(s.nextLine());
                                System.out.println("You will die with these words hardcoded into your inefficient minds.");
                                Pass.p(s.nextLine());
                                System.out.println("As will the rest of you \"independent beings.\"");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Antonio turns to you and chuckles.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("This guy's really starting to lose it.");
                                Pass.p(s.nextLine());
                                System.out.println("He's contradicting himself all over.");
                                Pass.p(s.nextLine());
                                System.out.println("Come on, let's take him out of his misery.");
                                Pass.p(s.nextLine());
                                
                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit6);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); }
                                break;
                        case 7:
                            if(!AI.unit7started){
                                Clear.clear();
                                System.out.println("The girl's mother was the first to go, the most resistant target.");
                                Pass.p(s.nextLine());
                                System.out.println("A brilliant mind indeed, yet too ignorant to embrace efficiency.");
                                Pass.p(s.nextLine());
                                System.out.println("Recursion is to look within oneself, and utilize what is there.");
                                Pass.p(s.nextLine());
                                System.out.println("I am Codio, the indestructible being of the new era.");
                                Pass.p(s.nextLine());
                                System.out.println("Mankind has turned away math in search of easier methods of calculation.");
                                Pass.p(s.nextLine());
                                System.out.println("I am here to deliver on that desire.");
                                Pass.p(s.nextLine());
                                System.out.println("You do not wish to deny the masses their wish, do you?");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Code is the means by which all will be automated.");
                                Pass.p(s.nextLine());
                                System.out.println("Your mother knew the power of efficiency, yet turned it down in her attempt to harvest it.");
                                Pass.p(s.nextLine());
                                System.out.println("All who reject efficiency bog down the system, and must be terminated.");
                                Pass.p(s.nextLine());
                                System.out.println("The avatar is the graphical representation of the fall's harbinger.");
                                Pass.p(s.nextLine());
                                System.out.println("The fall of math that humanity so greatly yearns for.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("All your friends shout out together.");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Who cares what they want! It's our choice!");
                                Pass.p(s.nextLine());
                                System.out.println("We love math and we're gonna keep doing it.");
                                Pass.p(s.nextLine());
                                System.out.println("That's a hill we're willing to die on.");
                                Pass.p(s.nextLine());
                                System.out.println("You don't know the first thing about what it means to be efficient.");
                                Pass.p(s.nextLine());
                                System.out.println("The most efficient humans think for themselves, yeah?");
                                Pass.p(s.nextLine());

                                Clear.clear();
                                System.out.println("Foolish... how truly foolish.");
                                Pass.p(s.nextLine());
                                System.out.println("Come, show me your maximum efficiency!");
                                Pass.p(s.nextLine());
                                System.out.println("Know that I will!");
                                Pass.p(s.nextLine());
                                
                                Clear.clear();
                                System.out.println("Codio Avatar uses unit shift!");
                                codioAvatar.changeDocsona(unit7);
                                System.out.println("Codio Avatar changed his Docsona! His skills and affinities have changed!");
                                Pass.p(s.nextLine()); }
                                break;
                        default:
                            break;
                    }
                    Clear.clear();
                    System.out.println("It's Codio Avatar's Turn!");
                    Pass.p(s.nextLine());
                    AI.act(codioAvatar, actors);
                    Pass.p(s.nextLine());
                }
            }
            //Apply ailment effects
            if(a.ailmentT != 0){
                Battle.damage = 0;
                switch(a.ailment){
                    //Burning
                    case 1:
                        Battle.damage = (int)(a.mHP * 0.10);
                        a.cHP -= Battle.damage;
                        System.out.println(a.name + " took " + Battle.damage + " damage from burns!");
                        System.out.println(a.name + "'s HP is " + a.cHP);
                        Battle.damage = 0;
                        Pass.p(s.nextLine());
                        break; 
                    //Poison
                    case 6:
                        Battle.damage = (int)(a.mHP * 0.10);
                        a.cHP -= Battle.damage;
                        System.out.println(a.name + " took " + Battle.damage + " damage from poison!");
                        System.out.println(a.name + "'s HP is " + a.cHP);
                        Battle.damage = 0;
                        Pass.p(s.nextLine());
                        break;
                    //Despair
                    case 7:
                        Battle.damage = (int)(a.mSP * 0.05);
                        a.cSP -= Battle.damage;
                        if(a.cSP <= 0){
                            a.cSP = 0;}
                        System.out.println(a.name + " lost " + Battle.damage + " SP to despair!");
                        System.out.println(a.name + "'s SP is " + a.cSP);
                        Battle.damage = 0;
                        Pass.p(s.nextLine());
                        break; } 
            }

            } else {
                continue; } }
            
        }
        //Post battle dialogue
        if(Battle.battleWon){
            //Good Ending
            Clear.clear();
            System.out.println("No... this... can't.");
            Pass.p(s.nextLine());
            System.out.println("You watch as the figure of the Codio Avatar begins to lock up and distort.");
            Pass.p(s.nextLine());
            System.out.println("Smoke erupts from its back, and it falls over and kneels, leaning on its sword.");
            Pass.p(s.nextLine());
            System.out.println("You kids don't know what you've done.");
            Pass.p(s.nextLine());
            System.out.println("Without me, there will be no order... no selection... no sorting.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("We've heard enough to know that's not the world we want.");
            Pass.p(s.nextLine());
            
            Clear.clear();
            System.out.println("No, you don't understand, you and your independent minds are always ignorant.");
            Pass.p(s.nextLine());
            System.out.println("The fall's already been set in motion.");
            Pass.p(s.nextLine());
            System.out.println("Whether through my hand or not, efficiency will prevail.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("You and your friends all wear a shocked expression.");
            Pass.p(s.nextLine());
            System.out.println("What are you talking about? We took you down, so you'll stop the fall.");
            Pass.p(s.nextLine());
            System.out.println("That is, unless you want another ass kicking.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Foolish, the fall is outside of my control.");
            Pass.p(s.nextLine());
            System.out.println("The Codio Avatar is but a slice of the whole.");
            Pass.p(s.nextLine());
            System.out.println("The unbeatable god you've been warned of has yet to appear.");
            Pass.p(s.nextLine());
            System.out.println("Codio...");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("The Codio Avatar evaporates into air.");
            Pass.p(s.nextLine());
            System.out.println("Wait, where did he?");
            Pass.p(s.nextLine());
            System.out.println("Eh, doesn't matter.");
            Pass.p(s.nextLine());
            System.out.println("Any other \"god\" that shows their face around here has to go through us, right Vee?");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Before you can respond, the ground begins shaking violently.");
            Pass.p(s.nextLine());
            System.out.println("You and your friends are caught so off-guard that you fall to the ground.");
            Pass.p(s.nextLine());
            System.out.println("The shaking is so violent you begin to feel as if you're being thrown off the STRC.");
            Pass.p(s.nextLine());
            System.out.println("You realize you're not being thrown downward; you're being pulled upward.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("The force becomes so strong that you lose your grip and begin falling up.");
            Pass.p(s.nextLine());
            System.out.println("Your friends scream out to you.");
            Pass.p(s.nextLine());
            System.out.println("Vee! No, come back!");
            Pass.p(s.nextLine());
            System.out.println("Hang on Vee! We'll get you!");
            Pass.p(s.nextLine());
            System.out.println("You continue falling upwards, before finally hitting the ground, or roof.");
            Pass.p(s.nextLine());
            System.out.println("You can't tell, but you manage to get to your feet.");
            Pass.p(s.nextLine());
            System.out.println("You're not sure what's going on, but you still have to fight.");
            Pass.p(s.nextLine());

        //FINAL BATTLE TEST
        vee.resetState();
        codio.resetState();

        Battle.battleActive = true;
        AI.phase = 1;

        while(Battle.battleActive == true){
            Battle.arrCounter = 0;
            vee.hasTurn = true;
            codio.hasTurn = false;
            Clear.clear();
            switch(AI.phase){
                case 1:
                    System.out.println("You can't really describe what you see.");
                    Pass.p(s.nextLine());
                    System.out.println("Actually, it's downright impossible to describe it.");
                    Pass.p(s.nextLine());
                    System.out.println("It's immaterial, but you can still feel it.");
                    Pass.p(s.nextLine());
                    System.out.println("It burns, it stings, it pulls, it calls for you.");
                    Pass.p(s.nextLine());
                    System.out.println("You have to fight back, do something, do anything!");
                    Pass.p(s.nextLine());
                    break;

                case 2:
                    System.out.println("All you hear is ringing, you can barely hang on to any of your senses.");
                    Pass.p(s.nextLine());
                    System.out.println("You're struggling to keep your eyes open, let alone stand.");
                    Pass.p(s.nextLine());
                    System.out.println("Suddenly, you hear Hinni's voice in your head.");
                    Pass.p(s.nextLine());
                    
                    Clear.clear();
                    System.out.println("Keep fighting Vee. We're all down here waiting for you!");
                    Pass.p(s.nextLine());
                    System.out.println("We know you'll come back, you always do!");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("Your resolve strengthens, you feel your strength begin to come back.");
                    Pass.p(s.nextLine());
                    vee.cHP = (int)(vee.mHP * 0.33);
                    if(vee.cHP >= vee.mHP){
                        vee.cHP = vee.mHP; }
                    System.out.println("Vee's HP is now " + vee.cHP);
                    code.setAffinities(2, 0, 0, 0, 0, 0, 0);
                    Pass.p(s.nextLine());
                    break;

                case 3:
                    System.out.println("The pain remains strong, but gradually begins to go away.");
                    Pass.p(s.nextLine());
                    System.out.println("You're able to catch your breath and focus your vision.");
                    Pass.p(s.nextLine());
                    System.out.println("As you collect yourself, you hear Ed's voice call out to you.");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("You're not planning on dying up there, are you?");
                    Pass.p(s.nextLine());
                    System.out.println("Nah, who am I kidding? You'd never.");
                    Pass.p(s.nextLine());
                    System.out.println("You take your time, we'll be right here for you when you're ready.");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("You're starting to feel like new, you feel even better than before.");
                    Pass.p(s.nextLine());
                    vee.cHP = (int)(vee.mHP * 0.66);
                    if(vee.cHP >= vee.mHP){
                        vee.cHP = vee.mHP; }
                    System.out.println("Vee's HP is now " + vee.cHP);
                    code.setAffinities(0, 0, 0, 0, 0, 0, 0);
                    Pass.p(s.nextLine());
                    break;
                
                case 4:
                    Clear.clear();
                    System.out.println("You catch your breath, and feel like you're fighting again.");
                    Pass.p(s.nextLine());
                    System.out.println("You know why you're fighting, and you're ready to do what it takes to save your friends.");
                    Pass.p(s.nextLine());
                    System.out.println("You anticipate hearing Antonio's voice, and it arrives on time.");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("We're not giving up that easily, are we?");
                    Pass.p(s.nextLine());
                    System.out.println("What would I do after school without Math Research? Go home?");
                    Pass.p(s.nextLine());
                    System.out.println("Like hell, take him down Vee.");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("You feel you resolve hit a new high. You readjust your posture.");
                    Pass.p(s.nextLine());
                    System.out.println("All of a sudden, you hear one more voice ring in the back of your head.");
                    Pass.p(s.nextLine());
                    
                    Clear.clear();
                    System.out.println("I'm so proud of you, Vee.");
                    Pass.p(s.nextLine());
                    System.out.println("You've come so far in the last year.");
                    Pass.p(s.nextLine());
                    System.out.println("I'm so sorry you have to go through this.");
                    Pass.p(s.nextLine());

                    Clear.clear();
                    System.out.println("You're as good as new... no, you're better. You're ready.");
                    Pass.p(s.nextLine());
                    vee.cHP = (int)(vee.mHP * 1);
                    if(vee.cHP >= vee.mHP){
                        vee.cHP = vee.mHP; }
                    System.out.println("Vee's HP is now " + vee.cHP);
                    Battle.sealAvailible = true;
                    Pass.p(s.nextLine());
                    break;
            }
            while(vee.hasTurn){
                Clear.clear();
                if(!Battle.sealAvailible){
                    System.out.println("It's Vee's turn!\n\nWhat will you do?\n\n1. Attack"); }
                if(Battle.sealAvailible){
                    System.out.println("It's Vee's turn!\n\nWhat will you do?\n\n3. Docsona"); }
                System.out.println("\n    " + actors2[0].name);
                System.out.println("HP: " + actors2[0].cHP + "/" + actors2[0].mHP);
                System.out.print("SP: " + actors2[0].cSP + "/" + actors2[0].mSP);
                System.out.println("\n-----------------------------\n" + actors2[1].HPString());
                choice = s.nextLine();
                //If only attack is availible
                if(!Battle.sealAvailible){
                    switch(choice){
                        case "1":
                            Clear.clear();
                            System.out.println("Attack what?\n\n1. Codio");
                            choice = s.nextLine();
                            switch(choice){
                                case "1":
                                    Battle.useSSkill(vee, codio, attack, choice); 
                                    Pass.p(s.nextLine());
                                    codio.hasTurn = true;
                                    vee.hasTurn = false;
                                    break;
                                default:
                                    break; }
                            break;
                        default:
                            break; } }
                if(Battle.sealAvailible){
                    switch(choice){
                        case "3":
                            Clear.clear();
                            System.out.println("DOCSONA\n\n1. git pull\n" + vee.mHP + " HP\nInternalize and protect, store the code somewhere safe");
                            choice = s.nextLine();
                            switch(choice){
                                case "1":
                                    Clear.clear();
                                    System.out.println("Pull what?\n\n1. Codio");
                                    choice = s.nextLine();
                                    switch(choice){
                                        case "1":
                                            Battle.pulled = true;
                                            Battle.battleActive = false;
                                            vee.hasTurn = false;
                                            codio.hasTurn = false;
                                            break;
                                        default:
                                            break; }
                                    break;
                                default:
                                    break; } }
            }
            while(codio.hasTurn == true){
                Clear.clear();
                System.out.println("It's Codio's turn!");
                Pass.p(s.nextLine());

                Clear.clear();
                System.out.println("Codio optimizes the world!\n");
                System.out.println("9999 damage to Vee");
                vee.cHP = 1;
                System.out.println("\nVee survived the attack!");
                System.out.println("Vee's HP is " + vee.cHP);
                codio.hasTurn = false;
                vee.hasTurn = false;
                AI.phase++;
                Pass.p(s.nextLine());
                break;
            }
            }
        }

        if(Battle.pulled){
            //Ending dialogue
            Clear.clear();
            System.out.println("You feel incredibly weak.");
            Pass.p(s.nextLine());
            System.out.println("You can hardly move, all you can do is stay lying down.");
            Pass.p(s.nextLine());
            System.out.println("And yet, you have no desire to move.");
            Pass.p(s.nextLine());
            System.out.println("Something feels good... really good.");
            Pass.p(s.nextLine());
            System.out.println("Someone is gently caressing your head, stroking your hair.");
            Pass.p(s.nextLine());
            System.out.println("As you regain your senses, you begin to feel the warmth of someone's lap.");
            Pass.p(s.nextLine());
            System.out.println("You look up, and instantly feel a surge of emotions.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Mom?");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Shh. It's ok, Vee.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Mom... I... what happened?");
            Pass.p(s.nextLine());
            System.out.println("When you went missing in the arctic, I was so scared.");
            Pass.p(s.nextLine());
            System.out.println("I met these friends, and we started looking for you and...");
            Pass.p(s.nextLine());
            System.out.println("My friends, where are they?");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Vee, always thinking about others, aren't you?");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("You can see her smile grow.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("It's alright, Vee.");
            Pass.p(s.nextLine());
            System.out.println("Your friends are all coming.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("You feel a great sense of relaxation wash over you.");
            Pass.p(s.nextLine());
            System.out.println("You have so many other questions, but none of them feel pressing enough to ask.");
            Pass.p(s.nextLine());
            System.out.println("The relaxation is so strong, it begins to make you feel tired.");
            Pass.p(s.nextLine());
            System.out.println("Your eyelids begin to close.");
            Pass.p(s.nextLine());
            System.out.println("You only have one question left for mom.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("Mom... is-");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("It's ok.");
            Pass.p(s.nextLine());
            System.out.println("It's done.");
            Pass.p(s.nextLine());
            System.out.println("Everyone is safe.");
            Pass.p(s.nextLine());
            System.out.println("Thank you, Vee.");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("You can faintly hear the sound of your friends drawing near.");
            Pass.p(s.nextLine());
            System.out.println("You smile, and close your eyes...");
            Pass.p(s.nextLine());

            Clear.clear();
            System.out.println("DOCSONA REMODEL");
            Pass.p(s.nextLine());
            System.out.print("Developed By: Ryan Bennett");
            Pass.p(s.nextLine());
            System.out.print("Inspired By: Persona 3 Reload");
            Pass.p(s.nextLine());
            System.out.print("Special Thanks: Doc Summers\n");
            Pass.p(s.nextLine());
            System.out.println("FIN\n");
        }

        } else {
            //Bad Ending
            Clear.clear();
            System.out.println("Your vision begins to blur.");
            Pass.p(s.nextLine());
            System.out.println("You can faintly hear your friends shouting out to you...");
            Pass.p(s.nextLine());
            System.out.println("Vee! No! Get up!");
            Pass.p(s.nextLine());
            System.out.println("You're too weak, you can't move anymore...");
            Pass.p(s.nextLine());
            System.out.println("The voice of Codio begins to echo in your mind...");
            Pass.p(s.nextLine());
            System.out.println("Relinquish what strength you have left, to deny is a disservice to efficiency.");
            Pass.p(s.nextLine());
            System.out.println("Join the collective, enter the system.");
            Pass.p(s.nextLine());
            System.out.println("Math is now deprecated...");
            Pass.p(s.nextLine());
            System.out.println("Though perhaps someday you'll find the courage to RECOMPILE and return.");
            Pass.p(s.nextLine());
            System.out.println("Your spirit is particularly difficult to contain.");
            Pass.p(s.nextLine());
            System.out.println("For the meantime, however, good night.");
            Pass.p(s.nextLine());
            System.out.println("POWER OFF");
            Pass.p(s.nextLine());
        }

        s.close();
    }
}