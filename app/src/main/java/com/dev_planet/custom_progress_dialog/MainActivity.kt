package com.dev_planet.custom_progress_dialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var progressDialog : Dialog? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_show_progress.setOnClickListener {
            btn_show_progress.visibility = View.GONE
            showProgress()
            Handler().postDelayed({
                hideProgress()
                btn_show_progress.visibility = View.VISIBLE
            }, 5000)
        }
    }

    private fun showProgress(){
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this);
    }
    private fun hideProgress(){
        progressDialog?.let { if(it.isShowing)it.cancel() }
    }
}
