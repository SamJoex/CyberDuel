package CyberDuel;

/*~[ Player ]~
 * Contains the base class for all combatants.
 * Standard stats are provided, as well as methods to change them.
 */

public class Player {
    // Player's Original Stats
	private int maxHP;				// Max Health Power
	private int maxCP;				// Max Cyber Power
	private int maxRP;				// Max Reserve Power
	private int ogPow;				// Original Attack Power
	private int ogDef;				// Original Defense
	private int ogCrt;				// Original Critical Rate
	private int ogStu;				// Original Sturdiness
	private int ogSpd;				// Original Speed
	private int ogEvd;				// Original Evasion

	// Player's Changeable Stats
	private int HP = 0;				// Current Health Power
	private int CP = 0;				// Current Cyber Power
	private int RP = 0;				// Current Reserve Power
	private int power = 0;			// Attack Power
	private int defense = 0;		// Defense
	private int critical = 0;		// Critical Rate
	private int sturdy = 0;			// Sturdiness
	private int speed = 0;			// Speed
	private int evasion = 0;		// Evasion
	private boolean danger = false;	// Danger State

	// ~~Change: Changes the stat by the amount specified.
	private void Change(int stat, int amount) {
		if(stat + amount < 0)
			stat = 0;
		else
			stat += amount;
	}
	
	// ~~Damage: Lowers HP based on damage given.
	public void Damage(int damage) {
		if(HP - damage <= 0) {
			HP = 0;
			danger = true;
		}
		else
			HP -= damage;
	}

	// ~~Heal: Increases HP based on the amount healed.
	public void Heal(int heal) {
		// If the Danger state is active, deactivate it.
		if(danger)
			danger = false;
		
		// Heal HP, but don't go over max HP.
		if(HP + heal >= maxHP)
			HP = maxHP;
		else
			HP += heal;
	}

	// ~~CanUseMove: Tests if the Player has enough CP to use a move.
	public boolean CanUseMove(int requiredCP) {
		if(CP - requiredCP < 0)
			return false;
		else
			return true;
	}
		
	// ~~UseMove: Decreases CP based on the CP required for the move.
	public void UseMove(int requiredCP) {	CP -= requiredCP;}

	// ~~Heal: Increases CP based on the amount restored.
	public void RestoreCP(int restore) {
		// Heal CP, but don't go over max CP.
		if(CP + restore >= maxCP)
			CP = maxCP;
		else
			CP += restore;
	}

	// ~~ChangeStat: Uses Change() to change an applicable stat.
	public void ChangeStat(char stat, int amount) {
		if		(stat == 'A')	Change(power	, amount);	// Change Attack Power
		else if	(stat == 'D')	Change(defense	, amount);	// Change Defense
		else if (stat == 'C')	Change(critical	, amount);	// Change Critical Rate
		else if (stat == 'T')	Change(sturdy	, amount);	// Change Sturdiness
		else if (stat == 'S')	Change(speed	, amount);	// Change Speed
		else if (stat == 'E')	Change(evasion	, amount);	// Change Evasion
		else	System.out.println("An error occurred.");	// This isn't supposed to execute
	}

	// ~~ResetStat: Resets an applicable stat to its original value.
	public void ResetStat(char stat) {
		if		(stat == 'A')	Change(power	, ogPow - power		);	// Reset Attack Power
		else if	(stat == 'D')	Change(defense	, ogDef - defense	);	// Reset Defense
		else if (stat == 'C')	Change(critical	, ogCrt - critical	);	// Reset Critical Rate
		else if (stat == 'T')	Change(sturdy	, ogStu - sturdy	);	// Reset Sturdiness
		else if (stat == 'S')	Change(speed	, ogSpd - speed		);	// Reset Speed
		else if (stat == 'E')	Change(evasion	, ogEvd - evasion	);	// Reset Evasion
		else	System.out.println("An error occurred.");				// This isn't supposed to execute
	}
}
