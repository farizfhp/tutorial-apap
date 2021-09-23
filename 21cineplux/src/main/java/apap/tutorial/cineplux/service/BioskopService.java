package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;
import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk menghapus bioskop
//    void deleteBioskop(BioskopModel bioskop);

    void updateBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar Bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
//    BioskopModel getBioskopByIdBioskop(String idBioskop);

    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    boolean isOpen(BioskopModel bioskop);

    void deleteBioskop(BioskopModel bioskop);

    boolean isEmpty(BioskopModel bioskop);


}


//package apap.tutorial.cineplux.service;
//
//import apap.tutorial.cineplux.model.BioskopModel;
//
//import java.util.List;
//public interface BioskopService {
//    //Method untuk menambah Bioskop
//    void addBioskop(BioskopModel bioskop);
//
//    //Method untuk mendapatkan daftar Bioskop yang telah tersimpan
//    List<BioskopModel> getBioskopList();
//
//    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
//    BioskopModel getBioskopByIdBioskop(String idBioskop);
//
//    BioskopModel deleteBioskopByIdBioskop(String idBioskop);
//}
