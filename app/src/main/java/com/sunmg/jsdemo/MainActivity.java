package com.sunmg.jsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private EditText input_et;
    private Button btn_invoke_js;
    private Button btn_invoke_js2;
    private LinearLayout activity_main;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        webView.setVerticalScrollbarOverlay(true);
        webView.getSettings().setJavaScriptEnabled(true);
        // 加载本地网页
        webView.loadUrl("file:///android_asset/index_js.html");
        // 在JS中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        // 添加客户端支持
        webView.setWebChromeClient(new WebChromeClient());

        onInvokeJs();
        onInvokeJs2();
    }

    private void onInvokeJs2() {
        btn_invoke_js2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:showInfoFromApp()");
            }
        });
    }

    private void onInvokeJs() {
        btn_invoke_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = input_et.getText().toString();
                Log.d("JSD","msg: "+msg);
                msg.replaceAll("\\\\","\\\\\\\\");
                webView.loadUrl("javascript:showInfoFromAppWithMsg(' "+msg+" ')");
            }
        });
    }

    private void initView() {
        input_et = (EditText) findViewById(R.id.input_et);
        btn_invoke_js = (Button) findViewById(R.id.btn_invoke_js);
        btn_invoke_js2 = (Button) findViewById(R.id.btn_invoke_js2);
        webView = (WebView) findViewById(R.id.webView);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
    }
}
