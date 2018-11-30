package fr.andrew.universite.universite_front.etudiant.repository.impl;

import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.etudiant.repository.IEtudiantRepository;
import fr.andrew.universite.universite_front.utils.repository.url;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Repository
public class EtudiantRepositoryImpl implements IEtudiantRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlEtudiant = url.urlF.getUrl() + "etudiants/";

    @Override
    public List<Etudiant> findAll() {

        return restTemplate.exchange(urlEtudiant, HttpMethod.GET, null, new ParameterizedTypeReference<List<Etudiant>>() {
        }).getBody();
    }

    @Override
    public Etudiant getOne(Integer id) {
        return restTemplate.getForObject(urlEtudiant+id, Etudiant.class);
    }

    @Override
    public Etudiant add(Etudiant etudiant) {
        return restTemplate.postForObject(urlEtudiant, etudiant, Etudiant.class);
    }

    @Override
    public Void update(Etudiant etudiant, Integer id) {
        restTemplate.put(urlEtudiant+id, etudiant, Etudiant.class);
        return null;
    }

    @Override
    public Void delete(Integer id) {
        restTemplate.delete(urlEtudiant+id);
        return null;
    }
}
