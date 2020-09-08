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
        val nome = et_jogador.text
        val vitoria = et_ptVitoria.text.toString().toInt()
        val empate = et_ptEmpate.text.toString().toInt()
        val derrota = et_ptDerrotas.text.toString().toInt()
        val partidas = vitoria + empate + derrota
        val total = ((vitoria * 10) + (empate * 7) + (derrota * 2))/partidas

        if (nome.length == 0){
            tv_resultado.text = "por favor insira seu nome"
            et_jogador.setTextColor(Color.RED)
        }

        if (derrota < 0 || empate < 0 || vitoria < 0){
            tv_resultado.text = "só aceitamos numeros maiores que 0"
            tv_resultado.setTextColor(Color.RED)
        }


        if (vitoria.toString().length == 0 || derrota.toString().length == 0 || empate.toString().length == 0){
            tv_resultado.text = "preencha todos os campos corretamente"
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

            if (total >= 0 || total <= 30){
                tv_resultado.text = "voce precisa treinar mais"
            }
            if (total > 30  || total <= 60){
                tv_resultado.text = "voce está pegando o jeito"
            }
            if (total > 60  || total <= 99){
                tv_resultado.text = "muito bem, quase um profissional"
            }
            if (total == 100){
                tv_resultado.text = "saia desse bar"
            }
        }
        tv_resultado.visibility = View.VISIBLE
    }
}