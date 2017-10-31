

package cz.fit.adp.mvcshooter.controller.command;

import cz.fit.adp.mvcshooter.model.Model;

/**
 *
 * @author Mikolasek
 */
public class IncreaseGravityCommand  extends Command{

    @Override
    public void execute(Model model) {
        model.getCannon().increaseGravity();
    }

}