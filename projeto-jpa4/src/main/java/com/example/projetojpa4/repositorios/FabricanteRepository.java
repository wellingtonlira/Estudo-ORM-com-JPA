package com.example.projetojpa4.repositorios;

import com.example.projetojpa4.dominios.Fabricante;
import com.example.projetojpa4.visoes.FabricanteNome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FabricanteRepository extends CrudRepository<Fabricante, String> {

    @Query("select new com.example.projetojpa4.visoes.FabricanteNome(f.nome) from Fabricante f")
    List<FabricanteNome> findAllByName();

}
