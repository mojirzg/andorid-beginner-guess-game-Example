package ir.gcorp.myapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val pref = getSharedPreferences("ir.gcorp.myapp", Context.MODE_PRIVATE)
        val lost = pref.getInt("lost",0)
        val won = pref.getInt("win",0)


        totalCount.text = "${lost + won}"

        lostCount.text = lost.toString()
        wonCount.text = won.toString()


    }
}
