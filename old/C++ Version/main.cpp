/* ~[ Cyber Duel: Main File ]~
 * AUTHOR:		SamJoex
 * VERSION:		0.3
 * BUILD:		4
 * DATESTAMP:	2021-11-25
 * DESCRIPTION:	This program simulates an RPG Battle called a "Cyber Duel".
 */

// Standard Library #includes
#include <iostream>
#include <cstdlib>
#include <string>
#include <fstream>

// Custom File #includes
#include "Player.h"
#include "Moves_Standard.h"
#include "Demo.h"

using namespace std;	// Use Standard Namespace

//~~ Main: The central hub of the program.
int main(int argc, char** argv) {
	// Variables
	int i, j;               	// Generic integers.
//	string move;            	// Desired move
	int turnOrder[16];      	// Turn order of all participants (sorted by speed)
	ifstream playerFiles[16];

	// Print Startup message.
	printf("----[ Cyber Duel v0.3 ]----\n");
	printf("----  Made by SamJoex  ----\n\n");

	if(argv[1] == "DEMO:MODE")
		DemoMode();				// Start Demo Mode
	else {
		// Load player files.
		for(i = 1; i < argc; i++) {
			;
		}
	}

	//~~ Run GUI.

	return 0;					// PROGRAM EXIT
}