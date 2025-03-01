import Table from 'react-bootstrap/Table';
import React,{useEffect,useState} from 'react';
import { Button } from 'bootstrap';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
function Tablee() {
  
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

    useEffect(() => {
      axios.get('http://localhost:8080/movies')
        .then(response =>{
            setMovies(response.data);
        })
        .catch((error) => console.error('Error fetching users:', error));
    }, []);

    return (

    
    <div>
      <Table responsive="md">
        <thead>
          <tr>
            
            <th>Picture</th>
            <th>Title</th>
            <th>Genres</th>
            <th>Available in</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {movies.map(movie=>(
            <tr key={movie.id}>
            
            <td><img onClick={(e)=> detailsMovie(movie.id,e)} src={movie.image} style={{width: "100px"}}/></td>
            <td style={{fontSize: "20px"}}>{movie.title}</td>
            <td>
                <ul>
                    {movie.genres.map(genre => (
                        <li key={genre.id}>{genre.name}</li>
                    ))}
                </ul>
            </td>
            <td style={{fontSize: "20px", fontWeight: "bold"}}>{(() => {
                if (movie.type === "TWO_D") return "2D";
                if (movie.type === "THREE_D") return "3D";
                return movie.type;
            })()}</td> 
            <td></td>
          </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default Tablee;



