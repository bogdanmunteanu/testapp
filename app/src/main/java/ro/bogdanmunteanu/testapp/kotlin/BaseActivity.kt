package ro.bogdanmunteanu.testapp.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Base activity that extends AppCompatActivity
 */

open class BaseActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }



}