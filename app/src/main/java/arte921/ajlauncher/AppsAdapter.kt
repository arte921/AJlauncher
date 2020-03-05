package arte921.ajlauncher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.appentrylayout.view.*

class AppsAdapter(private val appList: MutableList<AppEntry>) : RecyclerView.Adapter<AppsAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.appentrylayout, parent, false))

    override fun getItemCount(): Int {
        return appList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.view.appLabel.text = appList[position].label
        holder.view.packageName.text = appList[position].packageName
        holder.view.appIcon.setImageDrawable(appList[position].icon)

        holder.view.setOnClickListener { holder.view.context.startActivity(holder.view.context.packageManager.getLaunchIntentForPackage(appList[position].packageName)) }
    }
}