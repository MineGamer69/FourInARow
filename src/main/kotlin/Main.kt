import java.lang.NumberFormatException


val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
 var currentState: Int = GameConstants.PLAYING
 val userInput = ""
 //game loop
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

   /** TODO implement the game loop
    * 1- accept user move
    * 2- call getComputerMove
    * 3- Check for winner
    * 4- Print game end messages in case of Win , Lose or Tie !
    */
  }while (currentState == GameConstants.PLAYING && userInput != "q")
 } catch (e: ArrayIndexOutOfBoundsException){
  println("Incorrect number Please restart and enter between 0-35 or 'q' to quit")
 }
// repeat if not game-over
}
 