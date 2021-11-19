package com.garinetiquetas.apilcrst.resource;

import com.garinetiquetas.apilcrst.repository.IUsuarioRepository;

import java.util.List;

import com.garinetiquetas.apilcrst.entity.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apilcrst/v1")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioResource {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @GetMapping("/usuarios")
    public List<Usuarios>findAll(){
        return usuarioRepository.findAll();
    }
    @PostMapping("/usuarios")
    public Usuarios create(@RequestBody Usuarios usuario){
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/usuarios/{id}")
    public Usuarios update(@RequestBody Usuarios usuario,@PathVariable Integer id){
        Usuarios user=usuarioRepository.getOne(id);
        user.setUsuario(usuario.getUsuario());
        user.setPassword(usuario.getPassword());
        return usuarioRepository.save(user);
    }

    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
    }




    
}
