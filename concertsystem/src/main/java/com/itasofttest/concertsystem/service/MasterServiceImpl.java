package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Master;
import com.itasofttest.concertsystem.model.Ticket;
import com.itasofttest.concertsystem.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterServiceImpl implements MasterService{
        //Hubungkan MasterServiceImpl dengan MasterRepository
        @Autowired
        private MasterRepository masterRepository;
        //Buat method untuk menyimpan ticket baru
       
        @Override
        public List<Master> getAllMaster() {
            return masterRepository.findAll();
        }

        @Override
        public Master saveMaster(Master master) {
            return masterRepository.save(master);
        }


}
