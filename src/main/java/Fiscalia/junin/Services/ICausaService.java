package Fiscalia.junin.Services;

import Fiscalia.junin.Model.Causa;

import java.util.List;


public interface ICausaService{

    public List<Causa> findAllByDesc();
    public Causa save(Causa c);
}
