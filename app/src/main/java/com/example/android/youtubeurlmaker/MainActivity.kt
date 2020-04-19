package com.example.android.youtubeurlmaker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android.youtubeurlmaker.di.util.DaggerActivity
import com.example.android.youtubeurlmaker.ui.viewmodels.MainViewModel
import com.google.android.material.navigation.NavigationView
import com.google.gson.JsonObject
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import org.json.JSONObject
import javax.inject.Inject


class MainActivity : DaggerActivity(R.layout.activity_main), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbar = findViewById(R.id.toolbar)
        toolbar.apply {
            setSupportActionBar(this)
        }

        setUpNavigation()

        if(intent?.action == Intent.ACTION_SEND) {
            if ("text/plain" == intent.type) {
                handleSendText(intent) // Handle text being sent
            }
        }
    }

    private fun handleSendText(intent: Intent) {

        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared

            Ion.with(this)
                .load("http://www.youtube.com/oembed?url=$it&format=json")
                .asString()
                .setCallback(FutureCallback<String?> { e, result ->
                    if(e==null && result!=null){
                        val youtubeObj = JSONObject(result)
                        viewModel.addTopic(it, youtubeObj.getString("title"))
                    }else{
                        viewModel.addTopic(it, "No title")
                    }
                })

            //https://www.youtube.com/embed/KbINHTeJWQw?start=100&end=120&version=3&autoplay=1
            //https://www.youtube.com/embed/[video_id]?start=[start_at_second]&end=[end_at_second]

//            https://stackoverflow.com/questions/4661905/how-to-customize-an-end-time-for-a-youtube-video
        }
    }

    private fun setUpNavigation(){
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            navigationView.visibility = View.GONE
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

            when(destination.id){
                R.id.topicEditorScreen->{
                    supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                    supportActionBar!!.setHomeButtonEnabled(false)
                }
                R.id.topicListScreen->{
                    supportActionBar?.show()
                    navigationView.visibility = View.VISIBLE
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED)
                }
                R.id.questionsScreen->{
                    supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                    supportActionBar!!.setHomeButtonEnabled(false)
                }
                else->{
                supportActionBar?.show()
            }
            }
        }

        navigationView.setNavigationItemSelectedListener(this)

        val topLevelDestinations = setOf(R.id.topicListScreen)
        appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations)
            .setDrawerLayout(drawerLayout)
            .build()

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else if(navController.currentDestination?.id == R.id.topicListScreen){
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        else{
            if (!navController.popBackStack()) {
                // Call finish() on your Activity
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        when(id){
            R.id.nav_questions ->navController.navigate(R.id.action_topicListScreen_to_questionsScreen, null, options)
//            R.id.nav_about ->navController.navigate(R.id.action_homeFragment_to_aboutFragment, null, options)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
