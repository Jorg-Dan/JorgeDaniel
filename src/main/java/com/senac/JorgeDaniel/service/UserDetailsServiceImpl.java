package com.senac.JorgeDaniel.service;

import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Atendente atendente = atendenteRepository.findByLogin(username).orElseThrow(() -> new RuntimeException("Atendente não encontrado."));
        return new UserDetailsImpl(atendente);
    }

}