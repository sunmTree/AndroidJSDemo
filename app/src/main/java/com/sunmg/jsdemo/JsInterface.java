package com.sunmg.jsdemo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by sm on 2016/11/1.
 */

public class JsInterface {

    private Context mContext;

    public JsInterface(Context context) {
        mContext = context;
    }


    @JavascriptInterface
    public void showInfoFromJs(String name){
        Toast.makeText(mContext, "来自JS的信息： "+name, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showInfoFromJs(){
        Toast.makeText(mContext, "JS调用App方法", Toast.LENGTH_SHORT).show();
    }
}
