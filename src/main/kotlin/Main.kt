//Initializing board
val FIR_board = FourInARow()
/** The entry main method (the program starts here)  */
fun main() {
    //Displays current game state (and takes user input)
    var currentState: Int = GameConstants.PLAYING
    val userInput = ""
    //Game Loop
    //Setting up a try loop as if the index is out of bounds it will throw an error that can be shown to the user
    try {
        do {
            FIR_board.printBoard()
            print("Enter your move: ")
            val userInput = readLine()
            if(userInput == "q"){
                FIR_board.clearBoard()
                FIR_board.printBoard()
                println("Quitting Game...")
                break
            }
            var intInput: Int = Integer.parseInt(userInput)

            FIR_board.setMove(1, intInput)
            if (FIR_board.checkForWinner() == 3) {
                println("PLAYER WON")
                currentState = GameConstants.BLUE_WON
                break
            }
            FIR_board.setMove(2, FIR_board.computerMove)
            if(FIR_board.checkForWinner() == 2){
                println("COMPUTER WON")
                currentState = GameConstants.RED_WON
            }
        }while (currentState == GameConstants.PLAYING && userInput != "q")
    } catch (e: ArrayIndexOutOfBoundsException){
        println("Incorrect number Please restart and enter between 0-35 or 'q' to quit")
    }
}
 