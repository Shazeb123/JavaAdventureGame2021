/*
Enemy extends Npc
 - NoArgsConstructor
 - Enemy(String _name, String _description)
 - String getAttackName()
 - int getHealth
 - int getMagicWeakness()
 - void loseHealth(int h)
 - void setAttackName()
*/
public class Enemy extends Npc
{
  private int health;
  private int magicWeakness;
  private String attackName;
  
  public Enemy(){
   health = 100;
   magicWeakness = 1;
   attackName = "SLASH";
   name = "";
   speech = "";
   description = "";
  }
  public String getAttackName(){
   return attackName;
  }
  public int getMagicWeakness(){
  return magicWeakness;
  }
}
