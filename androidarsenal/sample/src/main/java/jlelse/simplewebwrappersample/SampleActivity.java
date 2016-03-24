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

package jlelse.simplewebwrappersample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import jlelse.simplewebwrapper.SimpleWebWrapperActivity;

public class SampleActivity extends SimpleWebWrapperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Share Fab
        setShareFab(true);

        // Define whether the activity should open other url in browser or not
        setOnlyOwnPagesAllowed(false);

        // Set start url
        setStartUrl("https://yahoo.com");

        //All SimpleUI methods
        setToolbarEnabled(true);
        initDrawer(true, R.menu.drawer, new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_home:
                        // load url
                        loadUrl(getStartUrl());
                        break;
                    case R.id.drawer_news:
                        loadUrl("https://news.yahoo.com");
                        break;
                }
                getDrawerLayout().closeDrawers();
                return true;
            }
        }, null);
        // ...

        // Other methods you can use
        getCurrentUrl();
        getCurrentTitle();
    }
}
