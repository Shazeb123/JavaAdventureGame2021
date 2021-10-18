/*
List of other classes and methods that we need to create

Room
 - NoArgsConstructor
 - Room(String _name)
 - getCharacter()
 - getItem()
 - getLocationTo(String direction)
 - getName()
 - getPossibleDirections()
 - linkRoom(Room r, String direction)
 - setCharacter(Npc character)
 - setDescription(String d)
 - setItem(Item i)
 - setName(String _name)
 - toString() // returns the description
 
Npc
 - NoArgsConstructor
 - Npc(String _name, String _description)
 - getName
 - getSpeech
 - setDescription(String d)
 - setName(String _name)
 - setSpeech
 - toString() // returns the description
 
Enemy extends Npc
 - NoArgsConstructor
 - Enemy(String _name, String _description)
 - String getAttackName()
 - int getHealth
 - int getMagicWeakness()
 - void loseHealth(int h)
 - void setAttackName()

Item
 - NoArgsConstructor
 - Item(String _name, String _description)
 - getMagicType()
 - getName()
 - getStrength()
 - setDescription(String d)
 - setName(String _name)
 - isBroken()
 - toString() // returns the description
 - weaken()


Map:
|                |   billiardsRm    |   theBasement     |   masterBedroom   |
|    kitchen     |   diningHall     |   mainHallway     |   theStudy        |
|                |   ballroom       |   grandFoyer      |                   |
*/

import java.util.Scanner;
import java.util.Random;

public class Main
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    Random rng = new Random();
    // create the world
    // create rooms
    Room kitchen = new Room("Kitchen");
    Room diningHall = new Room("Dining Hall");
    Room ballroom = new Room("Ballroom");
    Room masterBedroom = new Room("Master Bedroom");
    Room grandFoyer = new Room("Grand Foyer");
    Room mainHallway = new Room("Main Hallway");
    Room theStudy = new Room("The Study");
    Room billiardsRm = new Room("The Billiards Room");
    Room theBasement = new Room("The Basement");
    // descriptions
    kitchen.setDescription("A dank and dirty room buzzing with flies.");
    diningHall.setDescription("A large room with ornate golden decorations on each wall.");
    ballroom.setDescription("A vast room with a shiny wooden floor. Huge candlesticks guard the entrance.");
    masterBedroom.setDescription("A large room with a massive bed in the middle of it.");
    grandFoyer.setDescription("The entrance to the dark mansion. Designed to astonish guests. The hallway is north and there is are large, double-doors to the west.");
    mainHallway.setDescription("A long dark hall that has creepy paintings on the walls");
    theStudy.setDescription("");
    billiardsRm.setDescription("");
    theBasement.setDescription("");
    // link rooms together. don't forget to link the rooms in both directions.
    grandFoyer.linkRoom(mainHallway, "north");
    mainHallway.linkRoom(grandFoyer, "south");
    grandFoyer.linkRoom(ballroom, "west");
    ballroom.linkRoom(grandFoyer, "east");
    ballroom.linkRoom(diningHall, "north");
    diningHall.linkRoom(ballroom, "south");
    kitchen.linkRoom(diningHall, "east");
    diningHall.linkRoom(kitchen, "west");
    diningHall.linkRoom(billiardsRm, "north");
    billiardsRm.linkRoom(diningHall, "south");
    diningHall.linkRoom(mainHallway, "east");
    mainHallway.linkRoom(diningHall, "west");
    mainHallway.linkRoom(theBasement, "north");
    theBasement.linkRoom(mainHallway, "south");
    mainHallway.linkRoom(theStudy, "east");
    theStudy.linkRoom(mainHallway, "west");
    theStudy.linkRoom(masterBedroom, "north");
    masterBedroom.linkRoom(theStudy, "south");
    billiardsRm.linkRoom(theBasement, "east");
    theBasement.linkRoom(billiardsRm, "west");
    theBasement.linkRoom(masterBedroom, "east");
    masterBedroom.linkRoom(theBasement, "west");
    // create characters
    // Ava
    Enemy ava = new Enemy("Ava", "a beautiful chicken");
    ava.setSpeech("Hello...");
    ava.setAttackName("PECK");
    if(rng.nextInt(2) == 0)
    {
      kitchen.setCharacter(ava);
    }
    else
    {
      billiardsRm.setCharacter(ava);
    }
    // Becky
    Enemy becky = new Enemy("Becky", "a wicked witch");
    becky.setSpeech("Yahaha! You found me!");
    ava.setAttackName("BAD BREATH");
    if(rng.nextInt(2) == 0)
    {
      theBasement.setCharacter(becky);
    }
    else
    {
      diningHall.setCharacter(becky);
    }
    // Catrina
    Npc catrina = new Npc("Catrina", "a friendly skeleton");
    catrina.setSpeech("Why hello there.");
    if(rng.nextInt(2) == 0)
    {
      mainHallway.setCharacter(catrina);
    }
    else
    {
      ballroom.setCharacter(catrina);
    }
    // Dave
    Enemy dave = new Enemy("Dave", "a smelly zombie");
    dave.setSpeech("Brrlgrh... rhrhl... brains...");
    ava.setAttackName("BITE");
    if(rng.nextInt(2) == 0)
    {
      masterBedroom.setCharacter(dave);
    }
    else
    {
      theStudy.setCharacter(dave);
    }
    // create items
    Item staff = new Item("staff", "a weird old wizard's staff");
    if(rng.nextInt(2) == 0)
    {
      kitchen.setItem(staff);
    }
    else
    {
      diningHall.setItem(staff);
    }
    Item sword = new Item("sword", "a well-decorated sword");
    if(rng.nextInt(2) == 0)
    {
      masterBedroom.setItem(sword);
    }
    else
    {
      theStudy.setItem(sword);
    }
    Item wand = new Item("wand", "a strange, glowing wand");
    if(rng.nextInt(2) == 0)
    {
      billiardsRm.setItem(wand);
    }
    else
    {
      theBasement.setItem(wand);
    }
    // player variables
    int playerHealth = 100;
    int playerKickStrength = rng.nextInt(7) + 1;
    int playerPunchStrength = 9 - playerKickStrength;
    int enemiesDefeated = 0;
    Item backpack = null;
    Room currentRoom = grandFoyer;
    // the game loop
    while(true)
    {
      typewriter(50, "- - -\n");
      Npc roomNpc = currentRoom.getCharacter();
      Item roomItem = currentRoom.getItem();
      // describe the current room
      typewriter(50, currentRoom.toString());
      // check if there is a character and/or item in current room
      if(roomNpc != null)
      {
        typewriter(50, "There is " + roomNpc.toString() + " here.\n");
      }
      if(roomItem != null)
      {
        typewriter(50, "There is " + roomItem.toString() + " here.\n");
      }
      if(backpack != null)
      {
        typewriter(50, "You are holding " + backpack.toString()+"\n");
      }
      // prompt
      typewriter(50, "WHAT NEXT? " + currentRoom.getPossibleDirections() + ", " + (currentRoom.getItem() == null ? "" : "take, ") + (currentRoom.getCharacter() == null ? "" : "talk, fight, ") + "or quit: ");
      String command = input.next();
      command = command.toLowerCase();
      if(command.equals("north") || command.equals("south") || command.equals("east") || command.equals("west"))
      {
        currentRoom = currentRoom.getLocationTo(command);
      }
      else if(command.equals("take"))
      {
        takeItem(currentRoom, backpack);
      }
      else if(command.equals("talk"))
      {
        if(roomNpc != null)
        {
          typewriter(50, roomNpc.getSpeech());
        }
        else
        {
          typewriter(50, "There is nobody here to talk\n");
        }
      }
      else if(command.equals("fight"))
      {
        playerHealth = fight(input, rng, roomNpc, backpack, playerHealth, playerPunchStrength, playerKickStrength);
      }
      else if(command.equals("quit"))
      {
        typewriter(50, "Thanks for playing\n");
        break;
      }
      else
      {
        typewriter(50, "I don't know how to " + command);
        typewriter(50, ". Valid options include: " + currentRoom.getPossibleDirections() + ", " + (currentRoom.getItem() == null ? "" : "take, ") + (currentRoom.getCharacter() == null ? "" : "talk, fight, ") + "or quit.\n");
      }
      if(playerHealth <= 0)
      {
        typewriter(50, "You died. Game over.\n");
        break;
      }
    } // close while loop
  } // close main method

  /*
    Pick up an item from the current room and put it in the backpack. If something is in the backpack, drop it in the room.
  */
  public static void takeItem(Room currentRoom, Item backpack)
  {
    if(backpack != null)
    {
      Item temp = backpack;
      backpack = currentRoom.getItem();
      currentRoom.setItem(temp);
      typewriter(50, "You drop " + temp + " and pick up " + backpack + ".\n");
    }
    else
    {
      // not holding anything right now
      backpack = currentRoom.getItem();
      currentRoom.setItem(null);
      typewriter(50, "You pick up " + backpack + ".\n");
    }
  }

  /*
    fight with an enemy. returns the new playerHealth.
  */
  public static int fight(Scanner input, Random rng, Npc currentNpc, Item backpack, int playerHealth, int playerPunchStrength, int playerKickStrength)
  {
    if(currentNpc == null)
    {
      typewriter(50, "There is nobody here to fight.\n");
      return playerHealth;
    }
    if(currentNpc instanceof Enemy == false)
    {
      typewriter(50, currentNpc.getName() + " doesn't want to fight you.\n");
      return playerHealth;
    }
    Enemy e = (Enemy) currentNpc;
    while(playerHealth > 0)
    {
      System.out.print("FIGHT!!! p = punch, k = kick, r = run" + (backpack == null ? "" : ", x = use " + backpack.getName()) + ": ");
      String command = input.next();
      command = command.toLowerCase();
      if(command.equals("r"))
      {
        if(rng.nextInt(2) == 0)
        {
          typewriter(50, "You escaped... but " + e.getName() + " hits you as you run away...\n");
          playerHealth = playerLoseHealth(rng, e, playerHealth);
          return playerHealth;
        }
        else
        {
          typewriter(50, "Oof! Tried to run away, but could not escape!\n");
        }
      }
      enemyLoseHealth(rng, command, e, playerPunchStrength, playerKickStrength, backpack);
      if(e.getHealth() > 0)
      {
        // player lose health
        playerHealth = playerLoseHealth(rng, e, playerHealth);
      }
      else
      {
        typewriter(50, e.getName() + " fainted! You won the fight!\n");
        return playerHealth;
      }
    }
    return playerHealth;
  }

  public static int playerLoseHealth(Random rng, Enemy e, int playerHealth)
  {
    int attack = rng.nextInt(6) + rng.nextInt(6) + 2;
    typewriter(50, " > > > " + e.getName() + " uses " + e.getAttackName() + "\n");
    typewriter(50, " > > > -" + attack + " HP\n");
    playerHealth -= attack;
    typewriter(50, "You have " + playerHealth + " HP remaining\n");
    return playerHealth;
  }
  
  public static void enemyLoseHealth(Random rng, String command, Enemy e, int playerPunchStrength, int playerKickStrength, Item backpack)
  {
    int attack = 0;
    if(command.equals("p"))
    {
      typewriter(50, "You used PUNCH\n");
      attack = rng.nextInt(playerPunchStrength) + rng.nextInt(playerPunchStrength) + 1;
      if(attack >= 12)
      {
        typewriter(50, "It's super effective!\n");
      }
    }
    else if(command.equals("k"))
    {
      typewriter(50, "You used KICK\n");
      attack = rng.nextInt(playerKickStrength) + rng.nextInt(playerKickStrength) + 1;
      if(attack >= 12)
      {
        typewriter(50, "It's super effective!\n");
      }
    }
    else if(command.equals("x") && backpack != null)
    {
      typewriter(50, "You used " + backpack.getName().toUpperCase() + "\n");
      attack = rng.nextInt(backpack.getStrength()) + rng.nextInt(backpack.getStrength()) + rng.nextInt(backpack.getStrength()) + 1;
      if(backpack.getMagicType() == e.getMagicWeakness())
      {
        attack = attack * 3;
      }
      if(attack >= 12)
      {
        typewriter(50, "It's super effective!\n");
      }
      backpack.weaken();
      if(backpack.isBroken())
      {
        typewriter(50, "Oh no! Your " + backpack.getName() + " broke!\n");
        backpack = null;
      }
    }
    else
    {
      typewriter(50, "Sorry, I don't know how to " + command);
      typewriter(50, ". Valid options: p, k, r" + (backpack == null ? "" : ", x = use " + backpack.getName()) + "\n");
      return;
    }
    typewriter(50, e.getName() + " -" + attack + " HP\n");
    e.loseHealth(attack);
  }

  public static void typewriter(int delay, String s)
  {
    try
    {
      for(char c: s.toCharArray())
      {
        System.out.print(c); // print characters without newline
        Thread.sleep(delay); // wait for some milli seconds
      }
    }
    catch(InterruptedException e)
    {}
    //System.out.print("\n"); // finally, add a line break
  }
} // close the class
