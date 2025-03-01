import Header from './components/Header'
import './App1.css'
import axios from 'axios'
import { useLocation, useNavigate } from 'react-router-dom'
import React, { Component } from 'react'
import { useState,useEffect } from 'react'
import TableProjections from './components/TableProjections'
export default function DetailsPage() {

    const [projections, setProjections] = useState([]);
    const location=useLocation();
    const {movie}=location.state || {};
    const getProjections =(movie) => axios.get('http://localhost:8080/projections/' + movie)

    // useEffect(() => {
    //     fetch('http://localhost:8080/projections')
    //       .then((response) => response.json())
    //       .then((data) => setProjections(data))
    //       .catch((error) => console.error('Error fetching users:', error));
    //   }, []);

    useEffect(() =>{
        fetch('http://localhost:8080/projections/'+ movie.id)
        .then((response) => response.json())
        .then((data)=>setProjections(data))
        .catch((error)=> console.error('Error fetching users: ', error));
    }, []);
    
  return (
    <div>
     <div className='content'>
        <Header/>
        <div style={{width:'900px', marginLeft:"12"}}>
                <div className="movie-details">
        <div className="image-container">
            <img src={movie.image} alt={movie.title}/>
        </div>
        <div className="info-container">
            <h2>{movie.title}</h2>
            <p>Director: {movie.director}</p>
            <p>Movie ID: {movie.id}</p>
            <p>Genres: {movie.genres.map(genre => genre.name).join(', ')}</p>
            <p>Runtime: {movie.runtime}min</p>
            <p>Release Date: {movie.releaseDate}</p>
            <p>Available in: {movie.type === "TWO_D" ? "2D" : movie.type === "THREE_D" ? "3D" : movie.type}</p>
            <p>Description:<br/> {movie.description}</p>
            {/* <iframe
            width={320}
            height={240}
            src="https://www.youtube.com/embed?v=nO-cHNbW1zo"
            allow='autoplay'
            allowFullScreen
            ></iframe> */}
            <div style={{float:"left"}}>
            {projections.map(projection=>{ 
                
                // Chat-GPT
                const weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
 
                const projectionDate=new Date(projection.projectionDate);
                const dayofWeek=weekday[projectionDate.getDay()];
                //----------

                return(
                <span key={projection.id} style={{display:"inline-block", marginRight:"30px"}}>
                <p key={projection.id}>Cinema: {projection.projectionRoom}</p>
                <p>{projection.movie.title}</p>
                <p>{projection.projectionTime.slice(0,5)}</p>
                <p>{projection.projectionTime}</p>
                <p>{dayofWeek} {projection.projectionDate}</p>                
                <p></p>
                <p>Projection Id: {projection.id}</p>
                <p>Movie id: {projection.movie.id}</p>
                <p>{projection.movie.type === "TWO_D" ? "2D" : movie.type === "THREE_D" ? "3D" : movie.type}</p>
                </span>
                );
            })}
             <TableProjections/>
            </div>
        </div>
        </div>
        </div>
     </div>
    </div>
  )
}




