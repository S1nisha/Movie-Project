import React,{useEffect, useState} from 'react'
import './App1.css'
import './App.css'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import ThemeProvider from 'react-bootstrap/ThemeProvider'
import Header from './components/Header';
import Tablee from './components/Table';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


const App1=()=> {

  const [movies, setMovies]=useState([]);
  const [genres, setGenres]=useState([]);

  const navigator=useNavigate();

  const getMovies =(genre) => axios.get('http://localhost:8080/movies/' + genre);
  
    function filterGenre(e){
      const selectedGenre=e.target.value; 
      getMovies(selectedGenre)
      .then((response)=>{
        console.log(genre);
        navigate("/" + selectedGenre)
      })
    }


  

  useEffect(()=>{
    fetch('http://localhost:8080/genres')
    .then(Response=>Response.json())
    .then(data=>setGenres(data))
    .catch(error=>console.error('Error fetching users:',error))
  },[]);

  useEffect(() => {
    fetch('http://localhost:8080/movies')
      .then(Response => Response.json())
      .then(data => setMovies(data))
      .catch(error => console.error('Error fetching users:', error));
  }, []);

  
  function addMovie(){
    navigator("/add-movie")
  }

  const [search,setSearch]=useState('')
  console.log(search)



//   <ThemeProvider
//   breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
//   minBreakpoint="xxs"
// >
//   <div>Your app...</div>
// </ThemeProvider>;

return (

    <>
    <div className='content'>
    <Header/>
    <h2>MOvies</h2>
    <form method='post'><div className='bar'>
        <select style={{marginRight: "20px", float: "left"}}  onChange={filterGenre}>
        {genres.map(genre=>(
          <option key={genre.id}>{genre.name}</option>
        ))}
      </select>
      <button type='submit'>Search</button>
      </div> 
      
    </form>
    <Button variant="primary" onClick={addMovie}>Add Movie</Button>

        <Tablee/>
        </div>  
    </>
  )
}

export default App1
