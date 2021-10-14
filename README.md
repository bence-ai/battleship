# Battleship OOP


In this project your job is to implement the
[Battleship game](https://en.wikipedia.org/wiki/Battleship_%28game%29) for two players. Use newly learned OOP practices.


## Tasks

1. Gain good understanding of the OOP principles and implement it in your code.
    - Program does not use static context.
    - Classes are groupped in packages.
    - Classes have fields and methods that are related only to them.
    - Classes have access modifiers exposing their content as little as possible.
    - Classes have getters and setters for private fields only when it is necessary.
    - Classes are logically structured and inherit from parents which eliminates the code duplication.
    - Classes use public methods to communicate with the outside code, and private methods for eliminating code duplication and better readability.
    - Polymorphism is used wherever possible, in order to make the code as universal as possible and avoid code duplication.

2. Implement the `Battleship` class that will be used as the highest level class.
    - Class `Battleship` has fields `Display` and `Input` that are used throughout the program.
    - Class `Battleship` has a loop in which program runs.
    - Class `Battleship` shows main menu and allows the user to start new game, display highscores and exit.

3. Implement class `Display` and its methods.
    - Class `Display` prints the game menu.
    - Class `Display` prints the board during manual ship placement process.
    - Class `Display` prints the gameplay.
    - Class `Display` prints the outcome of the game when it's over.
    - No `System.out.print()` happens outside of `Display` class.

4. Implement class `Input` and its methods.
    - Class `Input` is responsible for gathering every needed kind of input and provides seperate method for each case.
    - Class `Input` handles the input validation.

5. Implement class `Game` and its methods.
    - Class `Game` has a loop in which players make moves.
    - Class `Game` has logic which determines the flow of round.
    - Class `Game` has condition on which game ends.
    - Class `Game` provides different game modes which use different round flow.

6. Implement class `Player` and its methods.
    - Class `Player` has logic responsible for handling shot.
    - Class `Player` has field of type `List<Ship>`.
    - Class `Player` has a method `isAlive` to check if player has not lost all ships and returns true or false accordingly.

7.  Implement `ComputerPlayer` class and it's methods.
    - Class `ComputerPlayerEasy` takes random shots excluding already struck fields.
    - Class `ComputerPlayerNormal` also excludes fields around ships when taking random hits.
    - Class `ComputerPlayerNormal` shoots around a ship after hitting it to determine its direction.
    - Class `ComputerPlayerNormal` changes direction to opposite when can not go further.
    - Class `ComputerPlayerNormal` follows the direction until the ship is sunk.
    - Class `ComputerPlayerHard` uses `ComputerPlayerNormal` logic but shoots diagonal fields only.

8. Implement class `BoardFactory` and it's methods.
    - Class `BoardFactory` has a `randomPlacement()` method that handles random ship placement on board.
    - Class `BoardFactory` has a `manualPlacement()` method that handles manual ship placement on board.

9. Implement class `Board` and it's methods.
    - Class `Board` has field `Square[][] ocean` - squares the board consists of.
    - Class `Board` has an `isPlacementOk()` method that verifies if placement of ship is possible.

10. Implement class `Ship` and it's methods.
    - Class `Ship` has field of `List<Square>` - all squares the ship consists of.

11. Implement enum `ShipType` and it's methods.
    - Enum `ShipType` represents ship types - Carrier, Cruiser, Battleship, Submarine and Destroyer.
    - Each `ShipType` has a unique length.

12. Implement class `Square` and its methods.
    - Class `Square` has fields `X` and `Y`.
    - Class `Square` has a field `SquareStatus`.
    - Class `Square` has method that returns given `SquareStatus`'s graphical representation.

13. Implement enum `SquareStatus`.
    - Enum `SquareStatus` represents possible square statuses (empty, ship, hit, missed).
    - Each `SquareStatus` has a unicode character that can be used to print it out. This unicode character is returned by a `SquareStatus.GetCharacter()` method.


## Hints

- Run the Application in IntelliJ


