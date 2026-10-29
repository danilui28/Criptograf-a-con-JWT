package com.krakedev.jwt.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.jwt.entidades.Usuario;
import com.krakedev.jwt.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public Usuario guardar(Usuario usuario) {
		
		return repository.save(usuario);
	}
	
	public boolean autenticar(String username, String password) {
		
		Optional<Usuario> usuarioOpt = repository.findByUsername(username);
		
		if(usuarioOpt.isPresent()) {
			
			Usuario usuario = usuarioOpt.get();
			
			if (usuario.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
