package ir.gcorp.myapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNumber  = 0
    var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumber = Random().nextInt(100)


        inputText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                submit.performClick()


        }
            false

        }



        submit.setOnClickListener {

            Log.i("appLog", "random number : $randomNumber")


            //region Logic
            if (step <= 5) {

                if (inputText.text.isNotBlank()){

                    val input = inputText.text.toString().toInt()

                    checkInput(input)

                    step++


                }else{
                    inputText.error = getString(R.string.empty)
                }



            }else {
                //Lost
                val pref = getSharedPreferences("ir.gcorp.myapp", Context.MODE_PRIVATE)
                val lostCount = pref.getInt("lost",0)
                Log.i("appLog","lostCount : $lostCount")
                pref.edit().putInt("lost", lostCount + 1 ).apply()



                gameFinished()
                infoText.text = getString(R.string.you_lost)



            }

            //endregion









        }


        detail.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
        }



//        val db = Database(this)
//
//        db.addString("k","jnkn")
//
//        db.getString("k")



    }

    fun checkInput(input: Int) {

        if (input > randomNumber) {
            infoText.text = getString(R.string.input_is_bigger)
        } else if (input < randomNumber) {
            infoText.text = getString(R.string.input_is_less)
        } else {

            val pref = getSharedPreferences("ir.gcorp.myapp", Context.MODE_PRIVATE)
            val winCount = pref.getInt("win",0)
            Log.i("appLog","winCount : $winCount")
            pref.edit().putInt("win", winCount + 1 ).apply()



            infoText.text = getString(R.string.you_win)
            gameFinished()


        }

        stepText.text = "$step / 5"
    }

    fun gameFinished(){
        randomNumber = Random().nextInt(100)
        step = 1
    }
}
