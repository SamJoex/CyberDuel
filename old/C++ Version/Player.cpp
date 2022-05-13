/*~[ Player ]~
 * Contains the implementation of some functions
 * in the base class for all combatants.
 */

#include "Player.h"
#include <iostream>

// ~~Damage: Lowers HP based on damage given.
void Player::Damage(int damage) {
	if(HP - damage <= 0) {
		HP = 0;
		danger = true;
	}
	else
		HP -= damage;
}

// ~~Heal: Increases HP based on the amount healed.
void Player::Heal(int heal) {
	// If the Danger state is active, deactivate it.
	if(HP == 0)
		danger = false;
	
	// Heal HP, but don't go over max HP.
	if(HP + heal >= maxHP)
		HP = maxHP;
	else
		HP += heal;
}


bool Player::CanUseMove(int requiredCP) {
	if(CP - requiredCP < 0)
		return false;
	else
		return true;
}

// ~~Heal: Increases CP based on the amount restored.
void Player::RestoreCP(int restore) {
	// Heal CP, but don't go over max CP.
	if(CP + restore >= maxCP)
		CP = maxCP;
	else
		CP += restore;
}

// ~~ChangeStat: Uses Change() to change an applicable stat.
void Player::ChangeStat(char stat, int amount) {
	if		(stat == 'A')	Change(power	, amount);	// Change Attack Power
	else if	(stat == 'D')	Change(defense	, amount);	// Change Defense
	else if (stat == 'C')	Change(critical	, amount);	// Change Critical Rate
	else if (stat == 'T')	Change(sturdy	, amount);	// Change Sturdiness
	else if (stat == 'S')	Change(speed	, amount);	// Change Speed
	else if (stat == 'E')	Change(evasion	, amount);	// Change Evasion
	else	printf("An error occurred.");				// This isn't supposed to execute
}

// ~~ResetStat: Resets an applicable stat to its original value.
void Player::ResetStat(char stat) {
	if		(stat == 'A')	Change(power	, ogPow - power		);	// Reset Attack Power
	else if	(stat == 'D')	Change(defense	, ogDef - defense	);	// Reset Defense
	else if (stat == 'C')	Change(critical	, ogCrt - critical	);	// Reset Critical Rate
	else if (stat == 'T')	Change(sturdy	, ogStu - sturdy	);	// Reset Sturdiness
	else if (stat == 'S')	Change(speed	, ogSpd - speed		);	// Reset Speed
	else if (stat == 'E')	Change(evasion	, ogEvd - evasion	);	// Reset Evasion
	else	printf("An error occurred.");							// This isn't supposed to execute
}

// ~~Change: Changes the stat by the amount specified.
void Player::Change(int stat, int amount) {
	if(stat + amount < 0)
		stat = 0;
	else
		stat += amount;
}