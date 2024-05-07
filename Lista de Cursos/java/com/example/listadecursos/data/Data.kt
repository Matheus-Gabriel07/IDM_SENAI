package com.example.listadecursos.data

import com.example.listadecursos.R
import com.example.listadecursos.model.Cursos

class Data {
    fun carregarGradeCursos():List<Cursos> {
        return listOf<Cursos>(
            Cursos(R.drawable.arquitetura,R.string.aquitetura, 58),
            Cursos(R.drawable.artes,R.string.games, 121),
            Cursos(R.drawable.adm,R.string.administracao,78),
            Cursos(R.drawable.culinaria,R.string.culinaria,118),
            Cursos(R.drawable.design,R.string.design,423),
            Cursos(R.drawable.moda,R.string.moda,92),
            Cursos(R.drawable.games,R.string.games,165),
            Cursos(R.drawable.desenho,R.string.desenho,326),
            Cursos(R.drawable.economia,R.string.financas, 302),
            Cursos(R.drawable.musica,R.string.musica,212),
            Cursos(R.drawable.pintura,R.string.pintura,172),
            Cursos(R.drawable.fotografia,R.string.fotografia,321),
            Cursos(R.drawable.tecnologia,R.string.tecnologia,118),
        )
    }
}