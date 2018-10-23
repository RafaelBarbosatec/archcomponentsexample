package com.barbosa.rafael.archcomponentsexample.view.home.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barbosa.rafael.archcomponentsexample.R
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.model.Coin
import com.barbosa.rafael.archcomponentsexample.util.loadFromUrl
import kotlinx.android.synthetic.main.item_coin.view.*

/**
 * Created by rafael on 23/10/18.
 */
class CoinAdapter(var mlista: ArrayList<Coin>,
                  val context: Context?) : RecyclerView.Adapter<CoinAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = mlista[position]

        holder.itemView.textView_name.text = item.name
        holder.itemView.textView_price_value.text = item.price_brl
        holder.itemView.imageview_coin.loadFromUrl("https://res.cloudinary.com/dxi90ksom/image/upload/${item.symbol}")


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlista.size
    }

    fun replaceData(mlista: ArrayList<Coin>){
        this.mlista.clear()
        this.mlista.addAll(mlista)
        notifyDataSetChanged()
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}