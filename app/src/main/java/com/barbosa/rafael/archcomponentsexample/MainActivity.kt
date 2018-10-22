package com.barbosa.rafael.archcomponentsexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.model.Coin
import com.barbosa.rafael.archcomponentsexample.view.home.HomeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()

    }

    private fun initViewModel() {

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)
        viewModel.getCoins()?.observe(this, Observer<ArrayList<Coin>> { list ->

            textview_hello.text = list.toString()
            Log.i("LOG","RESP: $list")

        })
    }
}
