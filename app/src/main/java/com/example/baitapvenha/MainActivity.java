package com.example.baitapvenha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        recyclerView = findViewById( R.id.recycler );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        new DownloadTask( this ).execute( "https://lebavui.github.io/jsons/users.json" );
    }

    class DownloadTask extends AsyncTask<String, Void, List<IteamModel>> {
        ProgressDialog dialog;
        Context context;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog( context );
            dialog.setMessage( "Loading data..." );
            dialog.show();
        }

        @Override
        protected List<IteamModel> doInBackground(String... params) {
            try {
                URL url = new URL( params[0] );
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod( "GET" );

                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
                while ((line = reader.readLine()) != null)
                    builder.append( line );
                reader.close();

                String jsonString = builder.toString();

                List<IteamModel> items = new ArrayList<>();
                JSONArray jArr = new JSONArray( jsonString );
                for (int i = 0; i < jArr.length(); i++) {
                    JSONObject jObj = jArr.getJSONObject( i );
                    int id = jObj.getInt( "id" );
                    String username = jObj.getString( "username" );
                    String name = jObj.getString( "name" );
                    String email = jObj.getString( "email" );
                    String phone = jObj.getString( "phone" );
                    String company = jObj.getString( "company" );
                    String address = jObj.getString( "address" );
                    IteamModel item = new IteamModel( id, username, name, email,phone,company,address );
                    items.add( item );
                }
                return items;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<IteamModel> items) {
            dialog.dismiss();
            if (items != null) {
                Log.v( "TAG", "Size:" + items.size() );
                Adapter adapter = new Adapter( items );
                recyclerView.setAdapter( adapter );
            }
        }
    }
}