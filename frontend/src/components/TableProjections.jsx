import ListGroup from 'react-bootstrap/ListGroup';
import React,{useEffect,useState} from 'react';
import { Button } from 'bootstrap';
import { useNavigate,useLocation } from 'react-router-dom';
import axios from 'axios';
function HorizontalExample() {

    const [projections, setProjections] = useState([]);
    const location=useLocation();
    const {movie}=location.state || {};
    const getProjections =(movie) => axios.get('http://localhost:8080/projections/' + movie)

    useEffect(() =>{
        fetch('http://localhost:8080/projections/'+ movie.id)
        .then((response) => response.json())
        .then((data)=>setProjections(data))
        .catch((error)=> console.error('Error fetching users: ', error));
    }, []);

return (
    
    <ListGroup horizontal>
        {projections.map(projection=>{
            
            const weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
            const month = ["January","February","March","April","May","June","July","August","September","October","November","December"];
            const projectionDate=new Date(projection.projectionDate);
            const Month=month[projectionDate.getMonth()];
            const dayofWeek=weekday[projectionDate.getDay()];

    return(
            
        <div key={projection.id} style={{ display: 'inline-block', marginRight: '5px', width:"130px"}}>
                <ListGroup.Item key={projection.id}>{dayofWeek} {Month} <br></br> {projection.projectionDate}</ListGroup.Item>
                <ListGroup.Item>Cinema: {projection.projectionRoom}</ListGroup.Item>
                <ListGroup.Item>Time: {projection.projectionTime.slice(0,5)}</ListGroup.Item>
                <ListGroup.Item>{projection.movie.type}</ListGroup.Item>
        </div>
)

})}
</ListGroup>
  );
}

export default HorizontalExample;