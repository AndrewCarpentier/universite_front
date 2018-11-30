package fr.andrew.universite.universite_front.enseignant.repository.impl;

import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import fr.andrew.universite.universite_front.utils.repository.url;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import fr.andrew.universite.universite_front.enseignant.repository.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EnseignantRepositoryImpl implements IEnseignantRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlEnseignant = url.urlF.getUrl() + "enseignants/";

    @Override
    public List<Enseignant> findAll() {

        return restTemplate.exchange(urlEnseignant, HttpMethod.GET, null, new ParameterizedTypeReference<List<Enseignant>>() {
        }).getBody();
    }

    @Override
    public Enseignant getOne(Integer id) {
        return restTemplate.getForObject(urlEnseignant+id, Enseignant.class);
    }

    @Override
    public Enseignant add(Enseignant enseignant) {
        return restTemplate.postForObject(urlEnseignant, enseignant, Enseignant.class);
    }

    @Override
    public Void update(Enseignant enseignant, Integer id) {
        restTemplate.put(urlEnseignant+id, enseignant, Enseignant.class);

        return null ;
    }


    @Override
    public Void deleteById(Integer id) {
        restTemplate.delete(urlEnseignant+id);
        return null;
    }
}
