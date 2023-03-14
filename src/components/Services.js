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


// const drawingNote = function (tiles, word) {
//   pointer = {
//   a: 1,
//   b: 3,
//   c: 3,
//   d: 3,
//   e: 1,
//   f: 4,
//   g: 2,
//   h: 4,
//   i: 1,
//   j: 8,
//   k: 5,
//   l: 1,
//   m: 3,
//   n: 1,
//   o: 1,
//   p: 3,
//   q: 10,
//   r: 1,
//   s: 1,
//   t: 1,
//   u: 1,
//   v: 4,
//   w: 4,
//   x: 8,
//   y: 4,
//   z: 10,
//   _: 0,
// };

// const tilesArray = tiles.join()
// let accumScore = 0;

// for (let i = 0; i < tilesArray.length; i++){
//   if (tilesArray.includes(word[i])){
//     accumScore += pointer.word[i]
//   }
// }

// return accumScore;

// }


