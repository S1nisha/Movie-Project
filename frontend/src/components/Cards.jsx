import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import '../App1.css';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function GroupExample() {
  const [movies, setMovies] = useState([]);

  const navigate=useNavigate();
    const getMovie =(movieId) => axios.get('http://localhost:8080/movies/movie' + '/' + movieId)
  
      function detailsMovie(movieId,e){ 
      getMovie(movieId)
      .then((response)=>{
        const movie=response.data;
        console.log(movieId);
        navigate("/movie"+"/"+movieId,{state: {movie}})
      })
    }

  const shuffleArray = (array) => {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
  };

  useEffect(() => {
    fetch('http://localhost:8080/movies')
      .then((response) => response.json())
      .then((data) => {
        const shuffledMovies=shuffleArray(data);
        setMovies(shuffledMovies.slice(0,3));
      })
      .catch((error) => console.error('Error fetching users:', error));
  }, []);

  


  return (
    <Row>
      {movies.map((movie) => (
        <Col xs={12} sm={6} md={4} key={movie.id}> {/* xs=12 (full width on small screens), sm=6 (two cards per row on small devices), md=4 (three cards per row on medium and larger screens) */}
          <Card className='card'>
            <Card.Img variant="top" src={movie.image} onClick={(e)=> detailsMovie(movie.id,e)}/>
            <Card.Body>
              <Card.Title>{movie.title}</Card.Title>
              <Card.Text>Release Date: {movie.releaseDate}</Card.Text>
            </Card.Body>
            <Card.Footer>
              <small className="text-muted">Last updated 3 mins ago</small>
            </Card.Footer>
          </Card>
        </Col>
      ))}
    </Row>
  );
}

export default GroupExample;
