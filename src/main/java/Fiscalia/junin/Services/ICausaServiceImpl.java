package Fiscalia.junin.Services;


import Fiscalia.junin.Model.Causa;
import Fiscalia.junin.Repository.CausaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICausaServiceImpl implements ICausaService{

    @Autowired
    private CausaRepository causaRepository;

    @Override
    public List<Causa> findAllByDesc() {
        return causaRepository.findAllByDesc();
    }

    @Override
    public Causa save(Causa c) {
        return causaRepository.save(c);
    }
}
