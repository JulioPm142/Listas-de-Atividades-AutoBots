package com.autobots.automanager.modelo.email;

import java.util.List;
import java.util.Set;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EmailControle;
import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.Email;
import com.autobots.automanager.modelo.AdicionadorLink;

@Component
public class AdicionadorLinkEmail implements AdicionadorLink<Email> {

	@Override
	public void adicionarLink(List<Email> lista) {
		for (Email email : lista) {
			long id = email.getId();
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmailControle.class)
							.obterEmail(id))
					.withSelfRel();
			email.add(linkProprio);
		}
	}

	@Override
	public void adicionarLink(Email objeto) {
		Link linkProprio = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmailControle.class)
						.obterEmails())
				.withRel("emails");
		objeto.add(linkProprio);
	}

	@Override
	public void adicionarLink(Set<Credencial> lista) {
		// TODO Auto-generated method stub
		
	}
}