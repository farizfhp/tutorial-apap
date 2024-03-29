package apap.tutorial.cineplux.service;

import java.time.*;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService  {

    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public void updatePenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public boolean isOpen(PenjagaModel penjaga) {
        LocalTime time = LocalTime.now();
        if (time.isAfter(penjaga.getBioskop().getWaktuTutup()) ||
                time.isBefore(penjaga.getBioskop().getWaktuBuka())) {

            return true;
        }
        return false;
    }



    @Override
    public void deletePenjaga(PenjagaModel penjaga) {
        penjagaDB.delete(penjaga);
    }


}
