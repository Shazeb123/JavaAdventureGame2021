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
 
  // sets the character to a Npc object that you inputed into this method
  public setCharacter(Npc character)
  {
     this.character = character;
  }
}

