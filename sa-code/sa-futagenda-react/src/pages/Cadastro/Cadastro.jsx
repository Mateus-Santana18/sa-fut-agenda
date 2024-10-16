import React from 'react';
import './Cadastro.css';
import Logo from '../../components/Logo/Logo';
// import LogoCadastro from '../../components/LogoCadastro/LogoCadastro';

const Cadastro = () => {

  return (
    <div className="cadastro-container">
      <div className="cadastroCorpo">
        <div className="ladoEsquerdoCadastro">
          <div className="divLogoCadastro">
            {/* <Logo classe={"logoCadastro"}/> */}
            <Logo
              src="./images/bordaPreta.png"
              largura="300px"
              altura="300px"
            />
          </div>
          <p style={{fontSize: "25px"}}>Possui uma conta?</p>
          <button className="botaoLoginCadastro" >
            Fazer Login
          </button>
        </div>
        <div className="ladoDireitoCadastro">
          <div className='tituloCadastroAlinhar'>
            
          <h1 className='tituloCadastro'>Faça seu cadastro</h1>
          </div>
          <label className='labelCadastro' htmlFor="email">Nome Completo</label>
          <input className='inputCadastro' type="text" placeholder="Digite seu Nome" />
          <label className='labelCadastro' htmlFor="email">E-mail</label>
          <input className='inputCadastro' type='email' placeholder="Digite seu E-mail" />
          <label className='labelCadastro' htmlFor="telefone">Telefone</label>
          <input className='inputCadastro' type='telefone' placeholder="Digite seu Telefone" />

          <label className='labelCadastro' htmlFor="password">Senha</label>
          <input className='inputCadastro' type="password" placeholder="Digite sua Senha" />
          <label className='labelCadastro' htmlFor="password">Confirme sua senha</label>
          <input className='inputCadastro' type="password" placeholder="Insira sua Senha Novamento" />
          <div className='parteDeBaixoCadastro'>
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
