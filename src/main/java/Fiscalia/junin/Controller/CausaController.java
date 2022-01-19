package Fiscalia.junin.Controller;


import Fiscalia.junin.Model.Causa;
import Fiscalia.junin.Model.LlamadaTelefonica;
import Fiscalia.junin.Services.ICausaService;
import Fiscalia.junin.Services.IllamadaTelefonicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("causa1")
public class CausaController {

    @Autowired
    private ICausaService causaService;

    @Autowired
    private IllamadaTelefonicaService llamadaTelefonicaService;

    @GetMapping("/causas")
    public String listarCausas(Model model){

        List<Causa> causas = causaService.findAllByDesc();

        model.addAttribute("titulo","Listado de causas");
        model.addAttribute("causas",causas);
        return "/causas";


    }

    @GetMapping("/formCausa")
    public String obtenerFormCausa(Model model){

        model.addAttribute("mensaje","Siguiente");
        model.addAttribute("titulo","Crear causa");
        model.addAttribute("causa",new Causa());
        return "formCausa";

    }

    @PostMapping("/formCausa")
    public String crearCausa(@Valid @ModelAttribute Causa causa, BindingResult result, Model model){

        if(result.hasErrors()) {
            model.addAttribute("mensaje","Siguiente");
            model.addAttribute("titulo","Crear causa");
            return "formCausa";
        }
        model.addAttribute("causa1",causa);
        model.addAttribute("titulo", "Seleccione tipo de informacion");
        return "eleccionInformacion";
    }

    @GetMapping("/formLLamadaTelefonica")
    public String obtenerFormInfoLLamadaTelefonica(Model model) {

        model.addAttribute("mensaje","Finalizar");
        model.addAttribute("llamadaTelefonica", new LlamadaTelefonica());
        model.addAttribute("titulo","Formulario de llamada telefonica");
        return "formLLamadaTelefonica";
    }


    @PostMapping("/formLLamadaTelefonica")
    public String crearInfoLLamadaTelefonica(@Valid @ModelAttribute LlamadaTelefonica llamadaTelefonica, BindingResult result,Model model,
                                             @ModelAttribute("causa1") Causa causa) {

        if(result.hasErrors()) {
            model.addAttribute("mensaje","Finalizar");
            model.addAttribute("titulo","Formulario de llamada telefonica");
            return "formLLamadaTelefonica";
        }
        Causa causa1 = causaService.save(causa);
        llamadaTelefonica.setCausa(causa1);
        llamadaTelefonicaService.save(llamadaTelefonica);
        return "redirect:/causas";
    }

    //falta detalle--> editar o no la observacion de la causa y falta formRedSocial y formMovBancario
}

