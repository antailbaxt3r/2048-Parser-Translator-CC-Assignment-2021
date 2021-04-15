# Compiler Construction Assignment
<i>Submission by Arjun Bajpai: 2018A7PS0182G</i>

## Summary of project

This code assignment was submitted in partial fulfi;lment for the course CS F363, April 2021.</br>

The assignment is written in ```Java``` and compiled by ```javac``` version ```14.0.2```. 

## Project Structure

The project is split into multiple ```.java``` files to keep the code modular and easy to navigate. Also, this has been done to separate the functioning of the scanner, the parser, and the translator. </br>
The following code files can be seen in the project directory:

- <code>Main.java</code> : The main function resides in this class. This manages the interactive shell that the client sees.
- <code>Parser.java</code> : This class is the parser, that receives user input from the Main class and returns a relevant debug code.
- <code>Handler.java</code> : This class takes care of the return codes that are returned from the Parser and translates them into required instructions that are then carried out. This also prints the required output into stdout and stderr.
- <code>DebugCodes.java</code> : This class keeps track of all the debug codes that are used for communication between the Main class, the Parser class, and the Handler class. 
- <code>Tile.java</code> : This is an Object-Oriented based POJO (Plain Old Java Object) class that represents each tile in the 2048 game.
- <code>Grid.java</code> : This is the main 2048 game engine.

## Compiling and Initialization

The entire compilation for the code can be done directly through the makefile and the make command.

To compile, use <code>make</code> or <code>make all</code>

This will run 2 'make' scripts: 
- <code>make compile</code> : Compiles the <code>Main.java</code> file along with all other relevant files.
- <code>make run</code> : Runs the compiled <code>Main</code> class.

Hence ```make all``` or ```make``` compiles AND runs the program. </br>

So to run the app, just use command : ```make```.

## Removing build files

Run <code>make clean</code> to clean and remove the temporary build files.

## Exiting the app

Once inside the interactive shell, enter command ```EXIT.``` to stop the program.

## Notes

- In Java, the stderr is printed on the console itself. Hence it would be visible in the interractive shell. One option to fix this would have been to redirect the stderr to a text file which can be easily done by adding the following code in line 6 of ```Main.java``` and adding a ```stderr.txt``` blank file inside the project directory. 

```java
    File file = new File("stderr.txt");
    try {
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setErr(ps);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("STDERR could not be sent to stderr.txt so it will appear on console.");
    }
```

- The development cycle for this project can be viewed through the maintained Github repository that can be found [here](https://github.com/antailbaxt3r/2048-Parser-Translator-CC-Assignment-2021)

- Please ignore the ```.gitignore``` file, it was created to maintain a clean structure on the version control system.

- All commands are case sensitive and must end with full stops as per assignment requirements.

- A complete list of all handled errors can be seen inside the ```DebugCodes.java``` file as all variable names were created with the aim to keep it readable and the meaning behind each variable apparant, much like actual industry code.

# Assumptions and Implementation

- Suppose a row is 4 2 2 4. Then SUBTRACT LEFT operation will result in 4 4 0 0 as the middle 2 tiles will get eliminated.

- Any nested commands must use parantheses. For example:
```java
    ASSIGN (VALUE IN 1,2) TO 2,3.
```

- Stderr is printed on every command.

- Stderr format is as follows: ```<Array of numbers representing matrix in row major form separated by space (\40)> <x1>,<y1>name1,name2,name3 <x2>,<y2>name4,name5``` and so on.

- Every error prints ```-1``` to stderr.

- Code runs from Main.java which calls Parser.java and Handler.java. The game engine runs in Grid.java. 

- Zero valued tiles cannot be assigned names, but they can be given values after which they will accept variable names. 