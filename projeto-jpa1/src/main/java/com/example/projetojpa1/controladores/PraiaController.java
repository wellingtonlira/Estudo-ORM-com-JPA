package com.example.projetojpa1.controladores;

import com.example.projetojpa1.repositorios.PraiaRepository;
import com.example.projetojpa1.dominius.Praia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praias")
public class PraiaController {

    /*
    @Autowired -> Injeta um objeto gerenciado pelo Spring na Controller
    E todos os "Repository" são gerenciados pelo Spring.
    Ele cria, em tempo de execução, implementações dos "Repository"
    de acordo com o driver de BD usado (no caso, H2)
    */
    @Autowired
    private PraiaRepository repository;

    @GetMapping
    public ResponseEntity getPraias(){
        if(repository.count() > 0) {
            return ResponseEntity.ok(repository.findAll());
        }else {
            return ResponseEntity.noContent().build();
        }
        //return repository.count() > 0 ? ResponseEntity.ok(repository.findAll()) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Praia novaPraia){
        repository.save(novaPraia);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPraia(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.ok(repository.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePraia(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dados-gerais")
    public ResponseEntity getDadosGerais() {
        return ResponseEntity.ok("Praias com menos de 9000 : " + repository.findByTamanhoLessThan(9000.0) +
                "Praias contendo a palavra 'amor': " +
                repository.findByNomeContains("amor")
                + "Quantas praias maiores que 200? " +
                repository.countByTamanhoGreaterThan(200.0) +
                "Existe praia com 0 de tamanho? " +
                repository.existsByTamanho(0.0) +
                "Existe 'praia da bandtec'?" +
                repository.existsByNome("praia da bandtec"));
    }
}
