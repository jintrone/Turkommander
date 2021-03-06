package edu.mit.cci.amtprojects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.protocol.http.WebApplication;

import com.amazonaws.mturk.requester.HIT;
import com.amazonaws.mturk.service.axis.RequesterService;
import com.amazonaws.mturk.util.ClientConfig;

import edu.mit.cci.amtprojects.util.FilePropertiesConfig;
import edu.mit.cci.amtprojects.util.IndexedIterator;

/**
 * User: jintrone
 * Date: 9/1/12
 * Time: 5:07 AM
 */
public class UserHitDataProvider implements IDataProvider<HIT> {

	GlobalManagePage.FormModel model;
	
    public UserHitDataProvider(GlobalManagePage.FormModel model) {
    	this.model = model;
    }

    public void detach() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Iterator<? extends HIT> iterator(long i, long count) {
    	RequesterService requesterService = getRequesterService(model.getSelectRealOrSandboxHitsDropdown());
        List<HIT> hits = new ArrayList<HIT>(Arrays.asList(requesterService.searchAllHITs()));
        return new IndexedIterator<HIT>(hits,i,count);
    }

    public long size() {
    	RequesterService requesterService = getRequesterService(model.getSelectRealOrSandboxHitsDropdown());
        return requesterService.searchAllHITs().length;
    }

	public IModel<HIT> model(HIT hit) {
		return new HITModel2(hit);
	}
	
	private RequesterService getRequesterService(String isReal){
		
		ClientConfig config;
    	
        try {
            config = new FilePropertiesConfig(getClass().getResourceAsStream("/global.mturk.properties"));
        } catch (IOException e) {
            config = new ClientConfig();
        }

        config.setAccessKeyId(model.getSelectAwsCredentialsDropdown());
        config.setSecretAccessKey(model.lookupAwsSecret());

        if (isReal.equals("real")) {
            config.setServiceURL(ClientConfig.PRODUCTION_SERVICE_URL);
        } else {
            config.setServiceURL(ClientConfig.SANDBOX_SERVICE_URL);
        }

		return new RequesterService(config);
	}
	
	
	//TODO later - experiment and batch IDs

}
