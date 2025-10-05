package padm.io.pad_m.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Orgao;
import padm.io.pad_m.service.OrgaoService;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    @GetMapping
    public ResponseEntity<List<Orgao>> getAllOrgaos() {
        List<Orgao> orgaos = orgaoService.findAll();
        return new ResponseEntity<>(orgaos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orgao> getOrgaoById(@PathVariable Integer id) {
        Optional<Orgao> orgao = orgaoService.findById(id);
        if (orgao.isPresent()) {
            return new ResponseEntity<>(orgao.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Orgao> createOrgao(@RequestBody Orgao orgao) {
        orgaoService.save(orgao);
        return new ResponseEntity<>(orgao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orgao> updateOrgao(@PathVariable Integer id, @RequestBody Orgao orgaoDetails) {
        Optional<Orgao> orgao = orgaoService.findById(id);
        if (orgao.isPresent()) {
            Orgao orgaoToUpdate = orgao.get();
            orgaoToUpdate.setNome(orgaoDetails.getNome());
            orgaoToUpdate.setDescricao(orgaoDetails.getDescricao());
            orgaoToUpdate.setSegmento(orgaoDetails.getSegmento());
            orgaoToUpdate.setSigla(orgaoDetails.getSigla());
            orgaoToUpdate.setObs(orgaoDetails.getObs());
            orgaoToUpdate.setSeq(orgaoDetails.getSeq());
            orgaoToUpdate.setFlag(orgaoDetails.getFlag());
            orgaoToUpdate.setPlaced(orgaoDetails.getPlaced());
            orgaoService.save(orgaoToUpdate);
            return new ResponseEntity<>(orgaoToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrgao(@PathVariable Integer id) {
        Optional<Orgao> orgao = orgaoService.findById(id);
        if (orgao.isPresent()) {
            orgaoService.delete(orgao.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
