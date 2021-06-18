package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import blockchaincall.BlockChain;
import blockchaincall.BlockChainUrl;
import blockchaincall.ObjectConversion;

import com.Modul.ContractModel;
import com.Modul.DistributorModel;
import com.Modul.SupplierModel;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class GetQrDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HashMap<Integer, String> hashMap;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		JSONObject manufacturer = new JSONObject();
		JSONObject supplier = new JSONObject();
		hashMap = new HashMap<Integer, String>();
		JSONArray jsonArray = new JSONArray();

		List<JSONObject> finalres = new ArrayList<JSONObject>();

		try {

			// String proid = request.getParameter("8783TometoSauce");
			String proid = request.getParameter("qrid");

			String chainre = BlockChain
					.retriveChain(BlockChainUrl.DISTRIBUTOR_CHAIN);

			JSONObject jsonObject = (JSONObject) new JSONParser()
					.parse(chainre);
			JSONArray array = (JSONArray) jsonObject.get("chain");

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

					byte[] object = (byte[]) Base64.decode(path);
					Object findbyid = (Object) new ObjectConversion()
							.byteToObj(object);
					if (findbyid instanceof DistributorModel) {
						DistributorModel model = (DistributorModel) findbyid;
						JSONObject distributor = new JSONObject();
						distributor.put("dProductName", model.getProname());
						distributor.put("dProductId", model.getProid());
						distributor.put("dDistributorPrice", model
								.getDisPrice());
						distributor.put("dDistributorId", model.getDisId());
						distributor.put("dImage", model.getImages());

						finalres.add(distributor);

						// ------------------------------Manufacture---------------------//

						ContractModel con = (ContractModel) model
								.getContractModel();

						distributor.put("mProductName", con.getManuName());
						distributor.put("mProductPrice", con.getPrice());
						distributor.put("mProductId", con.getProId());
						distributor.put("mAssembleDate", con.getAssembleDate());
						distributor.put("mProductCount ", con
								.getNumberOfProduct());

						jsonArray.add(distributor);
						// --------------------------Supplier---------------------------------//

						List<SupplierModel> models = (ArrayList) con
								.getHashMap();
						for (SupplierModel model2 : models) {
							JSONObject jsonObject2 = new JSONObject();
							jsonObject2.put("sSupplier Id", model2.getName());
							jsonObject2
									.put("sProductId", model2.getProduceid());
							// jsonObject.put("sProductId",
							// model2.getProduceid());
							jsonObject2.put("sQuantity", model2.getDesc());

							jsonArray.add(jsonObject2);

							/*
							 * distributor.put("sSupplier Id",
							 * model2.getName()); distributor .put("sProductId",
							 * model2.getProduceid());
							 * distributor.put("sQuantity ", model2.getDesc());
							 * supplier.put("message", "values");
							 * supplier.put("error", "false");
							 * supplier.put("user", distributor);
							 */

						}

					} else {
					}

					out.print(jsonArray);
				} else {
				}

			}

		} catch (Exception e) {

		}

	}
}