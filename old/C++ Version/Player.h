/*~[ Player | HEADER ]~
 * Contains the base class for all combatants.
 * Standard stats are provided, as well as functions to change them.
 */

class Player {
private:
	// Player's Original Stats
	int maxHP;				// Max Health Power
	int maxCP;				// Max Cyber Power
	int maxRP;				// Max Reserve Power
	int ogPow;				// Original Attack Power
	int ogDef;				// Original Defense
	int ogCrt;				// Original Critical Rate
	int ogStu;				// Original Sturdiness
	int ogSpd;				// Original Speed
	int ogEvd;				// Original Evasion

	// Player's Changeable Stats
	int HP = 0;				// Current Health Power
	int CP = 0;				// Current Cyber Power
	int RP = 0;				// Current Reserve Power
	int power = 0;			// Attack Power
	int defense = 0;		// Defense
	int critical = 0;		// Critical Rate
	int sturdy = 0;			// Sturdiness
	int speed = 0;			// Speed
	int evasion = 0;		// Evasion
	bool danger = false;	// Danger State

	// ~~Change: Changes the stat by the amount specified.
	void Change(int stat, int amount);

public:
	// ~~Damage: Lowers HP based on damage given.
	void Damage(int damage);

	// ~~Heal: Increases HP based on the amount healed.
	void Heal(int heal);

	// ~~CanUseMove: Tests if the Player has enough CP to use a move.
	bool CanUseMove(int requiredCP);
	
	// ~~UseMove: Decreases CP based on the CP required for the move.
	void UseMove(int requiredCP) {	CP -= requiredCP;}

	// ~~Heal: Increases CP based on the amount restored.
	void RestoreCP(int restore);

	// ~~ChangeStat: Uses Change() to change an applicable stat.
	void ChangeStat(char stat, int amount);

	// ~~ResetStat: Resets an applicable stat to its original value.
	void ResetStat(char stat);
};