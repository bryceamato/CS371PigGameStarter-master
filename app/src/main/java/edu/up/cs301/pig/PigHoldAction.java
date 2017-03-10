package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by amato19 on 3/9/2017.
 */
public class PigHoldAction extends GameAction
{
    public PigHoldAction(GamePlayer player)
    {
        super(player);
    }

    public boolean isHold()
    {
        return true;
    }
}
