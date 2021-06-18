package com.distributor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import blockchaincall.BlockChain;
import blockchaincall.BlockChainUrl;
import blockchaincall.ObjectConversion;

import com.Modul.DistributorModel;
import com.http.servlet.HttpsServlet;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class DistributorContract extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String proid = request.getParameter("id");
			System.out.println("****************>" + proid);
			String chainre = BlockChain
					.retriveChain(BlockChainUrl.DISTRIBUTOR_CHAIN);
			System.out.println(chainre);
			JSONObject jsonObject = (JSONObject) new JSONParser()
					.parse(chainre);
			JSONArray array = (JSONArray) jsonObject.get("chain");
			System.out.println("hi" + array);
			JSONObject json = null;
			JSONArray array2 = null;
			String path = null;
			for (int i = 1; i < array.size(); i++) {
				json = (JSONObject) array.get(i);
				array2 = (JSONArray) json.get("transactions");
				json = (JSONObject) array2.get(0);
				String pro_id = (String) json.get("productid");
				if (pro_id.equals(proid)) {
					path = (String) json.get("filepath");
					System.out.println("Path----------------->>" + path);

					byte[] object = (byte[]) Base64.decode(path);
					Object findbyid = (Object) new ObjectConversion()
							.byteToObj(object);
					if (findbyid instanceof DistributorModel) {
						DistributorModel sample = (DistributorModel) findbyid;

						request.setAttribute("id", proid);
						System.out.println("------------------->>>" + sample);
						request.setAttribute("contract", sample);
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("dtrace.jsp");
						dispatcher.forward(request, response);
					} else {

						System.out.println();
					}
				} else {
					System.out.println("========================");
				}
			}

		} catch (Exception e) {
			System.out
					.println("--------------------------------------------------"
							+ e);

		}
	}

}
