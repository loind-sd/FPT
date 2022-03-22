package com.musicapp;

import static com.musicapp.ApplicationClass.ARTIST_NAME;
import static com.musicapp.ApplicationClass.ARTIST_TO_FRAG;
import static com.musicapp.ApplicationClass.MUSIC_FILE;
import static com.musicapp.ApplicationClass.MUSIC_FILE_LAST_PLAYED;
import static com.musicapp.ApplicationClass.PATH_TO_FRAG;
import static com.musicapp.ApplicationClass.REQUEST_CODE;
import static com.musicapp.ApplicationClass.SHOW_MINI_PLAYER;
import static com.musicapp.ApplicationClass.SONG_NAME;
import static com.musicapp.ApplicationClass.SONG_NAME_TO_FRAG;
import static com.musicapp.ApplicationClass.albums;
import static com.musicapp.ApplicationClass.musicFilesList;
import static com.musicapp.ApplicationClass.nowPlayingFragment;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.musicapp.fragment.AlbumFragment;
import com.musicapp.fragment.SongsFragment;
import com.musicapp.model.MusicFiles;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    static boolean shuffleBoolean = false;
    static boolean repeatBoolean = false;
    private String MY_SORT_PREF = "SortOrder";
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission();
    }

    private void permission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        } else {
            musicFilesList = getAllAudio(this);
            bindingView();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                musicFilesList = getAllAudio(this);
                bindingView();
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        }
    }

    private void bindingView() {
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new SongsFragment(), "Songs");
        viewPagerAdapter.addFragments(new AlbumFragment(), "Album");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.frag_bottom_player, nowPlayingFragment)
                .commit();
    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;
        private List<String> titles;

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        void addFragments(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    public List<MusicFiles> getAllAudio(Context context) {
        SharedPreferences preferences = getSharedPreferences(MY_SORT_PREF, MODE_PRIVATE);
        String sortOrder = preferences.getString("sorting", "sortByName");
        ArrayList<String> duplicate = new ArrayList<>();
        albums.clear();
        List<MusicFiles> musicFilesList = new ArrayList<>();
        String order = null;
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        switch (sortOrder){
            case "sortByName":
                order = MediaStore.MediaColumns.DISPLAY_NAME + " ASC";
                break;
            case "sortByDate":
                order = MediaStore.MediaColumns.DATE_ADDED + " ASC";
                break;
            case "sortBySize":
                order = MediaStore.MediaColumns.SIZE + " DESC";
                break;
        }
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media._ID
        };
        Cursor cursor = context.getContentResolver()
                .query(uri,projection,null,null,order);
        if (cursor != null){
            while (cursor.moveToNext()){
                String title = cursor.getString(0);
                String album = cursor.getString(1);
                String duration = cursor.getString(2);
                String path = cursor.getString(3);
                String artist = cursor.getString(4);
                String id = cursor.getString(5);

                if (duration != null) {
                    MusicFiles musicFiles = new MusicFiles(id,path,title,artist,album,duration);
                    Log.e(id+"Path : "+path, " Album : "+ album + " Duration:" + duration);
                    musicFilesList.add(musicFiles);
                    if(!duplicate.contains(album)){
                        albums.add(musicFiles);
                        duplicate.add(album);
                    }
                }
            }
            cursor.close();
        }
        return musicFilesList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.search_option);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String textInput = newText.toLowerCase();
        List<MusicFiles> musicListSearch = new ArrayList<>();
        for(MusicFiles song: musicFilesList){
            if(song.getTitle().toLowerCase().contains(textInput)){
                musicListSearch.add(song);
            }
        }
        SongsFragment.musicAdapter.updateList(musicListSearch);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences.Editor editor = getSharedPreferences(MY_SORT_PREF, MODE_PRIVATE).edit();
        switch (item.getItemId()){
            case(R.id.by_name):
                editor.putString("sorting", "sortByName");
                editor.apply();
                this.recreate();
                break;
            case(R.id.by_date):
                editor.putString("sorting", "sortByDate");
                editor.apply();
                this.recreate();
                break;
            case(R.id.by_size):
                editor.putString("sorting", "sortBySize");
                editor.apply();
                this.recreate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(MUSIC_FILE_LAST_PLAYED, MODE_PRIVATE);

        String path = preferences.getString(MUSIC_FILE, null);
        String artist = preferences.getString(ARTIST_NAME, null);
        String songName = preferences.getString(SONG_NAME, null);
        if (path != null) {
            SHOW_MINI_PLAYER = true;
            PATH_TO_FRAG = path;
            ARTIST_TO_FRAG = artist;
            SONG_NAME_TO_FRAG = songName;
        }
        else {
            SHOW_MINI_PLAYER = false;
            PATH_TO_FRAG = null;
            ARTIST_TO_FRAG = null;
            SONG_NAME_TO_FRAG = null;
        }
    }

}