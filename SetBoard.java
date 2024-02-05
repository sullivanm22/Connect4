import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class SetBoard extends BorderPane {

    // these are all the variables that are used across multiple methods
    final int NUM_COLS = 6;
    final int NUM_ROWS = 5;
    final int initialCircleXCoord = 80;
    final int initialCircleYCoord = 60;
    private Button first = new Button();
    private Button second = new Button();
    private Button third = new Button();
    private Button fourth = new Button();
    private Button fifth = new Button();
    private Button sixth = new Button();
    private Text text = new Text();
    private String Player1 = "Turn: Player 1, choose a column!";
    private String Player2 = "Turn: Player 2, choose a column!";
    private Circle[][] circles = circles();
    private int[][] Board = Board();
    private Player Player = new Player();

    public SetBoard() {
        super();

        // this portion of the gui controls the texts within the top set of the pane
        String p1 = "Player 1:Red";
        String p2 = "Player 2:Yellow";
        Text p1color = new Text();
        Text p2color = new Text();
        p1color.setText(p1);
        p1color.setX(50);
        p1color.setY(35);
        p1color.setFont(Font.font("verdana", FontWeight.BOLD, 15));
        p2color.setText(p2);
        p2color.setX(720);
        p2color.setY(35);
        p2color.setFont(Font.font("verdana", FontWeight.BOLD, 15));
        if (Player.getTurn() == 1)
            text.setText(Player1);
        if (Player.getTurn() == 2)
            text.setText(Player2);
        text.setX(240);
        text.setY(35);
        text.setFont(Font.font("verdana", FontWeight.BOLD, 22));

        // this creates and adds the texts from above into the top pane
        Pane top = new Pane();
        top.setPrefSize(900, 100);
        setTop(top);
        top.getChildren().add(text);
        top.getChildren().add(p1color);
        top.getChildren().add(p2color);

        // this creates the center pane and makes the backround color turquoise.
        // this also creates all 30 circles and adds them all into the center pane
        Pane center = new Pane();
        center.setStyle("-fx-background-color: darkturquoise;");
        center.setPrefSize(900, 400);
        setCenter(center);
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                center.getChildren().add(circles[i][j]);
            }
        }

        // these use the buttons created above (1-6) and initializes their position,size
        // and adds them to the top pane
        first.setText("1");
        first.setPrefSize(50, 20);
        first.setLayoutX(60);
        first.setLayoutY(65);
        top.getChildren().add(first);

        second.setText("2");
        second.setPrefSize(50, 25);
        second.setLayoutX(205);
        second.setLayoutY(65);
        top.getChildren().add(second);

        third.setText("3");
        third.setPrefSize(50, 25);
        third.setLayoutX(355);
        third.setLayoutY(65);
        top.getChildren().add(third);

        fourth.setText("4");
        fourth.setPrefSize(50, 20);
        fourth.setLayoutX(505);
        fourth.setLayoutY(65);
        top.getChildren().add(fourth);

        fifth.setText("5");
        fifth.setPrefSize(50, 20);
        fifth.setLayoutX(655);
        fifth.setLayoutY(65);
        top.getChildren().add(fifth);

        sixth.setText("6");
        sixth.setPrefSize(50, 20);
        sixth.setLayoutX(805);
        sixth.setLayoutY(65);
        top.getChildren().add(sixth);

        // event-handlers
        // all of these control what happens when you click a button. since the players
        // turn starts with player 1
        // the first button clicked will drop a red piece at at the lowest point
        // possible in the column selected.
        // after placing the piece in the lowest point possible the turn is switched to
        // the other player and the
        // board is repainted and the loop ends

        first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // the int i starts at 4 here because after selecting the column you must drop
                // the piece at the
                // lowest point possible so this starts at the bottom row and goes up
                for (int i = 4; i >= 0; i--) {
                    if (Board[0][i] == 0) {
                        Board[0][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        second.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 4; i >= 0; i--) {
                    if (Board[1][i] == 0) {
                        Board[1][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        third.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 4; i >= 0; i--) {
                    if (Board[2][i] == 0) {
                        Board[2][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        fourth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 4; i >= 0; i--) {
                    if (Board[3][i] == 0) {
                        Board[3][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        fifth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 4; i >= 0; i--) {
                    if (Board[4][i] == 0) {
                        Board[4][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        sixth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 4; i >= 0; i--) {
                    if (Board[5][i] == 0) {
                        Board[5][i] = Player.getTurn();
                        Player.switchTurn();
                        repaint();
                        return;
                    }
                }
            }

        });
        repaint();
    }

    // this method is used to intialize the circle x and y coordinates to make it
    // easier in other methods.
    public Circle circle(int x, int y) {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        return circle;
    }

    // this method is used to create the 2-dimensional array in which the 30 circles
    // are intialially created and
    // placed on the board
    public Circle[][] circles() {
        Circle[][] circles = new Circle[NUM_COLS][NUM_ROWS];
        int y = initialCircleYCoord;
        int x = initialCircleXCoord;
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                circles[i][j] = circle(x, y);
                y = y + 120;
            }
            x = x + 150;
            y = initialCircleYCoord;
        }
        return circles;
    }

    // this method is used to create a 2-dimensional array that will store intially
    // 0 in all 30 places.
    // later on these 0's will be replaced with 1 or 2 depending on which player
    // places a piece in that spot
    public int[][] Board() {
        int[][] Board = new int[NUM_COLS][NUM_ROWS];
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                Board[i][j] = 0;
            }
        }
        return Board;
    }

    // the repaint method is a very useful method to basically update the GUI after
    // a player places a piece or
    // there is a winner on the board.
    // this method is called very often in the SetBoard method so that there will be
    // no point in which the board is not
    // up to date with the most recent move.
    public void repaint() {
        int p1 = 1;
        int p2 = 2;
        // these double for loops help check all 30 elements in the 2-dimensional array
        // that is the board.
        // it will check if any of the elements are 1's or 2's and if it is a 1 or a 2
        // it will repaint the color of the
        // circle in correspondence with the player's color (player1 = red) (player2 =
        // yellow)
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                if (Board[i][j] == 1) {
                    circles[i][j].setFill(Color.RED);
                }
                if (Board[i][j] == 2) {
                    circles[i][j].setFill(Color.YELLOW);
                }
            }
        }
        // will check who's turn it is and therefore set the text in the top center to
        // one of the final variables above
        // telling who needs to place a piece.
        if (Player.getTurn() == 1)
            text.setText(Player1);
        else if (Player.getTurn() == 2)
            text.setText(Player2);
        // these will display if there is a winner after the repaint using the methods
        // below that will check all win conditions
        if (Win(p1) == true)
            text.setText("Player 1 Wins!");
        if (Win(p2) == true)
            text.setText("Player 2 Wins!");
    }

    // this method will check for all possible ways a player could win horizontally
    public boolean horizontalWin(int player) {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS - 4; j++) {
                // here is the if statement that will check if there are 4 in-a-row
                if (Board[i][j] == player && Board[i][j + 1] == player && Board[i][j + 2] == player
                        && Board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    // this method checks for all possible vertical wins
    public boolean verticalWin(int player) {
        for (int i = 0; i < NUM_ROWS - 3; i++) {
            for (int j = 0; j < NUM_COLS - 1; j++) {
                if (Board[i][j] == player && Board[i + 1][j] == player && Board[i + 2][j] == player
                        && Board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    // this method checks for all possible diagonal wins in the upwards pointing
    // position
    public boolean updiagonalWin(int player) {
        for (int i = 3; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS - 3; j++) {
                if (Board[i][j] == player && Board[i - 1][j + 1] == player && Board[i - 2][j + 2] == player
                        && Board[i - 3][j + 3] == player)
                    return true;
            }
        }
        return false;
    }

    // lastly this checks for the down diagonal wins
    public boolean downdiagonalWin(int player) {

        for (int i = 0; i < NUM_ROWS - 3; i++) {
            for (int j = 0; j < NUM_COLS - 3; j++) {
                if (Board[i][j] == player && Board[i + 1][j + 1] == player && Board[i + 2][j + 2] == player
                        && Board[i + 3][j + 3] == player)
                    return true;

            }
        }
        return false;
    }

    // this method combines all possible win conditions into one method to make it
    // simpler in the repaint method
    // using this method if any of the above methods are true the correct winner
    // will be displayed.
    public boolean Win(int player) {
        if (verticalWin(player) == true || horizontalWin(player) == true || updiagonalWin(player) == true
                || downdiagonalWin(player) == true)
            return true;
        else
            return false;
    }
}
