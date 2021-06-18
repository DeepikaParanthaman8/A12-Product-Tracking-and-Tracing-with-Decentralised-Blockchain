package com.project.supplychain;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String drn="";
    private ListView distributor,manufacturer,supplier;
    private ImageView img;
    JSONArray array =null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distributor = findViewById(R.id.list_distributor);
        manufacturer = findViewById(R.id.list_manufacturer);
        supplier = findViewById(R.id.list_supplier);
        img = findViewById(R.id.product_img);

        drn = getIntent().getStringExtra("code");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Connection.USER_PRODUCT,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // progressBar.setVisibility(View.GONE);

                        List<String> dist = new ArrayList<String>();
                        List<String> manu = new ArrayList<String>();
                        List<String> supl = new ArrayList<String>();
                        try {
                            //converting response to json object
                            org.json.JSONArray obj = new org.json.JSONArray(response);
                            Log.e("response",obj.toString());

                                org.json.JSONObject jsonObject = new org.json.JSONObject(obj.get(0).toString());
                              //  Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.e("response",obj.toString());
                               // JSONObject jsonObject = obj.getJSONObject("user");
                                String url = jsonObject.get("dImage").toString();
                                String[] imgarry = url.split("\\\\");
                                String imgurl = imgarry[3];

                                Picasso.with(getApplicationContext())
                                        .load(Connection.Product_Image+imgurl)
                                        .into(img);
                                Log.e("json",jsonObject.toString());
                                dist.add("DistributorId:-"+jsonObject.get("dDistributorId").toString());
                                dist.add("DistributorPrice:-"+jsonObject.get("dDistributorPrice").toString());
                                dist.add("ProductName:-"+jsonObject.get("dProductName").toString());
                                dist.add("ProductId:-"+jsonObject.get("dProductId").toString());
                                distributor.setAdapter(new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,dist));


                                Utility.setDynamicHeight(distributor);

                               manu.add("ProductId:-"+jsonObject.get("mProductId").toString());
                                manu.add("ProductName:-"+jsonObject.get("mProductName").toString());
                                manu.add("AssembleDate:-"+jsonObject.get("mAssembleDate").toString());
                               manu.add("ProductCount:-"+jsonObject.get("mProductCount ").toString());
                                manu.add("ProductPrice:-"+jsonObject.get("mProductPrice").toString());

                                manufacturer.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,manu));
                                Utility.setDynamicHeight(manufacturer);

                            for (int i=1;i<obj.length();i++) {
                                JSONObject jobj = new JSONObject(obj.get(i).toString());
                                Log.e("array",obj.get(i).toString());
                                supl.add("Quantity:-"+jobj.get("sQuantity").toString());
                                supl.add("SupplierId:-"+jobj.get("sSupplier Id").toString());
                                supl.add("ProductId:-"+jobj.get("sProductId").toString());

                            }
                            supplier.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,supl));
                            Utility.setDynamicHeight(supplier);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("qrid",drn.trim());

                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


        /*try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, Connection.USER_PRODUCT,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("result-----------",response);
                            List<String> dist = new ArrayList<String>();
                            List<String> manu = new ArrayList<String>();
                            List<String> supl = new ArrayList<String>();
                            try {
                                array = (JSONArray) new JSONParser().parse(response);


                                JSONObject jsonObject = (JSONObject) array.get(0);

                                    String url = jsonObject.get("Image").toString();
                                   String[] imgarry = url.split("\\*");
                                   String imgurl = imgarry[3];

                                Picasso.with(getApplicationContext())
                                        .load(Connection.Product_Image+imgurl)
                                        .into(img);

                                   dist.add("DistributorId "+jsonObject.get("DistributorId").toString());
                                   dist.add("DisDate "+jsonObject.get("DisDate").toString());
                                   dist.add("DistributorPrice "+jsonObject.get("DistributorPrice").toString());
                                   dist.add("Packets "+jsonObject.get("Packets").toString());
                                   dist.add("ProductName "+jsonObject.get("ProductName").toString());
                                   dist.add("ProductId"+jsonObject.get("ProductId").toString());

                                   JSONObject jsonObject1 = (JSONObject) array.get(1);
                                manu.add("ProductId "+jsonObject1.get("ProductId").toString());
                                manu.add("ProductName "+jsonObject1.get("ProductName").toString());
                                manu.add("PackingDate "+jsonObject1.get("PackingDate").toString());
                                manu.add("ExpriyDate "+jsonObject1.get("ExpriyDate").toString());
                                manu.add("Packets "+jsonObject1.get("Packets").toString());
                                manu.add("ProductPrice "+jsonObject1.get("ProductPrice").toString());

                                JSONObject jsonObject2 = (JSONObject) array.get(2);
                                supl.add("SupplierId "+jsonObject2.get("SupplierId").toString());
                                supl.add("ProductName "+jsonObject2.get("ProductName").toString());
                                supl.add("ProductId "+jsonObject2.get("ProductId").toString());
                                supl.add("Quantity "+jsonObject2.get("Quantity").toString());

                                distributor.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,dist));
                                manufacturer.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,manu));
                                supplier.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,supl));
                                Utility.setDynamicHeight(distributor);
                                Utility.setDynamicHeight(manufacturer);
                                Utility.setDynamicHeight(supplier);




                            }catch (Exception e){
                                e.printStackTrace();
                            }


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("id",drn.trim());


                    return params;
                }
            };

            VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
