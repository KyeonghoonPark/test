package com.smtm.myapplication.view

import android.content.Context
import android.os.IBinder
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.smtm.myapplication.MainSearchRecyclerViewAdapter
import com.smtm.myapplication.R
import com.smtm.myapplication.base.BaseKotlinActivity
import com.smtm.myapplication.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseKotlinActivity<com.smtm.myapplication.databinding.ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    private val mainSearchRecyclerViewAdapter: MainSearchRecyclerViewAdapter by inject()


    private val TAG = "MainActivity"



    override fun initStartView() {
        Log.e(TAG, "initStartView()")
        main_activity_search_recycler_view.run {
            adapter = mainSearchRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity);
            setHasFixedSize(false)
        }
    }

    override fun initDataBinding() {
        Log.e(TAG, "initDataBinding()")
        viewModel.searchResponseLiveData.observe(this, Observer {
            it.items.forEach { items ->
                mainSearchRecyclerViewAdapter.addItem(items.name, items.description, items.owner.avatar_url)
            }
            mainSearchRecyclerViewAdapter.notifyDataSetChanged()
            Log.e(TAG, "initDataBinding() observe")
        })
    }

    override fun initAfterBinding() {
        main_activity_search_button.setOnClickListener {
            Log.e(TAG,"main_activity_search_button setOnClickListener")
            mainSearchRecyclerViewAdapter.clearItem()
            viewModel.getSearch(main_activity_search_text_view.text.toString())
            dismissKeyboard(it.windowToken)
        }


    }


    private fun dismissKeyboard(windowToken: IBinder) {
        val imm = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    }
}
