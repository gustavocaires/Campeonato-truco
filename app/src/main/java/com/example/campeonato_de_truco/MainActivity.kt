package com.example.campeonato_de_truco

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun resultado(componente: View) {
        if (et_ptVitoria.text.toString().length == 0 || et_ptDerrotas.text.toString().length == 0 ||
            et_ptEmpate.text.toString().length == 0 || et_jogador. text.toString().length == 0){

            tv_resultado.text = "preencha todos os campos corretamente"
            tv_resultado.setTextColor(Color.RED)
            tv_resultado.visibility = View.VISIBLE
            return
        }

        val vitoria = et_ptVitoria.text.toString().toInt()
        val empate = et_ptEmpate.text.toString().toInt()
        val derrota = et_ptDerrotas.text.toString().toInt()
        val total = (vitoria * 10) + (empate * 7) + (derrota * 2)

        if (derrota < 0 || empate < 0 || vitoria < 0){
            tv_resultado.text = "só aceitamos numeros maiores que 0"
            tv_resultado.setTextColor(Color.RED)
        }

        if (total > 100){
            tv_resultado.text = "não é possivel atingir essa quantidade de pontos"
            tv_resultado.setTextColor(Color.RED)
        }

        else{
            when (total) {
                in Int.MIN_VALUE..30 -> tv_resultado.setTextColor(Color.GRAY)
                in 31..60 ->  tv_resultado.setTextColor(Color.CYAN)
                in 61..99 ->  tv_resultado.setTextColor(Color.BLUE)
                100 ->  tv_resultado.setTextColor(Color.YELLOW)
                in 101..Int.MAX_VALUE -> tv_resultado.setTextColor(Color.RED)
            }
            when (total) {
                in Int.MIN_VALUE..30 -> tv_resultado.text = "voce precisa treinar mais"
                in 31..60 ->  tv_resultado.text = "voce está pegando o jeito"
                in 61..99 ->  tv_resultado.text = "muito bem, quase um profissional"
                100 ->  tv_resultado.text = "saia desse bar"
                in 101..Int.MAX_VALUE -> tv_resultado.setTextColor(Color.RED)
            }
        }
        tv_resultado.visibility = View.VISIBLE
    }
}