package edu.mit.cci.amtprojects.solver;

import edu.mit.cci.amtprojects.HitCreator;
import edu.mit.cci.amtprojects.InnerFormCallback;
import edu.mit.cci.amtprojects.PluginFactory;
import org.apache.wicket.markup.html.panel.Panel;

import java.io.Serializable;

/**
 * User: jintrone
 * Date: 10/17/12
 * Time: 10:36 PM
 */
public class SolverPluginFactory implements PluginFactory, Serializable {


    public Panel getFormPanel(String id,InnerFormCallback callback) {
        return new SolverFormPanel(id,callback);
    }

    public HitCreator getHitCreator() {
        return SolverHitCreator.getInstance();
    }
}
