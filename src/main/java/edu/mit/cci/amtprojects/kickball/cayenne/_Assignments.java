package edu.mit.cci.amtprojects.kickball.cayenne;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _Assignments was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Assignments extends CayenneDataObject {

    public static final String ASSIGNMENT_ID_PROPERTY = "assignmentId";
    public static final String BONUSED_PROPERTY = "bonused";
    public static final String COMPLETION_DATE_PROPERTY = "completionDate";
    public static final String HIT_ID_PROPERTY = "hitId";
    public static final String LAUNCH_DATE_PROPERTY = "launchDate";
    public static final String PROCESSED_PROPERTY = "processed";
    public static final String RESULTS_PROPERTY = "results";
    public static final String STATUS_PROPERTY = "status";
    public static final String TASK_DURATION_SECONDS_PROPERTY = "taskDurationSeconds";
    public static final String URL_PROPERTY = "url";
    public static final String WORKER_ID_PROPERTY = "workerId";
    public static final String HIT_PROPERTY = "hit";

    public static final String ID_PK_COLUMN = "id";

    public void setAssignmentId(String assignmentId) {
        writeProperty("assignmentId", assignmentId);
    }
    public String getAssignmentId() {
        return (String)readProperty("assignmentId");
    }

    public void setBonused(Float bonused) {
        writeProperty("bonused", bonused);
    }
    public Float getBonused() {
        return (Float)readProperty("bonused");
    }

    public void setCompletionDate(Date completionDate) {
        writeProperty("completionDate", completionDate);
    }
    public Date getCompletionDate() {
        return (Date)readProperty("completionDate");
    }

    public void setHitId(String hitId) {
        writeProperty("hitId", hitId);
    }
    public String getHitId() {
        return (String)readProperty("hitId");
    }

    public void setLaunchDate(Date launchDate) {
        writeProperty("launchDate", launchDate);
    }
    public Date getLaunchDate() {
        return (Date)readProperty("launchDate");
    }

    public void setProcessed(boolean processed) {
        writeProperty("processed", processed);
    }
	public boolean isProcessed() {
        Boolean value = (Boolean)readProperty("processed");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setResults(String results) {
        writeProperty("results", results);
    }
    public String getResults() {
        return (String)readProperty("results");
    }

    public void setStatus(String status) {
        writeProperty("status", status);
    }
    public String getStatus() {
        return (String)readProperty("status");
    }

    public void setTaskDurationSeconds(Long taskDurationSeconds) {
        writeProperty("taskDurationSeconds", taskDurationSeconds);
    }
    public Long getTaskDurationSeconds() {
        return (Long)readProperty("taskDurationSeconds");
    }

    public void setUrl(String url) {
        writeProperty("url", url);
    }
    public String getUrl() {
        return (String)readProperty("url");
    }

    public void setWorkerId(String workerId) {
        writeProperty("workerId", workerId);
    }
    public String getWorkerId() {
        return (String)readProperty("workerId");
    }

    public void setHit(Hits hit) {
        setToOneTarget("hit", hit, true);
    }

    public Hits getHit() {
        return (Hits)readProperty("hit");
    }


}
