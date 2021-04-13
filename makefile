all : compile run

compile : Main.java Grid.java Parser.java DebugCodes.java Tile.java Handler.java
	@javac *.java

run : Main.class 
	@java Main

clean : 
	rm -rf *.class *.txt