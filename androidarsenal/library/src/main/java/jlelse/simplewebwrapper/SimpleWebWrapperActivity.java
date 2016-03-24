/*
 *    Copyright 2015 Jan-Lukas Else
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package jlelse.simplewebwrapper;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import jlelse.simpleui.SimpleActivity;

public abstract class SimpleWebWrapperActivity extends SimpleActivity {

    private WebView webView;

    // URLs
    private String startUrl;

    // Rules
    private boolean onlyOwnPagesAllowed = true;

    // FAB
    private boolean shareFab = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FAB
        enableFabChanges();

        //WebView
        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (isOnlyOwnPagesAllowed()) {
                    if (Uri.parse(url).getHost().equals(Uri.parse(getStartUrl()).getHost())) {
                        loadUrl(url);
                        return false;
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        addContentView(webView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void loadUrl(String url) {
        webView.loadUrl(url);
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
        loadUrl(getStartUrl());
    }

    public String getCurrentUrl() {
        return webView.getUrl();
    }

    public String getCurrentTitle() {
        return webView.getTitle();
    }

    public boolean isOnlyOwnPagesAllowed() {
        return onlyOwnPagesAllowed;
    }

    public void setOnlyOwnPagesAllowed(boolean onlyOwnPagesAllowed) {
        this.onlyOwnPagesAllowed = onlyOwnPagesAllowed;
    }

    private void enableFabChanges() {
        if (isShareFab()) {
            setFabEnabled(true);
            setFabDrawable(ContextCompat.getDrawable(this, R.drawable.ic_share_white_24dp));
            setFabListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TITLE, webView.getTitle());
                    sendIntent.putExtra(Intent.EXTRA_TEXT, getCurrentUrl());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
            });
        } else {
            setFabEnabled(false);
        }
    }

    public boolean isShareFab() {
        return shareFab;
    }

    public void setShareFab(boolean shareFab) {
        this.shareFab = shareFab;
        if (isShareFab()) {
            enableFabChanges();
        }
    }
}
