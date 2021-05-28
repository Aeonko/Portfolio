package com.nemanjamiseljic.portfolio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.RequestManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nemanjamiseljic.portfolio.databinding.ActivityMainBinding
import com.nemanjamiseljic.portfolio.utils.MyFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG by lazy { MainActivity::class.java.name }

    @Inject
    lateinit var fragmentFactory: MyFragmentFactory

    @Inject
    lateinit var glide: RequestManager

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.am_fragment_host) as NavHostFragment

        navController = navHostFragment.findNavController()

        setBottomNavigation()
        setDrawer()
        setUpObservers()

    }

    @SuppressLint("SetTextI18n")
    private fun setUpObservers(){
        viewModel.metaData.observe(this,{ listOfMyMetaData->
            if(listOfMyMetaData.isNotEmpty()){
                val myMetaData = listOfMyMetaData[0]
                binding.apply {
                    val header = amDrawerNavigation.getHeaderView(0)
                    val headerFirstLastName = header.findViewById<TextView>(R.id.dhFirstLastName)
                    val jobDescription = header.findViewById<TextView>(R.id.dhJobDescription)
                    val imageView = header.findViewById<ImageView>(R.id.dhImageView)
                    headerFirstLastName.text = "${myMetaData.firstName} ${myMetaData.lastName}"
                    jobDescription.text = myMetaData.jobTitle
                    glide.load(myMetaData.profilePictureUrl).into(imageView)

                }
            }
        })
    }

    private fun setBottomNavigation() {
        NavigationUI.setupWithNavController(binding.amBottomNavigation, navController)

        binding.amBottomNavigation.itemIconTintList = null

    }

    private fun setDrawer() {
        val appBarConfiguration = AppBarConfiguration(
            setOf( // Fragments we want to have hamburger icon instead of back button as drawer icon
                R.id.profileFragment,
                R.id.portfolioFragment,
                R.id.experienceFragment,
                R.id.contactFragment,
                R.id.settingsFragment

            ), binding.amDrawerLayout
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return if(binding.amDrawerLayout.isOpen){
            binding.amDrawerLayout.closeDrawer(GravityCompat.START)
            true
        }else{
            binding.amDrawerLayout.openDrawer(GravityCompat.START)
            true
        }
//        return super.onSupportNavigateUp()
    }
    override fun onBackPressed() {
//        if (shouldShowExitDialog) {
//            if (binding.drawerLayout.isOpen) {
//                binding.drawerLayout.closeDrawer(GravityCompat.START)
//            } else {
//                navController.navigate(R.id.closeAppDialog)
//            }
//        } else {
//            navController.popBackStack()
//        }
        super.onBackPressed()
    }
}