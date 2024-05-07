package com.example.frasesmotivacionais.dados
import com.example.frasesmotivacionais.R
import com.example.frasesmotivacionais.modelo.Motivacional

class dados {
    fun carregarMotivacionais():List<Motivacional> {
        return listOf<Motivacional>(
            Motivacional(R.string.motivacional1, R.drawable.imagem1),
            Motivacional(R.string.motivacional2, R.drawable.imagem2),
            Motivacional(R.string.motivacional3, R.drawable.imagem3),
            Motivacional(R.string.motivacional4, R.drawable.imagem4),
            Motivacional(R.string.motivacional5, R.drawable.imagem5),
            Motivacional(R.string.motivacional6, R.drawable.imagem6),
            Motivacional(R.string.motivacional7, R.drawable.imagem7),
            Motivacional(R.string.motivacional8, R.drawable.imagem8),
            Motivacional(R.string.motivacional9, R.drawable.imagem9),
            Motivacional(R.string.motivacional10, R.drawable.imagem10)

        )
    }
}