package edu.mit.cci.amtprojects.solver;

import edu.cci.amtprojects.DefaultEnabledHitProperties;
import edu.cci.amtprojects.HitManager;
import edu.mit.cci.amtprojects.HitCreator;
import edu.mit.cci.amtprojects.UrlCreator;
import edu.mit.cci.amtprojects.kickball.cayenne.Batch;
import edu.mit.cci.amtprojects.util.MturkUtils;
import jsc.util.Rank;
import org.apache.wicket.ajax.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * User: jintrone
 * Date: 10/15/12
 * Time: 3:57 PM
 */
public class SolverHitCreator implements HitCreator {


    private static SolverHitCreator instance;

    private static String rankerpath;
    private static String generatorpath;

    private SolverHitCreator() {

    }

    public static SolverHitCreator getInstance() {
        if (instance == null) {
            instance = new SolverHitCreator();
        }
        return instance;
    }


    public void launch(UrlCreator creator, Object m, Batch b) throws UnsupportedEncodingException, JSONException {

        SolverTaskModel model = (SolverTaskModel) m;
        if (creator != null) {
            if (rankerpath == null) {
                rankerpath = creator.getUrlFor(SolverRankingTask.class);

            }

            if (generatorpath == null) {
                generatorpath = creator.getUrlFor(SolverGenerationTask.class);
            }
        }

        if (model != null && model.getBatch() == null) {
            model.saveToBatch(b);
            SolverProcessMonitor.get(b.getToExperiment());
        } else {
            model = new SolverTaskModel(b);
        }
        SolverTaskStatus status = model.getCurrentStatus();
        String groupText = "["+model.getGroupName()+"]";
        if (status.getPhase() == SolverProcessMonitor.Phase.INIT) {
            DefaultEnabledHitProperties props = new DefaultEnabledHitProperties();
            props.setTitle("Rank a set of answers to a question about climate change "+groupText);
            props.setDescription("Rank a set of answers to the question: " + model.getQuestionText() + "  Bonus of up to $." + String.format("%f.2", model.getMaxRankingBonus()));
            props.setKeywords("climate,experiment,rank,bonus");
            props.setMaxAssignments("" + model.getNumberOfRankers());
            props.setRewardAmount("" + model.getBaseReward());
            props.setAssignmentDuration("600000");
            MturkUtils.addBatchAnnotation(props, b);
            props.setLifetime("600000");

            String launchurl = MturkUtils.addUrlParams(rankerpath, "batch", b.getId() + "");
            HitManager.get(b).launch(launchurl, 800, props);

        } else if (status.getPhase() == SolverProcessMonitor.Phase.GENERATE) {
            DefaultEnabledHitProperties props = new DefaultEnabledHitProperties();
            props.setTitle("Create or improve an answer to a question about climate change "+groupText);
            props.setDescription("Choose to create a new answer or improve existing answers to the question: " + model.getQuestionText() + "  Bonus of up to $." + String.format("%f.2", Math.max(model.getMaxGeneratingBonus(), model.getMaxCombiningBonus())));
            props.setKeywords("climate,experiment,bonus");
            props.setMaxAssignments("" + model.getNumberOfGenerators());
            props.setRewardAmount("" + model.getBaseReward());
            MturkUtils.addBatchAnnotation(props, b);
            props.setLifetime("600000");
            String launchurl = MturkUtils.addUrlParams(generatorpath, "batch", b.getId() + "");
            props.setAssignmentDuration("600000");
            HitManager.get(b).launch(launchurl, 800, props);


        } else if (status.getPhase() == SolverProcessMonitor.Phase.RANK) {
            DefaultEnabledHitProperties props = new DefaultEnabledHitProperties();
            props.setTitle("Rank a set of answers to a question about climate change ["+model.getGroupName()+"]" );
            props.setDescription("Rank a set of answers to the question: " + model.getQuestionText() + "  Bonus of up to $." + String.format("%f.2", model.getMaxRankingBonus()));
            props.setKeywords("climate,experiment,rank,bonus");
            props.setMaxAssignments("" + model.getNumberOfRankers());
            props.setRewardAmount("" + model.getBaseReward());
            props.setLifetime("600000");
            MturkUtils.addBatchAnnotation(props, b);
            String launchurl = MturkUtils.addUrlParams(rankerpath, "batch", b.getId() + "");
            props.setAssignmentDuration("600000");
            HitManager.get(b).launch(launchurl, 800, props);

        }


    }


}
