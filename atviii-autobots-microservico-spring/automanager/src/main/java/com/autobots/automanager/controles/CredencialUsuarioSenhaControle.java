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
import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.modelo.credencial.CredencialAtualizador;
import com.autobots.automanager.modelo.credencial.CredencialSelecionador;
import com.autobots.automanager.modelo.credencialcodigobarra.AdicionadorLinkCredencialUsuarioSenha;
import com.autobots.automanager.modelo.credencialusuariosenha.CredencialUsuarioSenhaAtualizador;
import com.autobots.automanager.modelo.credencialusuariosenha.CredencialUsuarioSenhaSelecionador;
import com.autobots.automanager.repositorios.UsuarioRepositorio;
import com.autobots.automanager.repositorios.CredencialRepositorio;
import com.autobots.automanager.repositorios.CredencialUsuarioSenhaRepositorio;


@RestController
public class CredencialUsuarioSenhaControle {
	@Autowired
	private UsuarioRepositorio repositorio;
	@Autowired
	private CredencialUsuarioSenhaSelecionador selecionador;
	@Autowired
	private CredencialUsuarioSenhaRepositorio credencialusuariosenharepositorio;
	@Autowired
	private AdicionadorLinkCredencialUsuarioSenha adicionadorLink;
	

	@GetMapping("/credencialusuariosenha/{id}")
	public ResponseEntity<CredencialUsuarioSenha> obterCredencialUsuarioSenha(@PathVariable long id) {
		List<CredencialUsuarioSenha> credenciaisusuariosenha = credencialusuariosenharepositorio.findAll();
		CredencialUsuarioSenha credencialusuariosenha = selecionador.selecionar(credenciaisusuariosenha, id);
		if (credencialusuariosenha == null) {
			ResponseEntity<CredencialUsuarioSenha> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(credencialusuariosenha);
			ResponseEntity<CredencialUsuarioSenha> resposta = new ResponseEntity<CredencialUsuarioSenha>(credencialusuariosenha, HttpStatus.FOUND);
			return resposta;
		}
	}

	@GetMapping("/credenciaisusuariosenha")
	public ResponseEntity<List<CredencialUsuarioSenha>> obterCredenciaisUsuarioSenha() {
		List<CredencialUsuarioSenha> credenciaisusuariosenha = credencialusuariosenharepositorio.findAll();
		if (credenciaisusuariosenha.isEmpty()) {
			ResponseEntity<List<CredencialUsuarioSenha>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(credenciaisusuariosenha);
			ResponseEntity<List<CredencialUsuarioSenha>> resposta = new ResponseEntity<>(credenciaisusuariosenha, HttpStatus.FOUND);
			return resposta;
		}
	}

	@PostMapping("/cadastrocredenciaisusuariosenha")
	public void cadastrarUsuario(@RequestBody com.autobots.automanager.entidades.Usuario usuario) {
		Usuario usuario2 = repositorio.getById(usuario.getId());
		usuario2.getCredenciais().addAll(usuario.getCredenciais());
		repositorio.save(usuario2);
	}

	@PutMapping("/atualizarcredenciaisusuariosenha")
	public void atualizarcredencialusuariosenha(@RequestBody Usuario atualizacao) {
		Usuario usuario = repositorio.getById(atualizacao.getId());
		CredencialUsuarioSenhaAtualizador atualizador = new CredencialUsuarioSenhaAtualizador();
		atualizador.atualizar(usuario.getCredenciais(), atualizacao.getCredenciais());
		repositorio.save(usuario);
	}

	@DeleteMapping("/excluircredencial/{id}")
	public void excluircredencialusuariosenha(@PathVariable long id) {
		CredencialUsuarioSenha credencialusuariosenha = credencialusuariosenharepositorio.getById(id);
		Usuario usuario = repositorio.findByCredencialId(credencialusuariosenha.getId());
		usuario.getCredenciais().remove(credencialusuariosenha);
		repositorio.save(usuario);
	}
 }
