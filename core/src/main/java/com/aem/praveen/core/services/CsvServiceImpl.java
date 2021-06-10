package com.aem.praveen.core.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.praveen.core.utils.ResolverUtil;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
@Component(service = CsvService.class, immediate = true)
public class CsvServiceImpl implements CsvService {
	@Reference
	ResourceResolverFactory rrf;

	private static final Logger log = LoggerFactory.getLogger(CsvServiceImpl.class);

	public static final String SUBSERVICE = "praveentest";

	public static final String RESOURCE_PATH = "/content/dam/praveen/Sample.csv";

	ResourceResolver rr = null;

	String csvFile = null;

	@Activate
	@Modified
	public void activate() {
		log.info("The bundle is ACTIVATED!!!");
		Map<String, Object> map = new HashMap<>();

		map.put(ResourceResolverFactory.SUBSERVICE, SUBSERVICE);

		try {
			rr = rrf.getServiceResourceResolver(map);
			log.info("Resource Resolver Registered!!!");
		} catch (LoginException e) {
			log.error("LOGIN FAILED");
		}

	}

	@Override
	public String getAsset() throws LoginException {
		List<String> csvDetails = new ArrayList<String>();
        ResourceResolver resolver = null;
        resolver = ResolverUtil.newResolver(rrf);
        Resource csvResource = resolver.getResource(RESOURCE_PATH);
        Asset asset = csvResource.adaptTo(Asset.class);
        Rendition rendition = asset.getOriginal();
        InputStream inputStream = rendition.adaptTo(InputStream.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";

        try {
            while((line = br.readLine()) != null)
            {
                String[] tempArr;
                tempArr = line.split(";");
                String temp = "";
                for(String str : tempArr)
                {
                    temp += str+" "; 
                }
 
                csvDetails.add(temp);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        String str="";
        for(String content:csvDetails)
        {
        	str+=content+" ";
        }
        return str;



	}}

