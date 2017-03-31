package com.example.wether.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lijianfu on 2017/3/30.
 * Http请求数据
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
