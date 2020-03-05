package arte921.ajlauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.MATCH_ALL
import android.content.pm.PackageManager.MATCH_DEFAULT_ONLY
import android.content.pm.ResolveInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

var allApps = mutableListOf<AppEntry>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerViewManager = LinearLayoutManager(this)

        val pm: PackageManager = this.packageManager

        val i = Intent(Intent.ACTION_MAIN,null)
        i.addCategory(Intent.CATEGORY_LAUNCHER)

        val rawAllApps: List<ResolveInfo> = pm.queryIntentActivities(i,0)

        for(ri in rawAllApps) allApps.add(AppEntry(ri.loadLabel(pm) as String, ri.activityInfo.packageName, ri.activityInfo.loadIcon(pm)))

        drawerRv.apply{
            layoutManager = drawerViewManager
            adapter = AppsAdapter(allApps)
        }

        drawerRv.adapter?.notifyDataSetChanged()

    }

}



