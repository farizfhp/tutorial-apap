package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model){
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga" ;
    }

    @PostMapping("penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga) ;
        System.out.println(penjaga.getNamaPenjaga());
        model.addAttribute("noBioskop",penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable(required = false) Long noPenjaga,
            Model model
    ){
        System.out.println(noPenjaga);
        if (noPenjaga == null) {
            model.addAttribute("command", "update");
            model.addAttribute("type", "penjaga");
            model.addAttribute("message", "Anda tidak memasukkan nomor penjaga");
            return "failed";
        }
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);

        if(penjaga == null) {
            model.addAttribute("command", "update");
            model.addAttribute("type", "penjaga");
            model.addAttribute("message", "Tidak ada penjaga dengan nomor tersebut");
            return "failed";
        }
        model.addAttribute("penjaga", penjaga);
        return "form-update-penjaga";
    }

    @PostMapping("penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        if (penjagaService.isOpen(penjaga)) {
            penjagaService.updatePenjaga(penjaga);
            model.addAttribute("noBioskop",penjaga.getBioskop().getNoBioskop());
            model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
            return "update-penjaga";
        }
        model.addAttribute("command","update");
        model.addAttribute("type","penjaga");
        model.addAttribute("message", "Bioskop masih buka");
        return "failed";
    }

    @GetMapping("/penjaga/delete/{noPenjaga}")
    public String deletePenjaga(
            @PathVariable(required = false) Long noPenjaga,
            Model model
    ){
        if (noPenjaga == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "penjaga");
            model.addAttribute("message", "Anda tidak memasukkan nomor penjaga");
            return "failed";
        }
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);

        if(penjaga == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "penjaga");
            model.addAttribute("message", "Tidak ada penjaga dengan nomor tersebut");
            return "failed";
        }
        if(penjagaService.isOpen(penjaga)) {
            model.addAttribute("noBioskop",penjaga.getBioskop().getNoBioskop());
            model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
            penjaga.getBioskop().getListPenjaga().remove(penjaga);
            penjagaService.deletePenjaga(penjaga);
            return "delete-penjaga";
        }
        model.addAttribute("command","delete");
        model.addAttribute("type","penjaga");
        model.addAttribute("message", "Bioskop masih buka");
        return "failed";
    }


}