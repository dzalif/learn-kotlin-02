package com.example.aliffirdaus.keddit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.aliffirdaus.keddit.features.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null) {
            changeFragment(NewsFragment())
        }
    }

     private fun changeFragment(f: Fragment, cleanTask: Boolean = false) {
         val ft = supportFragmentManager.beginTransaction()
         if(cleanTask) {
             clearBackStack()
         }
         ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
         ft.replace(R.id.activity_base_content, f)
         ft.addToBackStack(null)
         ft.commit()
    }

    private fun clearBackStack() {
        val manager = supportFragmentManager
        if(manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
