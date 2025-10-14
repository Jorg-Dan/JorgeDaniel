package com.senac.JorgeDaniel.service;

import com.senac.JorgeDaniel.dto.request.AtendenteDTORequest;
import com.senac.JorgeDaniel.dto.response.AtendenteDTOResponse;
import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.entity.Role;
import com.senac.JorgeDaniel.repository.AtendenteRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtendenteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final AtendenteRepository atendenteRepository;

    public AtendenteService(AtendenteRepository atendenteRepository){
        this.atendenteRepository = atendenteRepository;
    }

    public List<Atendente> listarAtendentes(){
        return this.atendenteRepository.listarAtendentesAtivos();
    }

    public Atendente listarAtendentesPorId(int idAtendente){
        return this.atendenteRepository.obterAtendentePorId(idAtendente);
    }

    public AtendenteDTOResponse atendenteCriar(AtendenteDTORequest atendenteDTORequest) {
        Role role = new Role();
        role.setName(atendenteDTORequest.getRoleName());

        Atendente atendente = new Atendente();
        atendente.setId(atendenteDTORequest.getId());
        atendente.setNome(atendenteDTORequest.getNome());
        atendente.setLogin(atendenteDTORequest.getLogin());
        atendente.setAcesso(atendenteDTORequest.getAcesso());
        atendente.setAtividade(1);
        atendente.setCriacao(atendenteDTORequest.getData());
        atendente.setRoles(List.of(role));

        Atendente atendenteCriar = this.atendenteRepository.save(atendente);

        return modelMapper.map(atendenteCriar, AtendenteDTOResponse.class);
    }

    public AtendenteDTOResponse atualizar(@Valid Integer idAtendente, AtendenteDTORequest atendenteDTORequest) {
        Atendente atendente = this.listarAtendentesPorId(idAtendente);
        if(atendente!= null){
            modelMapper.map(atendenteDTORequest, atendente);
            Atendente atendenteTemp = this.atendenteRepository.save(atendente);
            return modelMapper.map(atendenteTemp, AtendenteDTOResponse.class);
        }else{
            return null;
        }
    }

    public void desligar(Integer idAtendente){
        this.atendenteRepository.atendenteDesligado(idAtendente);
    }

}
