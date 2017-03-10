package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame
{
    PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame()
    {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx)
    {
        if(playerIdx == state.getTurn())
        {
            return true;
        }else
        {
            return false;
        }

    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action)
    {
        if(action instanceof PigHoldAction)
        {
            int turn = state.getTurn();
            if(turn == 0)
            {
                int initP1Score = state.getP1Score();
                int total = state.getRunningTotal();
                state.setP1Score(initP1Score + total);
                state.setWhoseTurn( 1 - state.getTurn());
                state.setDieValue(0);
                state.setRunningTotal(0);
                return true;
            }else
            {
                int initP0Score = state.getP0Score();
                int total = state.getRunningTotal();
                state.setP0Score(initP0Score + total);
                state.setWhoseTurn( 1 - state.getTurn());
                state.setDieValue(0);
                state.setRunningTotal(0);
                return true;
            }

        }else if(action instanceof PigRollAction)
        {
            int rand = (int)((Math.random() * 6) + 1);
            if(rand == 1)
            {
                state.setRunningTotal(0);
                state.setDieValue(1);
                state.setWhoseTurn( 1 - state.getTurn());
                return true;
            }else
            {
                int currRunningTotal = state.getRunningTotal();
                state.setRunningTotal(currRunningTotal + rand);
                state.setDieValue(rand);
                return true;
            }
        }else
        {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p)
    {
        if(state == null)
        {
            return;
        }

        PigGameState stateForPlayer = new PigGameState(state);

        p.sendInfo(stateForPlayer);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver()
    {
        int currP0Score = state.getP0Score();
        int currP1Score = state.getP1Score();
        if(currP0Score >= 50)
        {
            return "Player 0 is the winner!";
        }else if(currP1Score >= 50)
        {
            return "Player 1 is the winner!";
        }else
        {
            return null;
        }
    }

}// class PigLocalGame
