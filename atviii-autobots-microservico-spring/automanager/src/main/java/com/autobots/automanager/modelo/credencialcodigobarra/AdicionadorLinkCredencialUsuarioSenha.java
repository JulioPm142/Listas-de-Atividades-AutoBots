package com.autobots.automanager.modelo.credencialcodigobarra;

import java.util.List;
import java.util.Set;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.CredencialUsuarioSenhaControle;
import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.modelo.AdicionadorLink;

@Component
public class AdicionadorLinkCredencialUsuarioSenha implements AdicionadorLink<CredencialUsuarioSenha> {

    @Override
    public void adicionarLink(CredencialUsuarioSenha objeto) {
        Link linkProprio = WebMvcLinkBuilder
                .linkTo(CredencialUsuarioSenhaControle.class)
                .slash("obterCredencialUsuarioSenha")
                .withRel("credencialUsuarioSenha");
        objeto.add(linkProprio);
    }

    @Override
    public void adicionarLink(Set<Credencial> lista) {
        for (Credencial credencial : lista) {
            long id = credencial.getId();
            Link linkProprio = WebMvcLinkBuilder
                    .linkTo(CredencialUsuarioSenhaControle.class)
                    .slash("obterCredencialUsuarioSenha")
                    .slash(id)
                    .withSelfRel();
            // Perform the necessary type casting to CredencialUsuarioSenha
            ((CredencialUsuarioSenha) credencial).add(linkProprio);
        }
    }

    @Override
    public void adicionarLink(List<CredencialUsuarioSenha> lista) {
        for (CredencialUsuarioSenha credencialusuariosenha : lista) {
            long id = credencialusuariosenha.getId();
            Link linkProprio = WebMvcLinkBuilder
                    .linkTo(CredencialUsuarioSenhaControle.class)
                    .slash("obterCredencialUsuarioSenha")
                    .slash(id)
                    .withSelfRel();
            credencialusuariosenha.add(linkProprio);
        }
    }
}
