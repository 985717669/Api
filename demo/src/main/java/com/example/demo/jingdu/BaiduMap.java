package com.example.demo.jingdu;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author fengjf
 * @Desc 百度地图根据地址查询经纬度信息
 **/

public class BaiduMap {
    public static void main(String[] args) {
        BaiduMap getLatAndLngByBaidu = new BaiduMap();
        Map<String, Double> map = getLatAndLngByBaidu.getLngAndLat("广东省深圳市南山区科技南一路");
        System.out.println(map);
        System.out.println("经度：" + map.get("lng") + "---纬度：" + map.get("lat"));
    }


    /**
     * 根据位置查询经纬度
     *
     * @param address
     * @return
     */
    public static Map<String, Double> getLngAndLat(String address) {
        Map<String, Double> map = new HashMap<String, Double>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=c1YlCnWf0Q5LRHNc8ehQerUlGXSGAT1r";
        String json = sendHttp(url);
        JSONObject obj = JSONObject.parseObject(json);
        if (obj.getString("status").equals("0")) {
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
        }
        return map;
    }


    /**
     * 发送GET请求获取返回数据
     *
     * @param url
     * @return
     */
    public static String sendHttp(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL oracle = new URL(url);
            URLConnection connection = oracle.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("请求出现异常！" + e);
            e.printStackTrace();
        }

        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


}
