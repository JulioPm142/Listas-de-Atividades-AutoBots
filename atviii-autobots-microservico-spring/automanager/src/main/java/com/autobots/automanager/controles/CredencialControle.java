package com.autobots.automanager.controles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.Usuario;

import com.autobots.automanager.modelo.credencial.CredencialAtualizador;
import com.autobots.automanager.modelo.credencial.CredencialSelecionador;
import com.autobots.automanager.modelo.credencialusuariosenha.AdicionadorLinkCredencial;
import com.autobots.automanager.repositorios.UsuarioRepositorio;
import com.autobots.automanager.repositorios.CredencialRepositorio;

@RestController
public class CredencialControle {
	@Autowired
	private UsuarioRepositorio repositorio;
	@Autowired
	private CredencialSelecionador selecionador;
	@Autowired
	private CredencialRepositorio credencialrepositorio;
	@Autowired
	private AdicionadorLinkCredencial adicionadorLink;
	

	@GetMapping("/credencial/{id}")
	public ResponseEntity<Credencial> obterCredencial(@PathVariable long id) {
		List<Credencial> credenciais = credencialrepositorio.findAll();
		Credencial credencial = selecionador.selecionar(credenciais, id);
		if (credencial == null) {
			ResponseEntity<Credencial> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(credencial);
			ResponseEntity<Credencial> resposta = new ResponseEntity<Credencial>(credencial, HttpStatus.FOUND);
			return resposta;
		}
	}

	@GetMapping("/credenciais")
	public ResponseEntity<List<Credencial>> obterCredenciais() {
		List<Credencial> credenciais = credencialrepositorio.findAll();
		if (credenciais.isEmpty()) {
			ResponseEntity<List<Credencial>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(credenciais);
			ResponseEntity<List<Credencial>> resposta = new ResponseEntity<>(credenciais, HttpStatus.FOUND);
			return resposta;
		}
	}

	@PostMapping("/cadastrocredenciais")
	public void cadastrarUsuario(@RequestBody com.autobots.automanager.entidades.Usuario usuario) {
		Usuario usuario2 = repositorio.getById(usuario.getId());
		usuario2.getCredenciais().addAll(usuario.getCredenciais());
		repositorio.save(usuario2);
	}

	@PutMapping("/atualizarcredenciais")
	public void atualizarcredencial(@RequestBody Usuario atualizacao) {
		Usuario usuario = repositorio.getById(atualizacao.getId());
		CredencialAtualizador atualizador = new CredencialAtualizador();
		atualizador.atualizar(usuario.getCredenciais(), atualizacao.getCredenciais());
		repositorio.save(usuario);
	}

	@DeleteMapping("/excluircredencial/{id}")
	public void excluircredencial(@PathVariable long id) {
		Credencial credencial = credencialrepositorio.getById(id);
		Usuario usuario = repositorio.findByCredencialId(credencial.getId());
		usuario.getCredenciais().remove(credencial);
		repositorio.save(usuario);
	}
 }
