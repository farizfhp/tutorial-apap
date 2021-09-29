package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {

    @Autowired
    BioskopDB bioskopDB;


    @Override
    public void addBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return bioskopDB.findAll();
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }
    @Override
    public boolean isOpen(BioskopModel bioskop) {
        LocalTime time = LocalTime.now();
        if (time.isAfter(bioskop.getWaktuTutup()) ||
                time.isBefore(bioskop.getWaktuBuka())) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {
        bioskopDB.delete(bioskop);
    }

    @Override
    public boolean isEmpty(BioskopModel bioskop) {
        if (bioskop.getListPenjaga().isEmpty()) {
            return true;
        }
        return false;
    }
}
