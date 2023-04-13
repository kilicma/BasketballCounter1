package com.kilicma.basketballcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var scoreA: Int =0
    private var scoreB: Int =0

    private var tvScoreA: TextView? = null
    private var tvScoreB: TextView? = null

    private var teamAThree: Button? = null
    private var teamBThree: Button? = null

    private var teamATwo: Button? = null
    private var teamBTwo: Button? = null

    private var teamAFreeThrow: Button? = null
    private var teamBFreeThrow: Button? = null

    private var resetButton: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setUpListener()




/*
        */
    }
    private fun initView(){
        tvScoreA = findViewById(R.id.score_one)
        tvScoreB = findViewById(R.id.score_two)

        teamAThree = findViewById(R.id.left_three_points)
        teamBThree = findViewById(R.id.right_three_points)

        teamATwo = findViewById(R.id.left_two_points)
        teamBTwo = findViewById(R.id.right_two_points)

        teamAFreeThrow = findViewById(R.id.left_free_throw)
        teamBFreeThrow = findViewById(R.id.right_free_throw)

        resetButton = findViewById(R.id.reset_button)
    }

    private fun setUpListener(){
        teamAThree?.setOnClickListener {
            scoreA +=3
            setTextScoreA()
        }
        teamBThree?.setOnClickListener {
            scoreB +=3
            setTextScoreB()
        }

        teamATwo?.setOnClickListener {
            scoreA +=2
            setTextScoreA()
        }
        teamBTwo?.setOnClickListener {
            scoreB +=2
            setTextScoreB()
        }

        teamAFreeThrow?.setOnClickListener {
            scoreA +=1
            setTextScoreA()
        }
        teamBFreeThrow?.setOnClickListener {
            scoreB +=1
            setTextScoreB()
        }

        resetButton?.setOnClickListener {
            scoreA = 0
            setTextScoreA()
            scoreB = 0
            setTextScoreB()
        }

    }
    private fun setTextScoreA(){
        tvScoreA?.text = scoreA.toString()
    }
    private fun setTextScoreB(){
        tvScoreB?.text = scoreB.toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("scoreA", scoreA)
        outState.putInt("scoreB", scoreB)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt("scoreA")
            scoreB = savedInstanceState.getInt("scoreB")
        }
        setTextScoreA()
        setTextScoreB()
    }


}