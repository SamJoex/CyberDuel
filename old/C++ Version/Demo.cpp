/* ~[ Demo Mode ]~
 * Contains the implementation of Demo Mode.
 */

#include "Demo.h"
#include <iostream>
#include <string>
#include "Moves_Standard.h"

using namespace std;

//~~ Demo Mode:	A demo of all functions I have programmed at this moment.
void DemoMode() {
	bool demoExit = false;	// If this is true, the function will terminate.
	printf("~~[ DEMO MODE ]~~\n");
	while(!demoExit) {
		string move;
		printf("Choose a move.\n");
		printf("For list of moves, type in \"list\".\n");
		printf("To exit, type 'exit'.\n\n");
		cin >> move;

		if (move == "list")
			DemoList();
		else if (move == "Attack") {
			int attack, defense;
			double result;

			printf("\n~~[ Attack ]~~\nThe standard attack.\n\n");
			printf("Please insert attacker's attack stat: ");
			cin >> attack;
			printf("Please insert target's defense stat: ");
			cin >> defense;

			result = Attack(attack, defense);
			printf("%f damage!\n", result);
			printf("[End Attack]\n\n");
		}
		else if (move == "ElemAtk") {
			char atkLevel;
			double result;

			printf("\n~~[ ElemAttack ]~~\nA single-target elemental attack.\n\n");
			printf("Please insert power letter of the attack: ");
			cin >> atkLevel;

			if (atkLevel > 98)
				atkLevel -= 32;
			
			result = ElemAtk(atkLevel);
			printf("%f damage!\n", result);
			printf("[End ElemAtk]\n\n");
		}
		else if (move == "exit") {
			char exit;
			cout << "Are you sure you wish to exit? (y/n): ";
			cin >> exit;
			if (exit == 'Y' || exit == 'y')
				demoExit = true;
		}
		else
			cout << "Command failure. Please try again." << endl;
	}
}

//~~ Demo List: A list of commands for use in Demo Mode.
void DemoList() {
	cout << endl << "~~[ Demo Mode Commands ]~~" << endl;
	cout << "Attack  : The standard attack." << endl;
	cout << "ElemAtk : A single-target elemental attack." << endl;
	cout << "list    : List available moves." << endl;
	cout << "exit    : Exit Demo Mode" << endl;
	cout << endl;
}