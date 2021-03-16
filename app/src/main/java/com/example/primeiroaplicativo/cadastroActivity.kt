package com.example.primeiroaplicativo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro.*

class cadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_inserir.setOnClickListener{
            val produto = txt_produto.text.toString()
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()

            if(produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()){
                val prod = Produto(produto, qtd.toInt(), valor.toDouble())

                produtosGlobal.add(prod)

                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()

            }else{
                txt_produto.error = if(txt_produto.text.isNotEmpty()) "Preencha o produto" else null
                txt_qtd.error = if(txt_qtd.text.isNotEmpty()) "Preencha a quantidade" else null
                txt_valor.error = if(txt_valor.text.isNotEmpty()) "Preencha o valor" else null
            }
        }
    }
}