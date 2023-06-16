package com.autobots.automanager.modelo.usuario;

import java.util.Set;

import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.modelo.StringVerificadorNulo;
import com.autobots.automanager.modelo.credencial.CredencialAtualizador;
import com.autobots.automanager.modelo.documento.DocumentoAtualizador;
import com.autobots.automanager.modelo.email.EmailAtualizador;
import com.autobots.automanager.modelo.endereco.EnderecoAtualizador;
import com.autobots.automanager.modelo.mercadoria.MercadoriaAtualizador;
import com.autobots.automanager.modelo.telefone.TelefoneAtualizador;
import com.autobots.automanager.modelo.veiculo.VeiculoAtualizador;

public class UsuarioAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();
    private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();
    private DocumentoAtualizador documentoAtualizador = new DocumentoAtualizador();
    private TelefoneAtualizador telefoneAtualizador = new TelefoneAtualizador();
    private EmailAtualizador emailAtualizador = new EmailAtualizador();
    private CredencialAtualizador credencialAtualizador = new CredencialAtualizador();
    private MercadoriaAtualizador mercadoriaAtualizador = new MercadoriaAtualizador();
    private VeiculoAtualizador veiculoAtualizador = new VeiculoAtualizador();

    private void atualizarDados(Usuario usuario, Usuario atualizacao) {
        if (!verificador.verificar(atualizacao.getNome())) {
            usuario.setNome(atualizacao.getNome());
        }
        if (!verificador.verificar(atualizacao.getNomeSocial())) {
            usuario.setNomeSocial(atualizacao.getNomeSocial());
        }
        if (!(atualizacao.getPerfis() == null)) {
            usuario.setPerfis(atualizacao.getPerfis());
        }
    }

    public void atualizar(Usuario usuario, Usuario atualizacao) {
        atualizarDados(usuario, atualizacao);
        enderecoAtualizador.atualizar(usuario.getEndereco(), atualizacao.getEndereco());
        documentoAtualizador.atualizar(usuario.getDocumentos(), atualizacao.getDocumentos());
        telefoneAtualizador.atualizar(usuario.getTelefones(), atualizacao.getTelefones());
        emailAtualizador.atualizar(usuario.getEmails(), atualizacao.getEmails());
        credencialAtualizador.atualizar(usuario.getCredenciais(), atualizacao.getCredenciais());
    }

    public void atualizar(Set<Usuario> usuarios, Set<Usuario> atualizacoes) {
        for (Usuario atualizacao : atualizacoes) {
            for (Usuario usuario : usuarios) {
                if (atualizacao.getId() != null) {
                    if (atualizacao.getId().equals(usuario.getId())) {
                        atualizar(usuario, atualizacao);
                    }
                }
            }
        }
    }
}
