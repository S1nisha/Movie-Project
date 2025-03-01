import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import React,{useEffect,useState} from 'react';
import Header from './components/Header';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddPage = () => {

    const [genres, setGenres]=useState([]);
    const [types, setTypes] = useState([]);
    const navigate = useNavigate();


    const createMovie =(movie) => axios.post('http://localhost:8080/movies/add-movie', movie); 

    const [title, setTitle] = useState('');
    const [image, setImage] = useState('');
    const [videoLink,setVideo]=useState('');
    const [director, setDirector] = useState('');
    const [runtime, setRuntime] = useState('');
    const [description, setDescription] = useState('');
    const [releaseDate, setReleaseDate] = useState('');
    const [selectedType, setSelectedType] = useState(''); // Store selected type
    const [selectedGenres, setSelectedGenres] = useState([]);

    function handleTitle(e) {
      setTitle(e.target.value);
    }
  
    function handleImage(e) {
      setImage(e.target.value);
    }
    function handleVideo(e){
      setVideo(e.target.value);
    }
  
    function handleDirector(e) {
      setDirector(e.target.value);
    }
  
    function handleRuntime(e) {
      setRuntime(e.target.value);
    }
  
    function handleDescription(e) {
      setDescription(e.target.value);
    }
  
    function handleReleaseDate(e) {
      setReleaseDate(e.target.value);
    }
  
    function handleTypeChange(e) {
      setSelectedType(e.target.value);
    }
  
    function handleGenreChange(e) {
      const genreId = Number(e.target.id);
      setSelectedGenres((prev) =>
        e.target.checked
          ? [...prev, genreId] // Add selected genre
          : prev.filter((id) => id !== genreId) // Remove unselected genre
      );
    }
    
      function saveMovie(e){
        e.preventDefault();

        const movie = {
          title,
          image,
          videoLink,
          director,
          runtime: Number(runtime),
          description,
          releaseDate,
          type: selectedType,
          genres: selectedGenres,
        };

        createMovie(movie).then((response)=>{
            console.log(movie);
            navigate('/movies');
        })
      } 


  useEffect(() => {
    fetch('http://localhost:8080/movies/types')  // Change the URL to your backend API
      .then(response => response.json())
      .then(data => setTypes(data))
      .catch(error => console.error('Error fetching types:', error));
  }, []);

  useEffect(()=>{
    fetch('http://localhost:8080/genres')
    .then(Response=>Response.json())
    .then(data=>setGenres(data))
    .catch(error=>console.error('Error fetching users:',error))
  },[]);


  return (
    
    <div className='content'>
    <Header/>
    <Form style={{width: "600px"}}>
      <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
        <Form.Label column sm={2}>
          Title
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Title" value={title} onChange={handleTitle}/>
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Image
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Image" value={image} onChange={handleImage}/>
        </Col>
      </Form.Group>
      
      <Form.Group as={Row} className="mb-3" controlId="formTrailer">
        <Form.Label column sm={2}>
          Trailer
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Trailer" value={videoLink} onChange={handleVideo}/>
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Director
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Director"  value={director} onChange={handleDirector}/>
        </Col>
      </Form.Group>
      
      <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Description
        </Form.Label>
        <Col sm={10}>
          <Form.Control as="textarea" placeholder="Description"  value={description} onChange={handleDescription}/>
        </Col>
      </Form.Group>
      
      <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Runtime
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="number" min={"70"}  placeholder="Length of the movie (in minutes)" value={runtime} onChange={handleRuntime}  />
        </Col>
      </Form.Group>

      <fieldset>
        <Form.Group as={Row} className="mb-3">
          <Form.Label as="legend" column sm={2} style={{marginRight: "30px"}}>
            Radios
          </Form.Label>
          <Col md={4}>
          {types.map(type=>(
                <Form.Check
                key={type}
                type="radio"
                label={type.replace('_', '').replace('TWO','2').replace('THREE','3')} // Show "TWO D" or "THREE D"
                name="type" // All radios should share the same 'name'
                value={type} // Use the enum value as the 'value'
                onChange={handleTypeChange}
              />    
            ))}  
          </Col>
        </Form.Group>
      </fieldset>

      <Form.Group as={Row} className='mb-3' controlId='formReleaseDate'>
          <Form.Label column sm={2}>
            Release Date
          </Form.Label>
          <Col sm={10}>
            <Form.Control type='date' value={releaseDate} onChange={handleReleaseDate} />
          </Col>
        </Form.Group>

      <fieldset style={{marginLeft:"5%"}}>
        <Form.Group as={Row} className="mb-3">
          <Form.Label as="legend" column sm={12}>
            Genres
          </Form.Label>
          <Row>
          {genres.map((genre) => (
          <Col key={genre.id} sm={12} md={4} className="mb-3">
          <Form.Check
            type="checkbox"
            label={genre.name}
            name={genre.name}
            id={genre.id}
            onChange={handleGenreChange}
          />
        </Col>
      ))}
          </Row>
        </Form.Group>
      </fieldset>
      <Button formMethod="Post" onClick={saveMovie}>Add</Button>
    </Form>
    </div>
  );
}

export default AddPage;