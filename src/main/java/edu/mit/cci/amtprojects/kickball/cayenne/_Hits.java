package edu.mit.cci.amtprojects.kickball.cayenne;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _Hits was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Hits extends CayenneDataObject {

    public static final String AMT_STATUS_PROPERTY = "amtStatus";
    public static final String COMPLETED_PROPERTY = "completed";
    public static final String CREATION_PROPERTY = "creation";
    public static final String ID_PROPERTY = "id";
    public static final String LIFETIME_PROPERTY = "lifetime";
    public static final String REQUESTED_PROPERTY = "requested";
    public static final String SCREEN_PROPERTY = "screen";
    public static final String STATUS_PROPERTY = "status";
    public static final String URL_PROPERTY = "url";
    public static final String BATCH_PROPERTY = "batch";
    public static final String LOGS_PROPERTY = "logs";
    public static final String NEXT_HIT_PROPERTY = "nextHit";
    public static final String PREVIOUS_HIT_PROPERTY = "previousHit";

    public static final String ID_PK_COLUMN = "id";

    public void setAmtStatus(String amtStatus) {
        writeProperty("amtStatus", amtStatus);
    }
    public String getAmtStatus() {
        return (String)readProperty("amtStatus");
    }

    public void setCompleted(Integer completed) {
        writeProperty("completed", completed);
    }
    public Integer getCompleted() {
        return (Integer)readProperty("completed");
    }

    public void setCreation(Date creation) {
        writeProperty("creation", creation);
    }
    public Date getCreation() {
        return (Date)readProperty("creation");
    }

    public void setId(String id) {
        writeProperty("id", id);
    }
    public String getId() {
        return (String)readProperty("id");
    }

    public void setLifetime(Long lifetime) {
        writeProperty("lifetime", lifetime);
    }
    public Long getLifetime() {
        return (Long)readProperty("lifetime");
    }

    public void setRequested(Integer requested) {
        writeProperty("requested", requested);
    }
    public Integer getRequested() {
        return (Integer)readProperty("requested");
    }

    public void setScreen(String screen) {
        writeProperty("screen", screen);
    }
    public String getScreen() {
        return (String)readProperty("screen");
    }

    public void setStatus(String status) {
        writeProperty("status", status);
    }
    public String getStatus() {
        return (String)readProperty("status");
    }

    public void setUrl(String url) {
        writeProperty("url", url);
    }
    public String getUrl() {
        return (String)readProperty("url");
    }

    public void setBatch(Batch batch) {
        setToOneTarget("batch", batch, true);
    }

    public Batch getBatch() {
        return (Batch)readProperty("batch");
    }


    public void addToLogs(TurkerLog obj) {
        addToManyTarget("logs", obj, true);
    }
    public void removeFromLogs(TurkerLog obj) {
        removeToManyTarget("logs", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<TurkerLog> getLogs() {
        return (List<TurkerLog>)readProperty("logs");
    }


    public void setNextHit(Hits nextHit) {
        setToOneTarget("nextHit", nextHit, true);
    }

    public Hits getNextHit() {
        return (Hits)readProperty("nextHit");
    }


    public void setPreviousHit(Hits previousHit) {
        setToOneTarget("previousHit", previousHit, true);
    }

    public Hits getPreviousHit() {
        return (Hits)readProperty("previousHit");
    }


}