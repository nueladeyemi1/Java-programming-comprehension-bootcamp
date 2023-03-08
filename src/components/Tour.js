import React from 'react'
import { tourData } from './Data';
import Title from './Title';

const Tour = () => {
  return (
    <>
      <section className="section" id="tours">
        <Title firstWord={"featured"} secondWord={"tours"} />
        <div className="section-center featured-center">
          {tourData.map(
            ({
              id,
              tourDate,
              tourTitle,
              tourImg,
              tourText,
              location,
              days,
              price,
            }) => {
              return (
                <article key={id} className="tour-card">
                  <div className="tour-img-container">
                    <img src={tourImg} className="tour-img" alt="" />
                    <p className="tour-date">{tourDate}</p>
                  </div>
                  <div className="tour-info">
                    <div className="tour-title">
                      <h4>{tourTitle}</h4>
                    </div>
                    <p>{tourText}</p>
                    <div className="tour-footer">
                      <p>
                        <span>
                          <i className="fas fa-map"></i>
                        </span>
                        {location}
                      </p>
                      <p>{days}</p>
                      <p>{price}</p>
                    </div>
                  </div>
                </article>
              );
            }
          )}
        </div>
      </section>
    </>
  );
}

export default Tour