package ir.gcorp.myapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
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

            Log.i("appLog", "$randomNumber")


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

                gameFinished()
                infoText.text = getString(R.string.you_lost)
            }

            //endregion









        }

    }

    fun checkInput(input: Int) {

        if (input > randomNumber) {
            infoText.text = getString(R.string.input_is_bigger)
        } else if (input < randomNumber) {
            infoText.text = getString(R.string.input_is_less)
        } else {
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
