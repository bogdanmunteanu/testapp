package ro.bogdanmunteanu.testapp.kotlin

import android.os.Bundle
import ro.bogdanmunteanu.testapp.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
