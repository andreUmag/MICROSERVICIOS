package app.userservice.services;

import app.userservice.models.Usuario;
import app.userservice.dtos.LoginDto;
import app.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> getAllUsuarios() {
        return userRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return userRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
    public Usuario loginUsuario(LoginDto loginDto) {

        Usuario usuario = userRepository.findByUsername(loginDto.getUsername());

        if (usuario != null && passwordEncoder.matches(loginDto.getPassword(), usuario.getPassword())) {
            return usuario;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
