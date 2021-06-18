package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BuyPojo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import service.ShopDao;
import service.UserDao;
import blockchaincall.BlockChain;
import blockchaincall.BlockChainUrl;
import blockchaincall.ObjectConversion;

import com.Modul.CustomerModel;
import com.Modul.DistributorModel;
import com.http.servlet.HttpsServlet;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Paysucess extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("called");
		HttpSession session = request.getSession(false);
		int qu = (Integer) session.getAttribute("toatlquanity");
		String pidd = (String) session.getAttribute("pid");

		System.out.println("------------int-------------" + qu + "======"
				+ pidd);

		List<BuyPojo> list = (ArrayList<BuyPojo>) session
				.getAttribute("buypojo");

		String aa = String.valueOf(qu);
		ShopDao sss = new ShopDao();

		boolean res = sss.updateStore(pidd, aa);
		UserDao userDao = new UserDao();
		String pid = "";
		String date = "";
		String pname = "";
		for (BuyPojo buy : list) {
			pid = buy.getProductId();
			date = buy.getDate();
			pname = buy.getProductName();
			boolean result = userDao.saveProducts(buy);
			System.out.println("Product name---::" + pname);
		}
		try {
			String chainre = BlockChain
					.retriveChain(BlockChainUrl.DISTRIBUTOR_CHAIN);
			System.out.println(chainre);
			JSONObject jsonObject1 = (JSONObject) new JSONParser()
					.parse(chainre);
			JSONArray array = (JSONArray) jsonObject1.get("chain");
			JSONObject json = null;
			JSONArray array2 = null;
			String path = null;
			for (int i = 1; i < array.size(); i++) {
				json = (JSONObject) array.get(i);
				array2 = (JSONArray) json.get("transactions");
				json = (JSONObject) array2.get(0);
				String pro_id = (String) json.get("productid");
				if (pro_id.equals(pid)) {
					path = (String) json.get("filepath");

					byte[] object = (byte[]) Base64.decode(path);
					Object findbyid = (Object) new ObjectConversion()
							.byteToObj(object);
					if (findbyid instanceof DistributorModel) {
						DistributorModel sample = (DistributorModel) findbyid;

						CustomerModel distributorModel = new CustomerModel();
						distributorModel.setDistributorModel(sample);
						distributorModel.setBankName("Global Bank");
						distributorModel.setPurdate(date);
						distributorModel.setTraxId("TRANS" + gen());

						JSONObject jsonObject = new JSONObject();
						jsonObject.put("productid", pid);
						jsonObject.put("filename", pname);
						jsonObject.put("filepath", Base64
								.encode(new ObjectConversion()
										.objToByte(distributorModel)));
						jsonObject.put("sender", "12");
						jsonObject.put("recipient", "12");
						jsonObject.put("amount", "12");

						System.out.println("********" + jsonObject);

						String resp = BlockChain.addTransaction(jsonObject
								.toJSONString(), BlockChainUrl.SELLER_TRANS);
						BlockChain.mineChain(BlockChainUrl.SELLER_MINE);

						request.setAttribute("msg",
								"Your order is placed successfully");
						RequestDispatcher rd = request
								.getRequestDispatcher("menu.jsp");
						rd.forward(request, response);

					} else {
						System.out.println();
					}

				} else {
					System.out.println("========================");
				}
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("BlockChain update");
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			System.out.println("ok MANIIIIIIIIIIIIIIIIIIIIIII");
			request.setAttribute("msg", "Your order is placed successfully");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String chainre = BlockChain
					.retriveChain(BlockChainUrl.SELLER_CHAIN);
			System.out.println(chainre);
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
				Object pid = null;
				if (pro_id.equals(pid)) {
					path = (String) json.get("filepath");
				}
			}

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File(path)));
			CustomerModel contractModel2 = (CustomerModel) ois.readObject();
			ois.close();

			System.out.println(contractModel2);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		request.setAttribute("msg", "Your order is placed successfully");
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);

	}

	public int gen() {
		Random r = new Random(System.currentTimeMillis());
		return 1000000000 + r.nextInt(2000000000);
	}

	public String commonMet(HttpServletRequest request) {
		String accmail = "";
		try {
			Properties prop = new Properties();
			String s1 = request.getRealPath("/");
			FileInputStream fis = new FileInputStream((new StringBuilder())
					.append(s1).append("ip.properties").toString());
			prop.load(fis);
			accmail = prop.getProperty("location").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accmail;
	}
}
