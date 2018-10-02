package com.sanjeevaniehr.user.registration.services;

import java.io.InputStream;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class imageService {
	public InputStream getImage(String id) {
		ClientResponse response = null;
		try {
			System.out.println("inside Get Image:" + id);
			System.out.println(
					"http://ec2-52-203-117-52.compute-1.amazonaws.com:8080/RestEasy-UP-DOWN-Image-File/resteasy/fileservice/download/image/"
							+ id + "/");

			Client client = Client.create();

			WebResource webResource = client.resource(
					"http://ec2-52-203-117-52.compute-1.amazonaws.com:8080/RestEasy-UP-DOWN-Image-File/resteasy/fileservice/download/image/"
							+ id + "/");
			response = webResource.get(ClientResponse.class);
			System.out.println("After calling another services");
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			//
			// System.out.println("Output from Server .... \n");
			// System.out.println(response.getEntity(String.class));
			// System.out.println("got total data");

		} catch (Exception e) {

			e.printStackTrace();

		}
		// System.out.println(response.getEntity(String.class));

		// bout.close();
		// System.out.println("Output from Server .... \n");
		// System.out.println(response.getEntity(String.class));
		// System.out.println("got total data");

		return response.getEntityInputStream();

	}
}
