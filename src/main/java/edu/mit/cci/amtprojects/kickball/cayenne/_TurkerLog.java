package edu.mit.cci.amtprojects.kickball.cayenne;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _TurkerLog was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TurkerLog extends CayenneDataObject {

    public static final String ASSIGNMENT_ID_PROPERTY = "assignmentId";
    public static final String DATA_PROPERTY = "data";
    public static final String DATE_PROPERTY = "date";
    public static final String QUERY_PARAMS_PROPERTY = "queryParams";
    public static final String TYPE_PROPERTY = "type";
    public static final String WORKER_ID_PROPERTY = "workerId";
    public static final String HIT_PROPERTY = "hit";
    public static final String TO_BATCH_PROPERTY = "toBatch";

    public static final String ID_PK_COLUMN = "id";

    public void setAssignmentId(String assignmentId) {
        writeProperty("assignmentId", assignmentId);
    }
    public String getAssignmentId() {
        return (String)readProperty("assignmentId");
    }

    public void setData(String data) {
        writeProperty("data", data);
    }
    public String getData() {
        return (String)readProperty("data");
    }

    public void setDate(Date date) {
        writeProperty("date", date);
    }
    public Date getDate() {
        return (Date)readProperty("date");
    }

    public void setQueryParams(String queryParams) {
        writeProperty("queryParams", queryParams);
    }
    public String getQueryParams() {
        return (String)readProperty("queryParams");
    }

    public void setType(String type) {
        writeProperty("type", type);
    }
    public String getType() {
        return (String)readProperty("type");
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


    public void setToBatch(Batch toBatch) {
        setToOneTarget("toBatch", toBatch, true);
    }

    public Batch getToBatch() {
        return (Batch)readProperty("toBatch");
    }


}
