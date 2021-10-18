/*
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
 */
public class Item
{
  private String name;
  private int strength;
  private String description;
  private int magicType;
 
  public Item(){
    name = "";
    strength = 50;
    description = "";
    magicType = 1;
  }
  

   public String getName()
   {
    return name;
   }
 
   public int getStrength()
   {
    return strength;
   }
 
   public void setDescription(String _string)
   {
    description = _string;
   }
 

}
