package `in`.starbow.covid19_tracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

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
        val view = convertView?:LayoutInflater.from(parent?.context).inflate(R.layout.item_list,parent,false)
        val item= list[position]

        val cnfTV = view.findViewById<TextView>(R.id.cnfTV)
        val actTV = view.findViewById<TextView>(R.id.actTV)
        val decTV = view.findViewById<TextView>(R.id.decTV)
        val recTV = view.findViewById<TextView>(R.id.recTV)
        val state = view.findViewById<TextView>(R.id.stateTV)
        cnfTV.text=SpannableDelta("${item.confirmed}\n ↑${item.deltaconfirmed ?: "0"}","#D32F2F",
            item.confirmed?.length?:0)
        Log.d("DELTA","${item.deltaconfirmed}")
        actTV.text=SpannableDelta("${item.active}\n ↑${item.deltaconfirmed?:"0"}","#D32F2F",
            item.confirmed?.length?:0)
        decTV.text=SpannableDelta("${item.deaths}\n ↑${item.deltadeaths?:"0"}","#FBC02D",
            item.deaths?.length?:0)
        recTV.text=SpannableDelta("${item.recovered}\n ↑${item.deltarecovered?:"0"}","#388E3C",
            item.recovered?.length?:0)
        state.text=item.state

        return view
    }

}