package ir.gcorp.myapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNumber  = 0
    var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumber = Random().nextInt(100)


        submit.setOnClickListener {

            Log.i("appLog", "$randomNumber")

            if (step <= 5) {

                val input = inputText.text.toString().toInt()
                checkInput(input)

                step++

            }else {

                gameFinished()
                infoText.text = "You just lost my friend"
            }


        }

    }

    fun checkInput(input: Int) {



        if (input > randomNumber) {
            infoText.text = "Input is bigger than generated number"
        } else if (input < randomNumber) {
            infoText.text = "Input is less than generated number"
        } else {
            infoText.text = "spot on"
            gameFinished()
        }

        stepText.text = "$step / 5"
    }

    fun gameFinished(){
        randomNumber = Random().nextInt(100)
        step = 1
    }
}
