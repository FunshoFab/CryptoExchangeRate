package com.funsooyenuga.cryptoexchangerate.data.api;

import android.content.Context;
import android.util.Log;

import com.funsooyenuga.cryptoexchangerate.BuildConfig;
import com.funsooyenuga.cryptoexchangerate.R;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by FAB THE GREAT on 13/10/2017.
 *
 * Uses a json response stored in assets when app is running in Mock mode
 */

public class MockInterceptor implements Interceptor {

    private Context context;

    private static final String TAG = MockInterceptor.class.getSimpleName();

    MockInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        if (BuildConfig.FLAVOR.equals("mock")) {
            Log.d(TAG, context.getString(R.string.debug_mode_active) +
                    "For live data, change the build variant to prodDebug");

            // Check if the request being sent is for multifull API
            if (chain.request().url().toString().contains("pricemultifull")) {
                String json = loadJsonFromAssets();
                response = new Response.Builder()
                        .code(200)
                        .message(json)
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_0)
                        .body(ResponseBody.create(MediaType.parse("application/json"), json.getBytes()))
                        .addHeader("content-type", "application/json")
                        .build();
            }
        } else {
            Log.d(TAG, "uri: " + chain.request().url());
            response = chain.proceed(chain.request());
        }

        return response;
    }

    private String loadJsonFromAssets() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("multifull.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            Log.d(TAG, "e: " + e.toString());
        }
        return json;
    }
}
