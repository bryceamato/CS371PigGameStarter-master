package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by amato19 on 3/9/2017.
 */
public class PigGameState extends GameState
{
    private int whoseTurn;

    private int p0Score;

    private int p1Score;

    private int runningTotal;

    private int dieValue;

    public PigGameState()
    {
        whoseTurn = 0;
        p0Score = 0;
        p1Score = 0;
        runningTotal = 0;
        dieValue = 1;
    }

    public PigGameState(PigGameState orig)
    {
        this.whoseTurn = orig.whoseTurn;
        this.p0Score = orig.p0Score;
        this.p1Score = orig.p1Score;
        this.runningTotal = orig.runningTotal;
        this.dieValue = orig.dieValue;
    }

    public int getTurn()
    {
        return this.whoseTurn;
    }

    public int getP0Score()
    {
        return this.p0Score;
    }

    public int getP1Score()
    {
        return this.p1Score;
    }

    public int getRunningTotal()
    {
        return this.runningTotal;
    }

    public int getDieValue()
    {
        return this.dieValue;
    }

    public void setWhoseTurn(int turn)
    {
        this.whoseTurn = turn;
    }

    public void setP0Score(int initP0Score)
    {
        this.p0Score = initP0Score;
    }

    public void setP1Score(int initP1Score)
    {
        this.p1Score = initP1Score;
    }

    public void setRunningTotal(int newTotal)
    {
        this.runningTotal = newTotal;
    }

    public void setDieValue(int value)
    {
        this.dieValue = value;
    }
}
