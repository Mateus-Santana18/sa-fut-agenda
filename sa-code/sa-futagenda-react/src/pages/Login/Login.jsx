import React from 'react';
import Logo from '../../components/Logo/Logo';
import './Login.css';
import { useId } from 'react';
const Login = () => {

  const idEmail = useId();
  const idSenha = useId();

  return (
    <div className="login-container">
      <div className="loginCorpo">
        <div className="ladoEsquerdo">
          <div className='txtFacaOLogin'>
            <h1 className='tituloLogin'>Faça o Login</h1>
          </div>
          <div className='inptsLogin'>
            <div className='inptContainerLogin'>
              <label className='labelLogin' htmlFor={idEmail}>E-mail</label>
              <input className='inputLogin' type="email" id={idEmail}  placeholder="Digite seu E-mail" />
            </div>
            <div className='inptContainerLogin'>
              <label className='labelLogin' htmlFor={idSenha}>Senha</label>
              <input className='inputLogin' type="password" id={idSenha} placeholder="Digite sua Senha" />
            </div>
          </div>
          <div className='parteDeBaixo'>
            <button className="botaoDeLogin">
              LOGIN
            </button>
          </div>

        </div>
        <div className="login-right">
          <Logo
            src="./images/bordaPreta.png"
            largura="300px"
            altura="300px"
          />
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