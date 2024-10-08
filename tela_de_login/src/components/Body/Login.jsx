import React from 'react';
import './Login.css';
import Logo from '../Logo/Logo';
const Login = () => {


  

  return (
    <div className="login-container">
      <div className="loginCorpo">
        <div className="ladoEsquerdo">
          <div className='txtFacaOLogin'>
            <h1 className='tituloLogin'>Faça o Login</h1>
          </div>
          <label className='labelLogin' htmlFor="email">E-mail</label>
          <input className='input' type="email" placeholder="Digite seu E-mail" />

          <label className='labelLogin' htmlFor="password">Senha</label>
          <input className='input' type="password" placeholder="Digite sua Senha" />
          <div className='parteDeBaixo'>
            <button className="botaoDeLogin">
              LOGIN
            </button>
          </div>

        </div>
        <div className="login-right">
          {/* <div className="brand-logo"> */}
            <Logo className="logo"/>

          {/* </div> */}
          <p className='txtNaoPossuiCadastro'>Não possui Cadastro?</p>
          <button className="register-button" >
            Cadastre-se
          </button>
        </div>
      </div>
    </div>
  );
};

export default Login;
