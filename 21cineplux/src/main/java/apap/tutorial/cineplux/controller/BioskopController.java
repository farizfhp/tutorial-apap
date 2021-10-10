package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans. factory.annotation.Qualifier;
import org. springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BioskopController {
    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @Qualifier("filmServiceImpl")
    @Autowired
    FilmService filmService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        BioskopModel bioskop = new BioskopModel();
        bioskop.setListFilm(new ArrayList<FilmModel>());
        List<FilmModel> listFilm = filmService.getListFilm();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listFilm", listFilm);
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        System.out.println(Arrays.toString(bioskop.getListFilm().toArray()));
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @PostMapping(value = "/bioskop/add", params = {"addRow"})
    public String addBioskopAddRow(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        System.out.println(bioskop.getNamaBioskop());
        if (bioskop.getListFilm() == null) {
            bioskop.setListFilm(new ArrayList<>());
        }
        bioskop.getListFilm().add(new FilmModel());
        System.out.println(Arrays.toString(bioskop.getListFilm().toArray()));
        model.addAttribute("bioskop", bioskop);
        List<FilmModel> listFilm = filmService.getListFilm();
        model.addAttribute("listFilm", listFilm);
        return "form-add-bioskop";
    }

    @GetMapping("bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        Collections.sort(listBioskop);
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop", required = false) Long noBioskop,
            Model model
    ) {
        System.out.println("masuk view");
        if (noBioskop == null) {
            model.addAttribute("command", "view");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Anda tidak memasukkan nomor bioskop");
            return "failed";
        }
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if(bioskop == null) {
            model.addAttribute("command", "view");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Tidak ada bioskop dengan nomor tersebut");
            return "failed";
        }
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);
        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable(required = false) Long noBioskop,
            Model model
    ) {
        if (noBioskop == null) {
            model.addAttribute("command", "update");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Anda tidak memasukkan nomor bioskop");
            return "failed";
        }
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if(bioskop == null) {
            model.addAttribute("command", "update");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Tidak ada bioskop dengan nomor tersebut");
            return "failed";
        }
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskop(
            @PathVariable(required = false) Long noBioskop,
            Model model
    ) {
        if (noBioskop == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Anda tidak memasukkan nomor bioskop");
            return "failed";
        }
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if(bioskop == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Tidak ada bioskop dengan nomor tersebut");
            return "failed";
        }

        if(!bioskopService.isEmpty(bioskop)) {
            model.addAttribute("command","delete");
            model.addAttribute("type","bioskop");
            model.addAttribute("message", "Bioskop masih memiliki penjaga");
            return "failed";
        }
        if(!bioskopService.isOpen(bioskop)) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "bioskop");
            model.addAttribute("message", "Bioskop masih buka");
            return "failed";
        }
        model.addAttribute("namaBioskop", bioskop.getNamaBioskop());
        bioskopService.deleteBioskop(bioskop);
        return "delete-bioskop";
    }
}