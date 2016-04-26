/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validarLogin() {
    var usuario = document.getElementById("form:usuario").value;
    if (!usuario) {
        alert('Campo usuário é obrigatório.');
        return false;
    }
    var senha = document.getElementById("form:senha").value;
    if (!senha) {
        alert('Campo senha é obrigatório.');
        return false;
    }
    var novaSenha = document.getElementById("form:novaSenha").value;
    var confirmarNovaSenha = document.getElementById("form:confirmarNovaSenha").value;
    if (novaSenha && !confirmarNovaSenha) {
        alert('Campo confirmar nova senha é obrigatório para alterar senha.');
        return false;
    }
    if (novaSenha && confirmarNovaSenha && novaSenha !== confirmarNovaSenha) {
        alert('Campo nova senha e confirmar nova senha não conferem.');
        return false;
    }
}


function validarNovaSimulacao() {
    var novaSimulacao = document.getElementById("form:nova_simulacao").value;
    if (!novaSimulacao) {
        alert('Campo ')
    }
    
}

function validarCadastrarUsuario() {
    var nome = document.getElementById("form:nome").value;
    if (!nome) {
        alert('Campo nome é obrigatório.');
        return false;
    }
    var usuario = document.getElementById("form:usuario").value;
    if (!usuario) {
        alert('Campo usuário é obrigatório.');
        return false;
    }
    var email = document.getElementById("form:email").value;
    if (!email) {
        alert('Campo email é obrigatório.');
        return false;
    }
    var senha = document.getElementById("form:senha").value;
    var confirmarSenha = document.getElementById("form:confirmarSenha").value;
    if (!senha) {
        alert('Campo senha é obrigatório.');
        return false;
    }
    if (senha && !confirmarSenha) {
        alert('Campo confirma senha é obrigatório.');
        return false;
    }
    
    if (senha && !confirmarSenha) {
        alert('Campos senha e confirma senha não conferem.');
        return false;
    }
    
}