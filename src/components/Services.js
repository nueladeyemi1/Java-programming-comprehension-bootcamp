import React from 'react'
import { serviceData } from './Data';
import Title from './Title';

const Services = () => {
  return (
    <>
      <section className="section services" id="services">
        <Title firstWord={"our"} secondWord={"services"} />
        <div className="section-center services-center">
          {serviceData.map(({ id, serviceTitle, serviceText }) => {
            return (
              <article key={id} className="service">
                <span className="service-icon">
                  <i className="fas fa-wallet fa-fw"></i>
                </span>
                <div className="service-info">
                  <h4 className="service-title">{serviceTitle}</h4>
                  <p className="service-text">{serviceText}</p>
                </div>
              </article>
            );
          })}
        </div>
      </section>
    </>
  );
}

export default Services