# ~~[ Cyber Duel Makefile ]~~
# This links the source code files together into one executable.
# EXECUTABLE NAME: cyberduel.exe

cyberduel: main.cpp
	g++ -c main.cpp Demo.cpp Moves_Standard.cpp Player.cpp
	g++ -o cyberduel.exe main.o Demo.o Moves_Standard.o Player.o

clean:
	rm -f cyberduel.exe
	rm -f *.o