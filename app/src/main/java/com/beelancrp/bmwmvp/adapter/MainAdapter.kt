package com.beelancrp.bmwmvp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.beelancrp.bmwmvp.R
import com.beelancrp.bmwmvp.model.MainModel
import com.pawegio.kandroid.layoutInflater

class MainAdapter(mContext: Context, list: List<MainModel>): BaseAdapter() {

    val mContext: Context = mContext
    val list: List<MainModel> = list

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val vh: ViewHolder
        val view: View
        if(convertView != null){
            view = convertView
            vh = view.getTag() as ViewHolder;
        }else{
            val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
            view = inflater.inflate(R.layout.item_main, parent, false)
            vh = ViewHolder(view)
            view.setTag(vh)
        }

        val item = list.get(position)

        val uri: Uri = Uri.parse(item.image[1])

        vh.image.setImageURI(uri)
        vh.text.setText(item.title)
        return view
    }

    override fun getItem(position: Int): Any? {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position as Long
    }

    override fun getCount(): Int {
        return list.size
    }

    class ViewHolder{
        @BindView(R.id.item_main_image)
        lateinit var image: ImageView

        @BindView(R.id.item_main_text)
        lateinit var text: TextView

        constructor(view: View){
            ButterKnife.bind(this, view)
        }
    }
}
