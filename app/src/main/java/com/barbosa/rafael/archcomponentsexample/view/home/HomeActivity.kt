package com.barbosa.rafael.archcomponentsexample.view.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.barbosa.rafael.archcomponentsexample.domain.coinDomain.model.Coin
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.barbosa.rafael.archcomponentsexample.R
import com.barbosa.rafael.archcomponentsexample.view.home.adapters.CoinAdapter
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var adapter:CoinAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)

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
