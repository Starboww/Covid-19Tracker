package `in`.starbow.covid19_tracker

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class StateAdapter (val list: List<StatewiseItem>):BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
    }

}