package CyberDuel;

/* ~[ Moves (Regular) ]~
 * Contains methods for the Standard Moves.
 */

public class Moves {
	
	//~~ Attack: The standard attack.
	public double Attack(int attackersPow, int targetsDef) {
		return (attackersPow / 2.0 - targetsDef / 4.0);
    }
	
	//~~ Elemental Attack: Returns the damage value for an elemental attack.
	public double ElemAtk(char power) {
		if		(power == 'A')	{	return 10	;}
		else if (power == 'B')	{	return 30	;}
		else if (power == 'C')	{	return 80	;}
		else if (power == 'D')	{	return 150	;}
		else if (power == 'E')	{	return 400	;}
		else if (power == 'F')	{	return 900	;}
		else if (power == 'G')	{	return 1600	;}
		else if (power == 'H')	{	return 2560	;}
		else if (power == 'J')	{	return 4096	;}
		else if (power == 'Q')	{	return 8192	;}
		else if (power == 'X')	{	return 16384;}
		else if (power == 'Y')	{	return 32768;}
		else if (power == 'Z')	{	return 65536;}
		else					{	return -1	;}	// This line should never execute.
	}
	
}
