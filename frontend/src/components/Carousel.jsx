import { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import Image from 'react-bootstrap/Image';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App1.css'

function ControlledCarousel() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel activeIndex={index} onSelect={handleSelect} variant='dark' className='carousel'>
      <Carousel.Item>
      <Image src="https://images7.alphacoders.com/131/1314905.jpeg" style={{width: "1280px"}}/>
        <Carousel.Caption>
          <h3 style={{color: "red"}}>Buy Tickets Now</h3>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
      <Image src="https://images7.alphacoders.com/131/1314905.jpeg" style={{width: "1280px"}}/>
        <Carousel.Caption>
          <h3 style={{color: "red"}}>Buy Tickets Now</h3>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <Image src="https://images7.alphacoders.com/131/1314905.jpeg" style={{width: "1280px"}}/>
        <Carousel.Caption>
          <h3 style={{color: "red"}}>Buy Tickets Now</h3>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}

export default ControlledCarousel;