package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopInMemoryService;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam (value = "idBioskop", required = true) String idBioskop,
            @RequestParam (value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam (value = "alamat", required = true) String alamat,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            @RequestParam (value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ){
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);
        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop" , idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";

    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model){
//        System.out.print("Assalamualaikum spring boot");
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke 'ListBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
        @RequestParam(value = "idBioskop", required = true) String idBioskop,
        Model model
    ){
        // Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);
        return "view-bioskop";
    }
    @GetMapping(value={"/bioskop/view/id-bioskop/{idBioskop}", "/bioskop/view/id-bioskop"})
    public String viewBioskop(
        @PathVariable(value = "idBioskop", required = false) String idBioskop,
        Model model
    ){
        if (idBioskop != null) {
            BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
            if (bioskopModel == null) {
                String command = "view";
                String status = "tidak ditemukan";
                model.addAttribute("command", command);
                model.addAttribute("status", status);
                return "task-failed";
            }
            model.addAttribute("bioskop", bioskopModel);
            return "view-bioskop";
        }
        else {
            String command = "view";
            String status = "kosong";
            model.addAttribute("command", command);
            model.addAttribute("status", status);
            return "task-failed";
        }

    }

    @RequestMapping(value={"/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}", "/bioskop/update/id-bioskop/jumlah-studio",  "/bioskop/update/id-bioskop/jumlah-studio/{jumlahStudio}"})
    public String updateBioskop(
            @PathVariable(value = "idBioskop", required = false) String idBioskop,
            @PathVariable(value = "jumlahStudio", required = true) Integer jumlahStudio,
            Model model
    ){
        if (idBioskop != null || jumlahStudio != null) {
            BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
            if (bioskopModel == null) {
                String command = "update";
                String status = "tidak ditemukan";
                model.addAttribute("command", command);
                model.addAttribute("status", status);
                return "task-failed";
            }
            bioskopModel.setJumlahStudio(jumlahStudio);
            model.addAttribute("bioskop", bioskopModel);
            return "update-bioskop";
        }
        else {
            String command = "update";
            String status = "kosong";
            model.addAttribute("command", command);
            model.addAttribute("status", status);
            return "task-failed";
        }
    }

    @GetMapping(value={"/bioskop/delete/id-bioskop/{idBioskop}", "/bioskop/delete/id-bioskop"})
    public String deleteBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ){
        if (idBioskop != null ) {
            BioskopModel bioskopModel = bioskopService.deleteBioskopByIdBioskop(idBioskop);
            if (bioskopModel == null) {
                String command = "delete";
                String status = "tidak ditemukan";
                model.addAttribute("command", command);
                model.addAttribute("status", status);
                return "task-failed";
            }
            model.addAttribute("bioskop", bioskopModel);
            return "delete-bioskop";
        }
        else {
            String command = "delete";
            String status = "kosong";
            model.addAttribute("command", command);
            model.addAttribute("status", status);
            return "task-failed";
        }

    }
}
