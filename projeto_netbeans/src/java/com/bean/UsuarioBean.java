package com.bean;

import com.dao.TipoUsuarioDAO;
import com.dao.UsuarioDAO;
import com.model.TipoUsuario;
import com.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@SessionScoped
@Named("usuarioBean")
public class UsuarioBean extends ComumBean implements Serializable {
    
    private Usuario model;
    private ArrayList<TipoUsuario> tipos;
    private UsuarioDAO database;
    private String novaSenha;
    private String confirmarSenha;
    private ArrayList<Usuario> listaUsuarios;

    /**
     * Constructor.
     */
    public UsuarioBean() {
        database = new UsuarioDAO();
        model = new Usuario();
        try {
            tipos = new TipoUsuarioDAO().buscar();
            listaUsuarios = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Redireciona para a tela de cadastro de usuário.
     */
    public void cadastrarGet() {
        model = new Usuario();
        redirecionar("/View/Administrador/Usuario/cadastrar.jsf");
    }

    /**
     * Realiza cadastro de um usuário.
     */
    public void cadastrarPost() {
        try {
            if (!dadosObrigatoriosPreenchidosCadastrar()) {
                return;
            }
            
            database.inserir(model);
            listaUsuarios = database.buscar();
            adicionarMensagemInfo("Usuário cadastrado com sucesso!");
            apagarCampos();
            redirecionar("/View/Administrador/Usuario/listar.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Redireciona para a tela de edição de usuário.
     * @param id Identificador do usuário que deve ser preenchido na tela.
     */
    public void editarGet(int id) {
        //percorre a lista de usuários
        for (Usuario u : this.listaUsuarios) {
            //quando encontrar, atribui o usuário para o atributo 'model'
            if (u.getId() == id) {
                model = u;
                break;
            }
        }
        redirecionar("/View/Administrador/Usuario/editar.jsf");
    }
    
    /**
     * Realiza a atualização do usuário.
     */
    public void editarPost() {
        try {
            if (!dadosObrigatoriosPreenchidosEditar()) {
                return;
            }
            
            //se digitou uma nova senha, então atualiza no model
            if (!novaSenha.isEmpty()) {
                model.setSenha(novaSenha);
            }
            
            database.editar(model);
            listaUsuarios = database.buscar();
            adicionarMensagemInfo("Usuário atualizado com sucesso!");
            apagarCampos();
            redirecionar("/View/Administrador/Usuario/listar.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Exclui um usuário.
     * @param id Identificador do usuário que deve ser excluído.
     */
    public void excluir(int id) {
        try {
            //exclui do banco de dados
            database.excluir(id);
            //exclui da lista
            for (Usuario u : listaUsuarios) {
                if (u.getId() == id) {
                    listaUsuarios.remove(u);
                    break;
                }
            }
            adicionarMensagemInfo("Usuário excluído com sucesso!");
            redirecionar("/View/Administrador/Usuario/listar.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Validação feita ao editar usuário.
     * @return true caso todos os dados obrigatórios da tela foram preenchidos,
     *         e retorna false caso contrário.
     */
    private boolean dadosObrigatoriosPreenchidosEditar() {
        if (!novaSenha.equals(confirmarSenha)) {
            adicionarMensagemErro("Campos Nova Senha e Confirmar Senha devem ser iguais!");
            return false;
        }
        
        return dadosObrigatoriosPreenchidos();
    }
    
    /**
     * Validação feita ao cadastrar usuário.
     * @return true caso todos os dados obrigatórios da tela foram preenchidos,
     *         e retorna false caso contrário.
     */
    private boolean dadosObrigatoriosPreenchidosCadastrar() {
        if (model.getNome().isEmpty()) {
            adicionarMensagemErro("Campo Nome é obrigatório!");
            return false;
        }
        
        if (model.getUsuario().isEmpty()) {
            adicionarMensagemErro("Campo Usuário é obrigatório!");
            return false;
        }

        if (model.getEmail().isEmpty()) {
            adicionarMensagemErro("Campo Email é obrigatório!");
            return false;
        }

        if (model.getSenha().isEmpty()) {
            adicionarMensagemErro("Campo Senha é obrigatório!");
            return false;
        }
        
        if (!model.getSenha().equals(confirmarSenha)) {
            adicionarMensagemErro("Campos Senha e Confirmar senha devem ser iguais!");
            return false;
        }
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (model.getUsuario().equals(listaUsuarios.get(i).getUsuario())) {
                adicionarMensagemErro("Usuário já existe, tente outro nome de usuário.");
                return false;
            }
        }
        return dadosObrigatoriosPreenchidos();
    }
    
    /**
     * Validações básicas. Comum ao cadastrar e editar.
     * @return true caso todos os dados obrigatórios da tela foram preenchidos,
     *         e retorna false caso contrário.
     */
    private boolean dadosObrigatoriosPreenchidos() {
        if (model.getNome().isEmpty()) {
            adicionarMensagemErro("Campo Nome é obrigatório!");
            return false;
        }
        
        if (model.getUsuario().isEmpty()) {
            adicionarMensagemErro("Campo Usuário é obrigatório!");
            return false;
        }
        
        if (model.getEmail().isEmpty()) {
            adicionarMensagemErro("Campo Email é obrigatório!");
            return false;
        }
        
        return true;
    }

    private void apagarCampos() {
        model.setNome("");
        model.setUsuario("");
        model.setEmail("");
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">    
    public Usuario getModel() {
        return model;
    }

    public void setModel(Usuario model) {
        this.model = model;
    }

    public ArrayList<TipoUsuario> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<TipoUsuario> tipos) {
        this.tipos = tipos;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
    // </editor-fold>

}