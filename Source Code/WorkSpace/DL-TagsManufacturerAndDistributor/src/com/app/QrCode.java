package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class QrCode extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		JSONObject distributor = new JSONObject();
		JSONObject manufacturer = new JSONObject();
		JSONObject supplier = new JSONObject();
		List<JSONObject> finalres = new ArrayList<JSONObject>();
		try {
			String proid = request.getParameter("qrid");
		//	out.print("hgh"+proid);
			// String proid = "1335";
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

					byte[] object = (byte[]) Base64.decode(path);
					Object findbyid = (Object) new ObjectConversion()
							.byteToObj(object);
					if (findbyid instanceof DistributorModel) {
						DistributorModel model = (DistributorModel) findbyid;

						distributor.put("ProductName", model.getProname());
						distributor.put("ProductId", model.getProid());
						distributor.put("DistributorPrice", model.getDisPrice());
						distributor.put("DistributorId", model.getDisId());
						distributor.put("Image", model.getImages());

						finalres.add(distributor);

						// ------------------------------Manufacture---------------------//

						ContractModel con = (ContractModel) model
								.getContractModel();

						manufacturer.put("ProductName", con.getManuName());
						manufacturer.put("ProductPrice", con.getPrice());
						manufacturer.put("ProductId ", con.getProId());
						manufacturer.put("Assemble Date ", con.getAssembleDate());
						manufacturer.put("Product Count", con.getNumberOfProduct());
						int total = Integer.parseInt(con.getPrice())
								* Integer.parseInt(con.getNumberOfProduct());
						manufacturer.put("Total Amount ", total);

						finalres.add(manufacturer);
						// --------------------------Supplier---------------------------------//

						List<SupplierModel> models = (ArrayList) con
								.getHashMap();
						for (SupplierModel model2 : models) {
							supplier.put("SupplierId", model2.getName());
							supplier.put("ProductId", model2.getProduceid());
							supplier.put("Quantity", model2.getDesc());

							finalres.add(supplier);
							// out.println("result---------->>>" + finalres);

						}
						out.print(finalres);

					} else {
						out.println();
					}

				} else {
					//out.println("=---else----");
					out.print(finalres);
				}

			}

		} catch (Exception e) {

		}

		// --------------------------- Distiputter---------------------//

	}

}
