import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Monster{
	// class variables to control number of monster
	
	// create a random object
	Random rand = new Random();

	// declare variables
	private int maxMonsterHealth;
	private int miniMonsterHealth;
	private int maxMonsterStrength;
	private int miniMonsterStrength;
	private String monsterName;
	private int currentHealth;
	private int currentStrength;
	// private String name; //["Zombie", "Skeletons", "Ghost"] ["Mummy", "Werewolf", "Vampire"]

	// constructor 
	public Monster(String monsterName, int maxMonsterHealth, int miniMonsterHealth, int maxMonsterStrength, int miniMonsterStrength){
		this.monsterName = monsterName;
		this.maxMonsterStrength = maxMonsterStrength;
		this.miniMonsterStrength = miniMonsterStrength;
		this.maxMonsterHealth = maxMonsterHealth;
		this.miniMonsterHealth = miniMonsterHealth;
		this.currentHealth = rand.nextInt(maxMonsterHealth - miniMonsterHealth) + miniMonsterHealth; //genrate random number from range
		this.currentStrength = rand.nextInt(maxMonsterStrength - miniMonsterStrength) + miniMonsterStrength;
	}

	// Create a monster 
	public static HashMap<String, Monster> createMonsters(Scanner in){
		HashMap<String, Monster> monsters = new HashMap<String, Monster>();

		while(in.hasNext()){
			String monsterName = FileUtil.getNonCommentLine(in); // read monster name from txt file
			int maxMonsterHealth = FileUtil.getInt(in); // read monster max health from txt file
			int miniMonsterHealth = FileUtil.getInt(in); // read monster minimum health from txt file
			int maxMonsterStrength = FileUtil.getInt(in); // read monster max strength from txt file
			int miniMonsterStrength = FileUtil.getInt(in); // read monster minimum strength from txt file

			monsters.put(monsterName, new Monster(monsterName, maxMonsterHealth, miniMonsterHealth,
					maxMonsterStrength, miniMonsterStrength));	// put the pairs in Hashmap instantiate monsters
		}
		in.close(); // close the scanner object 

		return monsters;
	}

	// setters 
	public void setCurrentHealth(int newHealth)
	{
		this.currentHealth = newHealth;
	}


	// getters
	public int getCurrentHealth(){
		return currentHealth;
	}
	public int getCurrentStrength(){
		return currentStrength;
	}
	public String getName(){
		return monsterName;
	}

	public void checkStatus()
	{
		if (currentHealth > 0)
		{
			System.out.println(monsterName + "'s strength: " + currentStrength);
			System.out.println(monsterName + "'s health: " + currentHealth);
		}

	}

}