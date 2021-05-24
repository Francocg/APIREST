package pe.edu.upeu.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.apirest.entity.Alumno;
import pe.edu.upeu.apirest.service.AlumnoService;

@RestController
public class AlumnoController {
	@Autowired
	private AlumnoService alumnservice;
	
	@GetMapping("/")
	public String mensaje() {
		return "Tabla Alumno";
	}
	@GetMapping("/alumnos")
	public List<Alumno> getList(){
		return alumnservice.readll();
	}
	@DeleteMapping("/alumnos/delete/{id}")
	public String delete(@PathVariable long id) {
		alumnservice.delete(id);
		return "Alumno Elimado";
	}
	@GetMapping("/alumnos/{id}")
	public Alumno read(@PathVariable Long id) {
		return alumnservice.read(id);
	}
	@PutMapping("/alumnos/update/{id}")
	public String update(@PathVariable Long id, @RequestBody Alumno alum) {
		System.out.println(id);
		Alumno a = alumnservice.read(id);
		System.out.println(alum.getNombre());
		a.setIdalumno(alum.getIdalumno());
		a.setNombre(alum.getNombre());
		a.setTelefono(alum.getTelefono());
		a.setCorreo(alum.getCorreo());
		alumnservice.update(a);
		return "Alumno Modificado";
	}
}
