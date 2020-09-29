package com.example.projetojpa1.repositorios;

import com.example.projetojpa1.dominius.Praia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
Repository -> Padrão de Projeto (desining pattern).
Ele nos oriente a cria 1 classe (ou interface) por tabela no banco
Nessa classe devem estar presentes os metódos que irão prover as operações junto ao BD

CrudRepository<1, 2>
1 - classe de entidade
2 - classe da PK da Entidade (atributos anotado com @Id)
*/
public interface PraiaRepository extends CrudRepository<Praia, Integer> {

    List<Praia> findByTamanhoLessThan(Double tamanhoMaximo);

    List<Praia> findByNomeContains(String trechoNome);

    int countByTamanhoGreaterThan(Double tamanhoMinimo);

    boolean existsByTamanho(Double tamanho);

    boolean existsByNome(String nome);

}
