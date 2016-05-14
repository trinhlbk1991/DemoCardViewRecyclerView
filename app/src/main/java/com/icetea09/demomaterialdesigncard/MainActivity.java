package com.icetea09.demomaterialdesigncard;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icetea09.demomaterialdesigncard.adapter.CardAdapter;
import com.icetea09.demomaterialdesigncard.entity.Movie;
import com.icetea09.demomaterialdesigncard.utils.BitmapUtils;
import com.icetea09.demomaterialdesigncard.utils.FileReader;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        assert mRecyclerView != null;

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        new LoadMoviesTask().execute();

    }

    class LoadMoviesTask extends AsyncTask<Void, Void, List<Movie>> {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(MainActivity.this, getString(R.string.title_loading),
                    getString(R.string.msg_loading), true);
        }

        @Override
        protected List<Movie> doInBackground(Void... params) {
            try {
                String strMovies = FileReader.getStringFromFile(getAssets(), "movies.json");
                Gson gson = new Gson();
                List<Movie> movies = gson.fromJson(strMovies, new TypeToken<List<Movie>>() {
                }.getType());

                for (Movie movie : movies) {
                    movie.imageBitmap = BitmapUtils.getBitmapFromAsset(getAssets(), movie.image);
                }

                return movies;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            dialog.dismiss();
            mAdapter.getItems().addAll(movies);
            mAdapter.notifyDataSetChanged();
        }
    }


}
