/*
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
*/
public class Room
{
  private String name;
  private String description;
  private Npc character;
  private Item roomItem;
  private Room north;
  private Room south;
  private Room east;
  private Room west;
 

  
  public Room(){
    this.description = "Living Room";
    this.name = "Living Room";
  }
  
  public String getName(){
    return name;
  }
  
  public void setDescription(String newDescription){
    this.description = newDescription;

  }
  
  // sets the character to a Npc object that you inputed into this method
  public setCharacter(Npc character)
  {
     this.character = character;
  }
 
  public void setDescription(String newDescription)
  {
    this.description = newDescription;
  }


}

