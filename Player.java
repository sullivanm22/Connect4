public class Player {
    int playersTurn = 1;

    // this constructor is used to make a player object in the other classes so that
    // it can access the getTurn method
    // and the switchturn method
    public Player() {
    }

    // this method gets the current turn of the players
    public int getTurn() {
        if (playersTurn == 1)
            return 1;
        if (playersTurn == 2)
            return 2;
        return 0;
    }

    // here the turn is switched from player 1 to player 2 or player 2 to player 1
    public void switchTurn() {
        if (playersTurn == 1)
            playersTurn = 2;
        else if (playersTurn == 2)
            playersTurn = 1;
    }
}
