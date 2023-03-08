import React from 'react'
import { pageLinks, socialLinks } from './Data';

const Footer = () => {
  return (
    <>
      <footer className="section footer">
        <ul className="footer-links">
          {pageLinks.map(({id, text})=>{
            return (
              <li key={id}>
                <a href={`#${text}`} className="footer-link">
                  {text}
                </a>
              </li>
            );
          })}
        </ul>
        <ul className="footer-icons">
         {socialLinks.map(({id, socialTarget})=>{
            return (
              <li key={id}>
                <a
                  href={`https://www.${socialTarget}.com`}
                  target="_blank"
                  rel='noreferrer'
                  className="footer-icon"
                >
                  <i className={`fab fa-${socialTarget}`}></i>
                </a>
              </li>
            );
         })}
        </ul>
        <p className="copyright">
          copyright &copy; Backroads travel tours company
          <span id="date"></span> all rights reserved
        </p>
      </footer>
    </>
  );
}

export default Footer