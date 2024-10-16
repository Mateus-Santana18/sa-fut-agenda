import React from 'react'
import './Logo.css'

// function Logo(props) {
//   return (
//     <div>
//      <img className={props.classe} src="./images/bordaPreta.png"/>
//     </div>
//   )
// }

const Logo = ({ src, largura, altura }) => {
  return (
    <img
      src={src}
      style={{ width: largura, height: altura }}
    />
  );
};

export default Logo