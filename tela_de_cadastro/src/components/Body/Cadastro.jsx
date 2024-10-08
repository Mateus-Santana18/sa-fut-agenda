import React from 'react';
import './Cadastro.css';
import Logo from './Logo/Logo';

const Cadastro = () => {
 

 ;

  return (
    <div className="cadastro-container">
      <div className="cadastroCorpo">
        <div className="ladoEsquerdo">
          <div className="logo">
          <Logo/>
          </div>
              <p>possui uma conta?</p>
            <button className="botaoLogin" >
              Fazer Login
            </button>
        </div>
        <div className="ladoDireito">
          <h1 className='tituoLogin'>Faça seu cadastro</h1>
          <label className='labelLogin' htmlFor="email">Nome Completo</label>
          <input input className='input'  type="text" placeholder="Digite seu Nome" />
          <label className='labelLogin' htmlFor="email">E-mail</label>
          <input input className='input'  type="email"  placeholder="Digite seu E-mail" />
          <label className='labelLogin' htmlFor="email">Telefone</label>
          <input input className='input'  type="tel"  placeholder="Digite seu Telefone" />
        
          <label className='labelLogin' htmlFor="password">Senha</label>
          <input className='input' type="password"  placeholder="Digite sua Senha" />
          <label className='labelLogin' htmlFor="password">Comfirme sua senha</label>
          <input className='input' type="password"  placeholder="Insira sua Senha Novamento" />
          <div className='parteDeBaixo'>
             <button className="botaoDeCadastrar">
            CADASTRAR
          </button>
          </div>
         
        </div>
      </div>
    </div>
  );
};

export default Cadastro;
