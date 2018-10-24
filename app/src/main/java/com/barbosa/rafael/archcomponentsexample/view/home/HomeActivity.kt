package com.barbosa.rafael.archcomponentsexample.view.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.barbosa.rafael.archcomponentsexample.domain.coinDomain.model.Coin
import android.view.View
import com.barbosa.rafael.archcomponentsexample.R
import com.barbosa.rafael.archcomponentsexample.util.base.BaseActivity
import com.barbosa.rafael.archcomponentsexample.view.home.adapters.CoinAdapter
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : BaseActivity() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)
    }

    private var adapter:CoinAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()

    }

    private fun initViews() {

        adapter = CoinAdapter(ArrayList(),this,recyclerview_coins)
        adapter?.setNextListern({
            viewModel.nextPage()
        })

    }

    private fun initViewModel() {

        viewModel.getCoins()?.observe(this, Observer<ArrayList<Coin>> { list ->

            adapter?.replaceData(list?:ArrayList())

        })

        viewModel.getProgresControl()?.observe(this, Observer<Boolean> { show ->

            if (show == true){
                progressbar.visibility = View.VISIBLE
            }else{
                progressbar.visibility = View.GONE
            }

        })
    }
}
