package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.ServicoOferecido;
import com.techdevbrazil.skillhubapi.repository.ServicoOferecidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoOferecidoService {

    private final ServicoOferecidoRepository servicoOferecidoRepository;

    public ServicoOferecidoService(ServicoOferecidoRepository servicoOferecidoRepository) {
        this.servicoOferecidoRepository = servicoOferecidoRepository;
    }

    public List<ServicoOferecido> findAll(){
        return servicoOferecidoRepository.findAll();
    }

    public ServicoOferecido findById(Long id){
        return servicoOferecidoRepository.findById(id).get();
    }

    public List<ServicoOferecido> findByUsuarioId(Long usuarioId){
        return servicoOferecidoRepository.findByUsuarioId(usuarioId);
    }

    public ServicoOferecido save(ServicoOferecido servicoOferecido){
        return  servicoOferecidoRepository.save(servicoOferecido);
    }

    public void delete(Long id){
        servicoOferecidoRepository.deleteById(id);
    }
}
