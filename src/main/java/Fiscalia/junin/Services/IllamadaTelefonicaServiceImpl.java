package Fiscalia.junin.Services;


import Fiscalia.junin.Model.LlamadaTelefonica;
import Fiscalia.junin.Repository.llamadaTelefonicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class IllamadaTelefonicaServiceImpl implements IllamadaTelefonicaService{

    @Autowired
    private llamadaTelefonicaRepository llamadaTelefonicaRepository;

    @Override
    public void save(LlamadaTelefonica llamadaTelefonica) {
        llamadaTelefonicaRepository.save(llamadaTelefonica);

    }
}
